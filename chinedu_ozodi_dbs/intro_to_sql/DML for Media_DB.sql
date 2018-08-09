--DML: Data manipulation language
--INSErT SELECT UPDATE DELETE
INSERT INTO actor VALUES (1,'Dig Daddy',TO_DATE('19960725', 'YYYYMMDD'),50, 'Adam', 'Sandler');
UPDATE actor
SET film = 'Big Daddy'
WHERE actor_id = 1;
INSERT INTO actor VALUES (2,'Avengers',TO_DATE('19760515', 'YYYYMMDD'),10, 'Chris', 'Pratt');
INSERT INTO actor VALUES (3,'Dr. Strange',TO_DATE('19800910', 'YYYYMMDD'),20, 'Ben', 'Cumberbatch');
SELECT *
FROM actor;

--INSERT values for ROLE (Will primarily be a lookup table)
INSERT INTO role VALUES (1,'Lead');
INSERT INTO role VALUES (2,'Supporting Male');
INSERT INTO role VALUES (3,'Supporting Female');
INSERT INTO role VALUES (4,'Sidekick');
INSERT INTO role VALUES (5,'Villain');

SELECT * FROM role;

--INSERT roles for actors
INSERT INTO actor_role VALUES (1,4);
INSERT INTO actor_role VALUES (1,2);
INSERT INTO actor_role VALUES (2,1);
INSERT INTO actor_role VALUES (3,1);

--We now have relationships for actors and roles byt how can we view them
--Useing SQL Joins: Joining 2+ tables for a ResultSet
--Only join on primary key foreign relationships!

SELECT actor.actor_id,film, birth_day,first_name,last_name,role_name
FROM actor
INNER JOIN actor_role ON actor.actor_id = actor_role.actor_id
INNER JOIN role ON actor_role.role_id = role.role_id;


