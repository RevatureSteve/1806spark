--DDL: Data Definition Language
--Keywords for DDL
-- CREATE, ALTER, DROP, TRUNCATE, RENAME

DROP TABLE employee;

CREATE TABLE employee(
name VARCHAR2(4000),
age NUMBER(38,0),
salary NUMBER(18,2)
);

--CRUD for DML: Data manipulation
-- insert for creating data
-- full insert
INSERT INTO employee VALUES('Superman',180,100000);
INSERT INTO employee VALUES('Joe',25,100000);
INSERT INTO employee VALUES('Mike',16,100000);

--partial insert
INSERT INTO employee(name,age) VALUES('Bobbert',22);
INSERT INTO employee(name,salary) VALUES('Jessie',25000);
INSERT INTO employee(name,age) VALUES('Robbie',25);
INSERT INTO employee(name,salary) VALUES('Batman',1);


-- select for reading data
SELECT * FROM employee;
SELECT name FROM employee;
SELECT name, salary FROM employee;

--now filter using WHERE clause
--get a result of employees salary bigger than 50000
SELECT name, salary 
FROM employee
WHERE salary > 50000;

SELECT name, age, salary
FROM employee
WHERE age = 25;

--update for updating data
--delete for deleting data