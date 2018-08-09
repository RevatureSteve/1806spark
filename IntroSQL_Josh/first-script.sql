--DDL 

-- keywords for DDL

-- CREATE, ALTER, DROP, TRUNCATE, RENAME

CREATE TABLE employees (
name VARCHAR(4000),
age NUMBER(38,0),
salary NUMBER(18,2)
);

INSERT INTO employees(name, age, salary) VALUES('Tom',45,50000.25);
INSERT INTO employees(name, age, salary) VALUES('Bobbert',55,44000.25);
INSERT INTO employees(name, age, salary) VALUES('Batman',80,1.25);
INSERT INTO employees VALUES('Dudeman',21,16000.25);
INSERT INTO employees(name, salary) VALUES('Awesomeman',1.25);


SELECT * FROM employees;   

SELECT name FROM employees;

SELECT name, AVG(salary) 
FROM employees;




