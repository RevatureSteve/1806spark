--DML: data manipulation language
-- insert, select, update, delete

-- grant access= go to admin - db-- right click ---granted roles -- DBA --- check granted

INSERT INTO actor VALUES(1, 'Big Daddy 3', TO_DATE('19960725','YYYYMMDD'), 50, 'Adam', 'Sandler');

INSERT INTO actor VALUES(2, 'avengers', TO_DATE('19800830','YYYYMMDD'), 10, 'chris', 'pratt');

INSERT INTO actor VALUES(3, 'Dr.strange', TO_DATE('19500126','YYYYMMDD'), 20, 'ben', 'cumberbatch');

INSERT INTO actor VALUES(4, 'Dr.strange', TO_DATE('19500126','YYYYMMDD'), 20, 'ben', 'cumberbatch');

UPDATE actor
SET years_acting = 15
WHERE actor_id = 1;



--delete a record

DELETE FROM actor
WHERE first_name = 'ben';

--note: what is the difference between truncate and delete?
-- delete doesn't requre a where clause so it acts the same as a truncate
--but truncate is faster because it automatically committed and cannot be rolledback 
-- when deleting will do an extra step for temporarily saving it to a file
-- in case of a rollback, truncate will not do extra step 

TRUNCATE TABLE actor; 

SELECT *
FROM actor;


-- add data to the role table, which primarily will be a lookup table 
INSERT INTO role VALUES(1, 'Lead');
INSERT INTO role VALUES(2, 'Supporting Male');
INSERT INTO role VALUES(3, 'Supporting Female');
INSERT INTO role VALUES(4, 'Sidekick');
INSERT INTO role VALUES(5, 'Villian');

select *
from role;
order by role_id desc;

--Create a junction/join table to show the relationship between actors and roles
-- They typically follow naming convention table1_table2

CREATE TABLE actor_role(
    --primary key of both tables 
    actor_id INT, 
    role_id INT,
    --2 or more columns that will be identified as the primary key is called a composite key 
    PRIMARY KEY (actor_id, role_id), 
    --Now state that the 2 columns are foreign keys
    --foreign key is a primary key in another table
    FOREIGN KEY (actor_id) REFERENCES actor(actor_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
    );
    
INSERT INTO actor_role VALUES(1,4);

INSERT INTO actor_role VALUES(2,5);

INSERT INTO actor_role VALUES (2,1);


-- WE NOW HAVE RELATIONSHIP FOR ACTORS IN ROLES BUT HOW CAN WE VIEW THEM 
-- USING SQL JOINS: JOINING 2 OR MORE TABLES FOR A RESULTSET 


SELECT * 
FROM actor
INNER JOIN actor_role 
ON actor.actor_id = actor_role.actor_id
INNER JOIN role
ON actor_role.role_id = role.role_id;

    






































5
