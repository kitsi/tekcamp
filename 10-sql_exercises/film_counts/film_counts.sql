-- Retrieve a list of the number of copies of each film that are in each store’s inventory 
USE sakila;
SELECT store_id, film_id, count(*) as num_copies 
	FROM inventory 
    GROUP BY store_id, film_id;