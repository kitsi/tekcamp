-- Retrieve a list of all the films that have the same 2-3 letters (of your choice, and they don’t need
-- to be together) in the title, and that are over 2 hours long
USE sakila;
SELECT title, length FROM film 
	WHERE length > 120 AND title LIKE '%k%s%';