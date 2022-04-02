use sakila;

-- select count(*) from category;
-- select count(film_category.category_id)
-- select count(distinct category_id)
-- from film_category;
-- from film
-- group by count(category_id);

-- select film_id, category_id
-- from film_category
-- limit 20;

-- select film_id, category_id, count(*)
-- from film_category
-- group by film_id, category_id
-- order by count(*) desc;


-- SELECT (CONCAT(customer.first_name, ' ', customer.last_name)) customer,
-- (film.title) film_title,
-- (category.name) category,
-- (rental.rental_date) rental_date
-- -- (count(*)) times_rented
-- from customer
-- join rental on customer.customer_id = rental.customer_id
-- join inventory on rental.inventory_id = inventory.inventory_id
-- join film on inventory.film_id = film.film_id
-- join film_category on film_category.film_id = film.film_id
-- join category on film_category.category_id = category.category_id
-- where customer.first_name like '%k%' or customer.last_name like ('%k%')
-- -- group by CONCAT(customer.first_name, ' ', customer.last_name), category.name;
-- order by customer.customer_id, rental.rental_date desc;


-- WITH customer_rentals
-- AS (SELECT 
-- ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY customer_id, name) AS rownum1,
-- customer_id,
-- category.name
-- FROM rental
-- JOIN inventory ON inventory.inventory_id = rental.inventory_id
-- JOIN film ON film.film_id = inventory.film_id
-- JOIN film_category ON film_category.film_id = film.film_id
-- JOIN category ON category.category_id = film_category.category_id
-- GROUP BY customer_id, rental_date
-- ORDER BY customer_id, rental_date)

-- SELECT * FROM (
-- SELECT * ,
-- ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY customer_id, rownum2 DESC) AS rownum3
-- FROM (
-- SELECT
-- ROW_NUMBER() OVER (PARTITION BY customer_id, name ORDER BY customer_id) AS rownum2,
-- customer_rentals.rownum1,
-- customer_id,
-- customer_rentals.name
-- FROM customer_rentals
-- WHERE
-- customer_rentals.rownum1 <= 10) AS x) AS y
-- WHERE rownum3 = 1;


-- WITH customer_rentals
-- AS (SELECT 
-- ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY customer_id, name) AS rownum1,
-- customer_id,
-- category.name
-- FROM rental
-- JOIN inventory ON inventory.inventory_id = rental.inventory_id
-- JOIN film ON film.film_id = inventory.film_id
-- JOIN film_category ON film_category.film_id = film.film_id
-- JOIN category ON category.category_id = film_category.category_id
-- GROUP BY customer_id, rental_date
-- ORDER BY customer_id, rental_date)

SELECT * FROM (
SELECT * ,
ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY customer_id, rownum2 DESC) AS rownum3
FROM (
SELECT
ROW_NUMBER() OVER (PARTITION BY customer_id, name ORDER BY customer_id) AS rownum2,
customer_rentals.rownum1,
customer_id,
customer_rentals.name
FROM 
(SELECT 
ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY customer_id, name) AS rownum1,
customer_id,
category.name
FROM rental
JOIN inventory ON inventory.inventory_id = rental.inventory_id
JOIN film ON film.film_id = inventory.film_id
JOIN film_category ON film_category.film_id = film.film_id
JOIN category ON category.category_id = film_category.category_id
GROUP BY customer_id, rental_date
ORDER BY customer_id, rental_date)
customer_rentals
WHERE
customer_rentals.rownum1 <= 10) AS x) AS y
WHERE rownum3 = 1;