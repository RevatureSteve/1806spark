-- DDL Data Definition Language

-- Keywords for DDL:
-- CREATE, ALTER, DROP, TRUNCATE, RENAME
DROP TABLE employee;
DROP TABLE customer;

CREATE TABLE employee(
name VARCHAR2(4000),
age NUMBER(38,0),
salary NUMBER(18,2)
);

-- CRUD FOR DML DATA MANIPULATION LANGUAGE
-- INSERT FOR CREATING DATA
-- this is a full insert
Insert into employee(name,age,salary) VALUES('Bob',45,45000.25);
-- when omitting the exact characteristics, you must provide each value.
Insert into employee VALUES('Bill',45,35000.25);
-- partial inserts allow you to field whatever ones youd like.
Insert into employee(name,salary) VALUES('Tom',67000.25);

Insert into employee(name,salary) VALUES('Superman',67000.25);

Insert into employee(name,salary) VALUES('Tom',67000.25);

-- SELECT FOR READING DATA
SELECT * 
FROM employee; -- means everything (meaning fields, columns, attributes)
-- returns a ResultSet, virtual table to act upon
-- FILTER using a WHERE clause:
--ex; get a result of employees salary bigger than 50,000
SELECT name, salary 
FROM employee 
WHERE salary>50000;
-- eg get a result of employee age 25 and salary.
SELECT name, age 
FROM employee 
WHERE salary = null;

--update for updating data