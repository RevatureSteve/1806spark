-- 2.1.1 select all records from the Employee table
SELECT * FROM employee;

-- 2.1.2 select all records from the Employee table where the last name is King
SELECT * FROM employee
WHERE lastname = 'King';

-- 2.1.3 select all records from the Employee table where the first name is Andrew and reportsto is null
SELECT * FROM employee
WHERE firstname = 'Andrew'
AND reportsto is null;

--SELECT DISTINCT title, firstname FROM employee;
--SELECT COUNT(DISTINCT title) FROM employee;
--SELECT COUNT(DISTINCT firstname) FROM employee;

--SELECT * FROM employee
--ORDER BY title;

--2.2.1 select all albums in Album table and sort result-set in descending order by title
SELECT * FROM album
ORDER BY title DESC;

--2.2.2 select first name from Customer and sort result-set in ascending order by city
SELECT firstname FROM employee
ORDER BY city;
/* ORDER BY defaults to ascending order */

--2.3.1 insert two new records into Genre table
INSERT INTO genre
VALUES(26, 'House');
INSERT INTO genre
VALUES(27, 'Horror');

--2.3.2 insert two new records into Employee table
INSERT INTO employee(employeeid,lastname,firstname)
VALUES(9,'Potter','Harry');
INSERT INTO employee(employeeid,lastname,firstname)
VALUES(10,'Malfoy','Draco');

--2.3.3 insert two new records into Customer table
INSERT INTO customer(customerid,firstname,lastname,email)
VALUES(60,'Don','Juan','don@julio.com');
INSERT INTO customer(customerid,firstname,lastname,email)
VALUES(61,'Tory','Bloom','tory@bloom.net');

--2.4.1 update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron'
AND lastname = 'Mitchell';

--2.4.2 update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';
/* Note, capital has higher precedence than lower case when ordering VARCHAR2's; ex., CCR < Creedence */

--2.5 select all invoices with a billing address like "T%"
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6.1 select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

--2.6.2 select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-2003' AND '01-MAR-2004';

--2.7 delete a record in Customer table where the name is Robert Walter
/********** NOTE: must run script from 2.4.1 if starting from original table */
DELETE FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter';
/* what I tried first */

SELECT customerid FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter';
/* to select id of record in Customer table that has an Invoice table relation that I want to drop */

SELECT invoiceid FROM invoice
WHERE customerid = (
SELECT customerid FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter'
);
/* use customerid of record-to-be-dropped in Customer table
    to find related record-to-be-dropped from child Invoice */
    
SELECT * FROM invoiceline
WHERE invoiceid in (
    SELECT invoiceid FROM invoice
    WHERE customerid = (
    SELECT customerid FROM customer
    WHERE firstname = 'Robert'
    AND lastname = 'Walter'
    )
);
/* same idea as above but deleting corresponding child records in 
    InvoiceLine table related to previous narrowed relation between
    Invoice table and Customer table according to record-to-be dropped */

DELETE FROM invoiceline
WHERE invoiceid IN (
    SELECT invoiceid FROM invoice
    WHERE customerid = (
    SELECT customerid FROM customer
    WHERE firstname = 'Robert'
    AND lastname = 'Walter'
    )
);

DELETE FROM invoice
WHERE customerid = (
SELECT customerid FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter'
);

DELETE FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter';
/* putting it all together */

/*************** 3 ***************/

--3.1.1 create a function that returns the current time
CREATE OR REPLACE FUNCTION get_current_time
RETURN TIMESTAMP
IS current_time TIMESTAMP;
BEGIN

current_time := SYSDATE;
RETURN current_time;

END;
/
/* note, uses default date language */
/* use below to return current time as a result table
    SELECT TO_CHAR(get_current_time, 'HH24:MI:SS') "The time is" FROM DUAL; */
    
/* trying to get time in our localhost timezone */
/* SELECT * FROM V$TIMEZONE_NAMES; */

--3.1.2 create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mediatype_length(mtype_index INT)
RETURN NUMBER
IS mtype_length NUMBER;
BEGIN

SELECT LENGTH(name) INTO mtype_length FROM mediatype
WHERE mediatypeid = mtype_index;

RETURN mtype_length;

