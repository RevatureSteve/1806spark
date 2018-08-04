create USER bank_db IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO bank_db;

SELECT * FROM users;
INSERT INTO users (username, password, fname, lname) VALUES ('DragonMom1', 'rhaegaristhebest22@@', 'Daenerys', 'Targaryen');

SELECT * FROM bank_account;
INSERT INTO bank_account (balance, users_id) VALUES ('1258345.78', '7');

COMMIT;

SELECT * FROM bank_tx;
INSERT INTO bank_tx (tx_timestamp, tx_amt, tx_type_id, account_number)
VALUES (CURRENT_TIMESTAMP, 150.00, 1, 1005);

SELECT * FROM bank_tx_type;
INSERT INTO bank_tx_type VALUES (3,'Balance');


--set DBA permissions
---Then create a connection

DROP TABLE users;

--USER
CREATE TABLE users (
users_id INT,
username VARCHAR2(20)UNIQUE NOT NULL,
password VARCHAR2 (20)NOT NULL,
fname VARCHAR2(4000),
lname VARCHAR2 (4000),
PRIMARY KEY (users_id)
);

--uid sequence
CREATE SEQUENCE uid_seq
    START WITH 1
    INCREMENT BY 1;
    
--Users_ID Trigger
CREATE OR REPLACE TRIGGER USERS_ID_trigger
BEFORE INSERT ON USERS
FOR EACH ROW  
BEGIN
  IF :new.users_id IS NULL THEN
        SELECT uid_seq.nextval INTO :new.users_id FROM DUAL;
  END IF;
END;
/

--BANK ACCOUNT

CREATE TABLE Bank_Account (
account_number INT,
balance NUMBER(18,2),
users_id INT,
PRIMARY KEY (account_number),
FOREIGN KEY (users_id) REFERENCES users(users_id)
);

--bank account sequence

CREATE SEQUENCE account_num_seq
    START WITH 1005
    INCREMENT BY 5;

--bank account trigger

CREATE OR REPLACE TRIGGER account_num_trigger
BEFORE INSERT ON BANK_ACCOUNT
FOR EACH ROW  
BEGIN
  IF :new.account_number IS NULL THEN
        SELECT account_num_seq.nextval INTO :new.account_number FROM DUAL;
          END IF;
END;
/

--Bank Transaction
CREATE TABLE Bank_Tx (
tx_id INT,
tx_timestamp TIMESTAMP,
tx_amt NUMBER (18,2),
tx_type_id INT,
account_number INT,
PRIMARY KEY (tx_id),
FOREIGN KEY (account_number) REFERENCES bank_account(account_number),
FOREIGN KEY (tx_type_id) REFERENCES bank_tx_type(tx_type_id)
);

--bank transaction sequence
CREATE SEQUENCE trans_num_seq
    START WITH 33
    INCREMENT BY 3;
    
--bank transaction trigger
CREATE OR REPLACE TRIGGER bank_trans_trigger
BEFORE INSERT ON BANK_Tx
FOR EACH ROW  
BEGIN
  IF :new.tx_id IS NULL THEN
        SELECT trans_num_seq.nextval INTO :new.tx_id FROM DUAL;
          END IF;
END;
/

--bank tx type
CREATE TABLE Bank_tx_type(
tx_type_id INT,
tc_type VARCHAR2 (20),
PRIMARY KEY (tx_type_id)
);
