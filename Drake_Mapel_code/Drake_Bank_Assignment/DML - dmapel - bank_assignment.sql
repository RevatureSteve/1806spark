
--USERS
CREATE TABLE Users (
users_id INT,
username VARCHAR2(20) UNIQUE NOT NULL,
password VARCHAR2(20) NOT NULL,
fname VARCHAR2(20),
lname VARCHAR2(20),
PRIMARY KEY (users_id)
);

--BANK ACCOUNT
CREATE TABLE Student_Account (
account_number INT,
balance NUMBER(18,2),
users_id INT,
PRIMARY KEY (account_number),
FOREIGN KEY (users_id) REFERENCES Users(users_id)
);

--BANK Transaction
CREATE TABLE Bank_Tx (
tx_id INT,
tx_timestamp TIMESTAMP,
tx_amt NUMBER(18,2),
tx_type_id INT,
account_number INT,
PRIMARY KEY (tx_id),
FOREIGN KEY (account_number) REFERENCES Bank_Account(account_number),
FOREIGN KEY (tx_type_id) REFERENCES Bank_tx_type(tx_type_id)
);

--BANK Transaction_type
CREATE TABLE Bank_tx_type (
tx_type_id INT,
tx_type VARCHAR2(20),
PRIMARY KEY (tx_type_id)
);

CREATE SEQUENCE u_seq 
  START WITH 1 
  INCREMENT BY 1;
  
DROP SEQUENCE u_seq;
  
CREATE OR REPLACE TRIGGER u_seq_trigger
BEFORE INSERT ON Users
FOR EACH ROW
BEGIN

  IF :new.users_id IS NULL THEN

    SELECT u_seq.nextval INTO :new.users_id FROM DUAL;

  END IF;
END;
/

CREATE SEQUENCE a_seq 
  START WITH 1 
  INCREMENT BY 1;
  
DROP SEQUENCE a_seq;
  
CREATE OR REPLACE TRIGGER a_seq_trigger
BEFORE INSERT ON Student_Account
FOR EACH ROW
BEGIN

  IF :new.account_number IS NULL THEN

    SELECT a_seq.nextval INTO :new.account_number FROM DUAL;

  END IF;
END;
/

-----------------------------INSERT Stored Procedure
CREATE OR REPLACE PROCEDURE insert_u_procedure(uname VARCHAR2, pw VARCHAR2, fn VARCHAR2, ln VARCHAR2)
IS
BEGIN
  
  INSERT INTO Users(username,password,fname,lname) VALUES(uname,pw,fn,ln);

  COMMIT;
  
END;
/

CREATE OR REPLACE PROCEDURE insert_ac_procedure(balance NUMBER, users_id NUMBER)
IS
BEGIN
  
  INSERT INTO Student_Account(balance,users_id) VALUES(balance,users_id);

  COMMIT;
  
END;
/



DELETE FROM Users;
SELECT * FROM Users;

DELETE FROM Student_Account;
SELECT * FROM Student_Account;



