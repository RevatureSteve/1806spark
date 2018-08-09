--Inserting test values into user 
INSERT INTO users VALUES (1, 'Alpha', '123', 'John', 'Smith');
INSERT INTO users VALUES (2, 'Omega', 'qwe', 'Jane', 'Doe');

--Inserting test values into bank account
INSERT INTO bank_account VALUES (123, 2018.08, 1);
INSERT INTO bank_account VALUES (456, 808.11, 2);

--Adding values to bank_tx_types table
INSERT INTO bank_tx_type VALUES (1, 'Deposit');
INSERT INTO bank_tx_type VALUES (2, 'Withdrawal');

SELECT * FROM users;
SELECT * FROM bank_account;

commit;


--Senquences
--users table
CREATE SEQUENCE users_id_seq 
  START WITH 1 
  INCREMENT BY 1;
  
--bank_account table
CREATE SEQUENCE account_number_seq 
  START WITH 1 
  INCREMENT BY 1;
  
--bank_tx table
CREATE SEQUENCE tx_id_seq 
  START WITH 1 
  INCREMENT BY 1;
  
--Triggers for Sequences
--users_id
CREATE OR REPLACE TRIGGER users_id_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
  IF :new.users_id IS NULL THEN
    SELECT users_id_seq.nextval INTO :new.users_id FROM dual;
  END IF;
END;
/

--account_number
CREATE OR REPLACE TRIGGER account_number_trigger
BEFORE INSERT ON bank_account
FOR EACH ROW 
BEGIN
  IF :new.account_number IS NULL THEN
    SELECT account_number_seq.nextval INTO :new.account_number FROM DUAL;
  END IF;
END;
/

--tx_id
CREATE OR REPLACE TRIGGER tx_id_trigger
BEFORE INSERT ON bank_tx
FOR EACH ROW 
BEGIN
  IF :new.tx_id IS NULL THEN
    SELECT tx_id_seq.nextval INTO :new.tx_id FROM DUAL;
  END IF;
END;
/
  
  
--Stored Procedures
CREATE OR REPLACE PROCEDURE create_bank_tx (amount IN NUMBER, type IN VARCHAR2, ac_num IN INT)
--receive parameters from java
IS
    type_int INT;
--setting tx_type_id
BEGIN
    IF type = 'Deposit' THEN
        type_int := 1;
    ELSE
        type_int := 2;
    END IF;    
    INSERT INTO bank_tx (tx_time, tx_amt, tx_type_id, account_number) 
    VALUES (CURRENT_TIMESTAMP, amount, type_int, ac_num);
END;
/
  
COMMIT;

BEGIN
    insert_bank_tx (1000, 'Deposit', 123);
END;
/

DELETE FROM bank_tx;

--tx history
CREATE OR REPLACE PROCEDURE tx_history (ac_num IN INT, tx OUT SYS_REFCURSOR)
--put in the account number to get transaction history for that particular account
IS 
BEGIN
    OPEN tx FOR
    --get the query result from below and give it to tx
    SELECT * FROM bank_tx b
    INNER JOIN bank_tx_type bt
    ON b.tx_type_id = bt.tx_type_id
    WHERE b.account_number = ac_num
    ORDER BY tx_time ASC;
END;
/