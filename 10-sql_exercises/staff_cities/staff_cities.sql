-- Retrieve a list of all staff that have their home store in a certain city (a city of your choice)
-- city of choice = Woodridge (Australia)

use sakila;
select staff.first_name, 
staff.last_name, 
city.city as home_store_city
from staff
join store on staff.store_id = store.store_id
join address on store.address_id = address.address_id
join city on address.city_id = city.city_id
where city.city_id=576;