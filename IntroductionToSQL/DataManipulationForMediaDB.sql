-- DML: Data Manipulation Language
-- Insert, Select, Delete, Update 



INSERT INTO actor 
VALUES (1,'Big Daddy 3', TO_DATE('19960725','YYYYMMDD'), 50, 'Adam', 'Sandler');
INSERT INTO actor 
VALUES (2,'Avengers', TO_DATE('19800830','YYYYMMDD'), 10, 'Chris', 'Pratt');
INSERT INTO actor 
VALUES (3,'Dr. Strange', TO_DATE('19500126','YYYYMMDD'), 20, 'Ben', 'Cumberpatch');
INSERT INTO actor
VALUES (4,'Dr. Strange!', TO_DATE('19500126','YYYYMMDD'), 20, 'Ben', 'Cumberpatch');

SELECT * FROM actor;

UPDATE actor
Set years_acting = 15
WHERE actor_id = 1;

DELETE FROM actor
WHERE first_name = 'Ben';

--DELETE doesn't require WHERE clause so it acts the same as truncate
--BUT truncate is faster because it automatically commited and cannot be rolledback;

-- when deleting that will do an extra step for temporarily saving it to a file
-- incase of a rollback, truncate will not do this extra step


-- ADD DATA to the role table, which will be a lookup table
INSERT INTO role VALUES(1,'Lead Character');
INSERT INTO role VALUES(2,'Supporting male');
INSERT INTO role VALUES(3,'Supporting female');
INSERT INTO role VALUES(4,'Sidekick');
INSERT INTO role VALUES(5,'Villain');


SELECT * FROM role
ORDER BY role_id; --to sort by a column exp Default to ascending   (ASC or DESC)



-- Create a junction/join table to show the relationship between actors and roles
-- They typically follow the naming convention: table1_table2


INSERT INTO actor_role VALUES (1,4);

INSERT INTO actor_role VALUES (2,5);

INSERT INTO actor_role VALUES (2,1);



-- We now have relationship for actors and roles but how can we view them 
--Using SQL JOINS: joing 2 or more tables for a result set

-- You can only join on primary key, foreign key relationships
SELECT * FROM actor
INNER JOIN actor_role 
ON actor.actor_id = actor_role.actor_id
INNER JOIN role
ON role.role_id = actor_role.role_id;



























































































































































































































































































































































