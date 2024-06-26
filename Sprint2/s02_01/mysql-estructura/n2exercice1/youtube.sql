DROP DATABASE IF EXISTS youtube;
CREATE DATABASE youtube;
USE youtube;

CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `email` varchar(255) UNIQUE NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `bod` date NOT NULL,
  `gender` enum('non binary','female','male'),
  `country` varchar(50),
  `postal_code` varchar(15)
);

CREATE TABLE `videos` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` text,
  `size` int,
  `file_name` varchar(255) NOT NULL,
  `duration` time,
  `thumbnail` varchar(255),
  `views` int DEFAULT 0,
  `likes` int DEFAULT 0,
  `dislikes` int DEFAULT 0,
  `comments_num` int DEFAULT 0,
  `status` enum('public','hidden','private'),
  `upload_datetime` datetime NOT NULL,
  `user_id` int
);

CREATE TABLE `tags` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) UNIQUE NOT NULL
);

CREATE TABLE `video_tags` (
  `tag_id` int,
  `video_id` int,
  PRIMARY KEY (`tag_id`, `video_id`)
);

CREATE TABLE `channels` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) UNIQUE NOT NULL,
  `description` text,
  `creation_date` datetime NOT NULL,
  `video_id` int,
  `user_id` int
);

CREATE TABLE `videos_on_channels` (
  `video_id` int,
  `channel_id` int,
  PRIMARY KEY (`video_id`, `channel_id`)
);

CREATE TABLE `playlists` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) UNIQUE NOT NULL,
  `creation_date` datetime NOT NULL,
  `status` enum('public','private'),
  `user_id` int
);

CREATE TABLE `videos_on_playlists` (
  `playlist_id` int,
  `video_id` int,
  PRIMARY KEY (`playlist_id`,`video_id`)
);

CREATE TABLE `subscriptions` (
  `user_id` int,
  `channel_id` int,
  `subscription_date` datetime NOT NULL,
  PRIMARY KEY (`user_id`, `channel_id`)
);

CREATE TABLE `reactions` (
  `video_id` int,
  `user_id` int,
  `reaction` enum('like','dislike'),
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`video_id`, `user_id`)
);

CREATE TABLE `comments` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `comment` text NOT NULL,
  `datetime` datetime NOT NULL,
  `video_id` int,
  `user_id` int
);

CREATE TABLE `comment_reactions` (
  `comment_id` int,
  `user_id` int,
  `reaction` enum('like','dislike'),
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`comment_id`, `user_id`)
);

ALTER TABLE `video_tags` ADD FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`);

ALTER TABLE `video_tags` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `videos` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `playlists` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `videos_on_playlists` ADD FOREIGN KEY (`playlist_id`) REFERENCES `playlists` (`id`);

ALTER TABLE `videos_on_playlists` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `channels` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `subscriptions` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `subscriptions` ADD FOREIGN KEY (`channel_id`) REFERENCES `channels` (`id`);

ALTER TABLE `reactions` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `reactions` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `comment_reactions` ADD FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`);

ALTER TABLE `comment_reactions` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `videos_on_channels` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `videos_on_channels` ADD FOREIGN KEY (`channel_id`) REFERENCES `channels` (`id`);

-- Some TRIGGER examples

DELIMITER //
CREATE TRIGGER before_channel_insert
BEFORE INSERT ON channels
FOR EACH ROW
BEGIN
    DECLARE video_count INT;
    
SELECT COUNT(*) INTO video_count FROM videos WHERE user_id = NEW.user_id;

    IF video_count = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You cannot create a channel without associated videos.';
    END IF;
END//

CREATE TRIGGER before_channel_update
BEFORE UPDATE ON channels
FOR EACH ROW
BEGIN
    DECLARE owner_id INT;
    
    SELECT user_id INTO owner_id FROM channels WHERE id = OLD.id;

    IF owner_id != OLD.user_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You are not authorized to update this channel.';
    END IF;
END//

CREATE TRIGGER before_add_video_to_playlist
BEFORE INSERT ON videos_on_playlists
FOR EACH ROW
BEGIN
    DECLARE playlist_owner_id INT;
    DECLARE video_owner_id INT;
    DECLARE video_status VARCHAR(10);

    SELECT user_id INTO playlist_owner_id FROM playlists WHERE id = NEW.playlist_id;
    SELECT user_id INTO video_owner_id FROM videos WHERE id = NEW.video_id;
    SELECT status INTO video_status FROM videos WHERE id = NEW.video_id;
	
    IF video_status = 'hidden' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot add videos with status "hidden" to the playlist.';
    END IF;
    
    IF playlist_owner_id != video_owner_id AND video_status = 'private'  THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot add videos with status "private" to the playlist if you are not the owner of the video.';
    END IF;
END//

CREATE TRIGGER before_reaction_insert
BEFORE INSERT ON reactions
FOR EACH ROW
BEGIN
    DECLARE video_owner_id INT;
    DECLARE video_status ENUM('public','hidden','private');
    DECLARE existing_reaction ENUM('like','dislike');

    SELECT user_id, status INTO video_owner_id, video_status FROM videos WHERE id = NEW.video_id;
    SELECT reaction INTO existing_reaction FROM reactions WHERE user_id = NEW.user_id AND video_id = NEW.video_id LIMIT 1;
    
    IF video_status = 'hidden' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot react to videos with status "hidden".';
    END IF;
    
    IF video_status = 'private' AND video_owner_id != NEW.user_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot react to videos with status "private" if you are not the owner of the video.';
    END IF;

    IF existing_reaction IS NOT NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'User has already reacted to this video.';
    END IF;
    
    IF NEW.reaction = 'like' THEN
        UPDATE videos SET likes = likes + 1 WHERE id = NEW.video_id;
    ELSEIF NEW.reaction = 'dislike' THEN
        UPDATE videos SET dislikes = dislikes + 1 WHERE id = NEW.video_id;
    END IF;
END//

CREATE TRIGGER before_reaction_update
BEFORE UPDATE ON reactions
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Update reactions is not allowed.';
END//

CREATE TRIGGER before_reaction_delete
BEFORE DELETE ON reactions
FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Deleting rows in the `reactions` table is not allowed.';
END//

CREATE TRIGGER before_comment_insert
BEFORE INSERT ON comments
FOR EACH ROW
BEGIN
    DECLARE video_status ENUM('public', 'hidden', 'private');

	SELECT status INTO video_status FROM videos WHERE id = NEW.video_id;

    IF video_status != 'public' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot comment on videos without status "public".';
    END IF;
END//

CREATE TRIGGER after_comment_insert
AFTER INSERT ON comments
FOR EACH ROW
BEGIN
    UPDATE videos SET comments_num = comments_num + 1 WHERE id = NEW.video_id;
END//

DELIMITER ;
