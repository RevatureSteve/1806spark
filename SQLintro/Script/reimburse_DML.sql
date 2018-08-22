INSERT INTO position
VALUES(1,'Manager');

INSERT INTO position
VALUES(2,'Assistant Manager');

INSERT INTO position
VALUES(3,'Employee');

INSERT INTO users
VALUES(1, 'kbrown@gmail.com', 'cooly', 'Kandra', 'Brown', 1);

INSERT INTO users
VALUES(2, 'tlawal@gmail.com', 'books', 'Tesleem', 'Lawal', 2);

INSERT INTO users
VALUES(3, 'jhightower@gmail.com', 'chilly', 'Josiah', 'Hightower', 3);

INSERT INTO users
VALUES(4, 'swissa@gmail.com', 'swissy', 'Aamari', 'Swiss', 3);

INSERT INTO rq_type
VALUES(1, 'Peace of mind/Relax');

INSERT INTO rq_type
VALUES(2, 'Slow down');

INSERT INTO rq_type
VALUES(3, 'Pleasure');

INSERT INTO rq_type
VALUES(4, 'Aspirations');

UPDATE INTO users 
SET fname = 'Capable', lname = 'being'
WHERE u_id = 1

UPDATE INTO users 
SET fname = 'Capable', lname = 'being'
WHERE u_id = 2