END;
/
/* can do an anonymous test or return a result-set; they use record where mediatypeid = 1
    DECLARE 
    mtype_length NUMBER;
    BEGIN
    
    mtype_length := mediatype_length(1);
    dbms_output.put_line(mtype_length);
    
    END;
    /
--OR
    SELECT mediatype_length(1) "This media type's name length" FROM DUAL;
*/

--3.2.1 create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_invoice_total
RETURN NUMBER
IS avg_total NUMBER(10,2);
BEGIN

SELECT AVG(total) INTO avg_total FROM invoice;

RETURN avg_total;

END;
/
/* display average total as a single-cell result-set */
SELECT avg_invoice_total "Average invoice total" FROM DUAL;

--3.2.2 create a function that returns the most expensive track

--there is no most expensive track, but there is a most expensive price for any track
CREATE OR REPLACE FUNCTION max_price_track
RETURN NUMBER
IS max_price NUMBER;
BEGIN

SELECT MAX(unitprice) INTO max_price FROM track;

RETURN max_price;

END;
/
/* display */
SELECT max_price_track FROM DUAL;

--3.3 create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_i_price
RETURN NUMBER
IS avg_price NUMBER(10,2);
BEGIN

SELECT AVG(unitprice) INTO avg_price FROM invoiceline;

RETURN avg_price;

END;
/
/* display */
SELECT avg_i_price FROM DUAL;

--3.4 create a function that returns all employees who are born after 1968
CREATE OR REPLACE TYPE emps
IS TABLE OF VARCHAR2(20);
/
/* creates type to return a multi-valued object from the function */
CREATE OR REPLACE FUNCTION emp_after_68
RETURN emps
AS emp_after emps := emps(); end_ind NUMBER;
BEGIN

SELECT COUNT(*) INTO end_ind FROM employee
WHERE 1968 < EXTRACT(YEAR FROM birthdate);
    emp_after.EXTEND(end_ind);
    FOR i in 1 .. end_ind
    LOOP
        SELECT name INTO emp_after(i) FROM employee WHERE 1968 < EXTRACT(YEAR FROM birthdate) ;
    END LOOP;

RETURN emp_after;

END;
/

/* display */
SELECT emp_after_68 FROM DUAL;

--4.1 create a stored procedure that selects the first and last names of all the employees

CREATE OR REPLACE PROCEDURE f_l_name_proc
IS
BEGIN

SELECT firstname, lastname FROM employee;

END;
/
/* display */
BEGIN
f_l_name_proc();
END;
/

--4.2.1 create a stored procedure that updates the personal information of an employee
CREATE OR REPLACE PROCEDURE update_pers_proc(pers_id NUMBER)
IS
BEGIN
UPDATE employee SET email = 'random@hotmail.com' WHERE employeeid = pers_id;
END;
/
/* example case, then display */
BEGIN
update_pers_proc(2);
END;
/
SELECT * FROM employee;

--4.2.2 create a stored procedure that returns the managers of an employee

--4.3 create a stored procedure that returns the name and company of a customer

--5.0.1 create a transaction that given an invoiceid will delete that invoice
CREATE OR REPLACE PROCEDURE inv_del_by_id_trans(inv_id NUMBER)
IS
BEGIN
DELETE FROM invoiceline
WHERE invoiceid = inv_id;

DELETE FROM invoice
WHERE invoiceid = inv_id;

COMMIT;
END;
/

/* example case, then display */
BEGIN
inv_del_by_id_trans(292);
END;
/
SELECT * FROM invoiceline;
SELECT * FROM invoice;

--5.0.2 create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE ins_cust_rec_trans(cust_id NUMBER)
IS
BEGIN
INSERT INTO customer(customerid, firstname, lastname, email) VALUES(cust_id, Cathleen, Joe, cjoe@e.com);
END;
/
/* display */
SELECT * FROM customer;

--6.1.1 create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER emp_trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN

END;
/

--6.1.2 create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_update_trigger
AFTER UPDATE ON album
FOR EACH ROW
BEGIN

END;
/

--7.1 create an inner join that joins customers and orders and specifies the name of the customer and the invoiceid


SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer
INNER JOIN invoice ON customer.customerid = invoice.customerid;

--7.2 create an outer join that joins the customer and invoice table,
      --specifying the customerid, firstname, lastname, invoiceid, and total

SELECT * FROM invoiceline;

SELECT * FROM invoice;

SELECT * FROM customer;











