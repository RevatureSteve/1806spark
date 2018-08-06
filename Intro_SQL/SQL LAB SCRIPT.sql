--SQL LAB

--1.0 Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.

--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.

--2.1 SELECT
--Task – Select all records from the Employee table.
--Task – Select all records from the Employee table where last name is King.
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT * FROM employee;

SELECT * FROM employee
WHERE lastname = 'King';

SELECT * FROM employee
WHERE firstname = 'Andrew'
AND reportsto IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
--Task – Select first name from Customer and sort result set in ascending order by city

SELECT * FROM album
ORDER BY title DESC;

SELECT firstname FROM customer
ORDER BY city ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
--Task – Insert two new records into Employee table
--Task – Insert two new records into Customer table

INSERT INTO genre(genreid, name) VALUES(26, 'Name 1');
INSERT INTO genre(genreid, name) VALUES(27, 'Name 2');

INSERT INTO employee(employeeid, lastname, firstname) VALUES(9, 'LastName 1', 'FirstName 1');
INSERT INTO employee(employeeid, lastname, firstname) VALUES(10, 'LastName 2', 'FirstName 2');

INSERT INTO customer(customerid, lastname, firstname, email) VALUES(60, 'LastName 1', 'FirstName 1', 'Email 1');
INSERT INTO customer(customerid, lastname, firstname, email) VALUES(61, 'LastName 2', 'FirstName 2', 'Email 2');

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”

SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

SELECT * FROM employee
WHERE hiredate BETWEEN TO_DATE('20030601', 'YYYYMMDD') AND TO_DATE('20040301', 'YYYYMMDD');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).

DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform
--various actions against the database

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Task – create a function that returns the length of a mediatype from the mediatype table

SELECT TO_CHAR(SYSDATE, 'HH12:MI:SS') "NOW" FROM DUAL;

SELECT LENGTH() "Length of Mediatype" FROM mediatype;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
--Task – Create a function that returns the most expensive track

SELECT AVG(total) "Average" FROM invoice;

SELECT MAX(unitprice) "Max Total" FROM track;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

SELECT ROUND(AVG(unitprice), 2) "Average Price" FROM invoiceline;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

DROP FUNCTION born_after;
--CREATE FUNCTION born_after;

      SELECT * INTO emp_list FROM employee 
      WHERE birthdate > TO_DATE('19681231', 'YYYYMMDD');
      

--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE or REPLACE PROCEDURE employee_names IS 
fn_user VARCHAR2(20);
ln_user VARCHAR(20);
BEGIN
FOR i IN 1..10 LOOP
SELECT firstname INTO fn_user FROM employee
WHERE employeeid = i;
SELECT lastname INTO ln_user FROM employee
WHERE employeeid = i;
DBMS_OUTPUT.PUT_LINE(fn_user || ' ' || ln_user);
END LOOP;
END;
/

BEGIN 
employee_names;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--Task – Create a stored procedure that returns the managers of an employee.

CREATE or REPLACE PROCEDURE employee_info (emp_id IN NUMBER, column_name IN %TYPE , value_change IN %TYPE)
IS
BEGIN
UPDATE employee
SET column_name = value_change
WHERE employeeid = emp_id;
END;
/

BEGIN
employee_info(9, name, 'Test 1');
END;
/

--CREATE OR REPLACE PROCEDURE employee_manager (emp_id IN NUMBER) IS
--BEGIN
--IF emp_id = 7 OR 8 THEN
--SELECT * FROM employee
--WHERE title = 'IT Manager';
--ELSE IF emp_id = 3 OR 4 OR 5 THEN
--SELECT * FROM employee
--WHERE title = 'Sales Manager';
--ELSE IF emp_id = 2 OR 6 THEN
--SELECT * FROM employee
--WHERE title = 'General Manager';
--END IF;
--END;
--/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE print_name_comp (cust_id IN NUMBER, first_name OUT VARCHAR2, 
last_name OUT VARCHAR2, comp_name OUT VARCHAR2) 
IS
BEGIN
SELECT firstname INTO first_name, lastname INTO last_name, company INTO comp_name FROM employee
WHERE customerid = cust_id;
DBMS_OUTPUT.PUT_LINE(first_name || ' ' || last_name ' ' || comp_name);
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored
--procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
--table

CREATE OR REPLACE PROCEDURE delete_invoice (inv) IS
BEGIN
INSERT INTO customer(customerid, firstname, lastname, email) VALUES(61, trans1, action2, email12);
COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE new_customer IS
BEGIN
INSERT INTO customer(customerid, firstname, lastname, email) VALUES(61, trans1, action2, email12);
COMMIT;
END;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are
--executed on a table.

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the
--table.
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.

CREATE OR REPLACE TRIGGER trig_emp
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('An employee has been inserted.');
END;
/

CREATE OR REPLACE TRIGGER trig_album
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('An album has been updated.');
END;
/

CREATE OR REPLACE TRIGGER trig_cust
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('An customer has been deleted.');
END;
/

--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work
--with outer, inner, right, left, cross, and self joins.

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.

SELECT c.firstname, c.lastname, inv.invoiceid
FROM customer c
INNER JOIN invoice inv
ON c.customerid = inv.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.

SELECT c.customerid, c.firstname, c.lastname, inv.invoiceid, inv.total
FROM customer c
FULL OUTER JOIN invoice inv
ON c.customerid = inv.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

SELECT ar.name, al.title
FROM album al
RIGHT JOIN artist ar
ON al.artistid = ar.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT *
FROM album
CROSS JOIN artist
ORDER BY name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

SELECT a.employeeid, b.employeeid, a.reportsto
FROM employee a, employee b
WHERE a.reportsto = b.reportsto;

--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you
--will also restore the database. Research or try random things then communicate with batchmates, do
--not ask trainer.
--Task – Create a .bak file for the Chinook database.
