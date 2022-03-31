-- Retrieve a list of the most recent 10 rentals that occurred before 10AM
-- o Include all columns from rental, as well as the date (not including the time) that the rental
-- 	 occurred

USE sakila;
select * from rental
WHERE HOUR(rental_date)<'10';