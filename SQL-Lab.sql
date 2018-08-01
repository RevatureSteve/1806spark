--  2.1 Select
-- Task A Select all records from the Employee table
SELECT * FROM CHINOOK.employee;

-- Task B Select all records from the Employee table where last name is king
SELECT *
FROM CHINOOK.employee
WHERE LASTNAME = 'King';

-- Task C Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT *
FROM CHINOOK.employee
WHERE firstname = 'Andrew'
AND reportsto IS null;

-- 2.2 ORDER BY
-- TASK A Select all albums in Album table and sort result set in descending order by title
SELECT *
FROM CHINOOK.album
ORDER BY title DESC;

--TASK B Select first name from Customer and sort result set in ascending order by city
SELECT firstname
FROM CHINOOK.customer
ORDER BY city ASC;

-- 2.3 INSERT INTO
-- TASK A Insert two new records into Genre table
INSERT INTO CHINOOK.genre(genreid, name)
VALUES (1001, 'Horror');
INSERT INTO CHINOOK.genre(genreid, name)
VALUES (1002, 'Happy');

-- TASK B Insert two new records into Employee table
INSERT INTO CHINOOK.employee(employeeid, lastname, firstname, city)
VALUES (9, 'Johnson', 'James', 'Los Angeles');
INSERT INTO CHINOOK.employee(employeeid, lastname, firstname, city)
VALUES (10, 'Daniels', 'Jeff', 'Tampa');

-- TASK C Insert two new records into customer table
INSERT INTO CHINOOK.customer(customerid, firstname, lastname, company, email)
VALUES (60, 'Michelle', 'Ganda', 'Pharmsc', 'mg@gmail.com');
INSERT INTO CHINOOK.customer(customerid, firstname, lastname, company, email)
VALUES (61, 'Mario', 'Luigi', 'Kingdom', 'ml@mk.com');
select * from CHINOOK.customer;

-- 2.4 UPDATE
-- Task A – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.customer SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

-- Task B – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE CHINOOK.artist SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task A – Select all invoices with a billing address like “T%”
SELECT * FROM CHINOOK.invoice
WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
-- Task A – Select all invoices that have a total between 15 and 50
SELECT * FROM CHINOOK.invoice
WHERE total BETWEEN 15 AND 50;

-- Task B – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM CHINOOK.employee
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints 
-- that rely on this, find out how to resolve them).
    DELETE FROM CHINOOK.invoiceline
    WHERE invoiceid IN (SELECT invoiceid FROM CHINOOK.invoice
    WHERE customerid IN (SELECT customerid FROM CHINOOK.customer
    WHERE customer.firstname = 'Robert' 
    AND customer.lastname = 'Walter'));

