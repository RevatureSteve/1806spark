--DML: Data Manipulation Language
-- insert, select, update, delete
INSERT INTO actor 
VALUES(1, 'Big Daddy 3', TO_DATE('19960725','YYYYMMDD'), 50, ' Adam', 'Sandler');
INSERT INTO actor 
VALUES(2, 'Avengers', TO_DATE('19800725','YYYYMMDD'), 25, ' Chris', 'Pratt');
INSERT INTO actor 
VALUES(3, 'Dr.Strange', TO_DATE('19500725','YYYYMMDD'), 12, ' Ben', 'Cumberbatch');

SELECT * FROM actor;

--UPDATE a record
UPDATE actor
SET years_acting = 15
WHERE actor_id = 1;

--DELETE a record
DELETE FROM actor
WHERE first_name = 'Ben';
--*NOTE* what is the dfference between truncate and delete
--Delete doesn't require a where clause so it acts the same as a truncate
--BUT truncate is faster because it automatically committed and cannot be rolledback
-- when deleting that will do an extra step for temporarily saving it to a file
-- incase of a rollback, truncate will not do this extra step

--add data to role table, which primarily will be a lookup table
INSERT INTO role VALUES(1, 'Lead');
INSERT INTO role VALUES(2, 'Supporting Male');
INSERT INTO role VALUES(3, 'Supporting Female');
INSERT INTO role VALUES(4, 'Sidekick');
INSERT INTO role VALUES(5, 'Villain');

SELECT * FROM role
ORDER BY role_id desc; --to sort by a column e.g. ORDER BY col_name desc/asc

--INSERT role for actors
INSERT INTO actor_role VALUES(1,4);
INSERT INTO actor_role VALUES(2,5);
INSERT INTO actor_role VALUES(2,1);

--We now have relationships for actors and roles but how can we view them
--Using SQL joins: joining 2 or more tables for a ResultSet
--Only join on primary key foreign key relationships!
SELECT *
FROM actor
INNER JOIN actor_role 
ON actor.actor_id = actor_role.actor_id
INNER JOIN role 
ON actor_role.role_id = role.role_id;
