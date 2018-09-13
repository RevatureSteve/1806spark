--Users Table
INSERT INTO USERS (username, pw_hash, fname, lname, email) 
    VALUES('Terry', '1', 'Terry', 'so', 'terry@gmail.com');
ALTER TABLE users DROP COLUMN pw_salt;
ALTER TABLE users MODIFY online_status DEFAULT 2;
SELECT * FROM USERS;
COMMIT;

--Message Table
ALTER TABLE message MODIFY TIME DEFAULT current_timestamp;
INSERT INTO message (U_ID, MESSAGE, CONVERSATION_ID) VALUES (2, 'HELLO WORLD', 2);
SELECT * FROM message;

--Conversation Table
SELECT * FROM conversation;

--Friends_list Table
SELECT * FROM friends_list;
DROP TABLE friends_list CASCADE CONSTRAINTS;
INSERT INTO friends_list VALUES (1, 1);
ALTER TABLE friends_list DROP COLUMN f_id;
ALTER TABLE friends_list ADD f_id INT;
ALTER TABLE friends_list ADD CONSTRAINT f_id PRIMARY KEY (f_id);

INSERT INTO friends_list (u_id_1, u_id_2) VALUES (2, 42);
INSERT INTO friends_list VALUES (1, 2, 9);
INSERT INTO friends_list VALUES (2, 2, 10);
INSERT INTO friends_list VALUES (2, 2);

--DROP TABLE friends_list;
ROLLBACK;
--Online_status Table
insert into online_status values (1, 'online');
insert into online_status values (2, 'offline');

drop table online_status;
select * from online_status;

commit;

