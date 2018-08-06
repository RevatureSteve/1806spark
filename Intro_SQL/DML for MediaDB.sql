--DML: Data Manipulation Language
-- insert, select, update, delete

INSERT INTO actor 
VALUES(1, 'Big Daddy 3', TO_DATE('19960725', 'YYYYMMDD'), 50, 'Adam', 'Sandlar');

INSERT INTO actor 
VALUES(2, 'Avengers', TO_DATE('19800830', 'YYYYMMDD'), 10, 'Chris', 'Pratt');

INSERT INTO actor 
VALUES(3, 'Dr.Strange', TO_DATE('19500126', 'YYYYMMDD'), 20, 'Ben', 'Cumberbatch');

INSERT INTO actor 
VALUES(4, 'Dr.Strange', TO_DATE('19500126', 'YYYYMMDD'), 20, 'Ben', 'Cumberbatch');

SELECT * FROM actor;

--UPDATE a record
UPDATE actor
SET years_acting = 15
WHERE actor_id = 1;

--DELETE a record
DELETE FROM actor;
--WHERE first_name = 'Ben';
--**NOTE** what is the difference betwen TRUNCATE and DELETE
--DELETE doesn't require a where clause so it acts the same as a TRUNCATE
--BUT TRUNCATE is faster because it automatically commited and cannot be rolledback
--when deleting that will do an extra step for temporaily saving it to a file 
--incase of a rollback, TRUNCATE will not do this extra step

--add data to role table, which primarily will be a lookup table
INSERT INTO role VALUES(1, 'Lead');
INSERT INTO role VALUES(2, 'Supporting Male');
INSERT INTO role VALUES(3, 'Supporting Female');
INSERT INTO role VALUES(4, 'Sidekick');
INSERT INTO role VALUES(5, 'Villian');

SELECT * FROM role
ORDER BY role_id asc; --to sort by column use ORDER BY column_name asc/desc

--Insert roles for actors
INSERT INTO actor_role Values(1, 4);
INSERT INTO actor_role Values(2, 5);
INSERT INTO actor_role Values(2, 1);

--We now have relationship for actors and roles but how can we view them
--Using SQL Joins: joining 2 or more tables for a ResultSet
--Only join on promary key foreign key relationships!
SELECT * FROM actor
INNER JOIN actor_role ON actor.actor_id = actor_role.actor_id
INNER JOIN role ON actor_role.role_id = role.role_id;