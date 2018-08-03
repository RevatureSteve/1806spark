

----------------------------------------------2.0  Section: SQL Queries
--Select everything from the Employee table.
SELECT * FROM Employee;

--Select all records from Emplyee table where last name is King.
SELECT * FROM Employee 
WHERE lastname = 'King';

--Select all records from the Employee table where first aname is Andrew and REPORTSTo is null.
SELECT * from Employee
WHERE firstname = 'Andrew' 
AND
reportsto is null;


--2.2 Section: Order By
--Select all albums in Albums table and sort result set in descending order by title.
SELECT * FROM Album 
ORDER BY title DESC;

--Select first name from Customer and sort result in ascending order by city.
SELECT firstname from Customer
ORDER BY city ASC;

----------------------------------------------------2.3 Section: Insert Into

--Insert tow records into Genre table.
INSERT INTO Genre
(genreid, name)
VALUES
(26, '80s Rap');

INSERT INTO Genre
(genreid, name)
VALUES
(27, '80s R&B');

--Insert tow new records into Employee table

SELECT * FROM Employee;

INSERT INTO Employee 
VALUES
(9, 'Murry', 'Bill', 'Operations Manager', 4, '04-May-50', '14-JUL-18', '123 Mur Lane', 'Hampton', 'AB', 'Canada', 'TIP 897', ' 1 (456)-788-2343',' (675) 456-8899', 'bmur@chinook.com');

INSERT INTO Employee
VALUES
(10, 'Wills', 'Sarah', 'Store Manager', 1, '14-JAN-80', '20-JUL-18', '123 Penny Lane', 'Hampton', 'AB', 'Canada', 'TIP 887', ' 1 (456)-788-2343',' (675) 456-8899', 'swills@chinook.com');


--Insert two new records into Customer table.

SELECT * FROM Customer;

INSERT INTO Customer
VALUES
(60, 'Mable', 'Lay', 'Revature', '1234 Mang Avenue', 'Reston', 'VA', 'USA', '5858', '983-233-888', '2222 55855 788', 'mlay@fmail.com', 2);

INSERT INTO Customer
VALUES
(61, 'Freddy', 'Park', 'Revature', '589 Ups Avenue', 'Hampton', 'VA', 'USA', '87855', '983-233-888', '2222 55855 788', 'fpark@fmail.com', 4);


---------------------------------------------------2.4 Section: Update

--Update Aaron Mitchell in Customer table to take to Robert Walter.
UPDATE customer
SET firstname = 'Robert' 
WHERE firstname = 'Aaron';
 UPDATE customer
 SET lastname = 'Walter'
 WHERE lastname = 'Mitchell';
 

--Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR".
UPDATE Artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revivial';

------------------------------------------------2.5 Section Like
--Select all invoices with a billing address like "T%'.
SELECT * FROM Invoice
WHERE billingaddress LIKE 'T%';

----------------------------------------------2.6 Section: Between

--Select all invoices that have a total between 15 and 50.
SELECT * FROM Invoice
WHERE total BETWEEN 15 AND 50;

--Select all employeee hired between 1st of June 2003 and 1st of March 2004.
SELECT * FROM Employee
WHERE hiredate BETWEEN  '01-JUN-03' AND '01-MAR-04';

--2.7 Section Delete-
--Delete a record in Customer table where the name is Robert Walter.
DELETE FROM Employee
WHERE firstname = 'Robert'
AND lastname = 'King';

DELETE FROM Customer
WHERE firstname = 'Robert'
AND lastname = 'Walter';


----------------------------------------------------3.0 Section SQL Functions
--3.1
--Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current_time
RETURN TIMESTAMP
AS
c_time TIMESTAMP;
BEGIN
  SELECT current_date into c_time from dual;
END;
commit;

--Create a function that returns the length of a mediatype from the mediatype table.
CREATE OR REPLACE FUNCTION media_length_function
RETURN  NUMBER
AS
m_length NUMBER;
BEGIN
SELECT length(name) into m_length FROM mediatype;
END;

--3.2
--Create a function that returns the average total of all invoices. 
CREATE OR REPLACE FUNCTION avg_invoices
RETURN NUMBER
AS
a_invo NUMBER;
BEGIN
SELECT AVG(total) into a_invo FROM invoice;
END;
commit;

--Create a function that returns the most expensive track.
CREATE OR REPLACE FUNCTION expensive_track
RETURN NUMBER
AS
e_track NUMBER;
BEGIN
SELECT MAX(unitprice) into e_track FROM Track;
END;
COMMIT;
--3.3
--Create a function that returns the average price of invoiceline items in the invoiceline table.
CREATE OR REPLACE FUNCTION average_invoiceline
RETURN NUMBER
AS
a_invoiceline NUMBER;
BEGIN
SELECT AVG(unitprice) into a_invoiceline FROM invoiceline;
END;
--3.4
--Create a function that returns all employees born after 1968.
CREATE OR REPLACE FUNCTION old_emp
RETURN VARCHAR2
AS name VARCHAR2(4000);
BEGIN
SELECT firstname into name FROM employee
WHERE birthdate > '12-DEC-68';
END;

commit;

---------------------------------------------4.0 Section: Stored procdures
--4.1 
--Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_emp_names  
IS
name1 VARCHAR2(4000);
name2 VARCHAR2(4000);
   BEGIN
     SELECT firstname, lastname INTO name1, name2 FROM Employee;
   END;

   --4.2
   --Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE upd_pers_info 
( first_name VARCHAR2 , last_name VARCHAR2 , phone VARCHAR2 )
IS
BEGIN
INSERT INTO employee
(firstname, lastname, phone)
VALUES
(first_name, last_name, phone);
END;


-- Create a stored procedure that returns the managers of an employee.
SELECT * FROM employee;

   CREATE OR REPLACE PROCEDURE return_manager 
   IS
  e_name VARCHAR2(4000);
   m_name VARCHAR2(4000);
   
BEGIN
   SELECT a.firstname,b.firstname INTO e_name, m_name
   FROM Employee a, Employee b
   WHERE b.employeeid = a.reportsto;
   END;
   


   
-------------------------------------------------6.0 Section Triggers
--6.1
--Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE SEQUENCE new_emp_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER new_emp_trigger
BEFORE INSERT ON employee
FOR EACH ROW  
BEGIN
  IF :new.employeeid IS NULL 
  THEN
    SELECT NEW_EMP_SEQ.nextval INTO :new.employeeid FROM DUAL;
  END IF;
END;

--Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER ablum_trigger 
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
END;



--Create an after delete trigger on the customer table that fires after a row is deleted from the table.
 CREATE OR REPLACE TRIGGER cust_trigger
AFTER DELETE ON customer
FOR EACH ROW
BEGIN

END;

-------------------------------------------------7.0 Section: Joins

--7.1
--–Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM Customer
INNER JOIN Invoice 
ON Customer.customerId = invoice.customerid;

--7.2
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
LEFT OUTER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.3
--Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM artist
RIGHT JOIN album
on artist.artistid = album.artistid;

--7.4
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
 SELECT *
 FROM album CROSS JOIN artist
 ORDER BY artist.name ASC;
 
 --7.5
 --Perform a self-join on the employee table, joining on the reportsto column.
 SELECT e1.employeeid, e2.reportsto
 FROM Employee e1, Employee e2
 WHERE e1.employeeid = e2.reportsto;
 
 commit;











