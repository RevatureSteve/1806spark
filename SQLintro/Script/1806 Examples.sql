--DDL: Data Definition Language
--keywords for DDL
--CREATE, ALTER, DROP, TRUNCATE, RENAME

DROP TABLE employee;

CREATE TABLE employee(
name VARCHAR2(4000),
age NUMBER (38,0),
salary NUMBER (18,2)
);

--Crud for DML: Data Manipulation Language
--insert for creating data
INSERT INTO employee VALUES('Superman',180,35000.00);
--when omitting the (name, age, salary) you are required to provide each one

--partial insert
INSERT INTO employee(name,age) VALUES('Amy',42);
INSERT INTO employee(name,age) VALUES('John',35);

INSERT INTO employee(name,age,salary) VALUES('TOM',45,50000.25);
INSERT INTO employee(name,age,salary) VALUES('Bobbert',55,45000.45);
INSERT INTO employee(name,age,salary) VALUES('BATMAN',80,1.00);
--select for reading data
SELECT * FROM employee; --* means everything(fields/columns/rows/attributes)
--Select returns a ResultSet, virtual table to act upon
SELECT name FROM employee;
SELECT name, salary FROM employee;

--now we need to filter using a WHERE clause
--e.g. get a resultset of employees salary bigger than 50,000
SELECT name, salary 
FROM employee
WHERE salary > 50000;
--e.g. get a result of employees age that is 180
SELECT name, age
FROM employee
WHERE age = 180;

--e.g WHERE salary IS null; checking for null? use is not =
--e.g Where age > 40 OR salary > 45k
SELECT name, age, salary
FROM employee
WHERE age > 40
OR salary > 45000;

--update for updating data
--delete for deleting data



