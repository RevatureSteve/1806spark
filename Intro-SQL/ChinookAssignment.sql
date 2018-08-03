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

SELECT CURRENT_TIMESTAMP FROM dual;


--ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY HH24:MI:SS';
--SELECT SESSIONTIMEZONE, CURRENT_TIMESTAMP FROM DUAL;

--edits a new time and not part of assignment, just for me
SELECT NEW_TIME(TO_DATE('11-10-09 01:23:45', 'MM-DD-YY HH24:MI:SS'), 'AST', 'PST')
         "New Date and Time"
  FROM DUAL;

--create a function that returns the length of a mediatype from the mediatype table
SELECT * FROM MediaType;

CREATE OR REPLACE FUNCTION getLength (name in Varchar2)
RETURN length as
    Begin
        Select * INTO Length;
        return Length;
END;
/
SELECT getlength(MediaType.name) FROM DUAL;

--==============================================================================================================================
--  3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
--==============================================================================================================================

--Create a function that returns the average total of all invoices

SELECT * FROM Invoice;

SELECT AVG(Total)
FROM Invoice;

--Create a function that returns the most expensive track
SELECT MAX(Total)
FROM Invoice;

--==============================================================================================================================
--  3.3 USER DEFINED SCALAR FUNCTIONS
--==============================================================================================================================

--Create a function that returns the average price of invoiceline items in the invoiceline table

SELECT * FROM InvoiceLine;

SELECT AVG(Total)
FROM Invoice;

--==============================================================================================================================
--  3.4 USER DEFINED TABLE VALUED FUNCTIONS
--==============================================================================================================================
--Create a function that returns all employees who are born after 1968.

SELECT * FROM Employee;



