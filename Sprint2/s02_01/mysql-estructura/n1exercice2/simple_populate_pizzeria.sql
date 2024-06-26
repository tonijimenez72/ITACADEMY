USE pizzeria;

-- INSERT Provinces
INSERT INTO provinces (name) 
VALUES 
('Barcelona');

-- INSERT Cities
INSERT INTO cities (name, province_id) 
VALUES 
('Barcelona', 1);

-- INSERT stores

INSERT INTO stores (address, postal_code, city_id)
VALUES 
    ('Carrer de la Botiga 1', '08001', 1);
	
-- INSERT employees store 1
INSERT INTO employees (name, surname, idcard, phone, role, store_id)
VALUES 
    ('Josep', 'Garcia', '12345678A', '612345678', 'kitchen', 1),
    ('Elena', 'Martínez', '23456789B', '623456789', 'kitchen', 1),
    ('Marc', 'Sánchez', '34567890C', '634567890', 'delivery', 1),
    ('Laura', 'López', '45678901D', '645678901', 'delivery', 1);
	
-- INSERT categories 
INSERT INTO categories (name) VALUES ('vegana'), ('oferta'), ('picant'), ('familiar'), ('mitjana'), ('gran');

-- INSERT products

INSERT INTO products (name, product, price, image, category_id)
VALUES ('Refresc', 'drink', 2.50, 'https://www.itpizza.com/img/refresc.png', NULL),
       ('Cervesa', 'drink', 3.00, 'https://www.itpizza.com/img/cervesa.png', NULL),
       ('Aigua', 'drink', 1.50, 'https://www.itpizza.com/img/aigua.png', NULL);
	   
INSERT INTO products (name, product, price, image, category_id)
VALUES ('Classic Burger', 'burger', 8.99, 'https://www.itpizza.com/img/classic_burger.png', NULL),
       ('Cheeseburger', 'burger', 9.99, 'https://www.itpizza.com/img/cheeseburger.png', NULL),
       ('Bacon Burger', 'burger', 10.99, 'https://www.itpizza.com/img/bacon_burger.png', NULL),
       ('Veggie Burger', 'burger', 7.99, 'https://www.itpizza.com/img/veggie_burger.png', NULL);
	   
-- Vegana
INSERT INTO products (name, product, price, image, category_id)
VALUES ('Pizza Vegana 1', 'pizza', 11.99, 'https://www.itpizza.com/img/vegana1.png', 1),
       ('Pizza Vegana 2', 'pizza', 12.99, 'https://www.itpizza.com/img/vegana2.png', 1),
       ('Pizza Vegana 3', 'pizza', 13.99, 'https://www.itpizza.com/img/vegana3.png', 1);

-- Oferta
INSERT INTO products (name, product, price, image, category_id)
VALUES ('Pizza Oferta 1', 'pizza', 9.99, 'https://www.itpizza.com/img/oferta1.png', 2),
       ('Pizza Oferta 2', 'pizza', 10.99, 'https://www.itpizza.com/img/oferta2.png', 2),
       ('Pizza Oferta 3', 'pizza', 11.99, 'https://www.itpizza.com/img/oferta3.png', 2);

-- Picant
INSERT INTO products (name, product, price, image, category_id)
VALUES ('Pizza Picant 1', 'pizza', 10.99, 'https://www.itpizza.com/img/picant1.png', 3),
       ('Pizza Picant 2', 'pizza', 11.99, 'https://www.itpizza.com/img/picant2.png', 3),
       ('Pizza Picant 3', 'pizza', 12.99, 'https://www.itpizza.com/img/picant3.png', 3);

-- Familiar
INSERT INTO products (name, product, price, image, category_id)
VALUES ('Pizza Familiar 1', 'pizza', 13.99, 'https://www.itpizza.com/img/familiar1.png', 4),
       ('Pizza Familiar 2', 'pizza', 14.99, 'https://www.itpizza.com/img/familiar2.png', 4),
       ('Pizza Familiar 3', 'pizza', 15.99, 'https://www.itpizza.com/img/familiar3.png', 4);

-- Mitjana
INSERT INTO products (name, product, price, image, category_id)
VALUES ('Pizza Mitjana 1', 'pizza', 8.99, 'https://www.itpizza.com/img/mitjana1.png', 5),
       ('Pizza Mitjana 2', 'pizza', 9.99, 'https://www.itpizza.com/img/mitjana2.png', 5),
       ('Pizza Mitjana 3', 'pizza', 10.99, 'https://www.itpizza.com/img/mitjana3.png', 5);

-- Gran
INSERT INTO products (name, product, price, image, category_id)
VALUES ('Pizza Gran 1', 'pizza', 16.99, 'https://www.itpizza.com/img/gran1.png', 6),
       ('Pizza Gran 2', 'pizza', 17.99, 'https://www.itpizza.com/img/gran2.png', 6),
       ('Pizza Gran 3', 'pizza', 18.99, 'https://www.itpizza.com/img/gran3.png', 6);


-- INSERT clients
INSERT INTO clients (name, surname, address, postal_code, phone, city_id)
VALUES ('Joan', 'Martínez', 'Carrer Major 123', '08001', '612345678', 1),
       ('Maria', 'García', 'Av. Diagonal 456', '08002', '654987321', 1),
       ('Pau', 'Sánchez', 'Plaça Catalunya 789', '08003', '689745123', 1);
	   
-- INSERT Orders
INSERT INTO orders (order_date, order_type, total_price, employee_id, store_id, client_id) VALUES
('2024-06-20 12:00:00', 'delivery', 0.00, 3, 1, 1),
('2024-06-20 13:00:00', 'delivery', 0.00, 3, 1, 2),
('2024-06-20 14:00:00', 'pickup', 0.00, 3, 1, 3),
('2024-06-20 15:00:00', 'delivery', 0.00, 4, 1, 1),
('2024-06-20 16:00:00', 'pickup', 0.00, 4, 1, 2);

-- INSERT orderdetails
INSERT INTO orderdetails (quantity, order_id, product_id) VALUES
(2, 1, 1), 
(1, 1, 2), 
(3, 2, 1),
(1, 2, 3),
(2, 3, 2),
(4, 4, 1),
(1, 4, 4),
(2, 5, 3);

-- INSERT deliveries
INSERT INTO deliveries (delivery_date, order_id, deliverer_id) VALUES
('2024-06-20 12:30:00', 1, 3),
('2024-06-20 13:30:00', 2, 3),
('2024-06-20 15:30:00', 4, 4);