-- DDL: Data Definition Language

-- kEY WORDS for DDL
--          1) CREATE
--          2) ALTER
--          3) DROP
--          4) TRUNCATE
--          5) RENAME

DROP TABLE employee;
CREATE table employee (

name VARCHAR2(4000),
age NUMBER(38,0),
salary NUMBER(18,2)
);


-- CRUD for DML: Data Manipulation Language

--Insert for creating data 
--These are full inserts, so I did not have to specify the fields in the employee table
-- INSERT INTO employee VALUES("Superman",180,35000.00)
INSERT INTO employee(name,age,salary) VALUES('Tom',45,50000.25);
INSERT INTO employee(name,age,salary) VALUES('Bobbert',55,45000.45);
INSERT INTO employee(name,age,salary) VALUES('Superman',180,35000.00);
INSERT INTO employee(name,age,salary) VALUES('Batman',50,50000.00);

--Partial insert: specify certain fields 
Insert INTO employee(name,age) VALUES('John', 35);
Insert INTO employee(name,salary) VALUES('Jessy', 38000.98);
--Select for reading data

SELECT * FROM employee; --* means everything, select all the fields
-- Select returns a ResultSet, virtual table to act upon

Select name From employee;

Select name, salary FROM employee;


-- now we need to filter using a WHERE clause;
        --Example, get a ResultSet of employees salary bigger than 50,000
        
Select name, salary 
FROM employee
WHERE salary > 50000;


SELECT name, age
FROM employee
WHERE age = 180;
--Update for updating data
--Delete for deleting data


--- Get a resultset of employees age is 25 and salary is null

SELECT name, age, salary
FROM employee
WHERE age = 25 AND salary is null;

SELECT name, age, salary
FROM employee
WHERE age>40 OR salary > 45000;
