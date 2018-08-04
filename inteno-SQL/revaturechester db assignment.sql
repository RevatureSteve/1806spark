-- assignment due on monday aug 6.
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT

--Task – Select all records from the Employee table.
SELECT * FROM employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT lastname FROM employee where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE  firstname ='Andrew' AND reportsto is NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title desc;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer ORDER BY city asc;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
SELECT *FROM Genre ORDER BY genreid ASC;
INSERT INTO genre(genreid,name) VALUES(28,'Reggae');
INSERT INTO genre(genreid,name) VALUES(27,'Hebrew');
--Task – Insert two new records into Employee table
INSERT INTO Employee(employeeid,lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) 
VALUES(1,'Johnson','Joshaua', 'Manager','', TO_DATE('100915','DD-MON-YY'), TO_DATE('110620','DD-MON-YY'),'206 main street','tampa','fl','north america','T6D M8G','+1(852) 442 1514','1(222) 555 4545',' one@gmail.com');

INSERT INTO Employee values(1,lastname, fristname, title, reportsto, birhdate, hiredate,address, city, state,country, postalcode, phone, fax, email) 
VALUES();
--Task – Insert two new records into Customer table
INSERT INTO Customer VALUES(60,'JACOBY','jacob',
'null', '222 money drive',
'juresalem','jrm', 'out of bablon',
'hfhehe','8888880008','254125412548',
'meae@yham.com',2, timestamp);
--

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
SELECT * FROM Customer where firstname = 'Aaron';
UPDATE Customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;
SELECT * FROM Customer where firstname = 'Robert' and lastname = 'Walter';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
SELECT * FROM Artist WHERE name = 'Creedence Clearwater Revival';
UPDATE artist
SET name = 'CCR'
WHERE artistid = 76;
SELECT * FROM Artist WHERE name = 'CCR';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress like'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 20 ORDER BY total ASC;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN TO_DATE('062003', 'MMYYYY') AND TO_DATE('062004','MMYYYY'); -- used to_date function

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).
----------------------------------------------------------------------------------------------------
--child constrain record found
----------------------------------------------------------------------------------------------------
SELECT * FROM customer
inner join invoice on invoice.customerid = customer.customerid
inner join employee on employee.employeeid = customer.supportrepid;
--inner join customer on customer.supportrepid = employee.employeeid;
--where firstname= 'Robert' and lastname = 'Walter';
DELETE customer  
WHERE  firstname = 'Robert' and lastname = 'Walter';
----------------------------------------------------------------------------------------------------
--child constrain record found
----------------------------------------------------------------------------------------------------

--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform
--various actions against the database

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT SYSTIMestamp ,SYSDATE, LOCALTIMESTAMP from EMPLOYEE;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH() FROM mediatype;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
--Task – Create a function that returns the most expensive track
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.


--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.


--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored
--procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
--table


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are
--executed on a table.
--3
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the
--table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.

--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work
--with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.

SELECT firstname, invoicedate FROM CUSTOMER 
inner join invoice on invoice.customerid = customer.customerid
--INNER JOIN CUSTOMER ON CUSTOMER.SUPPORTREPID =INVOICE.CUSTOMERID
ORDER BY FIRSTNAME;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.

SELECT invoice.customerid, customer.firstname, customer.lastname, invoice.invoiceid
FROM invoice 
FULL Outer Join customer ON invoice.customerid = customer.customerid ;


--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

SELECT name, title 
FROM artist
RIGHT JOIN album ON artist.artistid = album.artistid; 


--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT name 
FROM artist
RIGHT JOIN album ON artist.artistid = album.artistid
ORDER BY name ASC;

SELECT name 
FROM artist
cross JOIN album a
ORDER BY name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT employee.lastname FROM employee, reportsto;
self join reportsto on employee.employeedid = employee.reportsto;


--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you
--will also restore the database. Research or try random things then communicate with batchmates, do
--not ask trainer.
--Task – Create a .bak file for the Chinook database.