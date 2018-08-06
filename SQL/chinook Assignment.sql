SELECT * FROM employee;

SELECT * FROM employee
WHERE lastname = 'King';

SELECT * FROM employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;

SELECT * FROM album
ORDER BY title DESC;

SELECT * FROM customer
ORDER BY firstname ASC;

INSERT INTO genre (genreid, name) VALUES(12321321323, 'Trap');
INSERT INTO genre (genreid, name) VALUES(1232133, 'Chill Step');

INSERT INTO employee (employeeid, firstname, lastname) VALUES(06069611,'Marshall', 'Larson');
INSERT INTO employee (employeeid, firstname, lastname) VALUES(102896,'Jovy', 'Capacite');

INSERT INTO customer (customerid, firstname, lastname, email) VALUES(060696,'Beck', 'Larson', 'goldlink89@live.com');
INSERT INTO customer (customerid, firstname, lastname, email) VALUES(102896,'Jovy', 'Capacite', 'aemail@live.com');

UPDATE customer SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

UPDATE artist SET name = 'CCR' 
WHERE name = 'Creedence Clearwater Revival';

SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

SELECT * FROM invoice
WHERE total > 15 AND total < 30;

SELECT * FROM employee
WHERE hiredate > '01-JUN-03' AND hiredate < '01-MAR-04';

DELETE FROM CHINOOK.invoiceline
WHERE invoiceid IN (SELECT invoiceid FROM CHINOOK.invoice
WHERE customerid IN (SELECT customerid FROM CHINOOK.customer
WHERE firstname = 'Robert'
AND lastname = 'Walter'));

create or replace FUNCTION GET_TIME RETURN TIMESTAMP AS 
BEGIN
  RETURN CURRENT_TIMESTAMP;
END GET_TIME;
/
SELECT get_time FROM DUAL;

SELECT SESSIONTIMEZONE, CURRENT_TIMESTAMP FROM DUAL;

SELECT COUNT(*) FROM mediatype;

SELECT SUM(total)
FROM invoice;

SELECT MAX(unitprice)
FROM track;

SELECT AVG(unitprice)
FROM invoiceline;

COMMIT;

CREATE OR REPLACE FUNCTION get_employee_after_1968
RETURN SYS_REFCURSOR
IS
    employee_after_1968 SYS_REFCURSOR;
BEGIN
    OPEN employee_after_1968 FOR
    SELECT * FROM employee
    WHERE birthdate > TO_DATE('1968','YYYY');
    RETURN employee_after_1968;
END;
/



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
CREATE OR REPLACE PROCEDURE addcustomerrecord(numa INT, fname VARCHAR2, lname VARCHAR2, email VARCHAR2 )
    IS
    BEGIN
    INSERT INTO customer (customerid, firstname, lastname, email) VALUES (numa, fname, lname, email);
    END;
    /
    
    BEGIN
    addcustomerrecord(2342,'bill','land', 'bill@live.com');
    End;
    /
    CREATE SEQUENCE randy
START WITH 1
INCREMENT BY 1;

    CREATE OR REPLACE TRIGGER new_emp_record_trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('Insert complete!');
END;
/

    CREATE OR REPLACE TRIGGER update_album_trigger
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE('Album updated!');
END;
/
    CREATE OR REPLACE TRIGGER delete_record_customer_trigger
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('Record Deleted!');
END;
/
COMMIT;

SELECT * FROM customer
INNER JOIN 