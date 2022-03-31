-- Retrieve a list of all customers whose first and last names contain one of your initials
USE sakila;
SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM customer
	WHERE CONCAT(first_name, ' ', last_name) LIKE '%k%';
