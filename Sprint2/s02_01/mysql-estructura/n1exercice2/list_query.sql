USE pizzeria;

SELECT
    orders.id AS order_id,
    orders.order_date,
    orders.employee_id,
    orders.store_id,
    orders.client_id,
    clients.name AS client_name,
    clients.surname AS client_surname,
    products.name AS product_name,
    products.price AS product_price,
    SUM(products.price * orderdetails.quantity) AS product_total_price,
    (SELECT SUM(products.price * orderdetails.quantity)
     FROM orderdetails
     JOIN products ON orderdetails.product_id = products.id
     WHERE orderdetails.order_id = orders.id) AS order_total_price,
    orders.order_type,
    deliveries.delivery_date AS delivery_date,
    deliveries.deliverer_id AS deliverer_id,
    employees.name AS deliverer_name,
    employees.surname AS deliverer_surname
FROM orders
JOIN orderdetails ON orders.id = orderdetails.order_id
JOIN products ON orderdetails.product_id = products.id
JOIN clients ON orders.client_id = clients.id
LEFT JOIN deliveries ON deliveries.order_id = orders.id
LEFT JOIN Employees ON deliveries.deliverer_id = employees.id
GROUP BY orders.id, orders.order_date, orders.employee_id, orders.store_id, orders.client_id, clients.name, clients.surname, products.name,
	products.price, orders.order_type, deliveries.deliverer_id, deliveries.delivery_date
ORDER BY orders.id;