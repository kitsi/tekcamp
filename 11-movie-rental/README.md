## TEK.MDB
TEK.MDB is an API that provides functionality for reviews and ratings using the sakila database. It provides routing within controllers using standard REST naming and functionality. The client has the ability to view a list of customers & films, and also view each individually using GET methods. Along with accessing using GET methods, the client also has the ability to create, update, and delete ratings (using POST, PUT and DELETE methods) in the form of number of stars & descriptions for movies, which can then be used by customers to review movies in the database. Once the reviews are created, they may also be read, updated, or deleted.

### A. IntelliJ setup *before* running app

1) Run Mysql with sakila. Note the useername & password to enter in the next step

2) Create a 'src/main/resources/application.properties' file with the following:
```
    spring.datasource.url = jdbc:mysql://localhost:3306/sakila
    spring.datasource.username = [your username]
    spring.datasource.password = [your password]
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    spring.jpa.generate-ddl = true
    spring.jpa.hibernate.ddl-auto = update
```

### B. Run the app in IntelliJ from the MovieRentalApp file or the console
To confirm, at the bottom of the console, the last line will say ``server side wired up!`` and you should see a message similar to ``Tomcat started on port(s): 8080`` Make note of this port for the url to access Swagger

### C. Add data to rating & review tables
Once the app is running in IntelliJ, the rating and review tables should be automatically created. Then run the following sql in Mysql Workbench to populate both tables with data

```
use sakila;

INSERT INTO rating(num_stars, description)
	VALUES
	    (0, 'worst movie ever'),
	    (1, 'dissapointing'),
	    (2, 'bearable'),
	    (3, 'just fine'),
	    (4, 'pretty good'),
	    (5, 'awesome');

INSERT INTO review(customer_id, film_id, rating_id) VALUES
(1,1,2), (2,1,4), (3,1,3), (4,1,2), (5,1,5), (6,1,6), (7,1,4), (8,1,3), (9,1,5), (10,1,4),
(1,2,2), (2,2,4), (3,2,3), (4,2,2), (5,3,5), (6,3,6), (7,4,4), (8,4,3), (9,5,5), (10,6,4),
(1,7,2), (2,7,4), (3,7,3), (4,8,2), (5,8,5), (6,9,6), (7,9,4), (8,10,3), (9,10,5), (10,10,4);
```

### D. Interact with the API

Navigate to ``http://localhost:8080/swagger-ui/index.html#/`` in your web browser (change the port in this url to whatever Tomcat is using as noted in step B. Interaction below is demonstrated using ``review-controller``. Other controller methods are set up similarly.
1) **Review controller methods**<br />
   Expand the review controller accordian to view the methods available
   ![review controller methods](https://i.imgur.com/NGJ2ZiL.png)
   1) **GET /api/reviews**<br />
      Next, expand the fourth option under review-controller to see the reviews & click on the ``Try it out`` button
      ![get reviews method](https://i.imgur.com/jMuzUVL.png)
      This method provides the option for paging. Default values are provided for the first page and the first 10 rows of data. Unless a different page number or page size is desired, no data needs to be entered here.<br />
      To see reviews, click on the blue ``Execute`` button
      ![execute](https://i.imgur.com/4o08Fvt.png)
      Here is a sample of the response
      ![get reivews responst](https://i.imgur.com/90SDGLC.png)
   2) **GET /api/reviews/{id}**<br />
     To receive only one review by id, expand the first method under review-controller, <br/>
     click on ``Try it out``,
     enter an id in the required id field, and
     press the big blue ``Execute`` button<br />
     ![get review with id](https://i.imgur.com/nOA0t7B.png)
     The response will provide details of one review
     ![get review with id response](https://i.imgur.com/O5d94MA.png)
   3) **POST /api/reviews/**<br />
   To add a review, expand the last method of the review-controller & press ``Try it out``<br />
   Enter a **customerId**, **filmId**, and **ratingId** & press ``Execute``<br />
   (reviewID is auto incremented & data entered in other fields is ignored since only the ids for customers, films, and rating are used as foreign keys & included in the Review model)
   ![post review enter data](https://i.imgur.com/GzM4b09.png)
   The server response will update & provide the object corresponding to the newly created review
   ![post method server response](https://i.imgur.com/6wmnFRR.png)
   4) **DELETE /api/reviews/{id}**<br />
   Provide the id as done similarly to the get review by id method
   5) **PUT /api/reviews/{id}**<br />
   To update a review provide the id of the review in the required field.<br />
   In the request body, enter the **customerId**, **filmId**, and **ratingId** as done in the post method
   



### E. Resources

[Java Guides Paging in Spring Boot](https://www.javaguides.net/2021/10/spring-boot-pagination-and-sorting-rest-api.html)