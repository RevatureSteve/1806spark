-- Connection to the DB -> User - > Schema
-- Connection to the DB -> obosani -> Obosa's schema
-- Connection to the DB -> Chinook -> Chinook's schema

--2.1 SELECT:
-- Select all records from the Employee table
SELECT * FROM Employee;
SELECT records FROM Employee;
-- Select all records from the Employee table where last name is King
SELECT *  FROM Employee
WHERE LastName = 'King';
--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee
WHERE FirstName = 'Andrew' AND REPORTSTO IS null;

--2.2 ORDER BY:
--Select all albums in Album table and sort result set in descending order by title Pp
SELECT * FROM Album
ORDER BY ALBUM.TITLE DESC;
--Select first name from Customer and sort result set in ascending order by city
SELECT FirstName FROM Customer
ORDER BY CUSTOMER.CITY ASC;

--2.3 INSERT INTO
--Insert two new records into Genre table
INSERT INTO Genre(GenreId, Name) VALUES(26, 'AfroBeats');
INSERT INTO Genre(GenreId, Name) VALUES(27, 'EDM');
--Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Whitehall', 'Areah', 'Data Analist', 7, TO_DATE('1969-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2005-4-5 00:00:00','yyyy-mm-dd hh24:mi:ss'), '23 9 ST NE', 'Leftrail', 'AB', 'Canada', 'T1F 1X8', '+1 (401) 967-3551', '+1 (405) 477-8672', 'areah@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (8, 'Winwood', 'Jojo', 'CEO', 6, TO_DATE('1978-5-8 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-7-3 00:00:00','yyyy-mm-dd hh24:mi:ss'), '93 8 ST SW', 'Toronto', 'VA', 'Canada', 'T1W 1Z7', '+1 (433) 407-3001', '+1 (408) 497-4002', 'jojo@chinookcorp.com');
--Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'Paja', 'Sirano', '12,Taylor ln', 'Oakland', 'California', '94577', '+1(510)-874-0948', 'paja_sirano@yahoo.in', 4);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Sonia', 'Douglas', '7,Terrace Road', 'Baltimore', 'Maryland', '21787', '+1(410)-098-8873', 'sonia.douglas@yahoo.in', 5);

--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET FirstName = 'Robert', LastName = 'Walter'
WHERE FirstName='Aaron' and LastName = 'Mitchell';
--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Select all invoices with a billing address like “T%”
SELECT * FROM Invoice 
WHERE BillingAddress like 'T%';

--2.6 BETWEEN
--Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice WHERE Total BETWEEN 15 and 50;
--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM Employee WHERE hiredate BETWEEN '01-JUN-03' and '01-MAR-04';

--2.7 DELETE
--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID FROM INVOICE
WHERE CUSTOMERID IN (SELECT CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));
DELETE FROM INVOICE
WHERE CUSTOMERID IN (SELECT CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.1 System Defined Functions
--Create a function that returns the current time.
CREATE OR REPLACE FUNCTION CURRENTTIME
RETURN VARCHAR2 AS CURRENTTIME VARCHAR(260);
BEGIN
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS')INTO CURRENTTIME FROM DUAL;
RETURN CURRENTTIME;
END;
/
SELECT CURRENTTIME() FROM DUAL;
--create a function that returns the length of a mediatype from the mediatype table.
CREATE OR REPLACE FUNCTION IS_LENGTH
(MEDIA_NAME IN VARCHAR2)
RETURN NUMBER AS IS_LENGTH NUMBER;
BEGIN
RETURN LENGTH(MEDIA_NAME);
END;
/
SELECT IS_LENGTH(NAME) FROM MEDIATYPE;

--3.2 System Defined Aggregate Functions
--Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION AVERAGE
RETURN NUMBER AS AVERAGE NUMBER(10,2);
BEGIN
SELECT AVG(TOTAL) INTO AVERAGE FROM INVOICE;
RETURN AVERAGE;
END;
/
SELECT AVERAGE() FROM DUAL;
--Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MAXPRICE
RETURN NUMBER AS MOSTE NUMBER(10,2);
BEGIN
SELECT MAX(UNITPRICE) INTO MOSTE FROM TRACK;
RETURN MOSTE;
END;
/
SELECT MAXPRICE() FROM DUAL;

--3.3 User Defined Scalar Functions
--Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVERAGE_PRICE
RETURN NUMBER AS AVERAGE NUMBER(10,2);
BEGIN
SELECT AVG(UNITPRICE) INTO AVERAGE FROM INVOICELINE;
RETURN AVERAGE;
END;
/
SELECT AVERAGE_PRICE() FROM DUAL;

--3.4 User Defined Table Valued Functions
--Create a function that returns all employees who are born after 1968.
SELECT * FROM EMPLOYEE
WHERE BIRTHDATE > TO_DATE('19681231', 'YYYYMMDD');

CREATE OR REPLACE FUNCTION get_date(startdate IN STRING)
RETURN DATE
IS
BEGIN
    RETURN TO_DATE(startdate, 'YYYYMMDD');
END;
/

SELECT * FROM EMPLOYEE
WHERE BIRTHDATE > get_date('19681231');

--4.1 Basic Stored ProcedureTask 
--Create a stored procedure that selects the first and last names of all the employees
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
    full_name := CONCAT (first_name, last_name);
    DBMS_OUTPUT.PUT_LINE(full_name);
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
  new_firstname IN VARCHAR2
)
AS 
BEGIN
  UPDATE employee
  SET firstname = 
        CASE WHEN new_firstname IS NULL
        THEN firstname
        ELSE new_firstname
        END
    WHERE employeeid = the_employeeid;
END;
/

SET SERVEROUTPUT ON;
BEGIN
    update_employee(1, 'Davon');
END;
/

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE magr_of_employee
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
END magr_of_employee;
/

SET SERVEROUTPUT ON;
BEGIN
    magr_of_employee(8);
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
FOR cust 
IN
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


--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER after_insert_trigga
AFTER INSERT
ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('After insert trigger fired');
END;
/

INSERT INTO employee values(9, '1', '2', '3', '4', to_date('19960725','YYYYMMDD'), to_date('19960725','YYYYMMDD'), '7', '8', '9', '0', '1', '2', '3', '4');
DELETE FROM employee
WHERE employeeid = 9;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER after_update_trigga
AFTER UPDATE
ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('After update trigger fired');
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_trigga
AFTER DELETE
ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('After delete trigger fired');
END;
/
--7.0 JOINS
---7.1
--INNERJOIN
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2 
--OUTER JOIN
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, CUSTOMER.CUSTOMERID, INVOICE.INVOICEID,INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3
-- RIGHT JOIN
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT OUTER JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--7.4
--CROSS JOIN
SELECT *
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

--7.5
--SELF JOIN
SELECT *
FROM EMPLOYEE E, EMPLOYEE E2
WHERE E.REPORTSTO = E2.REPORTSTO;