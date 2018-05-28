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

![]()

In this class we are reading from the lists that we created in the first part,
and are then putting in into the respective CSV’s.
For each book / author / city we add a bookid, which we then ensure is added
for the right value by using the ID we added for each book in the previous section.
Thereby ensuring that we don’t add info about a wrong book.
Finally we have 3 CSV files which we can use to populate our databases.

To import the data to databases, for SQL we ran the syntax from Neo4j assignment notes:

```LOAD DATA LOCAL INFILE '/path/to/social_network_nodes.csv'
INTO TABLE gutenberg.Books
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
(bookid,title);```

For mongoDB we used MongoDB Compass that we connected to the droplet as well
and just imported data from the csv files.

![]()