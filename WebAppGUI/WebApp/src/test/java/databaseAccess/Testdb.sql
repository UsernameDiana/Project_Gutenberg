CREATE TABLE BOOKS (
    BOOKID int,
    TITLE varchar (99),
    PRIMARY KEY (BOOKID)
);

CREATE TABLE AUTHORS (
    BOOKID int,
    NAME varchar(99),
    FOREIGN KEY (BOOKID) REFERENCES BOOKS(BOOKID)
);

CREATE TABLE CITIES (
    BOOKID int,
    CITY varchar(99),
    FOREIGN KEY (BOOKID) REFERENCES BOOKS(BOOKID)
);

insert into books(title, bookid) values('Oliver Twist',1);

insert into authors(name, bookid) values('Charles Dickens',1);

insert into cities(city, bookid) values('London',1);

insert into books(title, bookid) values('The Three Musketeers',2);

insert into authors(name, bookid) values('Alexandre Dumas',2);

insert into cities(city, bookid) values('Madrid',2);

insert into books(title, bookid) values('The Picture of Dorian Gray',3);

insert into authors(name, bookid) values('Oscar Wilde',3);

insert into cities(city, bookid) values('Paris',3);

insert into books(title, bookid) values('War and Peace',4);

insert into authors(name, bookid) values('Leo Tolstoy',4);

insert into cities(city, bookid) values('Moscow',4);


SELECT DISTINCT b.bookid, title, city, name FROM Books b, Cities c, Authors a WHERE c.city = 'Paris' AND b.bookid = c.bookid AND a.bookid = b.bookid;