USE optics_new;

-- sales by a customer in a given period of time
SELECT
    sales.id AS sale_id, 
    sales.sale_date,
    sales.client_id,
    clients.name AS client_name,
    employees.name AS employee_name,
    brands.name AS brand_name,
    suppliers.name AS supplier_name,
    glasses.left_graduation,
    glasses.right_graduation,
    glasses.frame_type,
    glasses.frame_color,
    glasses.left_color,
    glasses.right_color,
    glasses.price
FROM sales
JOIN glasses ON sales.glasses_id = glasses.id
JOIN employees ON sales.employee_id = employees.id
JOIN clients ON sales.client_id = clients.id
JOIN brands ON glasses.brand_id = brands.id    
JOIN suppliers ON brands.supplier_id = suppliers.id
WHERE sales.client_id = 3 AND sales.sale_date BETWEEN '2022-01-01' AND '2024-12-31'
ORDER BY sales.sale_date;

-- models sold by employee in the last year
/*SELECT 
	sales.id AS sale_id, sales.sale_date, 
    employees.name AS employee_name,
    brands.name AS brand_name,
    glasses.price
FROM sales
JOIN glasses ON sales.glasses_id = glasses.id
JOIN employees ON sales.employee_id = employees.id
JOIN brands ON glasses.brand_id = brands.id    
WHERE sales.sale_date BETWEEN DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND CURDATE() AND sales.employee_id = 1*/

-- suppliers ranking
SELECT 
    suppliers.id AS supplier_id,
    suppliers.name AS supplier_name,
    brands.name AS brands_name,
    COUNT(glasses.id) AS number_of_glasses_sold
FROM sales
JOIN glasses ON sales.glasses_id = glasses.id
JOIN brands ON glasses.brand_id = brands.id    
JOIN suppliers ON brands.supplier_id = suppliers.id
GROUP BY suppliers.id, suppliers.name, brands.name
ORDER BY number_of_glasses_sold DESC;