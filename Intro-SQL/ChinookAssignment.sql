--==============================================================================================================================
--  2.1 SELECT
--==============================================================================================================================
SAVEPOINT A;
--Select all records from the Employee table
SELECT * 
FROM employee;

--Select all records from the Employee table where last name is King
SELECT *
FROM employee 
WHERE LastName = 'King';

--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT *
FROM employee
WHERE FirstName = 'Andrew'
AND ReportsTo IS NULL;

--==============================================================================================================================
--  2.2 ORDER BY
--==============================================================================================================================
SAVEPOINT B;
--Select all albums in Album table and sort result set in descending order by title
SELECT * 
FROM Album
ORDER BY Title DESC;

--Select all from Customer
SELECT *
FROM Customer;

--Select first name from Customer and sort result set in ascending order by city
SELECT FirstName
FROM Customer
ORDER BY City ASC;

--==============================================================================================================================
--  2.3 INSERT INTO
--==============================================================================================================================
SAVEPOINT C;
--Select all from the Genre table
SELECT * 
FROM Genre
ORDER BY GenreId ASC;

--Insert two new records into Genre table
INSERT INTO Genre (GenreId, Name)
VALUES (26, 'Lofi');
COMMIT;

INSERT INTO Genre (GenreId, Name)
VALUES (27, 'J-Rock');
COMMIT;

--Select all from the Employee table
SELECT * 
FROM Employee;

--Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (9, 'Law', 'Forest', 'Programmer', 1, TO_DATE('19920725','YYYYMMDD'), TO_DATE('20151125','YYYYMMDD'),'1254 Kenji Rd','Mitaka', 'TYO', 'Japan', '006 0841', '+1 (011)-271-6677', '+1 (011)-221-6377', 'law@chinookcorp.com');
COMMIT;

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (10, 'Wulong', 'Lie', 'Programmer', 1, TO_DATE('19900915','YYYYMMDD'), TO_DATE('20151026','YYYYMMDD'),'1254 Kinto ST','Hokido', 'TYO', 'Japan', '006 3591', '+1 (015)-270-3277', '+1 (015)-222-6370', 'lie@chinookcorp.com');
COMMIT;

--Select all from the Customer table
SELECT *
FROM Customer
ORDER BY CustomerId ASC;

--Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, State, Country, PostalCode, Phone, Email, SupportRepId)
VALUES (60, 'Wlliams', 'Nina', '100 Kinder Ave','Kendy', 'California','United States', '98240', '+44 (015)-270-3277', 'lie@chinookcorp.com', 5);
COMMIT;

INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, State, Country, PostalCode, Phone, Email, SupportRepId)
VALUES (61, 'Wlly', 'Big', '75th ST','Grand Prarie', 'Texas','United States', '98240', '+9 (345)-279-7777', 'BWillie@chinookcorp.com', 5);
COMMIT;

--==============================================================================================================================
--  2.4 UPDATE
--==============================================================================================================================
SAVEPOINT D;
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET FirstName = 'Robert', LastName = 'Walter'
WHERE CustomerId = 32;
COMMIT;

--select Creedence Clearwater Revival from Artist table
SELECT *
FROM Artist
WHERE ArtistId = 76;

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
SET name = 'CCR'
WHERE artistid = 76;
COMMIT;

--==============================================================================================================================
--  2.5 LIKE
--==============================================================================================================================
SAVEPOINT E;
--Select all invoices with a billing address like “T%”
SELECT *
FROM Invoice 
WHERE BillingAddress LIKE 'T%'; 

--==============================================================================================================================
--  2.6 BETWEEN
--==============================================================================================================================
SAVEPOINT F;
--Select all invoices that have a total between 15 and 50
SELECT *
FROM Invoice 
WHERE Total BETWEEN 15 AND 50;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM Employee
WHERE HireDate BETWEEN TO_DATE('20030601','YYYYMMDD')
AND TO_DATE('20040301','YYYYMMDD');

--==============================================================================================================================
--  2.7 DELETE
--==============================================================================================================================
SAVEPOINT G;
--Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
SELECT * FROM Customer;

UPDATE Customer
SET SupportRepId = NULL
WHERE CustomerId = 32;

DELETE FROM Invoice  
WHERE CustomerId = 32;

SELECT * FROM Invoice
WHERE CustomerId = 32;

SELECT * FROM Customer
WHERE CustomerId = 32; 

DELETE FROM Customer
WHERE CustomerId = 32;

SELECT * FROM InvoiceLine;

--==============================================================================================================================
--  3.1 SYSTEM DEFINED FUNCTIONS 
--==============================================================================================================================

--Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time 
RETURN TIMESTAMP AS 
BEGIN
RETURN CURRENT_TIMESTAMP;
END get_time;
/

SELECT get_time FROM dual;

--just to reference
SELECT CURRENT_TIMESTAMP FROM dual;


--create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(Name) FROM MediaType;

--was trying a code, didn't work
CREATE OR REPLACE FUNCTION getLength (name in Varchar2)
RETURN length as
    Begin
        Select * INTO Length;
        return Length;
END;
/


--==============================================================================================================================
--  3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
--==============================================================================================================================

--Create a function that returns the average total of all invoices

SELECT * FROM Invoice;

SELECT AVG(Total)"Total of all Invoices"
FROM Invoice;

--Create a function that returns the most expensive track
SELECT MAX(Total)"Most Expensive Track"
FROM Invoice;

--==============================================================================================================================
--  3.3 USER DEFINED SCALAR FUNCTIONS
--==============================================================================================================================

--Create a function that returns the average price of invoiceline items in the invoiceline table

SELECT * FROM InvoiceLine;

