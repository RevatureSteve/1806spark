--DDL: Data Definition Language
--Keywords for DDL
-- CREATE, ALTER, DROP, TRUNCATE, RENAME


DROP TABLE employee; -- DROP is to remove objects like employee

CREATE TABLE employee (
name VARCHAR2(4000),
age NUMBER(38,0),
salary NUMBER(18,2)
);


-- CRUD for DML: Data Manipulation Language
-- DML returns the number of rows affected

-- INSERT for creating data
-- This line is a full insert
INSERT INTO employee VALUES('Superman', 180,35000.00);
-- When omitting the (name, age, slaray) you are required to provide each one

-- partial insert: requires (field1,field2, etc) - Returns null values for fields to table
INSERT INTO employee(name,age) VALUES('John',25);
INSERT INTO employee(name,salary) VALUES('Amy', 100000.99); 


-- SELECT for reading data
SELECT * FROM employee;-- * means everything (meaning fields/columns/attributes)
--SELECT returns a ResultSet, virtual table to act upon
SELECT name FROM employee;
SELECT name, salary FROM employee;

--now we need to filter using a where clause
-- e.g. get a result of employees salary bigger than 50,000
SELECT name, salary
FROM employee
WHERE salary > 50000;
--e.g. get a ResultSet of employees age that is 180
SELECT name, age
FROM employee
WHERE age = 180;


--e.g. get a result of employee age is 25 and salary is null
SELECT name, age, salary
FROM employee
WHERE age = 25 
AND salary IS null; -- when checking for null just use is instead of =


-- e.g. resultset age > 40 or salary > 45k
SELECT name, age, salary
FROM employee
WHERE age > 40
OR salary > 50000;

-- UPDATE for updating data
-- DELETE for deleting data