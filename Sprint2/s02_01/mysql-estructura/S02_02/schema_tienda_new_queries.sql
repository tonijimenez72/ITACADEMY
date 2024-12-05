USE tienda;

-- List the name of all products in the 'producto' table.
SELECT nombre FROM producto;

-- List the names and prices of all products in the 'producto' table.
SELECT nombre, precio FROM producto;

-- List all columns from the 'producto' table.
SELECT * FROM producto;

-- List the name of the products, their price in euros, and their price in US dollars (USD).
SELECT nombre AS name, precio AS eur_price, FORMAT(precio * 0.93, 2) AS usd_price FROM producto;

-- List the name of the products, price in euros, and price in USD with the following aliases: product name, euros, dollars.
SELECT nombre AS 'product name', precio AS euros, FORMAT(precio * 0.93, 2) AS 'dollars' FROM producto;

-- List the names and prices of all products in the 'producto' table, converting the names to uppercase.
SELECT UPPER(nombre), precio FROM producto;

-- List the names and prices of all products in the 'producto' table, converting the names to lowercase.
SELECT LOWER(nombre), precio FROM producto;

-- List the name of all manufacturers in one column and the uppercase first two characters of their name in another column.
SELECT nombre, UPPER(LEFT(nombre, 2)) AS 'upper 2' FROM fabricante;

-- List the names and prices of all products in the 'producto' table, rounding the price value.
SELECT nombre, ROUND(precio) AS precio FROM producto;

-- List the names and prices of all products in the 'producto' table, truncating the price value to show no decimal digits.
SELECT nombre, CAST(precio AS SIGNED) AS precio FROM producto;

-- List the manufacturer codes that have products in the 'producto' table.
SELECT codigo_fabricante FROM producto;

-- List the manufacturer codes that have products in the 'producto' table, removing duplicates.
SELECT DISTINCT codigo_fabricante FROM producto;

-- Count the number of products per manufacturer and group them by their codes.
SELECT codigo_fabricante, COUNT(*) AS cantidad_productos FROM producto GROUP BY codigo_fabricante;

-- List the names of manufacturers in ascending order.
SELECT nombre FROM fabricante ORDER BY nombre;

-- List the names of manufacturers in descending order.
SELECT nombre FROM fabricante ORDER BY nombre DESC;

-- List the names of products ordered first by name (ascending) and then by price (descending).
SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;

-- Return a list with the first 5 rows from the 'fabricante' table.
SELECT * FROM fabricante LIMIT 5;

-- Return a list with 2 rows starting from the fourth row of the 'fabricante' table, including the fourth row.
SELECT * FROM fabricante ORDER BY codigo LIMIT 3, 2;

-- List the name and price of the cheapest product using only ORDER BY and LIMIT.
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;

-- List the name and price of the most expensive product using only ORDER BY and LIMIT.
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;

-- List the name of all products from the manufacturer whose code is equal to 2.
SELECT nombre, precio FROM producto WHERE codigo_fabricante = 2;

-- Return a list with the product name, price, and manufacturer name of all products in the database.
SELECT producto.nombre AS product, producto.precio AS price, fabricante.nombre AS manufacturer FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo;

-- Return the same list as above, but sorted alphabetically by manufacturer name.
-- SELECT fabricante.nombre AS manufacturer, producto.nombre AS product, producto.precio AS price FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo ORDER BY fabricante;

-- Return a list with the product code, product name, manufacturer code, and manufacturer name of all products.
SELECT producto.codigo AS 'product code', producto.nombre AS product, producto.codigo_fabricante AS 'manufacturer code', fabricante.nombre AS manufacturer FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo;

-- Return the name, price, and manufacturer name of the cheapest product.
SELECT producto.nombre AS name, producto.precio AS price, fabricante.nombre AS manufacturer FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo ORDER BY precio ASC LIMIT 1;

-- Return the name, price, and manufacturer name of the most expensive product.
SELECT producto.nombre AS name, producto.precio AS price, fabricante.nombre AS manufacturer FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo ORDER BY precio DESC LIMIT 1;

-- Return a list of all products from the manufacturer Lenovo.
SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre = 'Lenovo';

-- Return a list of all products from the manufacturer Crucial with a price greater than 200€.
SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre = 'Crucial' AND producto.precio > 200;

-- Return a list of all products from manufacturers Asus, Hewlett-Packard, and Seagate without using the IN operator.
SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre = 'Asus' OR fabricante.nombre = 'Hewlett-Packard' OR fabricante.nombre = 'Seagate';

-- Return the same list as above but using the IN operator.
SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre IN ('Asus', 'Hewlett-Packard', 'Seagate');

-- Return a list with the product name and price of products where the manufacturer name ends with the letter 'e'.
SELECT producto.nombre, producto.precio FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE LOWER(RIGHT(fabricante.nombre, 1)) = 'e';

-- Return a list with the product name and price where the manufacturer name contains the character 'w'.
SELECT producto.nombre, producto.precio FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE LOWER(fabricante.nombre) LIKE '%w%';

-- Return a list of products with price >= 180€, sorted by price (descending) and name (ascending).
SELECT producto.nombre AS product, producto.precio AS price, fabricante.nombre AS manufacturer FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE producto.precio >= 180 ORDER BY producto.precio DESC, producto.nombre ASC;

-- Return a list of manufacturer codes, names, and product counts (only for those with products in the database).
SELECT codigo_fabricante AS 'code', fabricante.nombre AS manufacturer, COUNT(*) AS products FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo GROUP BY codigo_fabricante ORDER BY products DESC;

-- Return all manufacturers in the database along with their products, including those without associated products.
SELECT fabricante.nombre AS manufacturer, producto.nombre AS product FROM fabricante LEFT JOIN producto ON fabricante.codigo = producto.codigo_fabricante ORDER BY fabricante ASC;

-- Return only manufacturers without any associated products.
SELECT fabricante.nombre, producto.codigo_fabricante AS product FROM fabricante LEFT JOIN producto ON fabricante.codigo = producto.codigo_fabricante WHERE producto.codigo_fabricante IS NULL;

-- Return all products from the manufacturer Lenovo (without using INNER JOIN).
SELECT producto.nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo');

-- Return all products with the same price as the most expensive product from Lenovo (without using INNER JOIN).
SELECT * FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));

-- List the name of the most expensive product from the manufacturer Lenovo.
SELECT producto.nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo') ORDER BY precio DESC LIMIT 1;

-- List the name of the cheapest product from the manufacturer Hewlett-Packard.
SELECT producto.nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Hewlett-Packard') ORDER BY precio ASC LIMIT 1;

-- Return all products in the database with a price greater than or equal to the most expensive product from Lenovo.
SELECT * FROM producto WHERE precio >= (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));

-- List all products from the manufacturer Asus with a price greater than the average price of all their products.
SELECT producto.codigo AS product_code, producto.nombre AS product, producto.precio, fabricante.nombre AS manufacturer FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre = 'Asus' AND producto.precio > (SELECT AVG(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus'));
SELECT fabricante.nombre AS manufacturer, producto.nombre AS product, producto.precio AS price FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo ORDER BY fabricante LIMIT 0, 50000
