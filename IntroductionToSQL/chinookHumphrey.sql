-- Connection to the DB --> User -> Schema
-- Connection to DB -> RevatureHumphrey -> Humphrey's Schema 
-- Connection to the DB -> Chinook -> Chinook's schema














-- Select all from employee table in chinook
SELECT * FROM employee;

--–Select all records from the Employee table where last name is King.
SELECT firstname, lastname 
FROM employee
WHERE lastname = 'King';

--Select all records from the Employee table where first name is Andrewand REPORTSTOis NULL.

SELECT * FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;

--Select all albumsin Albumtable and sort result set in descending orderby title.

SELECT * FROM album 
ORDER BY title DESC;

--–Select first name from Customerand sort result set in ascending orderbycity

SELECT firstname FROM customer
ORDER BY city ASC;


-- Insert two new records into Genre table

INSERT INTO genre VALUES(66,'Hip Hop');
INSERT INTO genre VALUES(67,'Pop');

--– Update AaronMitchellin Customertable to Robert Walter

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname= 'Mitchell';
commit;

-- Update name of artist in the Artist table“Creedence Clearwater Revival” to “CCR”

Update artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';



-- Select all invoiceswith a billing addresslike “T%”

SELECT billingaddress FROM invoice
WHERE billingaddress LIKE 'T%';



--Select all invoicesthat have a totalbetween 15and 50

SELECT total FROM invoice
WHERE total > 15 AND total < 50;

--Select all employees hired between 1stof June 2003 and 1stof March 2004

SELECT firstname, lastname, hiredate FROM employee
WHERE hiredate > TO_DATE(20030601,'YYYYMMDD') AND hiredate < TO_DATE(20040301,'YYYYMMDD');

--Delete a record in Customertable where the name is Robert Walter(There may be constraints that rely on this, find out how to resolve them).
--Delete from the parent tables first
DELETE FROM invoiceline WHERE invoiceid = 50 OR invoiceid= 61 OR invoiceid= 116 OR invoiceid= 245 OR invoiceid=268 OR invoiceid= 290 OR invoiceid= 342;
DELETE FROM invoice WHERE customerid =32;
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';

commit;
-- Create a function that returns the current time
SELECT chinook.get_current_time FROM DUAL;

-- create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name) as "Number of Chars" FROM mediatype;

-- Create a function that returns the average total of all invoices
SELECT AVG(total) as "Average For Invoices" FROM invoice;

-- Create a function that returns the most expensive track
SELECT name,MAX(unitprice) FROM track;

-- Create a function that returns the average priceof invoiceline itemsin the invoiceline table
SELECT AVG(unitprice) as "Average Price Of Items" FROM invoiceline;

-- Create a function that returns all employees who are born after 1968

SELECT firstname,lastname, birthdate FROM employee 
Where birthdate > TO_DATE('1968','YYYY');


-- Create a stored procedure that selects the first and last names of all the employees.









































