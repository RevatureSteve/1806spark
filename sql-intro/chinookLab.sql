--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee
WHERE firstname = 'Andrew'
AND reportsto IS null;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album
ORDER BY title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer
ORDER BY city ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Movie Songs');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Creepy');

--Task – Insert two new records into Employee table
INSERT INTO employee VALUES (9, 'Blessing', 'Julie', 'Sales Associate', 1, TO_DATE('19940318','YYYYMMDD'),
TO_DATE('20140729','YYYYMMDD'),'1110 St.', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 489-2802', 
'+1 (780) 489-2220','julie@chinookcorp.com');

INSERT INTO employee VALUES (10, 'Smith', 'Steve', 'Manager', 1, TO_DATE('19780321','YYYYMMDD'),
TO_DATE('19821102','YYYYMMDD'),'1423 ln.', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 800-3243', 
'+1 (780) 800-2432','steve_smith@chinookcorp.com');

--Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, State, Country, PostalCode, Phone, Email, SupportRepId) 
VALUES (60, 'Ashley', 'Mangilardo', '1478 ave.', 'Reading', 'PA', 'USA', '18722', '+1 (324) 671-4478', 'ashley@gmail.com', 3);

INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, State, Country, Email, SupportRepId) 
VALUES (61, 'Kyle', 'Smith', '23890 ct.', 'Rochester', 'NY', 'USA', 'ksmith@gmail.com', 2);

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
WHERE hiredate BETWEEN TO_DATE('20030601','YYYYMMDD') AND TO_DATE('20040301','YYYYMMDD');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
DELETE FROM invoiceline
WHERE invoiceid = 50
OR invoiceid = 61
OR invoiceid = 116
OR invoiceid = 245
OR invoiceid = 268
OR invoiceid = 290
OR invoiceid = 342;

DELETE FROM invoice
WHERE customerid = 32;

--customer id = 32
DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';


--3.0 SQL Functions
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
create or replace FUNCTION GET_CURRENT_TIME RETURN TIMESTAMP AS 
BEGIN
  RETURN CURRENT_TIMESTAMP;
END GET_CURRENT_TIME;
/

SELECT get_current_time FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name) FROM mediatype;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(total) as "Average Total of All Invoices" FROM invoice;

--Task – Create a function that returns the most expensive track
SELECT MAX(unitprice) as "Most Expensive Track" FROM track;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_average_price
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
    average_price := get_average_price();
    DBMS_OUTPUT.PUT_LINE('Average price is: ' || average_price);
END;
/

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE FUNCTION get_employee_after_1968
RETURN SYS_REFCURSOR
AS
    employee_after_1968 SYS_REFCURSOR;
BEGIN
    OPEN employee_after_1968 FOR
    SELECT * FROM employee
    WHERE birthdate > TO_DATE('1968','YYYY');
    RETURN employee_after_1968;
END;
/

--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_first_last_name (name OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN name FOR
    SELECT firstname, lastname FROM employee;
END;
/

DECLARE
    name SYS_REFCURSOR;
    somefn employee.firstname%TYPE;
    someln employee.lastname%TYPE;
BEGIN
    get_first_last_name(name);
    LOOP
        FETCH name INTO somefn, someln;
        EXIT WHEN name%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(somefn || ' ' || someln);
        
    END LOOP;
    CLOSE name;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee_info(emp_id IN INT, fname IN VARCHAR2, lname IN VARCHAR2)
IS BEGIN
    UPDATE employee
    SET firstname = fname, lastname = lname
    WHERE employeeid = emp_id;
END;
/

BEGIN
    update_employee_info(9, 'Jen', 'Blessing');
END;
/

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_employee_manager(fname IN VARCHAR2, lname IN VARCHAR2, managerfn OUT VARCHAR2, managerln OUT VARCHAR2)
IS 
    managerid INT;
BEGIN
    SELECT reportsto INTO managerid
    FROM employee 
    WHERE firstname = fname
    AND lastname = lname;
    
    SELECT firstname, lastname 
    INTO managerfn, managerln
    FROM employee
    WHERE employeeid = managerid;
END;
/

DECLARE
    mfn VARCHAR2 (4000);
    mln VARCHAR2 (4000);
BEGIN
    get_employee_manager('Nancy','Edwards',mfn,mln);
    DBMS_OUTPUT.PUT_LINE('Manager: ' || mfn || ' ' || mln);
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_customer_name_company(custid IN INT, fname OUT VARCHAR2, lname OUT VARCHAR2, company OUT VARCHAR2)
IS BEGIN
    SELECT firstname, lastname, company 
    INTO fname, lname, company
    FROM customer
    WHERE customerid = custid;
END; 
/

DECLARE 
    fname VARCHAR2 (4000);
    lname VARCHAR2 (4000);
    company VARCHAR2 (4000);
BEGIN
    get_customer_name_company(1,fname,lname,company);
    dbms_output.put_line(fname || ' ' || lname || ' ' || company);
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored
--procedure.

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
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

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
--table
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
WHERE customerid = 66;

BEGIN
    insert_customer_record(66,'Alicia','Douglas','Revature','1112 Dr.','Tampa','FL','USA','11232','+1 (322) 323-2131'
        ,'+1 (322) 243-3211', 'ad@gmail.com',3);
END;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are
--executed on a table.

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the
--table.

CREATE OR REPLACE TRIGGER after_employee_insert_trigger
AFTER INSERT ON employee
FOR EACH ROW 
BEGIN
    DBMS_OUTPUT.PUT_LINE('New employee inserted');
END;
/

DELETE FROM employee
WHERE employeeid = 10;

INSERT INTO employee VALUES (10, 'Smith', 'Steve', 'Manager', 1, TO_DATE('19780321','YYYYMMDD'),
TO_DATE('19821102','YYYYMMDD'),'1423 ln.', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 800-3243', 
'+1 (780) 800-2432','steve_smith@chinookcorp.com');

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER after_album_update_trigger
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album data updated');
END;
/

UPDATE album 
SET title = 'For Those About To Rock We Salute You'
WHERE albumid = 1;

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.
CREATE OR REPLACE TRIGGER after_customer_delete_trigger
AFTER DELETE ON customer 
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Cutomer row deleted');
END;
/

INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, State, Country, Email, SupportRepId) 
VALUES (62, 'Kyle', 'Smith', '23890 ct.', 'Rochester', 'NY', 'USA', 'ksmith@gmail.com', 2);

DELETE FROM customer
WHERE customerid = 62;


--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work
--with outer, inner, right, left, cross, and self joins.

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT firstname, lastname, invoiceid
FROM customer c
INNER JOIN invoice iv
ON c.customerid = iv.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.
SELECT c.customerid, c.firstname, c.lastname, iv.invoiceid, iv.total
FROM customer c
FULL OUTER JOIN invoice iv
ON c.customerid = iv.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title
FROM artist ar
RIGHT JOIN album al
ON ar.artistid = al.artistid;

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









