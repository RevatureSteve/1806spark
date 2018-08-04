--DDL: data defination language

--keyword for DDL
-- CREATE, ALTER,  DROP, TRUNCATE, RENAME


--DROP TABLE employee; --this will drop the employee table
CREATE TABLE employee(
name VARCHAR2(4000),
age NUMBER(38, 0),
salary NUMBER(18,2)

);

--CRUD FOR DATA MANIPULATION LANGUAGE

-- CCRUD FOR DML: DATA MANIPULATION
--SELECT FOR READING DATA
-- UPDATE FOR SELECTING DATA
-- DETELE FOR FOR DETELETING DATA
--full insert
INSERT INTO employee(name, age, salary)  -- when omitted the (name, age, salary) you are required to provide each one
VALUES ('Tom', 45, 50000.25);
--

--partial insert : require (field1, field2, field3) the field that are not provide will show up null
INSERT INTO employee 
VALUES ('Tom', 45, 50000.25);

--parcial insert eg
INSERT INTO employee 
VALUES ('', 35, 100000.25);

INSERT INTO employee(name, age, salary)
VALUES ('Tom', 45, 50000.25);

INSERT INTO employee(name, age, salary)
VALUES ('Bobbert', 55, 60000.25);

INSERT INTO employee(name, age, salary)
VALUES ('Batman', 80,850000.25);

INSERT INTO employee(name, age)
VALUES ('Batman', 80);



-- select for reading data
SELECT * FROM employee;  --*  mean all will be select

SELECT name FROM employee;
SELECT salary, 50 * salary,( salary * 1.7) - SALARY FROM employee;
SELECT name, salary FROM employee WHERE salary > 50000;
SELECT name, salary, age FROM employee WHERE salary IS NULL;
SELECT name, salary, age FROM employee WHERE salary = NULL; -- this will not give back no values so it is wrong

select * from employee where name = tom


 