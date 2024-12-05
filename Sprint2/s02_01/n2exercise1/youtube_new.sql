CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `email` varchar(255) UNIQUE NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `bod` date NOT NULL,
  `gender` ENUM ('non binary', 'female', 'male'),
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
  `status` ENUM ('public', 'hidden', 'private'),
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
  `user_id` int
);

CREATE TABLE `videos_on_channels` (
  `channel_id` int,
  `video_id` int,
  PRIMARY KEY (`channel_id`, `video_id`)
);

CREATE TABLE `playlists` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) UNIQUE NOT NULL,
  `creation_date` datetime NOT NULL,
  `status` ENUM ('public', 'private'),
  `user_id` int
);

CREATE TABLE `videos_on_playlists` (
  `playlist_id` int,
  `video_id` int,
  PRIMARY KEY (`playlist_id`, `video_id`)
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
  `reaction` ENUM ('like', 'dislike'),
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
  `reaction` ENUM ('like', 'dislike'),
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`comment_id`, `user_id`)
);

ALTER TABLE `videos` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `video_tags` ADD FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`);

ALTER TABLE `video_tags` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `channels` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `videos_on_channels` ADD FOREIGN KEY (`channel_id`) REFERENCES `channels` (`id`);

ALTER TABLE `videos_on_channels` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `playlists` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `videos_on_playlists` ADD FOREIGN KEY (`playlist_id`) REFERENCES `playlists` (`id`);

ALTER TABLE `videos_on_playlists` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `subscriptions` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `subscriptions` ADD FOREIGN KEY (`channel_id`) REFERENCES `channels` (`id`);

ALTER TABLE `reactions` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `reactions` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`video_id`) REFERENCES `videos` (`id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `comment_reactions` ADD FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`);

ALTER TABLE `comment_reactions` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);