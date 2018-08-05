--DML: Data Manipulation Language
-- insert, select, update, delete

INSERT INTO actor 
VALUES(1, 'Big Daddy 3', TO_DATE('19960725', 'YYYYMMDD'), 50, 'Adam', 'Sandler');
INSERT INTO actor 
VALUES(2, 'Avengers', TO_DATE('19800830', 'YYYYMMDD'), 10, 'Chris', 'Pratt');
INSERT INTO actor 
VALUES(3, 'Dr. Strange', TO_DATE('19500126', 'YYYYMMDD'), 20, 'Benedict', 'Cumberbatch');
-- Grant permission everytime to your users by going to Admin
-- Other users -> [username] -> right click user -> edit user -> select DBA grant checkbox

SELECT * FROM actor;

--UPDATE  a record
UPDATE actor SET years_acting = 15
WHERE actor_id = 1;

--DELETE a record
DELETE FROM actor
WHERE first_name = 'Benedict';

--**NOTE** what is the difference between truncate and delete
--Delete doesn't require a where clause so it acts the same as a truncate
--BUT turncate is faster because it automaicaly commited and cannot be rolleback
-- when deleting that will do an extra step for temporarily svaing it to a file
-- incase of a rollback, truncate will not do this extra step


-- add data to the role table, which primarily will be a lookup table
INSERT INTO role VALUES(1, 'Lead');
INSERT INTO role VALUES(2, 'Supporting Male');
INSERT INTO role VALUES(3, 'Supporting Female');
INSERT INTO role VALUES(4, 'Sidekick');
INSERT INTO role VALUES(5, 'Villain');

SELECT * FROM role
ORDER BY roleid; -- to sort by a column


