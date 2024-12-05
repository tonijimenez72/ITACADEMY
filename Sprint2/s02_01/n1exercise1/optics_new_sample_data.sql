USE optics;

-- INSERT brands
INSERT INTO brands (name) VALUES 
    ('Brand1'),
    ('Brand2'),
    ('Brand3');

-- INSERT employees
INSERT INTO employees (name) VALUES
    ('Employee1'),
    ('Employee2');

-- INSERT suppliers
-- supplier 1: 
INSERT INTO contacts (address, number, city, postal_code, country, phone) 
VALUES ('Supplier1 address', '1', 'Barcelona', '08001', 'Spain', '+34 111 111 111');
INSERT INTO suppliers (name, idcard, fax, contact_id) 
VALUES ('Supplier1', '11111111A', '+34 111 111 111', 1);

-- supplier 2: 
INSERT INTO contacts (address, number, city, postal_code, country, phone) 
VALUES ('Supplier2 address', '2', 'Barcelona', '08002', 'Spain', '+34 222 222 222');
INSERT INTO suppliers (name, idcard, fax, contact_id) 
VALUES ('Supplier2', '22222222B', '+34 222 222 222', 2);

-- supplier 3: 
INSERT INTO contacts (address, number, city, postal_code, country, phone) 
VALUES ('Supplier3 address', '3', 'Barcelona', '08003', 'Spain', '+34 333 333 333');
INSERT INTO suppliers (name, idcard, fax, contact_id) 
VALUES ('Supplier3', '33333333C', '+34 333 333 333', 3);

-- INSERT clients
-- Client 1
INSERT INTO contacts (address, number, floor, door, city, postal_code, country, phone)
VALUES ('Client1 address', '11', '1', 'A', 'Barcelona', '08001', 'Spain', '+34 111 111 113');
INSERT INTO clients (name, email, idCard, registration_date, contact_id, refered_by_id)
VALUES ('Client1', 'client1@example.com', '11111112C', NOW(), LAST_INSERT_ID(), NULL);


-- INSERT glasses
INSERT INTO glasses (left_graduation, right_graduation, frame_type, frame_color, left_color, right_color, price, supplier_id, brand_id) VALUES 
	(2.00, 1.75, 'floating', 'black', 'silver', 'silver', 150.00, 1, 1);