SELECT AVG(Total) "Average of all Invoices"
FROM Invoice;

--==============================================================================================================================
--  3.4 USER DEFINED TABLE VALUED FUNCTIONS
--==============================================================================================================================
--Create a function that returns all employees who are born after 1968.
DECLARE
SELECT BirthDate FROM Employee; 
BEGIN
    IF Birthdate > TO_DATE('19680101','YYYYMMDD') THEN        
        SELECT *
        FROM Employee
        WHERE Birthdate > TO_DATE('19680101','YYYYMMDD');
    END IF;
        DBMS_OUTPUT.PUT_LINE('There is nothing to show');
END;
/
--==============================================================================================================================
--  4.1 BASIC STORED PROCEDURE
--==============================================================================================================================
--Create a stored procedure that selects the first and last names of all the employees.
CREATE PROCEDURE get_entire_name (name OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN Name FOR
    SELECT FirstName, LastName FROM Employee;
END;
/

DECLARE
    name SYS_REFCURSOR;
    somefn employee.firstname%TYPE;
    someln employee.lastname%TYPE;
BEGIN
    get_entire_name (name);
    LOOP
        FETCH name INTO somefn, someln;
        EXIT WHEN name%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(somefn || ' ' || someln);
        
    END LOOP;
    CLOSE name;
END;
/
--==============================================================================================================================
--  4.2 STORED PROCEDURE INPUT PARAMETERS
--==============================================================================================================================
--Create a stored procedure that updates the personal information of an employee

--Create a stored procedure that returns the managers of an employee.


--==============================================================================================================================
--  4.3 STORED PROCEDURE OUTPUT PARAMETERS
--==============================================================================================================================
--Create a stored procedure that returns the name and company of a customer.
CREATE PROCEDURE get_company_and_customer (custid IN INT, firstname OUT VARCHAR2, lastname OUT VARCHAR2, company OUT VARCHAR2)
IS BEGIN
    SELECT firstname, lastname, company
    INTO firstname, lastname, company
    FROM customer
    WHERE customerid = custid;
END;
/

DECLARE 
    firstname VARCHAR2(4000);
    lastname VARCHAR2(4000);
    company VARCHAR2(4000);
BEGIN
    get_company_and_customer(1, firstname, lastname, company);
    DBMS_OUTPUT.PUT_LINE(firstname||' '||lastname|| ' '|| company);
END;
/

--==============================================================================================================================
--  5.0 TRANSACTIONS                      
--==============================================================================================================================
--Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
CREATE PROCEDURE delete_invoice (in_id IN INT)
IS BEGIN
    DELETE FROM InvoiceLine WHERE InvoiceId = in_id;
    DELETE FROM Invoice WHERE InvoiceId = in_id;
END;
/

BEGIN
    delete_invoice(10);
END;
/

--Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE PROCEDURE insert_new_customer1(customeId IN INT, firstname IN VARCHAR2, lastname IN VARCHAR2,
company IN VARCHAR2, address IN VARCHAR2, city IN VARCHAR2, state IN VARCHAR2, country IN VARCHAR2, 
postalcode IN VARCHAR2, phone IN VARCHAR2, fax IN VARCHAR2, email IN VARCHAR2, supportId IN NUMBER)
IS BEGIN 
    INSERT INTO customer VALUES (customerId, FirstName, LastName, Company, Address, City, State, 
        Country, Postalcode, Phone, Fax, Email, SupportId);
    COMMIT;
END;
/

BEGIN 
    insert_customer_record(61, 'Kenji', 'Romain', 'Intel', '1775 St.', 'Houston', 'TX', 
        'United States', '14509', '+9 (858) 345-7874', '+9 (800) 543-8743', 'ditto@yahoo.com', 4);
END;
/


--==============================================================================================================================
--  6.1 AFTER/FOR                     
--==============================================================================================================================
--Create an after insert trigger on the employee table fired after a new record is inserted into the
--table.

--Create an after update trigger on the album table that fires after a row is inserted in the table

--Create an after delete trigger on the customer table that fires after a row is deleted from the table.


--==============================================================================================================================
--  7.1 INNER                     
--==============================================================================================================================
--Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.

SELECT FirstName, LastName, InvoiceId
FROM Customer ctm
INNER JOIN Invoice inv
ON ctm.CustomerId = inv.CustomerId;

--==============================================================================================================================
--  7.2 OUTER                    
--==============================================================================================================================
--Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.

SELECT ctm.CustomerId, ctm.FirstName, ctm.LastName, inv.InvoiceId, inv.Total
FROM Customer ctm
FULL OUTER JOIN Invoice inv
ON ctm.CustomerId = inv.CustomerId;

--==============================================================================================================================
--  7.3 RIGHT                    
--==============================================================================================================================
--Create a right join that joins album and artist specifying artist name and title.

SELECT name, Title
FROM Artist art
RIGHT JOIN album albm
ON art.ArtistId = albm.ArtistId;

--==============================================================================================================================
--  7.4 CROSS                    
--==============================================================================================================================
--Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT name, Title
FROM Artist
CROSS JOIN Album
ORDER BY name ASC;

--==============================================================================================================================
--  7.5 SELF                     
--==============================================================================================================================
--Perform a self-join on the employee table, joining on the reportsto column.

SELECT *
FROM Employee a, Employee b
WHERE a.ReportsTo = b.ReportsTo;

--==============================================================================================================================
--  9.0 ADMINISTRATION           
--==============================================================================================================================
--In this section you will be creating backup files of your database. After you create the backup file you
--will also restore the database. Research or try random things then communicate with batchmates, do
--not ask trainer.

--Create a .bak file for the Chinook database.



