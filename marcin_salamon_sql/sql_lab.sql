--2.1 task A get all records from Employee table
SELECT * FROM CHINOOK.employee;
--2.1 task B get all records with last name King
SELECT * FROM CHINOOK.employee 
WHERE lastname ='King';
--2.1 task C first name Andrew and REPORTSTO null
SELECT * FROM CHINOOK.employee
WHERE firstname = 'Andrew' 
AND reportsto is null;
--2.2 task A order albums by title and sort descending
SELECT * FROM CHINOOK.album
ORDER BY title DESC;
--2.2 task B first name from Customer and sort ascending by city
SELECT firstname FROM CHINOOK.customer
ORDER BY city ASC;
--2.3 task A insert 2 new records into the Genre table
INSERT INTO CHINOOK.genre VALUES(26, 'Viking Metal');
INSERT INTO CHINOOK.genre VALUES(27, 'Speed Metal');
--2.3 task B insert 2 new records into the Employee table
INSERT INTO CHINOOK.employee(employeeid, lastname, firstname, title, reportsto)
VALUES(9, 'Doe', 'John', 'IT Staff', 6);
INSERT INTO CHINOOK.employee(employeeid, lastname, firstname, title, reportsto)
VALUES(10, 'Doe', 'Jane', 'IT Staff', 6);
--2.3 task C insert 2 new records into the Customer table
INSERT INTO CHINOOK.customer(customerid, lastname, firstname, company, 5)
VALUES(60, 'Malkovic', 'John', 'Bread LLC', 4);
INSERT INTO CHINOOK.customer(customerid, lastname, firstname, company, 5)
VALUES(61, 'Johnson', 'Jeffrey', 'Blue INC', 4);
--2.4 task A update Aaron Mitchel in Customer table to Robert Walter
-- changes properties of row 32
UPDATE CHINOOK.customer 
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--2.4 task B Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE CHINOOK.artist
SET name = 'Creedence Clearwater Revival'
WHERE name = 'CCR';
--2.5 Select all invoices with a billing address like “T%”
SELECT billingaddress FROM CHINOOK.invoice
WHERE billingaddress LIKE 'T%';
--2.6 task A Select all invoices that have a total between 15 and 50
SELECT * FROM CHINOOK.invoice
WHERE total BETWEEN 15 AND 50;
--2.6 task B Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM CHINOOK.employee
WHERE hiredate 
BETWEEN '01-JUN-2003' AND '01-MAR-04';
--2.7 – Delete a record in Customer table where the name 
--is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM CHINOOK.invoiceline
WHERE invoiceid IN (SELECT invoiceid FROM CHINOOK.invoice 
WHERE customerid IN (SELECT customerid FROM CHINOOK.customer
WHERE firstname = 'Robert'
AND lastname = 'Walter'));
DELETE FROM CHINOOK.invoice
WHERE customerid IN (SELECT customerid FROM CHINOOK.customer
WHERE firstname = 'Robert'
AND lastname = 'Walter');
DELETE FROM CHINOOK.customer
WHERE firstname = 'Robert'
AND lastname = 'Walter';
