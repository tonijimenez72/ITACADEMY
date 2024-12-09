USE tienda;

SELECT nombre FROM producto;

SELECT nombre, precio FROM producto;

SELECT * FROM producto;

SELECT nombre AS name, precio AS eur_price, FORMAT(precio * 0.93, 2) AS usd_price FROM producto;

SELECT nombre AS 'nom de producte' , precio AS euros, FORMAT(precio * 0.93, 2) AS 'dòlars' FROM producto;

SELECT UPPER(nombre), precio FROM producto;

SELECT LOWER(nombre), precio FROM producto;

SELECT nombre, UPPER(LEFT(nombre, 2)) AS 'upper 2' FROM fabricante;

SELECT nombre, ROUND(precio) AS precio FROM producto;

SELECT nombre, CAST(precio AS SIGNED) AS precio FROM producto;

SELECT codigo_fabricante FROM producto;

SELECT DISTINCT codigo_fabricante FROM producto;

SELECT codigo_fabricante, COUNT(*) AS cantidad_productos FROM producto GROUP BY codigo_fabricante;

SELECT nombre FROM fabricante ORDER by nombre;

SELECT nombre FROM fabricante ORDER BY nombre DESC;

SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;

SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;

SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;

SELECT * FROM fabricante LIMIT 5;

SELECT * FROM fabricante ORDER BY codigo LIMIT 3, 2;

SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;

SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;

SELECT nombre, precio FROM producto WHERE codigo_fabricante = 2;

SELECT producto.nombre AS producto, producto.precio AS precio, fabricante.nombre AS fabricante FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo;

SELECT fabricante.nombre AS fabricante, producto.nombre AS producto, producto.precio AS precio FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo ORDER BY fabricante;

SELECT  producto.codigo AS 'cod. producto', producto.nombre AS producto, producto.codigo_fabricante AS 'cod. fabricante', fabricante.nombre AS fabricante FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo;

SELECT producto.nombre AS nombre, producto.precio AS precio, fabricante.nombre AS fabricante FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo ORDER BY precio ASC LIMIT 1;

SELECT producto.nombre AS nombre, producto.precio AS precio, fabricante.nombre AS fabricante FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo ORDER BY precio DESC LIMIT 1;

SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre = 'Lenovo';

SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre = 'Crucial' AND producto.precio > 200;

SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre = 'Asus' OR fabricante.nombre = 'Hewlett-Packard' OR fabricante.nombre = 'Seagate';

SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre IN ('Asus', 'Hewlett-Packard', 'Seagate');

SELECT * FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre IN ('Asus', 'Hewlett-Packard', 'Seagate');

SELECT producto.nombre, producto.precio FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE LOWER(RIGHT(fabricante.nombre, 1)) = 'e';

SELECT producto.nombre, producto.precio FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE LOWER(fabricante.nombre) LIKE '%w%';

SELECT producto.nombre AS producto, producto.precio AS precio, fabricante.nombre AS fabricante FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE producto.precio >= 180 ORDER BY producto.precio DESC, producto.nombre ASC; -- no funciona

SELECT codigo_fabricante AS 'código', fabricante.nombre AS fabricante, COUNT(*) AS productos FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo GROUP BY codigo_fabricante ORDER BY productos DESC;

SELECT fabricante.nombre AS fabricante, producto.nombre AS producto FROM fabricante LEFT JOIN producto ON fabricante.codigo = producto.codigo_fabricante ORDER BY fabricante ASC;

SELECT fabricante.nombre, producto.codigo_fabricante AS producto FROM fabricante LEFT JOIN producto ON fabricante.codigo = producto.codigo_fabricante WHERE producto.codigo_fabricante IS NULL;

SELECT producto.nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo');

SELECT * FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo')); 

SELECT producto.nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo') ORDER BY precio DESC LIMIT 1;

SELECT producto.nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Hewlett-Packard') ORDER BY precio ASC LIMIT 1;

SELECT * FROM producto WHERE precio > (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));

SELECT producto.codigo AS codigo_producto, producto.nombre AS producto, producto.precio, fabricante.nombre AS fabricante  FROM producto JOIN fabricante ON producto.codigo_fabricante = fabricante.codigo WHERE fabricante.nombre = 'Asus' AND producto.precio > (SELECT AVG(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus'));