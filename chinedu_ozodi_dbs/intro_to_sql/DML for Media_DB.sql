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
