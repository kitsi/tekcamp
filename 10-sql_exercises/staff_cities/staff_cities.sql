-- Retrieve a list of all staff that have their home store in a certain city (a city of your choice)
-- city of choice = Woodridge (Australia)

USE sakila;
SELECT staff.first_name, 
staff.last_name, 
city.city AS home_store_city
FROM staff
JOIN store ON staff.store_id = store.store_id
JOIN address ON store.address_id = address.address_id
JOIN city ON address.city_id = city.city_id
WHERE city.city_id=576;