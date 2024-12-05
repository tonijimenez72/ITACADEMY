CREATE TABLE `users` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `email` VARCHAR(255) UNIQUE NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) UNIQUE NOT NULL,
  `birthdate` DATE NOT NULL,
  `gender` ENUM ('Non Binary', 'Female', 'Male'),
  `country` VARCHAR(50),
  `postal_code` VARCHAR(15)
);

CREATE TABLE `payments` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `payment_date` DATE NOT NULL,
  `order_number` VARCHAR(50) UNIQUE NOT NULL,
  `amount` DECIMAL(10,2) NOT NULL,
  `payment_type` ENUM ('credit_card', 'paypal') NOT NULL
);

CREATE TABLE `subscriptions` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `start_date` DATE NOT NULL,
  `renewal_date` DATE NOT NULL,
  `user_id` INT,
  `payment_id` INT
);

CREATE TABLE `paypal` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `payment_id` INT NOT NULL,
  `paypal_username` VARCHAR(255) NOT NULL
);

CREATE TABLE `credit_cards` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `payment_id` INT NOT NULL,
  `card_number` VARCHAR(16) NOT NULL,
  `expiry_month` INT NOT NULL,
  `expiry_year` INT NOT NULL,
  `security_code` VARCHAR(4) NOT NULL
);

CREATE TABLE `artists` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `img` VARCHAR(255) NOT NULL
);

CREATE TABLE `albums` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `cover_img` VARCHAR(255) NOT NULL,
  `release_year` INT NOT NULL,
  `artist_id` INT NOT NULL
);

CREATE TABLE `songs` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `album_id` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `duration` TIME NOT NULL,
  `play_count` INT DEFAULT 0
);

CREATE TABLE `favorite_songs` (
  `user_id` INT,
  `song_id` INT,
  PRIMARY KEY (`user_id`, `song_id`)
);

CREATE TABLE `favorite_albums` (
  `user_id` INT,
  `album_id` INT,
  PRIMARY KEY (`user_id`, `album_id`)
);

CREATE TABLE `artists_followers` (
  `user_id` INT,
  `artist_id` INT,
  PRIMARY KEY (`user_id`, `artist_id`)
);

CREATE TABLE `related_artists` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `artist_id` INT NOT NULL,
  `related_artist_id` INT NOT NULL
);

CREATE TABLE `playlists` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `song_count` INT DEFAULT 0,
  `creation_date` DATE NOT NULL,
  `deleted` BOOL DEFAULT false,
  `deletion_date` DATE
);

CREATE TABLE `playlist_songs` (
  `playlist_id` INT,
  `song_id` INT,
  `artist_id` INT NOT NULL,
  PRIMARY KEY (`playlist_id`, `song_id`)
);

ALTER TABLE `subscriptions` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `subscriptions` ADD FOREIGN KEY (`payment_id`) REFERENCES `payments` (`id`);

ALTER TABLE `paypal` ADD FOREIGN KEY (`payment_id`) REFERENCES `payments` (`id`);

ALTER TABLE `credit_cards` ADD FOREIGN KEY (`payment_id`) REFERENCES `payments` (`id`);

ALTER TABLE `albums` ADD FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`);

ALTER TABLE `songs` ADD FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`);

ALTER TABLE `favorite_songs` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `favorite_songs` ADD FOREIGN KEY (`song_id`) REFERENCES `songs` (`id`);

ALTER TABLE `favorite_albums` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `favorite_albums` ADD FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`);

ALTER TABLE `artists_followers` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `artists_followers` ADD FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`);

ALTER TABLE `related_artists` ADD FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`);

ALTER TABLE `related_artists` ADD FOREIGN KEY (`related_artist_id`) REFERENCES `artists` (`id`);

ALTER TABLE `playlists` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `playlist_songs` ADD FOREIGN KEY (`playlist_id`) REFERENCES `playlists` (`id`);

ALTER TABLE `playlist_songs` ADD FOREIGN KEY (`song_id`) REFERENCES `songs` (`id`);

ALTER TABLE `playlist_songs` ADD FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`);
