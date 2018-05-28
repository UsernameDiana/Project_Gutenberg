# Project_Gutenberg

Emil Klausen, Zygimantas Pranka, Diana Strele, Plamen Getsov

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
and has high performance. As we have mentioned before, we were already familiar with SQL syntax, so the queries were not the new information here. Setting it up and fiddling with the server took a bit more effort, mainly giving access to outer connections.


## Data modeled in the databases.

![]()

Relational Diagram for SQL and Postgres database

![]()

Relational Diagram for Mongo database

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

## How the data is imported
We imported our data into the database via a csv file. We created the csv file
by creating java application TxtToCsv with fileReader and fileWritter, one
which would read from all the books, and then one which would write to the CSV file.
The csv files where then located on a droplet in DigitalOcean.

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.36.12.png)

Here we read from the books. We are doing 3 things here, getting the Titles,
the Authors and the Cities and then we put it into lists. When we go through a
book we first get the title and author (if they don’t exist, then we write
“TitleNotFound-” and still add it in. When ever we go through a new book, we
add an ID for each of Title, Author and Cities, so that later on we can find
the exact info for a specific book.

Afterwards we start searching for the cities by taking all the words starting
with capital letter and we match it with a list of existing cities. We are
making sure that there are no duplicates by using “Distinct” so that if a city
appears a second time, then we ignore it. However, we only get one worded
cities with this method. So for example a city like “New York” would be split
into two, thereby getting “New” and “York”.

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.38.19.png)

In this class we are reading from the lists that we created in the first part,
and are then putting in into the respective CSV’s.
For each book / author / city we add a bookid, which we then ensure is added
for the right value by using the ID we added for each book in the previous section.
Thereby ensuring that we don’t add info about a wrong book.
Finally we have 3 CSV files which we can use to populate our databases.

To import the data to databases, for SQL we ran the syntax from Neo4j assignment notes:

`LOAD DATA LOCAL INFILE '/path/to/social_network_nodes.csv'
INTO TABLE gutenberg.Books
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY ''
LINES TERMINATED BY '\n'
(bookid,title)`

For mongoDB we used MongoDB Compass that we connected to the droplet as well
and just imported data from the csv files.

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.40.00.png)

## Behavior of query test set.
Including a discussion on how much of the query runtime is influenced by the
DB engine and what is influenced by the application frontend.
We did jmeter tests on our server to see how queries behaved.
For some reason we could only see the mongodb on the server when doing stress test.

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.42.32.png)

Here we see the first one failing to connect as we gave it a wrong path just
to test the connection. Then afterwards we get it the right path and 15
threads, which gave us the result.

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.43.20.png)

Here we can see the Cpu is very low (only 0.7) We then tried with 1.000.000
threads and had the exact same output, so we assume that the jmeter test is
not exactly sending what we had hoped for.

## Recommendation, for which database engine to use in such a project for production.

We think that SQL is the best of the databases that we used, as it was very
simple to just change up the queries if needed, where for example mongoDB took
some time figuring out, both with what to use and how to use it. For example,
in SQL we could easily combine tables, where in mongo it was a little harder
(only just implemented recently) where you could use “$Lookup” and then merge tables.

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.47.13.png)

This however only includes one other tables, so we would have to this for each
table and then in the end we would have to project the fields with “$project” as such:

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.48.28.png)

Where in SQL we could do it like:

![](https://github.com/UsernameDiana/Project_Gutenberg/blob/master/screenshots/Screen%20Shot%202018-05-28%20at%2011.49.14.png)

And then getting exactly what we wanted from just one query, it may be longer,
but it’s very easy to understand what’s going on, so more readable.


### Work Distributable of project Gutenberg

Webpages:
Bootstrap - Zygi
JS - Zygi
Index.jsp - Zygi

* Source Packages:

Interface - Everybody

* Database Access:

MongoControlFacade - Zygi

MongoDBConnector - Diana, Plamen and Zygi

MongoDBMapper - Diana, Emil and Zygi

MysqlControlFacade - Emil and Zygi

PostGresControlFacade - Zygi

PostgDBConnector - Diana and Plamen

PostgDBMapper - Diana, Plamen and Zygi

SQLDBConnector - Everybody

SQLDBMapper - Zygi

* Entity:

Book - Diana, Emil

City - Diana, Emil

* Facade:

MongoFacade - Zygi

MysqlFacade - Emil, Plamen and Zygi

PostgresFacade - Diana, Plamen and Zygi

* Creation of databases:

SQL - Zygi and Emil

MongoDB - Diana, Emil and Zygi

Postgres - Plamen and Diana

* Report:

Emil, Diana and Plamen
