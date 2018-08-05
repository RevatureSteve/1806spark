--2.1 task A get all records from Employee table
SELECT * FROM employee;
--2.1 task B get all records with last name King
SELECT * FROM employee 
WHERE lastname ='King';
--2.1 task C first name Andrew and REPORTSTO null
SELECT * FROM employee
WHERE firstname = 'Andrew' 
AND reportsto is null;
--2.2 task A order albums by title and sort descending
SELECT * FROM album
ORDER BY title DESC;
--2.2 task B first name from Customer and sort ascending by city
SELECT firstname FROM customer
ORDER BY city ASC;
--2.3 task A insert 2 new records into the Genre table
INSERT INTO genre VALUES(26, 'Viking Metal');
INSERT INTO genre VALUES(27, 'Speed Metal');
--2.3 task B insert 2 new records into the Employee table
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto)
VALUES(9, 'Doe', 'John', 'IT Staff', 6);
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto)
VALUES(10, 'Doe', 'Jane', 'IT Staff', 6);
--2.3 task C insert 2 new records into the Customer table
INSERT INTO customer(customerid, lastname, firstname, company, email, supportrepid)
VALUES(60, 'Malkovic', 'John', 'Bread LLC','abc@gmail.com', 4);
INSERT INTO customer(customerid, lastname, firstname, company, email, supportrepid)
VALUES(61, 'Johnson', 'Jeffrey', 'Blue INC','cda@gmail.com', 4);
--2.4 task A update Aaron Mitchel in Customer table to Robert Walter
-- changes properties of row 32
UPDATE customer 
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--2.4 task B Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'Creedence Clearwater Revival'
WHERE name = 'CCR';
--2.5 Select all invoices with a billing address like “T%”
SELECT billingaddress FROM invoice
WHERE billingaddress LIKE 'T%';
--2.6 task A Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;
--2.6 task B Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate 
BETWEEN '01-JUN-2003' AND '01-MAR-04';
--2.7 – Delete a record in Customer table where the name 
--is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM invoiceline
WHERE invoiceid IN (SELECT invoiceid FROM invoice 
WHERE customerid IN (SELECT customerid FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter'));
DELETE FROM invoice
WHERE customerid IN (SELECT customerid FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter');
DELETE FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter';
--3.1 task A Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_date
RETURN TIMESTAMP
    IS currDate TIMESTAMP;
BEGIN
    SELECT systimestamp
    INTO currDate
    FROM dual;
    RETURN (currDate);
END;
/
--3.1 task B create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_media_length (iter INT)
RETURN INT
    IS media_length INT;
BEGIN
    SELECT LENGTH(mediatype.name)
    INTO media_length
    FROM mediatype
    WHERE mediatypeid = iter;
    RETURN media_length;
END;
/
--3.2 task A Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_invoice_avg
RETURN NUMBER
    IS invoice_avg NUMBER(20,2);
BEGIN
    SELECT AVG(total) 
    INTO invoice_avg
    FROM invoice;
    RETURN invoice_avg;
END;
/
--3.2 task B Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_most_expensive_track
RETURN SYS_REFCURSOR
    AS curso SYS_REFCURSOR;
BEGIN
    OPEN curso
        FOR SELECT *
        FROM track
        WHERE unitprice = (SELECT MAX(unitprice) FROM track);
    RETURN curso;
END;
/

--3.3 Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_average_price 
RETURN NUMBER
    IS avgprice NUMBER;
BEGIN
    SELECT AVG(unitprice) 
    INTO avgprice
    FROM invoiceline
    WHERE unitprice = (SELECT MAX(unitprice) FROM track);
    RETURN avgprice;
END;
/

--3.4 Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION born_after_1968
RETURN SYS_REFCURSOR
    AS curso SYS_REFCURSOR;
BEGIN
    OPEN curso
        FOR SELECT * FROM employee
        WHERE birthdate > TO_DATE('19680101', 'YYYYMMDD');
    RETURN curso;
END;
/

--4.1 Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE first_last_name(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR
  SELECT firstname, lastname FROM employee;
END;
/
--4.2 task A Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee(employee_id IN INT, 
    last_name IN VARCHAR2, first_name IN VARCHAR2)
IS
BEGIN
  UPDATE employee SET lastname = last_name, firstname = first_name WHERE employeeid = employee_id;
END;
/
--4.2 task B Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE getmanager(employee_id IN INT, cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursorParam FOR
    SELECT *
    FROM employee
    WHERE employeeid = (SELECT reportsto
        FROM employee
        WHERE employeeid = employee_id);
END;
/
--4.3 Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE return_customer_details(customer_id IN INT, cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursorParam FOR
    SELECT firstname, lastname, company
    FROM customer
    WHERE customerid = customer_id;
END;
/
--5.0 task A Create a transaction that given a invoiceId will delete that invoice (There may be constraints that 
--rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice_by_id(invoice_id INT)
IS
BEGIN
    DELETE FROM invoiceline
    WHERE invoiceid  = invoice_id;
    DELETE FROM invoice
    WHERE invoiceid = invoice_id;
    COMMIT;
END;
/
--5.0 task B Create a transaction nested within a stored procedure that inserts a new record in the Customer
--table
CREATE OR REPLACE PROCEDURE create_new_customer(customer_id INT, first_name VARCHAR2, last_name VARCHAR2, company VARCHAR2,
    email VARCHAR2, supportrepid INT)
IS
BEGIN
    INSERT INTO customer(customerid, lastname, firstname, company, email, supportrepid)
    VALUES(customer_id, last_name, first_name, company, email, supportrepid);
    COMMIT;
END;
/
--6.1 Tast A Create an after insert trigger on the employee table fired after a new record is inserted into the
--table.
CREATE OR REPLACE TRIGGER after_employee_insert_trigger
AFTER INSERT ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('after employee insert trigger');
END;
/
--6.1 Task B Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER after_album_insert_trigger
AFTER INSERT ON album
BEGIN
    DBMS_OUTPUT.PUT_LINE('after album insert trigger');
END;
/
--6.1 Task C Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.
CREATE OR REPLACE TRIGGER after_customer_delete
AFTER DELETE ON customer
BEGIN
    DBMS_OUTPUT.PUT_LINE('after album insert trigger');
END;
/
--7.1 Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer INNER JOIN invoice
ON customer.customerid = invoice.customerid;
--7.2 Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.
SELECT customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;
--7.3 Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.artistid, artist.name, album.title
FROM artist RIGHT OUTER JOIN album
ON album.artistid = artist.artistid;
--7.4 Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT album.*, artist.*
FROM album
CROSS JOIN artist
ORDER BY artist.name ASC;
--7.5 Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.*
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;