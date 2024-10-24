USE youtube;

-- Some exceptions
-- INSERT INTO videos_on_playlists (playlist_id,video_id) VALUES (1, 3);
-- INSERT INTO videos_on_playlists (playlist_id,video_id) VALUES (2, 4);
-- INSERT INTO reactions (video_id, user_id, reaction, datetime) VALUES (3, 1, 'like', NOW());
-- INSERT INTO reactions (video_id, user_id, reaction, datetime) VALUES (3, 2, 'like', NOW());
-- INSERT INTO reactions (video_id, user_id, reaction, datetime) VALUES (4, 2, 'like', NOW());
-- UPDATE reactions SET reaction = 'like', datetime = NOW() WHERE video_id = 1 AND user_id = 2;
-- DELETE FROM reactions WHERE video_id = 1 AND user_id = 2;
-- INSERT INTO comments (comment, datetime, video_id, user_id) VALUES ('This comment is an error.', NOW(), 3, 1);

