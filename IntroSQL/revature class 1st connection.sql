--DDL: Data Definition Language
--Keywords for DDL
-- CREATE, ALTER, DROP, ALTER, TRUNCATE, RENAME


DROP TABLE employee; --DROP is to remove objects like employee


CREATE TABLE employee (
name VARCHAR2(4000),
age NUMBER(38,0),
salary NUMBER(18,2)
);



--CRUD for DML: Data manipulation langauge
--insert for creating data
--full insert
INSERT INTO employee VALUES('Superman',180,35000.00);
--when ommitting the (name,age,salary) you are required to provide each one

-- partial insert: requires (field1, field2, field3)
INSERT INTO employee(name,age) VALUES('John',25);
INSERT INTO employee(name,salary) VALUES('Amy',100000.99);



--select for reading data
SELECT * FROM employee; -- means everything (meaning frields/columns/attributes)
--SELECT returns a ResultSet, virtual table to act upon
SELECT name, salary
FROM employee
WHERE salary > 50000;
--e.g. get a result of employees age that is 180
SELECT name, age
FROM employee
WHERE age = 180;

--e.g. get a result of employee age is 25 and salary is null
SELECT name, age, salary
FROM employee
WHERE age = 25
AND salary is null; -- checking for null? use "is" not =


 

-- now we need to filter using a WHERE clause
--.e.g. get a result of employees salary bigger than 50,000
SELECT name, salary 
FROM employee
WHERE age > 40
OR salary > 45000;

--e.g. resultset age > 40 or salary >45k
--update for updating data
--delete for deleting data