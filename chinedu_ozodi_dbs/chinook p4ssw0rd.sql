---Part 2.1 SELECT
-- A
SELECT *
FROM employee;
-- B
SELECT *
FROM employee
WHERE lastname = 'King';
-- C
SELECT *
FROM employee
WHERE firstname = 'Andrew'
AND reportsto IS NULL;
---Part 2.2 ORDER
--A
SELECT *
FROM album
ORDER BY title DESC;
--B
SELECT firstname, city
FROM customer
ORDER BY city ASC;
---Part 2.3 INSERT
--A
--SELECT *
--FROM genre; 
--ORDER BY name ASC;
INSERT INTO genre
VALUES (26, 'Country');
INSERT INTO genre
VALUES(27, 'Bubstep');
--B
--SELECT *
--FROM employee;
INSERT INTO employee
VALUES (9,'Brickman','Bob','Builder',1,TO_DATE('19720519','YYYYMMDD'),TO_DATE('20040117','YYYYMMDD'), '3334 Construction Ln', 'Edmonton', 'AB', 'Canada', 'T5K 3N1', '+1 (780) 428-5500',NULL,'bob@chinookcorp.com');
INSERT INTO employee
VALUES (10,'Doe','Jane','Secretary',1,TO_DATE('19870929','YYYYMMDD'),TO_DATE('20050307','YYYYMMDD'), '1323 Rick St', 'Houston', 'TX', 'United States', '77054', '+1 (737) 441-5350','+ (403) 665-3442','jane@chinookcorp.com');
--C
--SELECT *
--FROM customer;
INSERT INTO customer
VALUES (60,'Rick','Johnson','Revature', '1234 Null Ave', 'Impliciton', NULL, 'USA',NULL,NULL,NULL,'rick.johnson@gnomail.com',4);
INSERT INTO customer
VALUES (61,'Private','Eye',NULL, NULL,NULL, NULL, NULL,NULL,NULL,NULL,'private@gnomail.com',3);
---Part 2.4 UPDATE
--A
UPDATE customer
Set firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;
--B
--SELECT *
--FROM artist
--WHERE name = 'Creedence Clearwater Revival';
UPDATE artist
SET name = 'CCR'
WHERE artistid = 76;
---Part 2.5 LIKE
SELECT * 
FROM invoice
WHERE billingaddress
LIKE 'T%';
---Part 2.6 BETWEEN
--A
SELECT *
FROM invoice
WHERE total > 15 
AND total < 50;
--B
SELECT *
FROM employee
WHERE hiredate > TO_DATE('20030601','YYYYMMDD')
AND hiredate < TO_DATE('20050301','YYYYMMDD');
---Part 2.7 DELETE
--SELECT customerid
--FROM customer
--WHERE firstname = 'Robert'
--AND lastname = 'Walter';
--SELECT *
--FROM invoice
--WHERE customerid = 32;
--SELECT *
--FROM invoiceline
--WHERE invoiceid = 50
--OR invoiceid = 61
--OR invoiceid = 116
--OR invoiceid = 342
--OR invoiceid = 245
--OR invoiceid = 268
--OR invoiceid = 290;
DELETE FROM invoiceline
WHERE invoiceid = 50
OR invoiceid = 61
OR invoiceid = 116
OR invoiceid = 342
OR invoiceid = 245
OR invoiceid = 268
OR invoiceid = 290;
DELETE FROM invoice
WHERE customerid = 32; 
DELETE FROM customer
WHERE firstname = 'Robert'
AND lastname = 'Walter';

------PART 3------
---Part 3.1
--A
--CREATE OR REPLACE FUNCTION get_current_time
--RETURN TIMESTAMP IS
--time TIMESTAMP;
--BEGIN
--    time := CURRENT_TIMESTAMP;
--    RETURN (time);
--END;
SELECT CURRENT_TIMESTAMP from album;
--B
--SELECT LENGTH(*) FROM mediatype;
--CREATE OR REPLACE FUNCTION get_mediatype_length( mediatype_name VARCHAR2)
--RETURN NUMBER IS
--length NUMBER;
--BEGIN
--    length := LENGTH(mediatype_name);
--    RETURN (length);
--END;
SELECT name, LENGTH(name) FROM mediatype;
---Part 3.2 System Defined Aggregate Functions
--A
--CREATE OR REPLACE FUNCTION invoice_average
--RETURN NUMBER IS
--average NUMBER;
--BEGIN
--    average := SELECT AVG(total) FROM invoice;
--    RETURN (average);
--END;
SELECT AVG(total) FROM invoice;
--B
SELECT * FROM track
WHERE unitprice = (SELECT MAX(unitprice) FROM track);
--SELECT MAX(unitprice) "Most Expensive Track" FROM track;
---Part 3.3 User Defined Functions
SELECT * FROM invoiceline;
CREATE OR REPLACE FUNCTION invoiceline_average_price
RETURN NUMBER IS
average NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO average FROM invoiceline;
    RETURN (average);
END;
/
SELECT Invoiceline_average_price() FROM DUAL;
---Part 3.4 User Defined Table Functions
SELECT * FROM employee;
CREATE OR REPLACE FUNCTION get_date( start_date IN STRING)
RETURN DATE IS
BEGIN
    RETURN TO_DATE(start_date,'YYYYMMDD');
