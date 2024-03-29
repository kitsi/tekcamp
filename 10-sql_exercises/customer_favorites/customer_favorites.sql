-- • For those customers with one of your initials in their name, *** initial = 'k' ***
-- 		list their most-often-rented movie category, 
-- 		from their past 10 rentals

use sakila;

WITH customer_rentals
AS (SELECT 
		ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY customer_id, name) rownum1,
		rental.customer_id,
        (CONCAT(customer.first_name, ' ', customer.last_name)) customer_name,
		category.name
	FROM rental
	JOIN inventory ON inventory.inventory_id = rental.inventory_id
	JOIN film ON film.film_id = inventory.film_id
	JOIN film_category ON film_category.film_id = film.film_id
	JOIN category ON category.category_id = film_category.category_id
    JOIN customer ON rental.customer_id = customer.customer_id
	GROUP BY customer_id, name, rental_date
    HAVING customer_name like '%k%'
    ORDER BY customer_id, rental_date)

SELECT * FROM (
	SELECT * ,
			ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY customer_id, rownum2 DESC) rownum3
			FROM (
				SELECT
					ROW_NUMBER() OVER (PARTITION BY customer_id, customer_rentals.name ORDER BY customer_id) rownum2,
					customer_rentals.rownum1,
					customer_id,
                    customer_rentals.customer_name,
					(customer_rentals.name) favorite_category
				FROM customer_rentals
				WHERE
					customer_rentals.rownum1 <= 10) AS x) AS y
	WHERE rownum3 = 1;

