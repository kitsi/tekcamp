use sakila;

WITH customer_rentals
AS (SELECT 
		ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY customer_id, name) AS rownum1,
		customer_id,
		category.name
	FROM rental
	JOIN inventory ON inventory.inventory_id = rental.inventory_id
	JOIN film ON film.film_id = inventory.film_id
	JOIN film_category ON film_category.film_id = film.film_id
	JOIN category ON category.category_id = film_category.category_id
	GROUP BY customer_id, name, rental_date
	ORDER BY customer_id, rental_date)

SELECT * FROM (
	SELECT * ,
			ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY customer_id, rownum2 DESC) AS rownum3
			FROM (
				SELECT
					ROW_NUMBER() OVER (PARTITION BY customer_id, customer_rentals.name ORDER BY customer_id) AS rownum2,
					customer_rentals.rownum1,
					customer_id,
					customer_rentals.name
				FROM customer_rentals
				WHERE
					customer_rentals.rownum1 <= 10) AS x) AS y
	WHERE rownum3 = 1;

