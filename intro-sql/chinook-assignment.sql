--2.1
    SELECT * FROM EMPLOYEE;

    SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

    SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--2.2
    SELECT * FROM ALBUM ORDER BY TITLE DESC;

    SELECT * FROM CUSTOMER ORDER BY CITY ASC;
--2.3
    INSERT INTO GENRE (GENREID, NAME) VALUES ('26', 'Instrumental');
    INSERT INTO GENRE (GENREID, NAME) VALUES ('27', 'Video_game');
    SELECT * FROM GENRE;
    
    INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS) VALUES ('9', 'Kazami', 'Yuka', 'Florist Manager', '1', '21-JAN-66', '27-MAY-04', '2543 Flower PL');
    INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS) VALUES ('10', 'Louihao', 'Touvan', 'Florist', '9', '1-MAR-96', '22-MAY-18', '15674 Geneso Wat');
    SELECT * FROM EMPLOYEE;
    
    INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID) VALUES ('60', 'Moukou', 'Fujiwara', NULL, 'Bamboo Forrest of the Lost', 'Gensokyo', NULL, 'Japan', NULL, NULL, NULL, 'everflame@geneso.com', '4');
    INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID) VALUES ('61', 'Louihao', 'Deson', NULL, '195 Nina way', 'Eden Prairie', 'MN', 'USA', NULL, '1+ 573 453 4155', NULL, 'Deson.Louihao@gmail.com', '2');
    SELECT * FROM CUSTOMER;
--2.4
    UPDATE customer
    SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
    WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
    
    UPDATE ARTIST
    SET NAME = 'CCR'
    WHERE NAME = 'Creedence Clearwater Revival';
--2.5
    SELECT *
    FROM INVOICE
    WHERE BILLINGADDRESS LIKE 'T%';
--2.6
    SELECT *
    FROM INVOICE
    WHERE TOTAL BETWEEN 15 AND 50;
    
    SELECT *
    FROM EMPLOYEE
    WHERE HIREDATE BETWEEN TO_DATE('20030601','YYYYMMDD') AND TO_DATE('20040301','YYYYMMDD');
--2.7
    SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID = 32;
    DELETE FROM INVOICELINE
    WHERE INVOICELINE.INVOICEID = 50;
    WHERE INVOICELINE.INVOICEID = 61;
    WHERE INVOICELINE.INVOICEID = 116;
    WHERE INVOICELINE.INVOICEID = 245;
    WHERE INVOICELINE.INVOICEID = 268;
    WHERE INVOICELINE.INVOICEID = 290;
    WHERE INVOICELINE.INVOICEID = 342;
    DELETE FROM INVOICE where CUSTOMERID = 32;
    DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
--3.1
    CREATE FUNCTION getTime
        RETURN TIMESTAMP
            IS currTime TIMESTAMP;
        BEGIN
            SELECT CURRENT_TIMESTAMP
            INTO currTime
            FROM dual;
            RETURN(currTime);
        END;
    SELECT getTime FROM DUAL;
    
    SELECT NAME, LENGTH(NAME) AS LengthOfString FROM MEDIATYPE
--3.2
    CREATE FUNCTION voiceAvg
        RETURN NUMBER
            IS average NUMBER;
        BEGIN
            SELECT AVG(TOTAL)
            INTO average
            FROM INVOICE;
            RETURN average;
        END;
    SELECT voiceAvg FROM DUAL;
    
    CREATE FUNCTION maxTrack
        RETURN NUMBER
            IS maximum NUMBER;
        BEGIN
            SELECT MAX(UNITPRICE)
            INTO maximum
            FROM TRACK;
            RETURN maximum;
        END;
    SELECT maxTrack FROM DUAL;
--3.3
    CREATE FUNCTION invoiceAve
        RETURN NUMBER
            IS average NUMBER;
        BEGIN
            SELECT AVG(UNITPRICE)
            INTO average
            FROM INVOICELine;
            RETURN average;
        END;
    SELECT invoiceAve FROM DUAL;
--3.4
    CREATE or REPLACE FUNCTION employee1968
        RETURN 
        BEGIN
            SELECT * FROM EMPLOYEE
            WHERE BIRTHDATE > TO_DATE('19681231','YYYYMMDD');
        END;
    SELECT * FROM EMPLOYEE
    WHERE BIRTHDATE > TO_DATE('19681231','YYYYMMDD');
--4.1
    CREATE OR REPLACE PROCEDURE get_emp_names  
    IS
    full_name VARCHAR2(4000);
    first_name VARCHAR(4000);
    last_name VARCHAR(4000);
    BEGIN
    for emp in
        ( SELECT firstname, lastname FROM employee)
    loop
        first_name := emp.firstname;
        last_name := emp.lastname;
        full_name :=  CONCAT (first_name, last_name);
        DBMS_OUTPUT.PUT_LINE(full_name);
    end loop;
    end;
    
