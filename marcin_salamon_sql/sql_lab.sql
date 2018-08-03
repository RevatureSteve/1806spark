--2.1 task A get all records from Employee table
SELECT * FROM employee;
--2.1 task B get all records with last name King
SELECT * FROM employee 
WHERE lastname ='King';
--2.1 task C first name Andrew and REPORTSTO null
SELECT * FROM employee
WHERE firstname = 'Andrew' 
AND reportsto is null;
--2.2 task A order albums by title and sort descending
SELECT * FROM album
ORDER BY title DESC;
--2.2 task B first name from Customer and sort ascending by city
SELECT firstname FROM customer
ORDER BY city ASC;
--2.3 task A insert 2 new records into the Genre table
INSERT INTO genre VALUES(26, 'Viking Metal');
INSERT INTO genre VALUES(27, 'Speed Metal');
--2.3 task B insert 2 new records into the Employee table
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto)
VALUES(9, 'Doe', 'John', 'IT Staff', 6);
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto)
VALUES(10, 'Doe', 'Jane', 'IT Staff', 6);
--2.3 task C insert 2 new records into the Customer table
INSERT INTO customer(customerid, lastname, firstname, company, email, supportrepid)
VALUES(60, 'Malkovic', 'John', 'Bread LLC','abc@gmail.com', 4);
INSERT INTO customer(customerid, lastname, firstname, company, email, supportrepid)
VALUES(61, 'Johnson', 'Jeffrey', 'Blue INC','cda@gmail.com', 4);
--2.4 task A update Aaron Mitchel in Customer table to Robert Walter
-- changes properties of row 32
UPDATE customer 
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--2.4 task B Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'Creedence Clearwater Revival'
WHERE name = 'CCR';
--2.5 Select all invoices with a billing address like “T%”
SELECT billingaddress FROM invoice
WHERE billingaddress LIKE 'T%';
--2.6 task A Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;
--2.6 task B Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate 
BETWEEN '01-JUN-2003' AND '01-MAR-04';
--2.7 – Delete a record in Customer table where the name 
--is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM invoiceline
WHERE invoiceid IN (SELECT invoiceid FROM invoice 
WHERE customerid IN (SELECT customerid FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter'));
DELETE FROM invoice
WHERE customerid IN (SELECT customerid FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter');
DELETE FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter';
--3.1 task A Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_date
RETURN TIMESTAMP
    IS currDate TIMESTAMP;
BEGIN
    SELECT systimestamp
    INTO currDate
    FROM dual;
    RETURN (currDate);
END;
/
--3.1 task B create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_media_length (iter INT)
RETURN INT
    IS media_length INT;
BEGIN
    SELECT LENGTH(mediatype.name)
    INTO media_length
    FROM mediatype
    WHERE mediatypeid = iter;
    RETURN media_length;
END;
/
--3.2 task A Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_invoice_avg
RETURN NUMBER
    IS invoice_avg NUMBER;
BEGIN
    SELECT AVG(total) 
    INTO invoice_avg
    FROM invoice;
    RETURN invoice_avg;
END;
/
--3.2 task B Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_most_expensive_track
RETURN TABLE
    IS price TABLE;
BEGIN
    SELECT * 
    INTO price
    FROM track
    WHERE unitprice = (SELECT MAX(unitprice) FROM track);
    RETURN invoice_avg;
END;
/

--3.3 Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_average_price 
RETURN NUMBER
    IS avgprice NUMBER;
BEGIN
    SELECT AVG(unitprice) 
    INTO avgprice
    FROM invoiceline
    WHERE unitprice = (SELECT MAX(unitprice) FROM track);
    RETURN avgprice;
END;
/

--3.4 Create a function that returns all employees who are born after 1968.
SELECT * FROM employee
WHERE birthdate > TO_DATE('19680101', 'YYYYMMDD');
--4.1 Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE  first_last_name (firstn IN VARCHAR) IS
   BEGIN
      SELECT firstname
      INTO firstn
      FROM employee;

   END first_last_name;
/
BEGIN
    first_last;
END;
/
--7.1 Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer INNER JOIN invoice
ON customer.customerid = invoice.customerid;
--7.2 Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.
SELECT customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;
--7.3 Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.artistid, artist.name, album.title
FROM artist RIGHT OUTER JOIN album
ON album.artistid = artist.artistid;
--7.4 Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT album.*, artist.*
FROM album
CROSS JOIN artist
ORDER BY artist.name ASC;
--7.5 Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.*
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;