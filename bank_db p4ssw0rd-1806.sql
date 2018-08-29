
TRUNCATE TABLE users;
--USER
CREATE TABLE users (
users_id INT,
username VARCHAR2 (20) UNIQUE NOT NULL,
password VARCHAR2 (20) NOT NULL,
fname VARCHAR2(4000),
lname VARCHAR2(4000),
PRIMARY KEY (users_id)
);

DELETE FROM USERS WHERE users_id = 2;
--BANK ACCOUT
CREATE TABLE Bank_Account(
account_number INT,
balance NUMBER (18,2),
users_id INT,
PRIMARY KEY (account_number),
FOREIGN KEY (users_id) REFERENCES users(users_id)
);

--BANK Transaction
CREATE TABLE Bank_Tx (
tx_id INT,
tx_timestamp TIMESTAMP,
tx_amt NUMBER(18,2),
tx_type_id INT,
account_number INT,
PRIMARY KEY (tx_id),
FOREIGN KEY (account_number) REFERENCES bank_account(account_number),
FOREIGN KEY (tx_type_id) REFERENCES bank_tx_type(tx_type_id)
);

--BANK Transaction_type
CREATE TABLE Bank_tx_type(
tx_type_id INT,
tx_type VARCHAR2 (20),
PRIMARY KEY (tx_type_id)
);

--CREATE SEQUENCE USERSEQ;
--CREATE SEQUENCE ACCOUNTSEQ;

--Adding values to bank_tx_types table
INSERT INTO bank_tx_type VALUES (1, 'Deposit');
INSERT INTO bank_tx_type VALUES (2, 'Withdrawal');


--Inserting test values into user 
INSERT INTO users(users_id, username,password, fname,lname) VALUES(1, 'yoyo1','Yoyo1@#','Yoyo','kan');
INSERT INTO USERS(users_id, username,password, fname,lname)VALUES(2, 'mary1','Walker1@#','Mary', 'Walker');
INSERT INTO USERS(users_id, username,password, fname,lname)VALUES(3, 'unicorn7','Lgreen1@#','Wade', 'Wilson');

--Inserting test values into bank account
INSERT INTO bank_account VALUES (765, 1000.00, 1);
INSERT INTO bank_account VALUES (243, 600.09, 2);
INSERT INTO bank_account VALUES (123, 2500.09, 3);

SELECT * FROM users;

commit;


--Sequences
--users table
CREATE SEQUENCE users_id_sequec
  START WITH 1 
  INCREMENT BY 1;
  
--bank_account table
CREATE SEQUENCE account_number_sequec 
  START WITH 1 
  INCREMENT BY 1;
  
--bank_tx table
CREATE SEQUENCE tx_id_sequec 
  START WITH 1 
  INCREMENT BY 1;
  
--Triggers for Sequences
--users_id
CREATE OR REPLACE TRIGGER users_id_trigga
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
  IF :new.users_id IS NULL THEN
    SELECT users_id_sequec.nextval INTO :new.users_id FROM dual;
  END IF;
END;
/

--account_number
CREATE OR REPLACE TRIGGER account_number_trigga
BEFORE INSERT ON bank_account
FOR EACH ROW 
BEGIN
  IF :new.account_number IS NULL THEN
    SELECT account_number_sequec.nextval INTO :new.account_number FROM DUAL;
  END IF;
END;
/

--tx_id
CREATE OR REPLACE TRIGGER tx_id_trigga
BEFORE INSERT ON bank_tx
FOR EACH ROW 
BEGIN
  IF :new.tx_id IS NULL THEN
    SELECT tx_id_sequec.nextval INTO :new.tx_id FROM DUAL;
  END IF;
END;
/
  
  
--Stored Procedures
CREATE OR REPLACE PROCEDURE insert_bank_tx (amount IN NUMBER, type IN VARCHAR2, account IN INT)
IS
    type_int INT;
BEGIN
    IF type = 'Deposit' THEN
        type_int := 1;
    ELSE
        type_int := 2;
    END IF;    
    INSERT INTO bank_tx (tx_amt, tx_type_id, account_number) 
    VALUES (amount, type_int, account);
    
    commit;
END;
/
  
BEGIN
    insert_bank_tx (2000, 'Deposit', 765);
    insert_bank_tx (1000, 'Deposit',243);
     insert_bank_tx (3000, 'Deposit',123);
END;
/

DELETE FROM bank_tx;

--get transactions and join tranasction
CREATE OR REPLACE PROCEDURE retrieve_transc (account_num IN INT, transactions OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN transactions FOR
    SELECT * FROM bank_tx b
    INNER JOIN bank_tx_type bt
    ON b.tx_type_id = bt.tx_type_id
    WHERE b.account_number = account_num;
END;
/




