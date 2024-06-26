USE pizzeria;

-- employee_id 1 is not a deliverer
-- INSERT INTO deliveries (delivery_date, order_id, deliverer_id) VALUES ('2024-06-21 10:00:00', 1, 1);

-- drinks don't have categories
INSERT INTO products (name, product, price, category_id) VALUES ('Cola', 'drink', 2.50, 2);
