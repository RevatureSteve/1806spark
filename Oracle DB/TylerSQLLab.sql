--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album
ORDER BY title ASC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM customer
ORDER BY city ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
SELECT * FROM genre;
INSERT INTO genre (GENREID, NAME) 
VALUES(26, 'Punk_Rock');
INSERT INTO genre (GENREID, NAME) 
VALUES(27, '90s_Grunge');

--Task – Insert two new records into Employee table
SELECT * FROM employee;
INSERT INTO employee
VALUES ('9', 'Schmoe', 'Joe', 'Janitor', '1', '02-JUL-76','08-JAN-18',
'123 This St', 'Calgary', 'AB', 'Canada', 'T1h 123', '403 555-5556',
'+1 (999)999-9999', 'janitor@chinookcorp.com');
INSERT INTO employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE)
VALUES ('10','Doc','McFly', 'FLUX_CAPICATOR_REPAIR'); 

--Task – Insert two new records into Customer table
SELECT * FROM customer;
INSERT INTO customer (Customerid, firstname, lastname, company, email)
VALUES ('60', 'Danny', 'McBride', 'Western Photography', 'dannymcbride@wp.com');

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
SELECT*FROM customer;
UPDATE customer
SET firstname= 'Robert', lastname ='Walter'
WHERE customerid = '32';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
SELECT*FROM artist;
UPDATE artist
SET name ='CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE

--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to reso.lve them)
--SELECT*FROM Customer
--ORDER BY firstname asc;
--DELETE FROM Customer
--WHERE customerid = 32; 
--
--SELECT * FROM invoice
--ORDER BY billingaddress asc;
--
--DELETE FROM Invoice
--WHERE billingaddress = '696_Osborne_Street';

--DELETE FROM Invoiceline

--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT TO_CHAR
(SYSDATE, 'HH12:MI:SS')"NOW"
    FROM DUAL;
    
SELECT SYSTIMESTAMP FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH (mediatype.name)FROM mediatype;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices

SELECT AVG (total)
FROM invoice;

--Task – Create a function that returns the most expensive track
SELECT * FROM track
ORDER BY unitprice DESC ;

SELECT MAX (unitprice)
FROM track;

SELECT * FROM track
WHERE unitprice >= 1.99;


--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT * FROM invoiceline;

CREATE OR REPLACE FUNCTION average_invoice
RETURN NUMBER IS avg_invoice NUMBER;
BEGIN
    SELECT AVG(unitprice)
    INTO avg_invoice
    FROM invoiceline;
    
    RETURN (avg_invoice);
END;
/
SELECT average_invoice FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM employee;

CREATE OR REPLACE FUNCTION bornAfter
RETURN VARCHAR2 IS empAfter VARCHAR2 (4000);
BEGIN
    SELECT birthdate 
    FROM employee
    WHERE birthdate >= '1968-01-01';
    
    RETURN (empAfter);
END;
/
    
SELECT empAfter FROM DUAL;
    

--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE select_names
IS
BEGIN
    SELECT firstname,lastname FROM EMPLOYEE;
   
    END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.


--Task – Create a stored procedure that returns the managers of an employee.


--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).


--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.


--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.


--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer INNER JOIN invoice
ON customer.customerid = invoice.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.artistid, artist.name, album.title
FROM artist RIGHT OUTER JOIN album
ON album.artistid = artist.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT album.*, artist.* FROM album
CROSS JOIN artist
ORDER BY artist.name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.*
FROM album
CROSS JOIN artist
ORDER BY artist.name ASC;


--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database. Research or try random things then communicate with batchmates, do not ask trainer.
--Task – Create a .bak file for the Chinook database.




