USE spotify;

-- INSERT users
INSERT INTO `users` (`email`, `password`, `username`, `birthdate`, `gender`, `country`, `postal_code`) 
VALUES 
('johndoe@example.com', '12345678', 'johhdoe90', '1990-01-01', 'Male', 'UK', '12345'),
('joanamora@example.com', '87654321', 'joanamora92', '1992-02-02', 'Female', 'Australia', '67890'),
('divine@example.com', '1a4md1v1n3', 'divine', '1994-03-03', 'Non Binary', 'USA', '54321');

-- INSERT payments
INSERT INTO `payments` (`payment_date`, `order_number`, `amount`, `payment_type`) 
VALUES 
('2023-01-01', 'ORD123', 100.00, 'credit_card'),
('2023-02-01', 'ORD124', 150.00, 'paypal');

-- INSERT subscriptions
INSERT INTO `subscriptions` (`user_id`, `start_date`, `renewal_date`, `payment_id`) 
VALUES 
(1, '2023-01-01', '2024-01-01', 1),
(2, '2023-02-01', '2024-02-01', 2);

-- INSERT paypal
INSERT INTO `paypal` (`payment_id`, `paypal_username`) 
VALUES 
(2, 'paypal_user2');

-- INSERT credit cards
INSERT INTO `credit_cards` (`payment_id`, `card_number`, `expiry_month`, `expiry_year`, `security_code`) 
VALUES 
(1, '1111222233334444', 12, 2024, '123');

-- INSERT artists
INSERT INTO `artists` (`name`, `img`) 
VALUES 
('Linkin Park', 'linkin_park.jpg'),
('Shakira', 'shakira.jpg'),
('Beyoncé', 'beyonce.jpg'),
('OutKast', 'outkast.jpg'),
('The White Stripes', 'the_white_stripes.jpg');

-- INSERT albums
INSERT INTO `albums` (`title`, `cover_img`, `release_year`, `artist_id`) 
VALUES 
('Hybrid Theory', 'hybrid_theory.jpg', 2000, 1),
('Oral Fixation Vol. 2', 'oral_fixation_vol2.jpg', 2005, 2),
('Dangerously in Love', 'dangerously_in_love.jpg', 2003, 3),
('Speakerboxxx/The Love Below', 'speakerboxxx_love_below.jpg', 2003, 4),
('Elephant', 'elephant.jpg', 2003, 5);

-- Insert songs
INSERT INTO `songs` (`album_id`, `title`, `duration`) 
VALUES 
(1, 'In the End', '00:03:36'),
(1, 'Numb', '00:03:07'),
(2, 'Hips Don\'t Lie', '00:03:38'),
(2, 'Whenever, Wherever', '00:03:17'),
(3, 'Crazy in Love', '00:03:56'),
(3, 'Halo', '00:04:21'),
(4, 'Hey Ya!', '00:03:55'),
(4, 'Ms. Jackson', '00:04:31'),
(5, 'Seven Nation Army', '00:03:52'),
(5, 'Icky Thump', '00:04:14');

-- INSERT favorite songs
INSERT INTO `favorite_songs` (`user_id`, `song_id`) 
VALUES 
(1, 1),
(2, 3), 
(3, 5); 

-- INSERT favorite albums
INSERT INTO `favorite_albums` (`user_id`, `album_id`) 
VALUES 
(1, 1), 
(2, 2), 
(3, 3); 

-- INSERT artist followers
INSERT INTO `artists_followers` (`user_id`, `artist_id`) 
VALUES 
(1, 1),
(2, 2),
(3, 3); 

-- INSERT related artists
INSERT INTO `related_artists` (`artist_id`, `related_artist_id`) 
VALUES 
(2, 3),
(3, 4),
(4, 3);

-- INSERT playlists
INSERT INTO `playlists` (`user_id`, `title`, `song_count`, `creation_date`) 
VALUES 
(1, 'John Doe Favorites', 2, '2023-03-01'),
(2, 'Joana Mora Greatest Hits', 1, '2023-04-01'),
(3, 'Divine list', 1, '2023-05-01');

-- INSERT playlist songs
INSERT INTO `playlist_songs` (`playlist_id`, `song_id`, `artist_id`) 
VALUES 
(1, 1, 1), 
(1, 2, 1), 
(2, 3, 2),
(3, 5, 3);
