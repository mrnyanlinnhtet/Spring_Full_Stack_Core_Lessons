CREATE DATABASE jdc_class;

TRUNCATE TABLE courses;

CREATE TABLE courses(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL UNIQUE,
level INT DEFAULT 0,
month INT,
fees DECIMAL(10,2)
);