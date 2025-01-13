USE fruits_db;

CREATE TABLE IF NOT EXISTS fruits (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    weight_in_kilograms DECIMAL(10,2) NOT NULL
);