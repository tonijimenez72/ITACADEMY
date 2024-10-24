USE youtube;

-- INSERT users
INSERT INTO users (email, password, username, bod, gender, country, postal_code) VALUES
('alice@example.com', 'securepassword123', 'Alice', '1990-01-01', 'female', 'USA', '12345'),
('bob@example.com', 'password456', 'Bob', '1985-05-15', 'male', 'Canada', 'A1B2C3'),
('charlie@example.com', 'mypassword789', 'Charlie', '1992-08-25', 'non binary', 'UK', 'N1 9GU'),
('dave@example.com', 'pass321', 'Dave', '1988-12-12', 'male', 'Australia', '2000');

-- INSERT Videos user_id 1
INSERT INTO videos (title, description, size, file_name, duration, thumbnail, views, likes, dislikes, status, upload_datetime, user_id) VALUES
('Video 1', 'Description for video 1', 1048576, 'video1.mp4', '00:10:00', 'thumbnail1.jpg', 0, 0, 0, 'public', NOW(), 1),
('Video 2', 'Description for video 2', 2097152, 'video2.mp4', '00:20:00', 'thumbnail2.jpg', 0, 0, 0, 'public', NOW(), 1),
('Video 3', 'Description for video 3', 3145728, 'video3.mp4', '00:30:00', 'thumbnail3.jpg', 0, 0, 0, 'hidden', NOW(), 1),
('Video 4', 'Description for video 4', 4194304, 'video4.mp4', '00:40:00', 'thumbnail4.jpg', 0, 0, 0, 'private', NOW(), 1);

-- INSERT channel
INSERT INTO channels (name, description, creation_date, user_id) VALUES
('Alice One', 'Hi, My name is Alice and this is my first channel.', NOW(), 1);

-- INSERT videos on channel
INSERT INTO videos_on_channels (channel_id, video_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4);

-- INSERT tags
INSERT INTO tags (name) VALUES ('one'), ('two'), ('three'), ('four');
INSERT INTO video_tags (tag_id, video_id) VALUES (1, 1), (2, 1);
INSERT INTO video_tags (tag_id, video_id) VALUES (4, 2), (3, 2);

-- INSERT playlists
INSERT INTO playlists (name, creation_date, status, user_id) VALUES 
('Playlist for Alice', NOW(), 'private', 1),
('Playlist for Bob', NOW(), 'public', 2);

-- INSERT videos on playlists
INSERT INTO videos_on_playlists (playlist_id,video_id) VALUES
(1, 1),
(1, 2),
(1, 4),
(2, 1),
(2, 2);

-- INSERT likes and dislikes
INSERT INTO reactions (video_id, user_id, reaction, datetime) VALUES
(1, 1, 'like', NOW()),
(2, 1, 'like', NOW()),
(4, 1, 'like', NOW()),
(1, 2, 'like', NOW()),
(2, 2, 'like', NOW()),
(1, 3, 'dislike', NOW()),
(2, 3, 'like', NOW()),
(1, 4, 'dislike', NOW()),
(2, 4, 'like', NOW());

-- INSERT comments
INSERT INTO comments (comment, datetime, video_id, user_id) VALUES
('Haters gonna hate.', NOW(), 1, 2),
('Lovers gonna love.', NOW(), 1, 3);

-- INSERT comment reactions
INSERT INTO comment_reactions (comment_id, user_id, reaction, datetime) VALUES
(1, 2, 'like', NOW()),
(1, 3, 'like', NOW()),
(1, 4, 'dislike', NOW()),
(2, 2, 'like', NOW()),
(2, 3, 'dislike', NOW()),
(2, 4, 'dislike', NOW());




