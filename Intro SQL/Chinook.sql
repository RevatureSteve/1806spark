--Connection to the DB -> User -> Schema
--Connection to the DB -> stephen -> Stephen's schema
--Connection to the DB -> Chinook -> Chinook's schema

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
VALUES (9, 'Doe', 'John', 'Intern', 3, TO_DATE('19900609', 'YYYYMMDD'), TO_DATE('20180518', 'YYYYMMDD'), '123 Sesame St', 'Tampa', 'FL', 'United States', 12345, '+1 (123) 456-7890', '+1 (123) 456-0987', 'john@chinookcorp.com');
INSERT INTO employee
VALUES (10, 'Doe', 'Jane', 'Intern', 3, TO_DATE('19890830', 'YYYYMMDD'), TO_DATE('20180326', 'YYYYMMDD'), '123 Main St', 'Fort Lee', 'NJ', 'United States', 54321, '+1 (098) 765-4321', '+1 (098) 765-1234', 'jane@chinookcorp.com');

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
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)
DELETE FROM invoiceline
WHERE invoiceid IN (SELECT invoiceid FROM invoice 
WHERE customerid IN (SELECT customerid FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter'));

--3.1 System Defined Functions
--Task – Create a function that returns the current time
SELECT CURRENT_TIMESTAMP FROM dual;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT length(name)
FROM mediatype;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(TOTAL) as "Average Total"
FROM invoice;

--Task – Create a function that returns the most expensive track
SELECT MAX(UNITPRICE) as  "Most expensive track"
FROM track;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT AVG(UNITPRICE) as "Average Price"
FROM invoiceline;

CREATE OR REPLACE FUNCTION get_avg_price
RETURN NUMBER
IS
  avg_price NUMBER;
BEGIN
  
  SELECT AVG(UNITPRICE) INTO avg_price FROM invoiceline;
  RETURN avg_price;
  
END;
/

SELECT get_avg_price() FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968
SELECT * FROM employee
WHERE birthdate > TO_DATE('19681231', 'YYYYMMDD');

CREATE OR REPLACE FUNCTION get_date(startdate IN STRING)
RETURN DATE
IS
BEGIN
    RETURN TO_DATE(startdate, 'YYYYMMDD');
END;
/

SELECT * FROM employee
WHERE birthdate > get_date('19681231');

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees
CREATE OR REPLACE PROCEDURE select_employee
IS
full_name VARCHAR2(4000);
first_name VARCHAR2(4000);
last_name VARCHAR2(4000);
BEGIN
FOR emp IN
(SELECT firstname, lastname FROM employee)
LOOP
    first_name := emp.firstname;
    last_name := emp.lastname;
    DBMS_OUTPUT.PUT_LINE(first_name || ' ' || last_name);
END LOOP;
END;
    
SET SERVEROUTPUT ON;
BEGIN
    select_employee();
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee 
(
  the_employeeid IN NUMBER,
  new_lastname IN VARCHAR2
)
AS 
BEGIN
  UPDATE employee
  SET lastname = 
        CASE WHEN new_lastname IS NULL
        THEN lastname
        ELSE new_lastname
        END
    WHERE employeeid = the_employeeid;
END;
/

SET SERVEROUTPUT ON;
BEGIN
    update_employee(1, 'Rick');
END;
/

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE manager_of_employee
(
  employee_id IN NUMBER
)
AS 
  a VARCHAR2(20);
  b VARCHAR2(20);
  c VARCHAR2(20);
  d VARCHAR2(20);
BEGIN
  SELECT mgr.firstname, mgr.lastname, emp.firstname, emp.lastname INTO a, b, c, d
  FROM employee emp
  INNER JOIN employee mgr
  ON mgr.employeeid = emp.reportsto
  WHERE emp.employeeid = employee_id AND emp.reportsto = mgr.employeeid;
  DBMS_OUTPUT.PUT_LINE(c || ' ' || d || ' reports to ' || a || ' ' || b);
END manager_of_employee;
/

SET SERVEROUTPUT ON;
BEGIN
    manager_of_employee(8);
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE select_customer
IS
first_name VARCHAR2(4000);
last_name VARCHAR2(4000);
company VARCHAR2(4000);
BEGIN
FOR cust IN
(SELECT firstname, lastname, company FROM customer)
LOOP
    first_name := cust.firstname;
    last_name := cust.lastname;
    company := cust.company;
    DBMS_OUTPUT.PUT_LINE(first_name || ' ' || last_name || ' ' || company);
END LOOP;
END;
    
SET SERVEROUTPUT ON;
BEGIN
    select_customer();
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice
--(There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice (in_id IN INT)
IS 
BEGIN
    DELETE FROM invoiceline WHERE invoiceid = in_id;
    DELETE FROM invoice WHERE invoiceid = in_id;
END;
/

BEGIN
    delete_invoice (10);
END;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer_record(customerid IN INT, firstname IN VARCHAR2, lastname IN VARCHAR2,
company IN VARCHAR2, address IN VARCHAR2, city IN VARCHAR2, state IN VARCHAR2, country IN VARCHAR2, postalcode IN VARCHAR2,
phone IN VARCHAR2, fax IN VARCHAR2, email IN VARCHAR2, supportedid IN NUMBER)
IS
BEGIN
    INSERT INTO customer VALUES (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, 
            fax, email, supportedid);
    commit;
END;
/

DELETE FROM customer
WHERE customerid = 62;

BEGIN
    insert_customer_record(62, 'John', 'Doe', '', '123 Sesame St', 'Tampa', 'FL', 'United States', 12345, '+1 (123) 456-7890', '', 'john@chinookcorp.com', 3);
END;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER after_insert_trigger
AFTER INSERT
ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('After insert trigger fired');
END;
/

INSERT INTO employee values(9, '1', '2', '3', '4', to_date('19960725','YYYYMMDD'), to_date('19960725','YYYYMMDD'), '7', '8', '9', '0', '1', '2', '3', '4');
DELETE FROM employee
WHERE employeeid = 9;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER after_update_trigger
AFTER UPDATE
ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('After update trigger fired');
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_trigger
AFTER DELETE
ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('After delete trigger fired');
END;
/

--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins
--You will work with outer, inner, right, left, cross, and self joins
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT firstname, lastname, invoiceid
FROM customer c
INNER JOIN invoice i
ON c.customerid = i.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying
--the CustomerId, firstname, lastname, invoiceId, and total
SELECT firstname, lastname, invoiceid, total
FROM customer c
FULL OUTER JOIN invoice i
ON c.customerid = i.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title
FROM album al
RIGHT JOIN artist ar
ON al.artistid = ar.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ar.name, al.title
FROM artist ar
CROSS JOIN album al
ORDER BY name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee a, employee b
WHERE a.reportsto = b.reportsto;
