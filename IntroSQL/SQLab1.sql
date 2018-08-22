--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM CHINOOK.employee;

--Task – Select all records from the Employee table where last name is King
SELECT LastName FROM CHINOOK.employee WHERE LastName = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT FirstName, REPORTSTO FROM CHINOOK.employee WHERE FirstName = 'Andrew' AND REPORTSTO is null;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM CHINOOK.album ORDER BY title DESC;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FirstName FROM CHINOOK.customer ORDER BY city ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO genre VALUES (26, 'Deathcore');
INSERT INTO genre VALUES (27, 'Trap');
--Task – Insert two new records into Employee table
INSERT INTO employee VALUES (9, 'Holmes', 'Chris', 'Software Engineer',2, '29-Jan-91', '1-Jan-07', '221 OK St', 'Tampa', 'FL','USA', 't3k''1t8',17808369987, 17208339987,'chris@chinookcorp.com' );
INSERT INTO employee VALUES (300, 'LOLOLOL', 'RARARA', 'Footware Associate',1,'22-Apr-91', '1-Jan-07', '335 yeayea Ln', 'Tampa', 'FL','USA','t3k''1t8',8135678478, 12808365987,'devin@chinookcorp.com' );
--Task – Insert two new records into Customer table
INSERT INTO customer VALUES (60, 'Mike','Jones', 'Revature', '1234 st', 'Tampa', 'FL', 'USA',44132, 19894567789,2349991111,'mike@mikejones.com', 5) ; 
INSERT INTO customer VALUES (61, 'Bill','Waterman', 'Revature', '6789 st', 'Brandon', 'FL', 'USA',33510, 1787899822,17574667373,'bill@billwaterman.com', 5) ; 
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walker'
WHERE firstname = 'Aaron'AND lastname = 'Mitchell';

SELECT * FROM customer;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

SELECT * FROM artist;

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
WHERE hiredate BETWEEN '1-June-03' AND '1-MAR-04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM CHINOOK.invoiceline
WHERE invoiceid IN (SELECT invoiceid FROM CHINOOK.invoice 
WHERE customerid IN (SELECT customerid FROM CHINOOK.customer
WHERE firstname = 'Robert'
AND lastname = 'Walker'));

--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE FUNCTION currentTime
RETURN VARCHAR2 
    IS currentDate VARCHAR2(4000);
BEGIN
    SELECT TO_CHAR(sysdate,'MM-DD-YY HH12:MI:SS')
    INTO currentDate
    FROM DUAL;
    RETURN (currentDate);
END;
/
SET SERVEROUTPUT ON;
BEGIN
DBMS_OUTPUT.PUT_LINE(currentTime);
END;
/


--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION currentLength
RETURN INT
    IS nameLength INT(38);
    BEGIN 
    SELECT mediatypeid, LENGTH(TRIM(name))
    INTO nameLength
    FROM mediatype;
    RETURN nameLength;
    END;
    /
SET SERVEROUTPUT ON;
BEGIN
DBMS_OUTPUT.PUT_LINE(currentLength);
END;
/

SELECT mediatypeid, LENGTH(TRIM(name)) 
FROM mediatype;

-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION averagetotal
RETURN INT
IS totalstorage INT(36,3);
BEGIN
SELECT AVG (total)
INTO totalstorage
FROM invoice;
RETURN (totalstorage);
END;
/

SET SERVEROUTPUT ON;
BEGIN
DBMS_OUTPUT.PUT_LINE(averagetotal);
END;
/



--SELECT AVG (total) FROM invoice;


--Task – Create a function that returns the most expensive track
--CREATE FUNCTION mostexpensive
--RETURN 
CREATE OR REPLACE FUNCTION returngreat
RETURN INT
IS getgreat INT (36,3);
BEGIN
SELECT GREATEST(unitprice) 
INTO getgreat
FROM track;
RETURN (getgreat);
END;
/

SET SERVEROUTPUT ON;
BEGIN
DBMS_OUTPUT.PUT_LINE(returngreat);
END;
/



SELECT GREATEST (unitprice) FROM track;


-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE FUNCTION averageprice
RETURN NUMBER
IS priceavg NUMBER(36,5);
BEGIN
SELECT AVG (unitprice) 
INTO priceavg
FROM invoiceline;
RETURN priceavg;
END;
/

SET SERVEROUTPUT ON;
BEGIN
DBMS_OUTPUT.PUT_LINE(averageprice);
END;
/



SELECT AVG (unitprice) FROM invoiceline;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION getemployee
RETURN VARCHAR2
IS employeebirth VARCHAR2(4000);
BEGIN 
SELECT  TO_CHAR('DD-MON-YY')
INTO employeebirth
FROM employee WHERE birthdate > '31-DEC-67';
RETURN employeebirth;
END;
/

SET SERVEROUTPUT ON;
BEGIN
DBMS_OUTPUT.PUT_LINE(getemployee);
END;
/

SELECT * FROM employee WHERE birthdate > '31-DEC-67';

--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE getnames
IS name1 VARCHAR2(4000);
name2 VARCHAR2(4000);
BEGIN
SELECT firstname,lastname 
INTO name1, name2
FROM employee;
END;
/


SELECT firstname,lastname FROM employee;

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE getpersonal
IS info VARCHAR2(4000);
BEGIN
UPDATE employee 
SET title = 'Punk'
WHERE title = 'Footware Associate';
END;
/

-- Task – Create a stored procedure that returns the managers of an employee.
SELECT REPORTSTO;


-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER new_record AFTER 
INSERT ON employee FOR EACH ROW 
BEGIN
INSERT INTO ALBUM VALUES(500, '500', 200);
END;



COMMIT;
INSERT INTO employee VALUES (277, 'P', 'D', 'Footware Associate',1,'22-Apr-91', '1-Jan-07', '335 yeayea Ln', 'Tampa', 'FL','USA','t3k''1t8',8135678478, 12808365987,'devin@chinookcorp.com' );
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER new_row AFTER 
UPDATE ON album FOR EACH ROW 
BEGIN
INSERT INTO ALBUM VALUES(501, '501', 200);
END;
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER deleted_row AFTER 
DELETE ON customer FOR EACH ROW 
BEGIN
INSERT INTO ALBUM VALUES(502, '502', 200);
END;

DELETE FROM customer WHERE customerid = 22;
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.