DROP DATABASE IF EXISTS optics;
CREATE DATABASE optics;
USE optics;

CREATE TABLE `clients` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `idCard` varchar(20) UNIQUE NOT NULL,
  `registration_date` datetime NOT NULL,
  `refered_by_id` int,
  `contact_id` int
);

CREATE TABLE `suppliers` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `idcard` varchar(20) UNIQUE NOT NULL,
  `fax` varchar(15),
  `contact_id` int
);

CREATE TABLE `contacts` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `number` varchar(5) NOT NULL,
  `floor` varchar(15),
  `door` varchar(15),
  `city` varchar(40) NOT NULL,
  `postal_code` varchar(255) NOT NULL,
  `country` varchar(30) NOT NULL,
  `phone` varchar(15) NOT NULL
);

CREATE TABLE `employees` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL
);

CREATE TABLE `glasses` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `left_graduation` decimal(4,2),
  `right_graduation` decimal(4,2),
  `frame_type` enum('floating','plastic','metal') NOT NULL,
  `frame_color` varchar(30),
  `left_color` varchar(30),
  `right_color` varchar(30),
  `price` decimal(9,2) NOT NULL,
  `supplier_id` int,
  `brand_id` int
);

CREATE TABLE `brands` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100)
);

CREATE TABLE `sales` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `sale_date` datetime NOT NULL,
  `employee_id` int NOT NULL,
  `client_id` int NOT NULL,
  `glasses_id` int NOT NULL
);

ALTER TABLE `sales` ADD FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`);

ALTER TABLE `sales` ADD FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);

ALTER TABLE `sales` ADD FOREIGN KEY (`glasses_id`) REFERENCES `glasses` (`id`);

ALTER TABLE `glasses` ADD FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`);

ALTER TABLE `glasses` ADD FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`);

ALTER TABLE `clients` ADD FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`);

ALTER TABLE `suppliers` ADD FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`);

ALTER TABLE `clients` ADD FOREIGN KEY (`refered_by_id`) REFERENCES `clients` (`id`);
