CREATE TABLE `clients` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `idCard` VARCHAR(20) UNIQUE NOT NULL,
  `registration_date` DATETIME NOT NULL,
  `refered_by_id` INT DEFAULT null,
  `contact_id` INT
);

CREATE TABLE `suppliers` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `idcard` VARCHAR(20) UNIQUE NOT NULL,
  `fax` VARCHAR(15),
  `contact_id` INT
);

CREATE TABLE `contacts` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `address` VARCHAR(100) NOT NULL,
  `number` VARCHAR(5) NOT NULL,
  `floor` VARCHAR(15),
  `door` VARCHAR(15),
  `city` VARCHAR(40) NOT NULL,
  `postal_code` VARCHAR(255) NOT NULL,
  `country` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(15) NOT NULL
);

CREATE TABLE `employees` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL
);

CREATE TABLE `glasses` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `left_graduation` DECIMAL(4,2),
  `right_graduation` DECIMAL(4,2),
  `frame_type` ENUM ('floating', 'plastic', 'metal') NOT NULL,
  `frame_color` VARCHAR(30),
  `left_color` VARCHAR(30),
  `right_color` VARCHAR(30),
  `price` DECIMAL(9,2) NOT NULL,
  `brand_id` INT
);

CREATE TABLE `brands` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(100),
  `supplier_id` INT
);

CREATE TABLE `sales` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `sale_date` DATETIME NOT NULL,
  `employee_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  `glasses_id` INT NOT NULL
);

ALTER TABLE `sales` ADD FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`);

ALTER TABLE `sales` ADD FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);

ALTER TABLE `sales` ADD FOREIGN KEY (`glasses_id`) REFERENCES `glasses` (`id`);

ALTER TABLE `brands` ADD FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`id`);

ALTER TABLE `glasses` ADD FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`);

ALTER TABLE `clients` ADD FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`);

ALTER TABLE `suppliers` ADD FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`);

ALTER TABLE `clients` ADD FOREIGN KEY (`refered_by_id`) REFERENCES `clients` (`id`);
