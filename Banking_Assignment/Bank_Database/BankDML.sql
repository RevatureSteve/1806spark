


--Create a sequence that will be used in trigger for Users table
CREATE SEQUENCE theUserId_sequence
  START WITH 138
  INCREMENT BY 41;
  
  

-- Use sequence in trigger that will be invoked before an insert on users table
CREATE OR REPLACE TRIGGER userId_sequence_trigger BEFORE INSERT ON users FOR EACH ROW
BEGIN
  IF :new.users_id IS NULL THEN
    SELECT theUserId_Sequence.nextval INTO :new.users_id FROM DUAL;
    
  END IF;
END;
/
SELECT * FROM users WHERE username = 'hminott4';
SELECT * FROM users;
SELECT * FROM bank_account;
DELETE FROM users WHERE users_id=179;
INSERT INTO  users (username,password,fname,lname) values('hminott5','junior1996','humphrey4','minott4');


--Create a sequence that will be used in trigger for Bank_Account table
CREATE SEQUENCE accountNumber_sequence
  START WITH 1369
  INCREMENT BY 231;


-- Use sequence in trigger that will be invoked before an insert on users table
CREATE OR REPLACE TRIGGER accountNumber_sequence_trigger BEFORE INSERT ON Bank_Account FOR EACH ROW
BEGIN
  IF :new.account_number IS NULL THEN
    SELECT accountNumber_Sequence.nextval INTO :new.account_number FROM DUAL;
  END IF;
END;
/
 
 
 
 
 
 CREATE OR REPLACE TRIGGER insert_into_bankAccount
AFTER INSERT
   ON users
 FOR EACH ROW 
BEGIN
     INSERT INTO bank_account (balance,users_id) values(0,:new.users_id);

END;
/
 


CREATE OR REPLACE PROCEDURE update_account(some_userID IN NUMBER, amount IN NUMBER, errormsg OUT VARCHAR2)
IS
BEGIN
  
  UPDATE bank_account 
  
  SET balance = balance + amount
  
  WHERE users_ID = some_userid;
  
  COMMIT;
  
  EXCEPTION
  WHEN OTHERS THEN
  errormsg := SQLERRM;
  
END;
/



DECLARE 
  errormsg VARCHAR2(4000);
BEGIN
  
  update_account(1901, 100, errormsg);
END;
/


-------------------------------
CREATE OR REPLACE PROCEDURE withdraw_account(some_userID IN NUMBER, amount IN NUMBER, errormsg OUT VARCHAR2)
IS
BEGIN
  
  UPDATE bank_account 
  
  SET balance = balance - amount
  
  WHERE users_ID = some_userid;
  
  COMMIT;
  
  EXCEPTION
  WHEN OTHERS THEN
  errormsg := SQLERRM;
  
END;
/

