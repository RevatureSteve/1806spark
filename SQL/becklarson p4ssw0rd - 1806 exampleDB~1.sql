--DDL: Dtat Definition Language
--Keywords for DDL
--CREATE, ALTER, DROP, TRUNCATE, RENAME
DROP TABLE employee;

CREATE TABLE employee (
name VARCHAR2(4000),
age NUMBER(38,0),
salary NUMBER(18,2)
);


--CRUD for DML: Data manipulation Language
--insert for creating data
--full insert
INSERT INTO employee VALUES('Tom', 45,50000.25);
--when ommitting the (name,age,salary) you are required to provide each one
INSERT INTO employee(name,age,salary) VALUES('Bobbert', 55,20000.25);
--partial insert: required (column1, column2, etc)
INSERT INTO employee(name,age) VALUES('Batman', 85);
--select for reading data
SELECT * FROM employee; --* means everything(from columns) running this returns a ResultSet, virtual table to act upon
SELECT name FROM employee;
SELECT name, salary FROM employee;

--now we need to filter using a WHERE clause
--e.g. get a reult of employees salary bigger than 50,000
SELECT name, salary 
FROM employee WHERE salary > 50000;
--e.g. get a resultset of employees age
SELECT name, age
FROM employee WHERE age >28;

SELECT name,age, salary 
FROM employee WHERE age = 85 AND salary IS null;


SELECT name,age, salary FROM
employee WHERE age > 40 OR salary > 45000;
--update for updating data
--delete for deleting data