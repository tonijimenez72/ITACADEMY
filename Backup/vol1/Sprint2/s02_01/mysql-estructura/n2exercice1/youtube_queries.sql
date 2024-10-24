USE youtube;

-- Some queries
-- SELECT video_tags.video_id AS video_id, name AS tag FROM tags JOIN video_tags ON tag_id = tags.id WHERE video_tags.video_id = 1 OR video_tags.video_id = 2 ORDER BY video_id;
-- SELECT videos.user_id AS user_id, videos_on_channels.channel_id AS channel_id, videos.id AS video_id, videos.title, videos.size, videos.duration, videos.likes, videos.dislikes, videos.status, videos.upload_datetime FROM videos JOIN videos_on_channels ON videos.id = videos_on_channels.video_id WHERE videos_on_channels.channel_id = 1 ORDER BY user_id;
-- SELECT playlists.name AS playlist, videos.title, videos.duration, videos.likes, videos.dislikes, videos.status, videos.upload_datetime, users.username AS uploader FROM videos JOIN videos_on_playlists ON videos.id = videos_on_playlists.video_id JOIN playlists ON videos_on_playlists.playlist_id = playlists.id JOIN  users ON videos.user_id = users.id ORDER BY playlists.name;
