INSERT INTO actor VALUES(1, 'Big Daddy 3', TO_DATE('19960725','YYYYMMDD'), 50, 'Adam', 'Sandler');
INSERT INTO actor VALUES(2, 'Avengers', TO_DATE('19800725','YYYYMMDD'), 10, 'Chris', 'Pratt');
INSERT INTO actor VALUES(3, 'Dr. Strange', TO_DATE('19600725','YYYYMMDD'), 20, 'Ben', 'Cumberbatch');

SELECT * FROM actor;

UPDATE actor 
SET years_acting = 15
WHERE actor_id = 1;

DELETE FROM actor
WHERE first_name = 'Ben';

INSERT INTO role VALUES(1, 'Lead');
INSERT INTO role VALUES(2, 'Supporting Male');
INSERT INTO role VALUES(3, 'Supporting Female');
INSERT INTO role VALUES(4, 'Sidekick');
INSERT INTO role VALUES(5, 'Villain');

SELECT * FROM role;

--Create a junction table to show the relationship between actors and roles
CREATE TABLE actor_role(
    --primary key for both tables
    actor_id INT,
    role_id INT,
    --2 or more column that will be identified as a primary key is called a composite key
    --Junction/Join table usually have acomposite key
    PRIMARY KEY(actor_id, role_id),
    --Now state that the 2 columns are Foreign Key
    FOREIGN KEY (actor_id) REFERENCES actor(actor_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

SELECT * FROM role
ORDER BY role_id desc;

INSERT INTO actor_role VALUES(1,4);
INSERT INTO actor_role VALUES(2,5);
INSERT INTO actor_role VALUES(2,1);

-- we now have a relationship of actors and roles but how can we view them using sql joins
--only join on primary key foreign key relationships
SELECT *
FROM actor
INNER JOIN actor_role ON actor.actor_id = actor_role.actor_id
INNER JOIN role ON actor_role.role_id = role.role_id;