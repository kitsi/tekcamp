-- • Retrieve a list of customers that 
-- 		rented more than one movie 
-- 		on the same day, 
-- 		and list the
-- 			customer, rental date, number of rentals, and total amount paid for that day’s rentals

USE sakila;

SELECT (CONCAT(customer.first_name, ' ', customer.last_name)) customer, 
	(DATE(rental.rental_date)) rental_date, 
	(COUNT(rental.rental_id)) num_rentals, 
	(SUM(payment.amount)) days_total
FROM customer
	JOIN rental ON rental.customer_id = customer.customer_id
	JOIN payment ON payment.rental_id = rental.rental_id
GROUP BY customer.customer_id, DATE(rental.rental_date)
HAVING (COUNT(rental.rental_id)) > 1;