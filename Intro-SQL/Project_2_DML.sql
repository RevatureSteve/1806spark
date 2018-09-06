
--Users Table
insert into users values(1, 'dan', 'a', 'a', 'dan', 'stan', 'dan@gmail.com', null, 1);
insert into users values(2, 'stan', 'b', 'b', 'stan', 'san', 'stan@gmail.com', null, 1);
ALTER TABLE users DROP COLUMN pw_salt;
select * from users;
commit;

--Message Table
ALTER TABLE message MODIFY time DEFAULT current_timestamp;
INSERT INTO message (U_ID, MESSAGE, CONVERSATION_ID) VALUES (2, 'HELLO WORLD', 2);
--Conversation Table

--Friends_list Table
select * from friends_list;
drop table friends_list CASCADE CONSTRAINTS;
insert into friends_list values (1, 1);
ALTER TABLE friends_list DROP COLUMN f_id;

--Online_status Table


