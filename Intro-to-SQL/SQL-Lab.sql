--  2.1 Select
-- Task A Select all records from the Employee table
SELECT * FROM CHINOOK.employee;

-- Task B Select all records from the Employee table where last name is king
SELECT *
FROM CHINOOK.employee
WHERE LASTNAME = 'King';

-- Task C Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT *
FROM CHINOOK.employee
WHERE firstname = 'Andrew'
AND reportsto IS null;

-- 2.2 ORDER BY
-- TASK A Select all albums in Album table and sort result set in descending order by title
SELECT *
FROM CHINOOK.album
ORDER BY title DESC;

--TASK B Select first name from Customer and sort result set in ascending order by city
SELECT firstname
FROM CHINOOK.customer
ORDER BY city ASC;

-- 2.3 INSERT INTO
-- TASK A Insert two new records into Genre table
INSERT INTO CHINOOK.genre(genreid, name)
VALUES (1001, 'Horror');
INSERT INTO CHINOOK.genre(genreid, name)
VALUES (1002, 'Happy');

-- TASK B Insert two new records into Employee table
INSERT INTO CHINOOK.employee(employeeid, lastname, firstname, city)
VALUES (9, 'Johnson', 'James', 'Los Angeles');
INSERT INTO CHINOOK.employee(employeeid, lastname, firstname, city)
VALUES (10, 'Daniels', 'Jeff', 'Tampa');

-- TASK C Insert two new records into customer table
INSERT INTO CHINOOK.customer(customerid, firstname, lastname, company, email)
VALUES (60, 'Michelle', 'Ganda', 'Pharmsc', 'mg@gmail.com');
INSERT INTO CHINOOK.customer(customerid, firstname, lastname, company, email)
VALUES (61, 'Mario', 'Luigi', 'Kingdom', 'ml@mk.com');
select * from CHINOOK.customer;

-- 2.4 UPDATE
-- Task A – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.customer SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

-- Task B – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE CHINOOK.artist SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
-- Task A – Select all invoices with a billing address like “T%”
SELECT * FROM CHINOOK.invoice
WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
-- Task A – Select all invoices that have a total between 15 and 50
SELECT * FROM CHINOOK.invoice
WHERE total BETWEEN 15 AND 50;

-- Task B – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM CHINOOK.employee
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints 
-- that rely on this, find out how to resolve them).
    DELETE FROM CHINOOK.invoiceline
    WHERE invoiceid IN (SELECT invoiceid FROM CHINOOK.invoice
    WHERE customerid IN (SELECT customerid FROM CHINOOK.customer
    WHERE customer.firstname = 'Robert' 
    AND customer.lastname = 'Walter'));
    
--3.1 System Defined Functions
--Task A – Create a function that returns the current time.
CREATE FUNCTION getDate
RETURN VARCHAR2 
    IS currDate VARCHAR2(4000);
BEGIN
    SELECT TO_CHAR(sysdate,'MM-DD-YY HH12:MI:SS')
    INTO currDate
    FROM dual;
    RETURN (currDate);
END;

SELECT getDate FROM dual;

--Task B – create a function that returns the length of a mediatype from the mediatype table
CREATE FUNCTION getLength(mediaid INT)
RETURN INT
    IS l INT;
BEGIN
    SELECT LENGTH(name)
    INTO l
    FROM mediatype
    WHERE mediatypeid = mediaid;
    RETURN (l);
END;
/
SELECT getLength(1) FROM dual;

--3.2 System Defined Aggregate Functions
--Task A – Create a function that returns the average total of all invoices
CREATE FUNCTION getAverage
RETURN INT
    IS average INT;
BEGIN
    SELECT AVG(total)
    INTO average
    FROM invoice;
    RETURN average;
END;
    
SELECT getAverage FROM dual;

--Task B – Create a function that returns the most expensive track*

CREATE FUNCTION findExpensive
RETURN INT
    IS expense INT(38,2);
BEGIN
SELECT unitprice 
INTO expense
FROM track
WHERE unitprice = ( 
    SELECT MAX(unitprice)
    FROM track
    );
RETURN (expense);
END;

SELECT findExpensive FROM dual;

--3.3 User Defined Scalar Functions
--Task A – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE FUNCTION averagePrice
RETURN NUMBER
    IS price NUMBER;
BEGIN
    SELECT ROUND(unitprice)
    INTO price
    FROM invoiceline;
    RETURN price;
END;

SELECT averagePrice FROM dual;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--CREATE FUNCTION bornAfter(beep DATE)
--RETURNS employee
--    AS
--RETURN
--    SELECT e.name
--    INTO afteryear
--    FROM employee e
--    WHERE birthdate > '01-Jan-69';
--END;
--BEGIN

--END;

--SELECT * FROM employee
--WHERE birthdate > '01-Jan-69';

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE get_all_names(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR
  SELECT * FROM employee;
END;
/

--Anonymous test of Stored Proc with Cursor
DECLARE
  fc_cursor SYS_REFCURSOR;
  someId firstname.fc_id%TYPE;
  someQ lastname.fc_question%TYPE;
BEGIN
  
  get_all_fc_procedure(fc_cursor);
  LOOP
    FETCH fc_cursor INTO someId, someQ;
    EXIT WHEN fc_cursor%NOTFOUND;
    
    DBMS_OUTPUT.PUT_LINE(someId || ' ' || someQ);
    
  END LOOP;
  CLOSE fc_cursor;
END;

--4.2 Stored Procedure Input Parameters
--Task A – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateInfo(lname VARCHAR2, fname VARCHAR2, address VARCHAR2, city VARCHAR2, s VARCHAR2, 
                                        country VARCHAR2, phoneNum VARCHAR2, faxNum VARCHAR2, mail VARCHAR2)
AS
BEGIN 
    UPDATE employee SET  
END;


--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice(invoid INT)
AS
BEGIN
    DELETE FROM invoiceline
    WHERE invoiceline.invoiceid = invoid; 
    DELETE FROM invoice
    WHERE invoice.invoiceid = invoid;
END;
/
BEGIN
deleteInvoice(320);
END;
/

--Task B – Create a transaction nested within a stored procedure that inserts a new record in the Customer
--table

CREATE OR REPLACE PROCEDURE insert_customer(numId IN INT, fname IN VARCHAR2, lname IN VARCHAR2, mail IN VARCHAR2)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname, email) VALUES (numId, fname, lname, mail);
END;
/

BEGIN 
    insert_customer(60, 'jorge', 'jorge', 'j@gmail.com');
END;
/

--6.1 AFTER/FOR
--Task A - Create an after insert trigger on the employee table fired after a new record is inserted into the
--table.

CREATE OR REPLACE TRIGGER afterInsert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Good job for inserting!');
END;

--Task B – Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER afterUpdate
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Good job for updating!');
END;

--Task C – Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.

CREATE OR REPLACE TRIGGER afterDelete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Good job for deleting!');
END;





--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.

SELECT c.firstname, c.lastname, i.invoiceid
FROM customer c
INNER JOIN invoice i ON c.customerid = i.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.

SELECT c.firstname, c.lastname, i.invoiceid, i.total
FROM customer c
FULL OUTER JOIN invoice i ON c.customerid = i.invoiceid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

SELECT a.name, am.title
FROM album am
RIGHT OUTER JOIN artist a ON am.artistid = a.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT a.name
FROM album am
CROSS JOIN artist a
ORDER BY a.name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

SELECT a.*, b.firstname AS reporting_to_name
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;
