-- Connection to the DB --> User -> Schema
-- Connection to DB -> RevatureHumphrey -> Humphrey's Schema 
-- Connection to the DB -> Chinook -> Chinook's schema














-- Select all from employee table in chinook----------------------------------------------------------------------------------------------------------------------------
SELECT * FROM employee;

--–Select all records from the Employee table where last name is King.--------------------------------------------------------------------------------------------------
SELECT firstname, lastname 
FROM employee
WHERE lastname = 'King';

--Select all records from the Employee table where first name is Andrewand REPORTSTOis NULL.----------------------------------------------------------------------------

SELECT * FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;

--Select all albumsin Albumtable and sort result set in descending orderby title.---------------------------------------------------------------------------------------

SELECT * FROM album 
ORDER BY title DESC;

--–Select first name from Customerand sort result set in ascending orderbycity-----------------------------------------------------------------------------------------

SELECT firstname FROM customer
ORDER BY city ASC;


-- Insert two new records into Genre table-----------------------------------------------------------------------------------------------------------------------------

INSERT INTO genre VALUES(66,'Hip Hop');
INSERT INTO genre VALUES(67,'Pop');

--– Update AaronMitchellin Customertable to Robert Walter--------------------------------------------------------------------------------------------------------------

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname= 'Mitchell';
commit;

-- Update name of artist in the Artist table“Creedence Clearwater Revival” to “CCR”-------------------------------------------------------------------------------------

Update artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';



-- Select all invoiceswith a billing addresslike “T%”--------------------------------------------------------------------------------------------------------------------

SELECT billingaddress FROM invoice
WHERE billingaddress LIKE 'T%';



--Select all invoicesthat have a totalbetween 15and 50

SELECT total FROM invoice
WHERE total > 15 AND total < 50;

--Select all employees hired between 1stof June 2003 and 1stof March 2004

SELECT firstname, lastname, hiredate FROM employee
WHERE hiredate > TO_DATE(20030601,'YYYYMMDD') AND hiredate < TO_DATE(20040301,'YYYYMMDD');

--Delete a record in Customertable where the name is Robert Walter(There may be constraints that rely on this, find out how to resolve them).
--Delete from the parent tables first
DELETE FROM invoiceline WHERE invoiceid = 50 OR invoiceid= 61 OR invoiceid= 116 OR invoiceid= 245 OR invoiceid=268 OR invoiceid= 290 OR invoiceid= 342;
DELETE FROM invoice WHERE customerid =32;
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';

commit;
-- Create a function that returns the current time
SELECT chinook.get_current_time FROM DUAL;

-- create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name) as "Number of Chars" FROM mediatype;

-- Create a function that returns the average total of all invoices
SELECT AVG(total) as "Average For Invoices" FROM invoice;

-- Create a function that returns the most expensive track
SELECT name,MAX(unitprice) FROM track;

-- Create a function that returns the average priceof invoiceline itemsin the invoiceline table
SELECT AVG(unitprice) as "Average Price Of Items" FROM invoiceline;

-- Create a function that returns all employees who are born after 1968

SELECT firstname,lastname, birthdate FROM employee 
Where birthdate > TO_DATE('1968','YYYY');


-- Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE select_full_name(x OUT SYS_REFCURSOR)
IS
BEGIN
  
  OPEN x FOR SELECT firstname, lastname FROM employee;

    
END;
/

DECLARE
   x SYS_REFCURSOR;
  firstname employee.firstname%TYPE;
  lastname employee.lastname%TYPE;
Begin
select_full_name(x);


  LOOP
    FETCH x INTO firstname, lastname;
    EXIT WHEN x%NOTFOUND;
    
    DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname);
    
  END LOOP;
  CLOSE x;
END;
/


--Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE update_personal(employeeID2 IN NUMBER, newCity IN VARCHAR, newState IN VARCHAR, newCountry IN VARCHAR)
IS
BEGIN
  
  UPDATE employee
  
  SET city =  newcity ,
  state = newstate,
  country = newCountry
  
  WHERE employeeid = employeeid2;
 
  
END;
/

DECLARE
  
Begin
        update_personal(1,'Palm Beach', 'FL', 'USA');
END;
/


SELECT * FROM employee;

--Task – Create a stored procedure that returns the managers of an employee.

CREATE OR REPLACE PROCEDURE who_manages(reportstoNumber IN NUMBER,x OUT SYS_REFCURSOR)
IS
BEGIN
  
OPEN x FOR SELECT firstname,lastname FROM employee WHERE employeeid = reportstoNumber;

END;
/

