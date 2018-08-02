-- Data Manipulation Language

-- insert, select, update, delete

SELECT * FROM actor;

INSERT INTO actor
VALUES(1,'Big Daddy 3', TO_DATE('19960725','YYYYMMDD'), 50,'Adam','Sandler');

INSERT INTO actor
VALUES(2,'The Office', TO_DATE('19800705','YYYYMMDD'), 35,'Chris','Pratt');

INSERT INTO actor
VALUES(3,'Doctor Strange', TO_DATE('19960725','YYYYMMDD'), 45,'Ben','Cumberbatch');

SELECT * FROM actor;

-- update record
UPDATE actor
SET years_acting = 15
WHERE actor_id = 1;

-- delete record
DELETE FROM actor
WHERE name = 'Adam';

-- diff between truncate and delete:
-- delete doesnt require a where clause, so, it acts the same as truncate.
-- but, truncate is faster because it automatically committed and cannot be rolled back.
-- when deleting that will do an extra step for temporarily saving it to a file
-- incase of a rollback

--add data to role table, which primarily will be a lookup table
INSERT INTO role 
VALUES(1, 'lead');

INSERT INTO role 
VALUES(2, 'supporting male');

INSERT INTO role 
VALUES(3, 'supporting female');

INSERT INTO role 
VALUES(4, 'sidekick');

INSERT INTO role 
VALUES(5, 'villan');

SELECT *
FROM role;
--ORDER BY role_id asc | desc to order by ascending or descending

--Insert role for actors
INSERT INTO actor_role VALUES( 1,4);
INSERT INTO actor_role VALUES( 2,5);
INSERT INTO actor_role VALUES( 2,1);

--we now hae relationship for actors and roles but how can we view them
--Using SQL Joins: joining 2 or more tables for a ResultSet
--only join on primary key foreign key relationships
SELECT *
FROM actor
INNER JOIN actor_role ON actor.actor_id = actor_role.actor_id
INNER JOIN role ON actor_role.role_id = role.role_id;
