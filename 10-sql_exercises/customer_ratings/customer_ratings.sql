-- • Add an additional table to your schema, to store records of customer ratings for movies
-- 	o Foreign key constraints/ cardinality should be set appropriately
-- • Create (manually or randomly) 20-30 records in the customer ratings table
--  • List each movie, including the highest, lowest, and average score they received, as well as the
-- number of reviews

USE sakila;
DROP TABLE IF EXISTS customer_rating;
CREATE TABLE customer_rating(
	id INT NOT NULL AUTO_INCREMENT,
    customer_id SMALLINT UNSIGNED,
    film_id SMALLINT UNSIGNED,
    rating_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY(film_id) REFERENCES film(film_id),
    FOREIGN KEY(rating_id) REFERENCES rating(rating_id)
);
INSERT INTO customer_rating(customer_id, film_id, rating_id) VALUES
(1,1,2), (2,1,4), (3,1,3), (4,1,2), (5,1,5), (6,1,6), (7,1,4), (8,1,3), (9,1,5), (10,1,4),
(1,2,2), (2,2,4), (3,2,3), (4,2,2), (5,3,5), (6,3,6), (7,4,4), (8,4,3), (9,5,5), (10,6,4),
(1,7,2), (2,7,4), (3,7,3), (4,8,2), (5,8,5), (6,9,6), (7,9,4), (8,10,3), (9,10,5), (10,10,4);

SELECT film.film_id, 
film.title AS film_title,
(MAX(rating.num_stars)) highest_rating, 
(MIN(rating.num_stars)) lowest_rating, 
(AVG(rating.num_stars)) avg_rating,
(COUNT(rating.num_stars)) num_reviews
FROM rating 
INNER JOIN customer_rating ON rating.rating_id = customer_rating.rating_id
INNER JOIN film ON film.film_id = customer_rating.film_id
GROUP BY film_id;


