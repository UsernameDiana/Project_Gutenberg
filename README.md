# Project_Gutenberg

Emil Klausen
Zygimantas Pranka
Diana Strele
Plamen Getsov

The goal of This project is to build an application that queries different
databases, with the end goal of giving a recommendation for a DBMS from one of
the database paradigms.

## Database engines used

### SQL
We selected SQL as our first database. Since we’re all the most familiar with
the SQL from previous semesters. Therefore we could get a good start and
familiarize ourselves with the Gutenberg database.

### MongoDB
Our second choice was MongoDB, as we wanted to work with document oriented
database in contrast of relational database.However it caused us some troubles
as we went a long and it ended up taking quite a bit longer than expected.

### Postgres
Third choice is Postgres object-relational database system as it is readable
and has high performance.

## Data modeled in the databases.

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.24.12.png)

ER Diagram for SQL and Postgres database

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.24.51.png)

ER Diagram for Mongo database

## Data modeled in application

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.27.23.png)

## Data called to show it

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.28.17.png)

This image shows the creation of the first sql query “getBooksByCityName”.
Where we are extracting the data from the table into something that we’re able
to display. So for this one we’re getting tittle (title), name, city, latitude
and longitude. The name(author) is connected to the book, and latitude and
longitude is connected to the city.

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2010.56.24.png)
![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2010.56.47.png)

To see if the query works for Postgres, we checked them in using terminal.
