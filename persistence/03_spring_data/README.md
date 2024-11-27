# Spring Data JPA

## Task 1

1. first we have to make sure that our class `Farmer` is recognised as an entity. To do this, annotate the class
   with JPA annotations so that it can be persisted.
2. start the application. Open the H2 console under `localhost:8080/h2-console`. Use the information from the console
   to find out the correct database URL and the `application.properties` to find out username and password.

If you have annotated the entity correctly, you should find two entries in your database in the `Farmers` table.

## Task 2

1. so that we can use Spring magic to query our database tables, the `FarmerRepository` must inherit from the correct Spring Data JPA interface.
   correct Spring Data JPA interface.
2. we want to find individual farmers by searching for their last name. Write a query in the `FarmerRepository`,
   which returns a farmer for the last name.
3. write methods in `FarmerService` to query all farmers and to find a farmer with his last name.

You can find out whether you have solved the tasks correctly if you execute the tests in the class `ApplicationTest` and run them successfully.
run them successfully.