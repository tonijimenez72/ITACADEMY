CREATE TABLE `provinces` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL
);

CREATE TABLE `cities` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `province_id` int
);

CREATE TABLE `clients` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `postal_code` varchar(10) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `city_id` int
);

CREATE TABLE `stores` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `address` varchar(200) NOT NULL,
  `postal_code` varchar(10) NOT NULL,
  `city_id` int
);

CREATE TABLE `employees` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `idcard` varchar(15) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `role` ENUM ('kitchen', 'delivery') NOT NULL,
  `store_id` int
);

CREATE TABLE `categories` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL
);

CREATE TABLE `products` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `image` varchar(200),
  `product` ENUM ('pizza', 'burger', 'drink') NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `category_id` int
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `order_date` datetime NOT NULL,
  `order_type` ENUM ('pickup', 'delivery') NOT NULL,
  `total_price` decimal(9,2) NOT NULL,
  `employee_id` int,
  `client_id` int,
  `store_id` int
);

CREATE TABLE `orderdetails` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `order_id` int,
  `product_id` int
);

CREATE TABLE `deliveries` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `delivery_date` datetime NOT NULL,
  `deliverer_id` int,
  `order_id` int
);

ALTER TABLE `stores` ADD FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`);

ALTER TABLE `cities` ADD FOREIGN KEY (`province_id`) REFERENCES `provinces` (`id`);

ALTER TABLE `employees` ADD FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`);

ALTER TABLE `orderdetails` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `orderdetails` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);

ALTER TABLE `deliveries` ADD FOREIGN KEY (`deliverer_id`) REFERENCES `employees` (`id`);

ALTER TABLE `deliveries` ADD FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

ALTER TABLE `clients` ADD FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`);

ALTER TABLE `products` ADD FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`);