COMMIT;

DECLARE
firstname employee.firstname%TYPE;
lastname employee.lastname%TYPE;
x SYS_REFCURSOR;

Begin

    who_manages(3,x);
    
    LOOP
    FETCH x INTO firstname, lastname;
    EXIT WHEN x%NOTFOUND;
    
    DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname);
    
  END LOOP;
  CLOSE x;

END;
/

-- Create a stored procedure that returns the name and company of a customer---------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE customerInfo(customerID2 IN NUMBER,x OUT SYS_REFCURSOR)
IS
BEGIN
  
OPEN x FOR SELECT firstname,lastname,company FROM customer WHERE customerid = customerID2;

END;
/


DECLARE
firstname customer.firstname%TYPE;
lastname customer.lastname%TYPE;
company customer.company%TYPE;

x SYS_REFCURSOR;

Begin

    customerInfo(3,x);
    
    LOOP
    FETCH x INTO firstname, lastname, company;
    EXIT WHEN x%NOTFOUND;
    
    DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname ||' '|| company);
    
  END LOOP;
  CLOSE x;

END;
/

--–Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

CREATE OR REPLACE PROCEDURE delete_where(invoiceID2 IN NUMBER)
IS
BEGIN

Delete FROM invoiceline where invoiceid = invoiceID2;
DELETE FROM invoice WHERE invoiceid = invoiceID2;
COMMIT;

END;
/


DECLARE
  
Begin
        delete_where(240);
END;
/


--Create a transaction nested within a stored procedure that inserts a new record in the Customer table -----------------------------------------------------------------

CREATE OR REPLACE PROCEDURE insert_new(customerID2 IN NUMBER,fname1 IN VARCHAR2,lname1 IN VARCHAR2,company1 IN VARCHAR2, address1 IN VARCHAR2, email1 IN VARCHAR2)
IS
BEGIN

INSERT INTO customer(customerid,firstname,lastname,company,address,email) VALUES (customerid2, fname1, lname1, company1,address1, email1);
COMMIT;

END;
/

DECLARE
  
Begin
        insert_new(106,'freddy','flinstone','Walmart', '3337 northrump','hmdf@yahoo.com');
END;
/

--Create an after insert trigger on the employee table fired after a new record is inserted into the table---------------------------------------------------------------
CREATE OR REPLACE TRIGGER after_insert_employee
After INSERT ON employee
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
  IF :new.Firstname IS NOT NULL THEN
  
    DBMS_OUTPUT.PUT_LINE('Welcome,' || ' ' || :new.Firstname);
    
  END IF;
END;
/

INSERT INTO employee (employeeID,lastname,firstname) VALUES(212,'Minott','Humphrey');



--Create an after update trigger on the album table that fires after a row is inserted in the table----------------------------------------------------------------------

CREATE OR REPLACE TRIGGER after_insert_album
After UPDATE ON album
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
  DBMS_OUTPUT.PUT_LINE('There has been a change in Albums table');
END;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER after_delete_cust
After DELETE ON customer
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
  DBMS_OUTPUT.PUT_LINE('A row in customers has been deleted from table');
END;
/

--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId

SELECT customer.firstname,customer.lastname, invoice.invoiceid FROM customer INNER JOIN invoice on customer.customerid = invoice.customerid;

--– Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid,invoice.total FROM 
customer FULL OUTER JOIN invoice on customer.customerid = invoice.customerid;

--– Create a right join that joins album and artist specifying artist name and title.

SELECT artist.name,album.title FROM artist RIGHT OUTER JOIN Album ON artist.artistid = album.artistid;

-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT 
album.TITLE,
artist.name
FROM artist 
CROSS JOIN album;

COMMIT;

--– Perform a self-join on the employee table, joining on the reportsto column.

SELECT e1.firstname, e1.lastname, e2.reportsto FROM employee ;



--- Perform an join on all tables in chinook
SELECT * FROM customer INNER JOIN invoice on customer.customerid = invoice.customerid
INNER JOIN employee on customer.supportrepid = employee.employeeid
INNER JOIN invoiceline on invoice.invoiceid = invoiceline.invoiceid
INNER JOIN track on invoiceline.trackid = track.trackid
INNER JOIN mediatype on  track.MEDIATYPEID= mediatype.mediatypeid
INNER JOIN genre on track.genreid= genre.genreid
INNER JOIN album on track.albumid= album.albumid
INNER JOIN playlisttrack on playlisttrack.trackid = track.trackid
INNER JOIN playlist on playlist.playlistid = playlisttrack.playlistid;




