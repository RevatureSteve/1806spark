--Adding values to bank_tx_types table
INSERT INTO bank_tx_type VALUES (1, 'Withdrawal');
INSERT INTO bank_tx_type VALUES (2, 'Deposit');


--Inserting test values into user 
INSERT INTO users VALUES (1, 'adoug', '111', 'Alicia', 'Douglas');
INSERT INTO users VALUES (2, 'skyedoug', '111', 'Skye', 'Douglas');
INSERT INTO users (username, password, fname, lname) VALUES ('ad2', '111', 'a', 'd');


--Inserting test values into bank account
INSERT INTO bank_account VALUES (1, 23000, 1);
INSERT INTO bank_account (balance, users_id) VALUES (200,2);


commit;


--Senquences
--For users_id in users
CREATE SEQUENCE users_seq 
  START WITH 1 
  INCREMENT BY 1;
  
--For account_number in bank_account
CREATE SEQUENCE bank_account_seq 
  START WITH 1 
  INCREMENT BY 1;
  
--for tx_id in bank_tx
CREATE SEQUENCE bank_tx_seq 
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

--account_number
CREATE OR REPLACE TRIGGER bank_account_seq_trigger
BEFORE INSERT ON bank_account
FOR EACH ROW 
BEGIN
  IF :new.account_number IS NULL THEN
    SELECT bank_account_seq.nextval INTO :new.account_number FROM DUAL;
  END IF;
END;
/

--tx_id
CREATE OR REPLACE TRIGGER bank_tx_seq_trigger
BEFORE INSERT ON bank_tx
FOR EACH ROW 
BEGIN
  IF :new.tx_id IS NULL THEN
    SELECT bank_tx_seq.nextval INTO :new.tx_id FROM DUAL;
  END IF;
END;
/
  
  
--Stored Procedures
CREATE OR REPLACE PROCEDURE insert_bank_tx (amount IN NUMBER, type IN VARCHAR2, account IN INT)
IS
    type_int INT;
BEGIN
    IF type = 'Withdrawal' THEN
        type_int := 1;
    ELSE
        type_int := 2;
    END IF;    
    INSERT INTO bank_tx (tx_timestamp, tx_amt, tx_type_id, account_number) 
    VALUES (CURRENT_TIMESTAMP, amount, type_int, account);
    
    commit;
END;
/
  
BEGIN
    insert_bank_tx (30320,'Withdrawal',2);
END;
/
  
  
--get transactions and join tranasction
CREATE OR REPLACE PROCEDURE get_transactions (account_num IN INT, transactions OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN transactions FOR
    SELECT * FROM bank_tx b
    INNER JOIN bank_tx_type bt
    ON b.tx_type_id = bt.tx_type_id
    WHERE b.account_number = account_num
    ORDER BY tx_timestamp DESC;
END;
/








 
  
  
  
  
  
  
  