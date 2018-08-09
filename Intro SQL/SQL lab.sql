--1.0 Setting up Oracle Chinook
--Task – Open the Chinook_Oracle.sql file and execute the scripts within
--Done

--2.1 SELECT
--Task – Select all records from the Employee table
SELECT * FROM employee;

--Task – Select all records from the Employee table where last name is King
SELECT * FROM employee
WHERE lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT * FROM employee
WHERE firstname = 'Andrew'
AND REPORTSTO IS null;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title
SELECT * FROM album
ORDER BY title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT * FROM customer
ORDER BY city ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO genre (genreid, name)
VALUES (26, 'Kpop');
INSERT INTO genre (genreid, name)
VALUES (27, 'OST');

--Task – Insert two new records into Employee table
INSERT INTO employee
VALUES (9, 'Doe', 'John', 'Intern', 3, '09-Jun-90', '14-MAY-18', '123 Sesame St', 'Tampa', 'FL', 'United States', 12345, '+1 (123) 456-7890', '+1 (123) 456-0987', 'john@chinookcorp.com');
INSERT INTO employee
VALUES (10, 'Doe', 'Jane', 'Intern', 3, '30-AUG-89', '26-MAR-18', '123 Main St', 'Fort Lee', 'NJ', 'United States', 54321, '+1 (098) 765-4321', '+1 (098) 765-1234', 'jane@chinookcorp.com');

--Task – Insert two new records into Customer table
INSERT INTO customer
VALUES (60, 'John', 'Doe', '', '123 Sesame St', 'Tampa', 'FL', 'United States', 12345, '+1 (123) 456-7890', '', 'john@chinookcorp.com', 3);
INSERT INTO customer
VALUES (61, 'Jane', 'Doe', '', '456 Main St', 'Newark', 'NJ', 'United States', 54321, '+1 (098) 765-4321', '', 'jane@chinookcorp.com', 4);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE artistid = 76;

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM Chinook.invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM Chinook.employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)
