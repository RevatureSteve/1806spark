--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee
WHERE lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album
ORDER BY title DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT * FROM customer
ORDER BY firstname ASC;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO genre (genreid, name) VALUES(12321321323, 'Trap');
INSERT INTO genre (genreid, name) VALUES(1232133, 'Chill Step');
--Task – Insert two new records into Employee table
INSERT INTO employee (employeeid, firstname, lastname) VALUES(06069611,'Marshall', 'Larson');
INSERT INTO employee (employeeid, firstname, lastname) VALUES(102896,'Jovy', 'Capacite');
--Task – Insert two new records into Customer table
INSERT INTO customer (customerid, firstname, lastname, email) VALUES(060696,'Beck', 'Larson', 'goldlink89@live.com');
INSERT INTO customer (customerid, firstname, lastname, email) VALUES(102896,'Jovy', 'Capacite', 'aemail@live.com');
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name = 'CCR' 
WHERE name = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total > 15 AND total < 30;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate > '01-JUN-03' AND hiredate < '01-MAR-04';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
DELETE FROM CHINOOK.invoiceline
WHERE invoiceid IN (SELECT invoiceid FROM CHINOOK.invoice
WHERE customerid IN (SELECT customerid FROM CHINOOK.customer
WHERE firstname = 'Robert'
AND lastname = 'Walter'));

--3.0 Functions
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
create or replace FUNCTION gettime RETURN TIMESTAMP AS 
BEGIN
  RETURN CURRENT_TIMESTAMP;
END gettime;
/
SELECT gettime FROM DUAL;
SELECT SESSIONTIMEZONE, CURRENT_TIMESTAMP FROM DUAL;


--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name) FROM mediatype;
--Task – Create a function that returns the average total of all invoices
SELECT AVG(total) as "Average Total" FROM invoice;
--Task – Create a function that returns the most expensive track
SELECT MAX(unitprice) as "Highest Value" FROM track;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION getaverageprice
RETURN NUMBER
IS
    average_price NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO average_price FROM invoiceline;
    RETURN average_price;
END;
/
DECLARE
    average_price NUMBER;
BEGIN    
    average_price := getaverageprice();
    DBMS_OUTPUT.PUT_LINE('The average price is: ' || average_price);
END;
/
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE FUNCTION get_employee_after
RETURN SYS_REFCURSOR
IS
    employee_after SYS_REFCURSOR;
BEGIN
    OPEN employee_after FOR
    SELECT * FROM employee
    WHERE birthdate > TO_DATE('1968','YYYY');
    RETURN employee_after;
END;
/
--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_f_l_name (name OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN name FOR
    SELECT firstname, lastname FROM employee;
END;
/

DECLARE
    name SYS_REFCURSOR;
    foo employee.firstname%TYPE;
    line employee.lastname%TYPE;
BEGIN
    get_f_l_name(name);
    LOOP
        FETCH name INTO foo, line;
        EXIT WHEN name%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(foo || ' ' || line);
        
    END LOOP;
    CLOSE name;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateemployee(emp_id IN INT, fname IN VARCHAR2, lname IN VARCHAR2)
IS BEGIN
    UPDATE employee
    SET firstname = fname, lastname = lname
    WHERE employeeid = emp_id;
END;
/

BEGIN
    updateemployee(2334, 'Zeus', 'Godden');
END;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE getmanager(fname IN VARCHAR2, lname IN VARCHAR2, foo OUT VARCHAR2, ln OUT VARCHAR2)
IS 
    managerid INT;
BEGIN
    SELECT reportsto INTO managerid
    FROM employee 
    WHERE firstname = fname
    AND lastname = lname;
    
    SELECT firstname, lastname 
    INTO foo, ln
    FROM employee
    WHERE employeeid = managerid;
END;
/

DECLARE
    fn VARCHAR2 (4000);
    ln VARCHAR2 (4000);
BEGIN
    getmanager('Nancy','Edwards',fn,ln);
    DBMS_OUTPUT.PUT_LINE('Manager: ' || fn || ' ' || ln);
END;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE getcname(cid IN INT, fname OUT VARCHAR2, lname OUT VARCHAR2, company OUT VARCHAR2)
IS BEGIN
    SELECT firstname, lastname, company 
    INTO fname, lname, company
    FROM customer
    WHERE customerid = cid;
END; 
/

DECLARE 
    fname VARCHAR2 (4000);
    lname VARCHAR2 (4000);
    company VARCHAR2 (4000);
BEGIN
    getcname(1,fname,lname,company);
    dbms_output.put_line(fname || ' ' || lname || ' ' || company);
END;
/
COMMIT;
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored
--procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteinvoice(num_id INT)
    IS
    BEGIN
    DELETE FROM invoiceline WHERE invoiceline.invoiceid = num_id;
    DELETE FROM invoice WHERE invoiceid = num_id;
    END;
    /
BEGIN
        deleteinvoice(63);
    END;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE addcustomerrecord(numa INT, fname VARCHAR2, lname VARCHAR2, email VARCHAR2 )
    IS
    BEGIN
    INSERT INTO customer (customerid, firstname, lastname, email) VALUES (numa, fname, lname, email);
    END;
    /
    
    BEGIN
    addcustomerrecord(232,'Jake','Land', 'jake@live.com');
    End;
    /
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are
--executed on a table.  
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.   
     CREATE OR REPLACE TRIGGER new_emp_record_trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('Insert complete!');
END;
/   
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
    CREATE OR REPLACE TRIGGER update_album_trigger
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('Album updated!');
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
    CREATE OR REPLACE TRIGGER delete_record_customer_trigger
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('Record Deleted!');
END;
/
COMMIT;
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work
--with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT firstname, lastname, invoiceid
FROM customer c
INNER JOIN invoice inv
ON c.customerid = inv.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title
FROM artist art
RIGHT JOIN album alb
ON art.artistid = alb.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT name, title
FROM artist
CROSS JOIN album
ORDER BY name ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;

--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you
--will also restore the database. Research or try random things then communicate with batchmates, do
--not ask trainer.
--Task – Create a .bak file for the Chinook database.




-- LOST STUFF *I lost the place this went in*
SELECT SUM(total)
FROM invoice;

SELECT MAX(unitprice)
FROM track;

SELECT AVG(unitprice)
FROM invoiceline;

COMMIT;


SELECT *
FROM employee
INNER JOIN customer
ON employee.employeeid = customer.supportrepid
INNER JOIN invoice
ON customer.customerid = invoice.customerid
INNER JOIN invoiceline
ON invoice.invoiceid = invoiceline.invoiceid
INNER JOIN track
ON invoiceline.trackid = track.trackid
INNER JOIN playlisttrack
ON track.trackid = playlisttrack.trackid
INNER JOIN playlist
ON playlisttrack.playlistid = playlist.playlistid
INNER JOIN album
ON track.albumid = album.albumid
INNER JOIN artist
ON album.artistid = artist.artistid
INNER JOIN genre
ON track.genreid = genre.genreid
INNER JOIN mediatype
ON track.mediatypeid = mediatype.mediatypeid;

