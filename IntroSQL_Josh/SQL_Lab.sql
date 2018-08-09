Set serveroutput on
/

--2.1 SELECT
--a. Select all records from the Employee table.

SELECT * 
FROM employee;

--b. Select all records from the Employee table where last name is King.

SELECT *
FROM employee
WHERE lastname = 'King';

--c. Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

SELECT *
FROM employee
WHERE firstname = 'Andrew' AND
    reportsto IS NULL;
    
  
  
  
  --2.2 ORDER BY
  
--  a. Select all albums in Album table and sort result set in descending order by title.

SELECT *
FROM album
ORDER BY title desc;

--  b. Select first name from Customer and sort result set in ascending order by city  

SELECT firstname, city
FROM customer
ORDER BY city;




--2.3 INSERT INTO 

-- a. Insert two new records into Genre table

INSERT INTO genre (genreid, name)
VALUES(26, 'Revature Tango');

INSERT INTO genre (genreid, name)
VALUES(27, 'standing still doing nothing');

-- b. Insert two new records into Employee table

INSERT INTO employee Values(9, 'Smith', 'George', 'bossman', null, TO_DATE('19960725','YYYYMMDD'), TO_DATE('20150725','YYYYMMDD'),
                            '34 north st', 'Chicago', 'IL', 'United States', '60516', '630-745-7986', '985-898-8888', 'mine@notyours.com');
                            
INSERT INTO employee Values(10, 'SoSo', 'Mike', 'the bottom', 9, TO_DATE('19950725','YYYYMMDD'), TO_DATE('20150705','YYYYMMDD'),
                            '34 south st', 'Chicago', 'IL', 'United States', '60516', '630-745-74546', '985-898-7788', 'mine@notyours2.com');

-- c. Insert two new records into Customer table

    INSERT INTO customer VALUES(60, 'Jojo', 'Joe', 'North Pole Shipping', '1458 East st.', 'Miami', 'FL', 'United States', '58587', 
                        '585-878-7852', '898-898-8989', 'mineismine@mine.com', 6);
    
    INSERT INTO customer VALUES(61, 'Jojojo', 'Joeseph', 'South Pole Shipping', '1457 West st.', 'Miami', 'FL', 'United States', '58587', 
                        '585-785-7852', '898-815-8989', 'mineismine@yours.com', 6);
    
  
    
--2.4 UPDATE

-- a. Update Aaron Mitchell in Customer table to Robert Walter


UPDATE customer
SET firstname = 'Robert', lastname ='Walter'
WHERE firstname = 'Aaron' and
    lastname = 'Mitchell';

-- b. Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

    
--2.5 LIKE 
-- a. Select all invoices with a billing address like “T%”

SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';



--2.6 BETWEEN 

-- a. Select all invoices that have a total between 15 and 50

SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

-- b. Select all employees hired between 1st of June 2003 and 1st of March 2004

SELECT * 
FROM employee
WHERE hiredate BETWEEN TO_DATE('20030601','YYYYMMDD') AND TO_DATE('20040301','YYYYMMDD');


-- 2.7 DELETE 

-- a. Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
    
DELETE FROM invoiceline
WHERE invoiceid IN( SELECT invoiceid
                    FROM invoice
                    WHERE customerid IN (SELECT customerid 
                                            FROM customer 
                                            WHERE firstname = 'Robert' AND
                                                        lastname = 'Walter'));
                                                        

DELETE FROM invoice
Where customerid IN (SELECT customerid 
                     FROM customer 
                     WHERE firstname = 'Robert' AND
                     lastname = 'Walter');
                     
DELETE FROM customer 
WHERE firstname = 'Robert' AND
      lastname = 'Walter';

--3.1 System Defined Functions 

-- a. Create a function that returns the current time. 

CREATE or REPLACE FUNCTION get_the_time
RETURN varchar2 Is
 
 find_time varchar2(4000);
 
BEGIN 
    SELECT To_char( SYSDATE, 'MM-DD-YY HH12:MI:SS') --to char 
    INTO find_time
    FROM dual;
    RETURN (find_time);

END;
/

select get_the_time from dual;




-- b. create a function that returns the length of a mediatype from the mediatype table
       
SELECT name, LENGTH(name) 
FROM mediatype;         

--3.2 System Defined Aggregate Functions

-- a. Create a function that returns the average total of all invoices

SELECT AVG(total) as "average total" 
FROM invoice;

-- b. Create a function that returns the most expensive track

SELECT MAX(unitprice) as "most expensive track" 
FROM track;

--3.3 User Defined Scalar Functions 
--a. Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION avgPrice
RETURN NUMBER
    IS price NUMBER;
BEGIN
    SELECT AVG(unitprice)
    INTO price
    FROM invoiceline;
    RETURN price;
END;
/
SELECT avgPrice FROM dual;
--3.4 User Defined Table Valued Functions

--a. Create a function that returns all employees who are born after 1968.
  
SELECT * FROM employee
WHERE birthdate > TO_DATE ('1968','YYYY');

