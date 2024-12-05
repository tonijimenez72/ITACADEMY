USE pizzeria_new;

-- drinks by city query
SELECT
    orders.id AS order_id,
    orders.order_date,
    cities.name AS city_name,
    products.product AS product_type,
    products.name AS product_name,
    orderdetails.quantity
FROM
    orders
JOIN
    orderdetails ON orders.id = orderdetails.order_id
JOIN
    products ON orderdetails.product_id = products.id
JOIN
    clients ON orders.client_id = clients.id
JOIN
    stores ON orders.store_id = stores.id
JOIN
    cities ON stores.city_id = cities.id
WHERE
    products.product = 'drink' AND   cities.id = 1 -- select city id
ORDER BY
    orders.id;
	
-- orders by employee
SELECT
    employees.id AS employee_id,
    employees.name AS employee_name,
    employees.surname AS employee_surname,
    COUNT(orders.id) AS total_orders
FROM
    orders
JOIN
    employees ON orders.employee_id = employees.id
WHERE
    employees.id = 1 OR employees.id = 2
GROUP BY
    employees.id, employees.name, employees.surname;