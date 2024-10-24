USE optics;

-- INSERT brands
INSERT INTO brands (name) VALUES 
    ('Ray-Ban'),
    ('Oakley'),
    ('Prada'),
    ('Gucci'),
    ('Dior');

-- INSERT employees
INSERT INTO employees (name) VALUES
    ('Joan Petit'),
    ('Joana Mora'),
    ('Oriol Tinoco');

-- INSERT suppliers
-- supplier 1: 
INSERT INTO contacts (address, number, city, postal_code, country, phone) 
VALUES ('Carrer de Proveïdor 1', '123', 'Barcelona', '08001', 'Spain', '+34 123 456 789');
INSERT INTO suppliers (name, idcard, fax, contact_id) 
VALUES ('LensWorld', '123456789A', '123-456-789', 1);

-- supplier 2: 
INSERT INTO contacts (address, number, city, postal_code, country, phone) 
VALUES ('Carrer de Proveïdor 2', '456', 'Barcelona', '08002', 'Spain', '+34 987 654 321');
INSERT INTO suppliers (name, idcard, fax, contact_id) 
VALUES ('EagleVision', '987654321B', '987-654-321', 2);

-- supplier 3: 
INSERT INTO contacts (address, number, city, postal_code, country, phone) 
VALUES ('Carrer de Proveïdor 3', '789', 'Barcelona', '08003', 'Spain', '+34 567 890 123');
INSERT INTO suppliers (name, idcard, fax, contact_id)  
VALUES ('OptiCare', '567890123C', '567-890-123', 3);

-- supplier 4:
INSERT INTO contacts (address, number, city, postal_code, country, phone)
VALUES ('Carrer del Proveïdor 4', '456', 'Barcelona', '08004', 'Spain', '+34 456 789 012');
INSERT INTO suppliers (name, idcard, fax, contact_id)
VALUES ('Euro-Optics', '987654321D', '987-654-321', 4);

-- INSERT clients
-- Client 1
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 1', '123', 'Principal', 'A', 'Barcelona', '08001', 'Spain', '+34 123 456 789');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Marcos García', 'client1@example.com', '12345678A', NOW(), LAST_INSERT_ID(), NULL);

-- Client 2
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 2', '234', '1st', 'B', 'Barcelona', '08002', 'Spain', '+34 234 567 890');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Anna Schmidt', 'client2@example.com', '23456789B', NOW(), LAST_INSERT_ID(), 1);  -- Referent amb id = 1

-- Client 3
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 3', '345', '2nd', 'C', 'Barcelona', '08003', 'Spain', '+34 345 678 901');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Hugo Dupont', 'client3@example.com', '34567890C', NOW(), LAST_INSERT_ID(), 1);  -- Referent amb id = 1

-- Client 4
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 4', '456', '3rd', 'D', 'Barcelona', '08004', 'Spain', '+34 456 789 012');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Luis Andersen', 'client4@example.com', '45678901D', NOW(), LAST_INSERT_ID(), NULL);

-- Client 5 
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 5', '567', '4th', 'E', 'Barcelona', '08005', 'Spain', '+34 567 890 123');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Sophie Van Damme', 'client5@example.com', '56789012E', NOW(), LAST_INSERT_ID(), 3);

-- Client 6
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 6', '678', '5th', 'F', 'Barcelona', '08006', 'Spain', '+34 678 901 234');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Javier Müller', 'client6@example.com', '67890123F', NOW(), LAST_INSERT_ID(), 2);

-- Client 7 
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 7', '789', '6th', 'G', 'Barcelona', '08007', 'Spain', '+34 789 012 345');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Ana López', 'client7@example.com', '78901234G', NOW(), LAST_INSERT_ID(), 2);

-- Client 8
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 8', '890', '7th', 'H', 'Barcelona', '08008', 'Spain', '+34 890 123 456');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Michel Kowalski', 'client8@example.com', '89012345H', NOW(), LAST_INSERT_ID(), 3);

-- Client 9
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 9', '901', '8th', 'I', 'Barcelona', '08009', 'Spain', '+34 901 234 567');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Giuseppe Rossi', 'client9@example.com', '90123456I', NOW(), LAST_INSERT_ID(), NULL);

-- Client 10
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Carrer del Client 10', '012', '9th', 'J', 'Barcelona', '08010', 'Spain', '+34 012 345 678');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Lena Müller', 'client10@example.com', '01234567J', NOW(), LAST_INSERT_ID(), 1);

