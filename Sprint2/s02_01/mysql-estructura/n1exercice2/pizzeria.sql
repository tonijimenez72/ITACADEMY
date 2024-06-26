DROP DATABASE IF EXISTS pizzeria;
CREATE DATABASE pizzeria;
USE pizzeria;

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
  `role` enum('kitchen','delivery') NOT NULL,
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
  `product` enum('pizza','burger','drink') NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `category_id` int
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `order_date` datetime NOT NULL,
  `order_type` enum('pickup','delivery') NOT NULL,
  `total_price` decimal(9,2) NOT NULL,
  `employee_id` int,
  `store_id` int,
  `client_id` int
);

CREATE TABLE `orderdetails` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `product_id` int,
  `order_id` int
);

CREATE TABLE `deliveries` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `delivery_date` datetime NOT NULL,
  `order_id` int,
  `deliverer_id` int
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

-DELIMITER //
CREATE TRIGGER check_delivery_role
BEFORE INSERT ON deliveries
FOR EACH ROW
BEGIN
    DECLARE emp_role ENUM('kitchen', 'delivery');
    -- Retrieve the role of the employee trying to make the delivery
    SELECT role INTO emp_role FROM employees WHERE id = NEW.deliverer_id;
    
    -- If the employee is not a delivery person, raise an error
    IF emp_role != 'delivery' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Only employees with the role of delivery can make deliveries.';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER check_product_category
BEFORE INSERT ON products
FOR EACH ROW
BEGIN
    -- If the product is not a pizza and a category_id is provided, raise an error
    IF NEW.product != 'pizza' AND NEW.category_id IS NOT NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Categories can only be assigned to pizzas.';
    END IF;
END //
DELIMITER ;

DELIMITER //

CREATE TRIGGER update_order_total_insert
AFTER INSERT ON orderdetails
FOR EACH ROW
BEGIN
    UPDATE orders
    SET total_price = (
        SELECT SUM(products.price * NEW.quantity)
        FROM products
        WHERE products.id = NEW.product_id
    )
    WHERE orders.id = NEW.order_id;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER update_order_total_update
AFTER UPDATE ON orderdetails
FOR EACH ROW
BEGIN
    UPDATE orders
    SET total_price = (
        SELECT SUM(products.price * NEW.quantity)
        FROM products
        WHERE products.id = NEW.product_id
    )
    WHERE orders.id = NEW.order_id;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER update_order_total_delete
AFTER DELETE ON orderdetails
FOR EACH ROW
BEGIN
    UPDATE orders
    SET total_price = (
        SELECT SUM(products.price * orderdetails.quantity)
        FROM orderdetails
        JOIN products ON orderdetails.product_id = products.id
        WHERE orderdetails.order_id = OLD.order_id
    )
    WHERE orders.id = OLD.order_id;
END //
DELIMITER ;