-- 2.1 Select
-- To select everything from the employee table
SELECT * FROM employee; 

-- To select everything from the employee who has King as lastname
SELECT * FROM employee
WHERE lastname = 'King';

-- To select all records from employee where firstname is Andrew & REPORTSTO is null
SELECT * FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;

-- 2.2 Order by
-- Select all albums in the alubm table and sort the result set in descending order by title
SELECT * FROM album
ORDER BY title DESC;

-- Select first name from customer and sort result set in ascending order by city
SELECT * FROM customer
ORDER BY city ASC;

-- 2.3 Insert Into
-- Insert two new records into Genre table
SELECT * FROM genre;

INSERT INTO genre (genreid, name)
VALUES ('26','Bachata');
-- Cannot have the same generalid 
INSERT INTO genre (genreid, name)
VALUES ('27','Merengue'); 

-- Insert two new records into Employee table
SELECT * FROM employee;

INSERT INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
VALUES ('9','Moraga','Alex','Software Developer','7','02-NOV-94','01-AUG-15','Livingston','Tampa','Florida','USA', '31589','911','+1 (703) 865 86
45','alex.moraga94@gmail.com');

INSERT INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
VALUES ('10','Moraga','Axel','Software Developer','7','02-NOV-94','01-AUG-15','Livingston','Tampa','Florida','USA', '31589','911','+1 (703) 865 86
45','alex.moraga94@gmail.com');

-- Insert two new records into Customer table
SELECT * FROM customer;

INSERT INTO customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
VALUES ('60','Alex','Moraga','Revature','Livingston','Tampa','Florida','USA', '31589','911','+1 (703) 865 8645','alex.moraga94@gmail.com','3');

INSERT INTO customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
VALUES ('61','Axel','Moraga','Revature','Livingston','Tampa','Florida','USA', '31589','911','+1 (703) 865 8645','alex.moraga94@gmail.com','3');

-- 2.4 Update
-- Update Aaron Mitchell in Customer table to Robert Walter
SELECT * FROM customer;

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

-- Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
SELECT * FROM artist;

UPDATE artist
SET name = 'CCR'
WHERE artistid = 76;

-- 2.5 Like
-- Select all invoices with a billing address like "T%"
SELECT * FROM invoice
WHERE billingaddress
-- selects everything that starts with the letter 'T'
LIKE 'T%';

-- 2.6 Between
-- Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN TO_DATE('01062003', 'DDMMYYYY') AND TO_DATE('01062004', 'DDMMYYYY');

-- 2.7 Delete
-- Delete a record in Customer table where the name is Robert Walter 
SELECT * FROM customer;
--SELECT * FROM invoiceline;
DELETE FROM customer
WHERE customerid = 32;

DELETE FROM invoice
WHERE customerid = 32;

DELETE FROM invoiceline
WHERE invoiceid = 32;

DELETE FROM invoiceline
WHERE invoicelineid = 32;

-- 3.0 SQL Functions

-- 3.1 System Defined Functions
-- Create a function that returns the current time
SELECT NOW();

-- Create a function that returns the length of a mediatype from the mediatype table
SELECT * FROM mediatype;

SELECT LENGTH(name) AS LengthOfName FROM mediatype;

-- 3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices
SELECT * FROM invoice;
SELECT AVG(total) AS averagetotal FROM invoice;

-- Create a function that returns the most expensive track
SELECT * FROM track;
SELECT MAX(unitprice) AS expensivetrack FROM track;

-- 3.3 User Defined Scalar Functions
SELECT * FROM invoiceline;
SELECT AVG(unitprice) AS average FROM invoiceline;

-- 3.4 User Defined Table Valued Functions
SELECT * FROM employee;

SELECT birthdate,BIRTHDATE(birthdate)
FROM employee; 

-- 4.0 Stored Procedures

-- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees
set serveroutput on;
BEGIN
procedure1;
END;
/

-- 4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the personal information of an employee
set serveroutput on;
BEGIN
parameters(1, 'Stephen');
END;
/

-- Create a stored procedure that returns the managers of an employee
set serveroutput on;
BEGIN
MANAGERS();
END;
/

-- 4.3 Stored Procedure Output Parameters
-- Create a stored procedure that returns the name and compnay of a customer
set serveroutput on;
BEGIN
COMPANY;
END;
/

-- 5.0 Transaction
-- Create a transaction that given a invoiceid will delete that invoice (There may be constraints that rely on this, find out how to resolve them)


-- 6.0 Triggers

-- 6.1 AFTER/FOR
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER new_record_insert
AFTER INSERT ON employee
BEGIN
    INSERT INTO bank_account (balance, users_id) VALUES (0, :new.users_id); --:new allows to use the same reference variable from it's parent's... since it a foreign key
END;
/

commit;









