USE spotify;

-- Some querys
-- users query
SELECT username, email, birthdate, gender, country  from users;
-- users on subscription query
SELECT users.id AS user_id, users.username, users.email, subscriptions.start_date, subscriptions.renewal_date, payments.payment_type FROM users
JOIN subscriptions ON users.id = subscriptions.id
JOIN payments ON subscriptions.payment_id = payments.id;

-- albums query
SELECT artists.name AS artist, albums.title AS title, albums.release_year, songs.title AS song_title, songs.duration FROM artists
JOIN albums ON artists.id = albums.artist_id
JOIN songs ON albums.id = songs.album_id
ORDER BY artists.name, albums.release_year, albums.title, songs.title;

-- playlist query
SELECT playlists.title AS playlist, users.username AS created_by, songs.title AS song_title, artists.name AS artist FROM playlists
JOIN users ON playlists.user_id = users.id
JOIN playlist_songs ON playlists.id = playlist_songs.playlist_id
JOIN songs ON playlist_songs.song_id = songs.id
JOIN artists ON playlist_songs.artist_id = artists.id
ORDER BY playlists.title, songs.title;

-- favorite songs query
SELECT users.username, songs.title AS song, artists.name AS artist FROM favorite_songs
JOIN users ON favorite_songs.user_id = users.id
JOIN songs ON favorite_songs.song_id = songs.id
JOIN albums ON songs.album_id = albums.id
JOIN artists ON albums.artist_id = artists.id
ORDER BY users.username, songs.title;

-- favorite albums query
SELECT users.username, albums.title AS album, artists.name AS artist FROM favorite_albums
JOIN users ON favorite_albums.user_id = users.id
JOIN albums ON favorite_albums.album_id = albums.id
JOIN artists ON albums.artist_id = artists.id
ORDER BY users.username, albums.title;