END;
/
SELECT * FROM employee WHERE hiredate > get_date('19681231');
-------Part 4---------
---Part 4.1 Stored Procedure
SELECT * FROM employee;
CREATE OR REPLACE PROCEDURE get_names( cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursorParam FOR
    SELECT firstname,lastname FROM employee;
END;
/
DECLARE
    employee_cursor SYS_REFCURSOR;
    firstname employee.firstname%TYPE;
    lastname employee.lastname%TYPE;
BEGIN
    get_names(employee_cursor);
    LOOP
        FETCH employee_cursor INTO firstname, lastname;
        EXIT WHEN employee_cursor%NOTFOUND;
    
        DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname); 
    END LOOP;
    CLOSE employee_cursor;
END;
/
---Part 4.2 Stored Procedure Input Parameters
--A
SELECT * FROM employee;
CREATE OR REPLACE PROCEDURE edit_employee_name( selectedemployeeid IN INT, newfirstname IN VARCHAR2, newlastname IN VARCHAR2)
IS
BEGIN
    UPDATE employee SET firstname = newfirstname, lastname = newlastname WHERE employeeid = selectedemployeeid;
    COMMIT;
END;
/

BEGIN
    edit_employee_name(1,'Adams','Andrew');
END;
/
--B
CREATE OR REPLACE PROCEDURE get_manager_of( selectedemployeeid IN VARCHAR2, managerfirstname OUT VARCHAR2, managerlastname OUT VARCHAR2)
IS
BEGIN
    SELECT firstname, lastname INTO managerfirstname, managerlastname FROM employee
    WHERE employeeid = (SELECT reportsto FROM employee WHERE employeeid = selectedemployeeid);
END;
/
DECLARE
    managerfirstname VARCHAR2(400);
    managerlastname VARCHAR2(400);
BEGIN
    get_manager_of(5,managerfirstname,managerlastname);
    DBMS_OUTPUT.PUT_LINE(managerfirstname || ' ' || managerlastname); 
END;
/
---Part 4.3 Stored Procedure Output Parameters
SELECT * FROM customer;
CREATE OR REPLACE PROCEDURE get_customer_name_company( selectedcustomerid IN VARCHAR2, customerfirstname OUT VARCHAR2, customerlastname OUT VARCHAR2, customercompany OUT VARCHAR2)
IS
BEGIN
    SELECT firstname, lastname, company INTO customerfirstname, customerlastname, customercompany FROM customer
    WHERE customerid = selectedcustomerid;
END;
/
DECLARE
    firstname VARCHAR2(400);
    lastname VARCHAR2(400);
    company VARCHAR2(4000);
BEGIN
    get_customer_name_company(10,firstname,lastname, company);
    DBMS_OUTPUT.PUT_LINE(firstname || ' ' || lastname || ' ' || company); 
END;
/
-------Part 5---------
--A
SELECT * FROM invoice;
SELECT * FROM invoiceline;

DECLARE
   selectedinvoiceid VARCHAR(4000);
BEGIN
    selectedinvoiceid := 5;
    DELETE FROM invoiceline
    WHERE invoiceid = selectedinvoiceid;
    DELETE FROM invoice WHERE invoiceid = selectedinvoiceid;
END;
/
--B
SELECT * FROM customer WHERE customerid = 1000;
CREATE OR REPLACE PROCEDURE create_new_customer( newcustomerid IN INT, newfirstname IN VARCHAR2, newlastname IN VARCHAR2, newcompany IN VARCHAR2, address IN VARCHAR2, city IN VARCHAR2, thestate IN VARCHAR2, country IN VARCHAR2, postalcode IN VARCHAR2, phone In VARCHAR2, fax IN VARCHAR2, email IN VARCHAR2, supportrepid IN INT)
IS
BEGIN
    INSERT INTO customer VALUES (newcustomerid, newfirstname, newlastname, newcompany, address, city, thestate, country, postalcode, phone, fax, email, supportrepid);
    COMMIT;
END;
/

BEGIN
    create_new_customer(1001, 'Bobert', 'Mackman', 'None Inc', '444 Litte Rock St', 'New York', 'NY', 'USA', NULL, NULL, NULL, 'bobert.mackman@email.com',3);
END;
/
-------Part 6---------
----Part 6.1 After/For
---A
CREATE OR REPLACE TRIGGER employee_after_insert_trigger
AFTER INSERT ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Employee Inserted');
END;
/
---B
CREATE OR REPLACE TRIGGER album_after_update_trigger
AFTER UPDATE ON album
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album record updated');
END;
/
---C
CREATE OR REPLACE TRIGGER customer_after_delete_trigger
AFTER DELETE ON customer
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer record deleted');
END;
/
-------Part 7---------
----Part 7.1 INNER
SELECT * FROM customer;
SELECT * FROM invoice;
SELECT customer.firstname,customer.lastname, invoiceid FROM invoice
INNER JOIN customer ON customer.customerid = invoice.customerid;
----Part 7.2 OUTER
SELECT c.customerid, c.firstname,c.lastname, invoiceid, total FROM invoice
LEFT OUTER JOIN customer c ON c.customerid = invoice.customerid;
----Part 7.3 RIGHT
SELECT * FROM artist;
SELECT * FROM album;
SELECT name, title FROM album
RIGHT OUTER JOIN artist ON album.artistid = artist.artistid;
----Part 7.4 CROSS
SELECT artist.name, title FROM album, artist
--CROSS JOIN album ON album.artistid = artist.artistid;
ORDER BY (artist.name);
----Part 7.5 SELF
SELECT * FROM employee;
SELECT * FROM employee a, employee b
WHERE a.reportsto = b.employeeid;
---------Part 9----------
BACKUP DATABASE;