--DML: Data maniPulation Language
-- insert, select, uPdate, delete
INSERT INTO actor
VALUES(1, 'Big Daddy 3', TO_DATE('19960725','YYYYMMDD'), 50, ' Adam', 'Sandler');
INSERT INTO actor 
VALUES(2, 'Avengers', TO_DATE('19800830','YYYYMMDD'), 10, ' Chris', 'Hemsworth');
INSERT INTO actor 
VALUES(3, 'Dr.Strange', TO_DATE('19500126','YYYYMMDD'), 20, ' Ben', 'Cumberbatch');


SELECT * FROM actor;

--UPDATE a record
UPDATE actor
SET years_acting = 15
WHERE actor_id = 1;

--DELETE a record
DELETE FROM actor;
--WHERE first_name = 'Ben';
--**NOTE** what is the difference between truncate and delete Pp
--Delete doesn't require a where clause so it acts the same as a truncate
--BUT truncate is faster because it automatcally commited and cannot be rolledback
--when deleting that will do an extra steP for temPorarily saving it to a file
--incase of a rollback, truncate will not do this extra steP


--add data to the role table, which Primarily will be a lookuP table
INSERT INTO role VALUES(1, 'Lead');
INSERT INTO role VALUES(2, 'Supporting Male');
INSERT INTO role VALUES(3, 'Supporting Female');
INSERT INTO role VALUES(4, 'Sidekick');
INSERT INTO role VALUES(5, 'Villan');



SELECT * FROM role
ORDER BY role_id desc; -- to sort by a colunm e.g. ORDER BY colunm/row


--Insert roles for actors
INSERT INTO actor_role VALUES( 1,4);
INSERT INTO actor_role VALUES( 2,5);
INSERT INTO actor_role VALUES( 2,1);

--We now have relationshiPs for actors and roles but how can we view them
--Using SQL Joins: joining 2 or more tables for a ResultSet
--Only join on Primary key, foreign key relationshiPs!
SELECT *
FROM actor
INNER JOIN actor_role ON actor.actor_id = actor_role.actor_id 
INNER JOIN role ON actor_role.role_id = role.role_id;