SET serveroutput ON;
BEGIN
get_emp_names();
END;

--4.2
    create or replace PROCEDURE CHANGENAME (id NUMBER, lname VARCHAR2, fname VARCHAR2)
    IS
    BEGIN
    UPDATE employee
        SET LASTNAME = lname, FIRSTNAME = fname
        WHERE employeeid = id;
    END;
    
    
    CREATE OR REPLACE PROCEDURE get_manager(eid NUMBER)
    IS
    reports NUMBER(4000);
    manager VARCHAR2;
    full_name VARCHAR2(4000);
    first_name VARCHAR(4000);
    last_name VARCHAR(4000);
    BEGIN
    for emp in
        ( SELECT reportsto FROM employee WHERE employeeid = eid)
    loop
        reports := emp.reportsto;
        for man in
            ( SELECT firstname, lastname FROM employee WHERE employeeid = reports)
        loop
          first_name := man.firstname;
          last_name := man.lastname;
          full_name :=  CONCAT (first_name, last_name);
          DBMS_OUTPUT.PUT_LINE(full_name);
        end loop;
    end loop;
    end;
--4.3
    create or replace PROCEDURE customerinfo(cid NUMBER)
    IS
    full_name VARCHAR2(4000);
    first_name VARCHAR(4000);
    last_name VARCHAR(4000);
    co VARCHAR2(4000);
    BEGIN
    for emp in
        ( SELECT firstname, lastname, company FROM customer WHERE customerid = cid)
    loop
        first_name := emp.firstname;
        last_name := emp.lastname;
        co := emp.company;
        full_name :=  CONCAT (first_name, last_name);
        full_name := CONCAT (full_name, co);
        DBMS_OUTPUT.PUT_LINE(full_name);
    end loop;
    end;
    
    SET serveroutput ON;
    BEGIN
    customerinfo(62);
    END;
--5.0
    CREATE OR REPLACE PROCEDURE deleteVoiceline (num_id NUMBER)
    IS
    BEGIN
    DELETE FROM INVOICELINE WHERE INVOICELINE.INVOICEID = num_id;
    DELETE FROM INVOICE WHERE INVOICE.INVOICEID = num_id;
    END;
    BEGIN
        DELETEVOICELINE(63);
    END;

    CREATE OR REPLACE PROCEDURE addCustomer (customerid NUMBER, firstname VARCHAR2, lastname VARCHAR2, 
    company VARCHAR2, address VARCHAR2, city VARCHAR2, stateat VARCHAR2, country VARCHAR2, 
    postalcode VARCHAR2, phone VARCHAR2, fax VARCHAR2, email VARCHAR2, supportrepid NUMBER)
    IS
    BEGIN
    INSERT INTO CUSTOMER VALUES(customerid, firstname, lastname, company, address, city, 
    stateat, country, postalcode, phone, fax, email, supportrepid);
    END;
    BEGIN
        ADDCUSTOMER(62, 'Luca', 'Oblaze', 'Geode', 'Forbidden Legend', 'Permafrost', NULL, 'Trove', NULL, '555', 'qarehbeqr', 'dsdf@g.sd', 3);
    END;
--6.1
    CREATE OR REPLACE TRIGGER INSERTEMPLOYEE 
    BEFORE INSERT ON EMPLOYEE 
    FOR EACH ROW 
    BEGIN
        UPDATE employee
        SET country = 'Canada'
        WHERE employeeid = 10;
    END;
    
    CREATE OR REPLACE TRIGGER UPDATEALBUM 
    AFTER UPDATE ON ALBUM 
    FOR EACH ROW 
    BEGIN
        NULL;
    END;
    
    CREATE OR REPLACE TRIGGER DELETECUSTOMER 
    AFTER DELETE ON CUSTOMER 
    FOR EACH ROW 
    BEGIN
        DELETE FROM ARTIST WHERE ARTISTID = 276;
    END;
--7.1
    SELECT c.firstname, c.lastname, 
    i.invoiceid
    FROM customer c
    INNER JOIN invoice i ON c.customerid = 
    i.customerid;
--7.2
    Select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
    FROM CUSTOMER c, INVOICE i 
--7.3
    SELECT ar.name, al.title
    FROM artist ar
    RIGHT JOIN album al ON ar.artistid =
    al.artistid;
--7.4
    SELECT *
    FROM ALBUM
    CROSS JOIN ARTIST;
--7.5
    SELECT  e.reportsto
    FROM EMPLOYEE e
--9.0
    