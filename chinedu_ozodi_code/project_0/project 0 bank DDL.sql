--USER
CREATE TABLE users (
    users_id INT,
    fname VARCHAR2 (4000) NOT NULL,
    lname VARCHAR2 (4000),
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR2(20),
    PRIMARY KEY(users_id)
);

--USER ID SEQ
CREATE SEQUENCE user_id_seq
START WITH 1000
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER user_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.users_id IS NULL THEN
    --embedded SQL
    SELECT user_id_seq.nextval INTO :new.users_id FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/

--BANK ACCOUNT
CREATE TABLE bank_account (
    account_number INT,
    balance NUMBER(18,2),
    users_id INT,
    PRIMARY KEY(account_number),
    FOREIGN KEY(users_id) REFERENCES users(users_id)
);

--BANK ACCOUNT ID SEQ
CREATE SEQUENCE bank_id_seq
START WITH 10000
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER bank_seq_trigger
BEFORE INSERT ON bank_account
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.account_number IS NULL THEN
    --embedded SQL
    SELECT bank_id_seq.nextval INTO :new.account_number FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/

--BANK TRANSACTION
CREATE TABLE bank_tx (
    tx_id INT,
    tx_type_id INT,
    tx_timestamp TIMESTAMP,
    account_number INT,
    tx_amt NUMBER(18,2),
    PRIMARY KEY (tx_id),
    FOREIGN KEY (tx_type_id) REFERENCES bank_tx_type(tx_type_id),
    FOREIGN KEY (account_number) REFERENCES bank_account(account_number)
);

--BANK TRANSACTION ID SEQ
CREATE SEQUENCE bank_transaction_id_seq
START WITH 1000
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER bank_transaction_seq_trigger
BEFORE INSERT ON bank_tx
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.tx_id IS NULL THEN
    --embedded SQL
    SELECT bank_transaction_id_seq.nextval INTO :new.tx_id FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/

--BANK TRANSACTION TYPE
CREATE TABLE bank_tx_type(
    tx_type_id INT,
    tx_type VARCHAR2(20) NOT NULL,
    PRIMARY KEY(tx_type_id)
);
/
--PROCEDURES
CREATE OR REPLACE PROCEDURE  insert_account_procedure( starting_balance IN NUMBER, selected_user IN NUMBER, 
					fc_error_msg OUT VARCHAR2) --OUT parameter doesn't specify size
IS
BEGIN
  
  INSERT INTO bank_account(balance, users_id) VALUES (starting_balance,selected_user);

  COMMIT;--ALWAYS COMMIT!!
  
EXCEPTION
  WHEN OTHERS THEN
  fc_error_msg := SQLERRM;
END;
/
CREATE OR REPLACE PROCEDURE update_account_procedure( new_balance IN NUMBER, selected_an IN NUMBER)
IS
BEGIN
  
  UPDATE bank_account SET balance = new_balance WHERE account_number = selected_an;

  COMMIT;--ALWAYS COMMIT!!
END;
/