CREATE OR REPLACE FUNCTION employees_after_1968
RETURN SYS_REFCURSOR
IS
    employees_after_1968 SYS_REFCURSOR;
BEGIN
    OPEN employees_after_1968
    FOR
    SELECT * FROM employee
    WHERE birthdate > TO_DATE('1968','YYYY');
    RETURN employees_after_1968;
END;
 /   
 
 select employees_after_1968 from dual;
 
--4.1 Basic Stored Procedure
--a. Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE first_last_name (name OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN name 
    FOR
    SELECT firstname, lastname 
    FROM employee;
END;
/

DECLARE
    name SYS_REFCURSOR;
    somefn employee.firstname%TYPE;
    someln employee.lastname%TYPE;
BEGIN
    first_last_name(name);
    LOOP
        FETCH name INTO somefn, someln;
        EXIT WHEN name%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(somefn || ' ' || someln);
        
    END LOOP;
    CLOSE name;
END;
/

--4.2 Stored Procedure Input Parameters Task 
--a. Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE update_employee_info(emp_id IN INT, fname IN VARCHAR2, lname IN VARCHAR2)
IS BEGIN
    UPDATE employee
    SET firstname = fname, lastname = lname
    WHERE employeeid = emp_id;
END;
/

BEGIN
    update_employee_info(8, 'Freddy', 'Fredson');
END;
/

select * from employee;

--b. Create a stored procedure that returns the managers of an employee.

CREATE OR REPLACE PROCEDURE get_employee_manager(fname IN VARCHAR2, lname IN VARCHAR2, mfn OUT VARCHAR2, mln OUT VARCHAR2)
IS 
    managerid INT;
BEGIN
    SELECT reportsto INTO managerid
    FROM employee 
    WHERE firstname = fname
    AND lastname = lname;
    
    SELECT firstname, lastname 
    INTO mfn, mln
    FROM employee
    WHERE employeeid = managerid;
END;
/

DECLARE
    mfn VARCHAR2 (4000);
    mln VARCHAR2 (4000);
BEGIN
    get_employee_manager('Mike','SoSo',mfn,mln);
    DBMS_OUTPUT.PUT_LINE('Manager: ' || mfn || ' ' || mln);
END;
/

select * from employee;

--4.3 Stored Procedure Output Parameters 

--a. Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE get_name_company(cid IN NUMBER, emp OUT VARCHAR2)
AS
BEGIN
SELECT firstname 
INTO emp 
FROM customer 
WHERE customerid = cid;

SELECT company 
INTO emp 
FROM customer 
WHERE customerid = cid;
END;
/
Declare
    emp VARCHAR2(400);
BEGIN
    get_name_company(5, emp);
    DBMS_OUTPUT.PUT_LINE(emp);
END;

   
    
--5.0 Transactions In this section you will be working with transactions. Transactions are usually nested within a stored procedure.

 --a. Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

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
deleteInvoice(110);
END;
/

select * from invoice;
 --b. Create a transaction nested within a stored procedure that inserts a new record in the Customer table
 select * from customer;
 
 CREATE OR REPLACE PROCEDURE insert_cust(numId IN INT, fname IN VARCHAR2, lname IN VARCHAR2, email IN VARCHAR2)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname, email) VALUES (numId, fname, lname, email);
END;
/

BEGIN 
    insert_cust(62, 'jimmy', 'jimson', 'whyisntemailnullable@why');
END;
/
 
 
 --6  AFTER/FOR 
 
-- a. Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER afterInsert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('insert');
END;
/




--select * from employee;
--DELETE FROM employee where employeeid = 3;
-- b. Create an after update trigger on the album table that fires after a row is inserted in the table


CREATE OR REPLACE TRIGGER afterUpdate
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(' update!');
END;

-- c. Create an after delete trigger on the customer table that fires after a row is deleted from the table.


CREATE OR REPLACE TRIGGER afterDelete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('delete');
END;

-- 7.1 INNER 

-- a. Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.


SELECT firstname, lastname, invoiceid
FROM customer c
INNER JOIN invoice i
ON c.customerid = i.customerid;


    
-- 7.2 OUTER Task 

--a. Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
FROM customer c
FULL OUTER JOIN invoice i
ON c.customerid = i.customerid;

-- 7.3 RIGHT  

--a. Create a right join that joins album and artist specifying artist name and title.

SELECT name, title
FROM album b
RIGHT OUTER JOIN artist a 
ON b.artistid = a.artistid;


-- 7.4 CROSS Task 

--a.Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT a.name
FROM album b
CROSS JOIN artist a
ORDER BY a.name;



-- 7.5 SELF Task
--a.Perform a self-join on the employee table, joining on the reportsto column.

SELECT a.employeeid, b.employeeid  
FROM employee a, employee b
WHERE a.reportsto =  b.employeeid;
    

    
 -- 9.0 Administration In this section you will be creating backup files of your database. After you create the backup file you will also restore the database. Research or try random things then communicate with batchmates, do not ask trainer.
--Task – Create a .bak file for the Chinook database.
  
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    s



