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
  
--Triggers
--User_id
CREATE OR REPLACE TRIGGER users_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
  IF :new.users_id IS NULL THEN
    SELECT users_seq.nextval INTO :new.users_id FROM DUAL;
  END IF;
END;
/


--inserting values into my bank account table
SELECT * FROM bank_account;

INSERT INTO bank_account VALUES(24, 123, 3);

--For account_number in bank_account
CREATE SEQUENCE bank_account_seq 
  START WITH 1 
  INCREMENT BY 1;
  