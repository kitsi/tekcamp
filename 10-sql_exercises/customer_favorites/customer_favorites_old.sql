-- • For those customers with one of your initials in their name, *** initial = 'k' ***
-- 		list their most-often-rented movie category, 
-- 		from their past 10 rentals

use sakila;

SELECT customer_id, (CONCAT(customer.first_name, ' ', customer.last_name)) customer
from customer
where customer.first_name like '%k%' or customer.last_name like ('%k%');

SELECT (CONCAT(customer.first_name, ' ', customer.last_name)) customer,
(category.name) category,
(count(*)) times_rented
from customer
join rental on customer.customer_id = rental.customer_id
join inventory on rental.inventory_id = inventory.inventory_id
join film on inventory.film_id = film.film_id
join film_category on film_category.film_id = film.film_id
join category on film_category.category_id = category.category_id
where customer.first_name like '%k%' or customer.last_name like ('%k%')
group by CONCAT(customer.first_name, ' ', customer.last_name), category.name;

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
