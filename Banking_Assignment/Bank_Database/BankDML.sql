


--Create a sequence that will be used in trigger for Users table
CREATE SEQUENCE theUserId_sequence
  START WITH 138
  INCREMENT BY 41;
  
  commit;

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
  
  
  EXCEPTION
  WHEN OTHERS THEN
  errormsg := SQLERRM;
  
END;
/
commit;


DECLARE 
  errormsg VARCHAR2(4000);
BEGIN
  
  update_account(1901, 100, errormsg);
END;
/


-------------------------------
CREATE OR REPLACE PROCEDURE withdraw_account(some_userID IN NUMBER, amount IN NUMBER, errormsg OUT VARCHAR2)
IS
 balance NUMBER(8,2);
 
 cursor resultset is
     SELECT balance
     FROM bank_account
     WHERE users_id = some_userid;
  
     
BEGIN

   open resultset;
   fetch resultset into balance;
   close resultset;
  
  IF  
  
  balance >= amount THEN
 
  UPDATE bank_account 
  
  SET balance = balance - amount
  
  
  WHERE users_ID = some_userid;
  
  

  
  END IF;
  
  EXCEPTION
  WHEN OTHERS THEN
  errormsg := SQLERRM;
END;
/

DECLARE 
  errormsg VARCHAR2(4000);
BEGIN
  
  withdraw_account(1901, 800, errormsg);
END;
/

SELECT * FROM bank_account;

CREATE OR REPLACE PROCEDURE withdraw_account2(some_userID IN NUMBER, amount IN NUMBER, rowsAffected OUT NUMBER)
IS
 balance NUMBER(8,2);
 
 cursor resultset is
     SELECT balance
     FROM bank_account
     WHERE users_id = some_userid;
  
     
BEGIN

   open resultset;
   fetch resultset into balance;
   close resultset;
  
  IF  
  
  balance >= amount THEN
 
  UPDATE bank_account 
  
  SET balance = balance - amount
  
  
  WHERE users_ID = some_userid;
  rowsAffected := 1;
  
  

  
  END IF;
  commit;
END;
/
commit;

INSERT INTO bank_tx_type VALUES(1,'Deposit');
INSERT INTO bank_tx_type VALUES(2,'withdrawal');

CREATE OR REPLACE TRIGGER txId_sequence_trigger BEFORE INSERT ON bank_tx FOR EACH ROW
BEGIN
  IF :new.tx_id IS NULL THEN
    SELECT theUserId_Sequence.nextval INTO :new.tx_id FROM DUAL;
    
  END IF;
END;
/



INSERT INTO bank_tx(tx_amt,tx_type_id,account_number) VALUES(5,1,1831);
SELECT * FROM bank_tx;
SELECT * FROM bank_tx_TYPE;



commit;

CREATE OR REPLACE TRIGGER timestamp_trigger BEFORE INSERT ON bank_tx FOR EACH ROW
BEGIN
  IF :new.tx_timestamp IS NULL THEN
  
    :new.tx_timestamp:=CURRENT_TIMESTAMP;
    
  END IF;
END;
/
