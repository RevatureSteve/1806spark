--DML: Data manipulation Language
--Insert, Select, Update, Delete

INSERT INTO actor VALUES(1, 'Big Daddy 3', TO_DATE('19960725','YYMMDD'), 50, ' Adam', 'Sandler');
INSERT INTO actor VALUES(2, 'Avengers ', TO_DATE('19800821','YYMMDD'), 35, ' Chris', 'Pratt');
INSERT INTO actor VALUES(3, 'Dr.Strange', TO_DATE('19500126','YYMMDD'), 40, ' Ben', 'Cumberbatch');

SELECT * FROM actor;

--update record 
UPDATE actor
SET years_acting = 15 
WHERE actor_id = 1; ---if this is not here it will update everything

--Delete a record
DELETE FROM actor
WHERE last_name = 'Cumberbatch';

--difference between truncate and delete
--delete doesnt require a where clause so it act the same as truncate
--truncate is faster because it is automatically truncated and cannot be rolledback
--when deleting that will do an extra step for temporarily saving it to a file
--incase of a rollback, truncate will not do this extra step
SELECT * FROM actor;

--add data to role table which primarily will be a lookup table
INSERT INTO role VALUES(1, 'lead');
INSERT INTO role VALUES(2, 'Supporting Male');
INSERT INTO role VALUES(3, 'Supporting Female');
INSERT INTO role VALUES(4, 'Sidekick');
INSERT INTO role VALUES(5, 'Villian');

SELECT * FROM role
ORDER BY role_id desc;  --to sort by a column  asc/desc

--Insert roles for actors
INSERT INTO actor_role VALUES(1,4);
INSERT INTO actor_role VALUES(2,5);
INSERT INTO actor_role VALUES(2,1);

--We now have relationships for actors and roles we still need to view (not just relationship tables)
--Using SQL joins: joining 2 or more tables for a ResultSet
--Only join on primary key and foreign key relationships!
SELECT * FROM actor
INNER JOIN actor_role 
ON actor.actor_id = actor_role.actor_id
INNER JOIN role ON actor_role.role_id = role.role_id;