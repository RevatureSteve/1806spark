--This is my Data Manipulation Language page

--inserting values into my users table
SELECT * FROM users;

INSERT INTO users VALUES(3, 'username', 'password', 'daniel', 'sidhu');

commit;


--Senquences
--For users_id in users
CREATE SEQUENCE users_seq 
  START WITH 1 
  INCREMENT BY 1;