-- INSERT glasses
INSERT INTO glasses (left_graduation, right_graduation, frame_type, frame_color, left_color, right_color, price, supplier_id, brand_id) VALUES (2.00, 1.75, 'floating', 'black', 'silver', 'silver', 150.00, 1, 1),
(0.00, 0.00, 'metal', 'black', 'silver', 'silver', 180.00, 1, 1),
(1.00, 1.50, 'metal', 'black', 'silver', 'silver', 200.00, 1, 1),
(0.00, 0.00, 'metal', 'black', 'silver', 'silver', 180.00, 2, 1),
(1.00, 1.50, 'metal', 'black', 'silver', 'silver', 200.00, 2, 3),
(1.00, 1.50, 'metal', 'black', 'silver', 'silver', 200.00, 3, 2),
(1.25, 1.25, 'metal', 'blue', 'green', 'green', 150.00, 1, 1), 
(1.50, 1.75, 'metal', 'black', 'blue', 'blue', 200.00, 2, 2),   
(0.75, 0.75, 'metal', 'silver', 'clear', 'clear', 180.00, 3, 3), 
(2.00, 2.00, 'metal', 'red', 'yellow', 'yellow', 250.00, 1, 4), 
(1.00, 0.50, 'metal', 'green', 'grey', 'grey', 220.00, 2, 5),   
(1.75, 1.25, 'metal', 'purple', 'brown', 'brown', 170.00, 3, 1), 
(2.50, 2.25, 'metal', 'orange', 'pink', 'pink', 210.00, 1, 2), 
(1.00, 1.50, 'plastic', 'yellow', 'red', 'red', 190.00, 2, 3),    
(0.50, 0.25, 'plastic', 'blue', 'black', 'black', 160.00, 3, 4), 
(1.25, 1.75, 'plastic', 'grey', 'blue', 'blue', 230.00, 1, 5),  
(2.00, 1.75, 'floating', 'black', 'silver', 'silver', 150.00, 1, 1), 
(0.00, 0.00, 'metal', 'black', 'silver', 'silver', 180.00, 1, 1), 
(1.00, 1.50, 'metal', 'black', 'silver', 'silver', 200.00, 1, 1), 
(0.00, 0.00, 'metal', 'black', 'silver', 'silver', 180.00, 2, 1), 
(1.00, 1.50, 'metal', 'black', 'silver', 'silver', 200.00, 2, 3), 
(1.00, 1.50, 'metal', 'black', 'silver', 'silver', 200.00, 3, 2), 
(2.25, 2.00, 'floating', 'black', 'silver', 'silver', 150.00, 1, 1), 
(1.50, 1.25, 'metal', 'black', 'silver', 'silver', 180.00, 1, 1), 
(2.75, 2.50, 'metal', 'black', 'silver', 'silver', 200.00, 1, 1), 
(1.25, 1.00, 'metal', 'black', 'silver', 'silver', 180.00, 2, 1), 
(0.25, 0.75, 'metal', 'black', 'silver', 'silver', 200.00, 2, 3), 
(2.00, 2.50, 'metal', 'black', 'silver', 'silver', 200.00, 3, 2), 
(1.50, 1.75, 'floating', 'black', 'silver', 'silver', 150.00, 1, 1), 
(2.25, 2.75, 'metal', 'black', 'silver', 'silver', 180.00, 1, 1), 
(2.50, 2.25, 'metal', 'black', 'silver', 'silver', 200.00, 1, 1), 
(2.75, 2.50, 'plastic', 'black', 'silver', 'silver', 180.00, 2, 1);

-- INSERT sales
INSERT INTO sales (sale_date, employee_id, client_id, glasses_id)
VALUES
	('2022-09-05 11:05:00', 1, 1, 1),
	('2022-09-12 11:05:00', 1, 10, 2),
	('2022-10-10 11:05:00', 2, 2, 3),
	('2022-11-15 11:05:00', 3, 3, 4),
	('2022-12-20 11:05:00', 1, 4, 5),
	('2023-01-25 11:05:00', 2, 5, 6),
	('2023-02-28 11:05:00', 3, 6, 7),
	('2023-03-05 11:05:00', 1, 7, 8),
	('2023-04-10 11:05:00', 2, 8, 9),
	('2023-05-15 11:05:00', 3, 9, 10),
    ('2024-06-01 10:00:00', 1, 1, 11),
    ('2024-06-02 11:30:00', 2, 2, 12),
    ('2024-06-03 09:45:00', 3, 3, 13),
    ('2024-06-04 13:15:00', 1, 4, 14),
    ('2024-06-05 14:00:00', 2, 5, 15),
    ('2024-06-06 16:30:00', 3, 6, 16),
    ('2024-06-07 08:45:00', 1, 7, 17),
    ('2024-06-08 12:00:00', 2, 8, 18),
    ('2024-06-09 15:20:00', 3, 9, 19),
    ('2024-06-10 17:00:00', 1, 10, 20),
    ('2024-06-11 09:30:00', 2, 1, 21),
    ('2024-06-12 11:45:00', 3, 2, 22),
    ('2024-06-13 14:10:00', 1, 3, 23),
    ('2024-06-14 16:20:00', 2, 4, 24),
    ('2024-06-15 08:00:00', 3, 5, 25),
    ('2024-06-16 10:45:00', 1, 6, 26),
    ('2024-06-17 13:30:00', 2, 7, 27),
    ('2024-06-18 15:50:00', 3, 8, 28),
    ('2024-06-19 09:15:00', 1, 9, 29),
    ('2024-06-20 12:30:00', 2, 10, 30),
    ('2024-06-21 14:40:00', 3, 1, 31);