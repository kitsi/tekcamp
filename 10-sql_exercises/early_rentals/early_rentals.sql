-- Retrieve a list of the most recent
-- 10 rentals 
-- that occurred before 10AM
-- Include all columns from rental, 
-- as well as the date (not including the time) that the rental occurred

USE sakila;
SELECT rental_id, date(rental_date) AS rent_date, inventory_id, customer_id, return_date, staff_id, last_update from rental
WHERE HOUR(rental_date)<'10'
ORDER BY rental_date DESC
LIMIT 10;