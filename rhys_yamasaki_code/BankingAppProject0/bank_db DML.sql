

-- CREATE

-- Insert statements to users table
INSERT INTO USERS VALUES (1, 'loti', 'bananas', 'lo', 'ti');
INSERT INTO USERS VALUES (2, 'Roti', 'bananas', 'Ro', 'ti');
INSERT INTO USERS VALUES (3, 'Dude', 'hello', 'man', 'hi');
INSERT INTO USERS VALUES (4, 'The Dude', 'hey man', 'The Dude', 'Lebowski');
commit;

select * from users;

-- Insert statements for BankAccount
INSERT INTO bank_account VALUES (12345678, 1000, 1);
INSERT INTO bank_account VALUES (2, 100, 2);
INSERT INTO bank_account VALUES (3, 2000, 3);
INSERT INTO bank_account VALUES (4, 0, 4);
commit;

select * from bank_account;


insert into bank_tx_type VALUES(1, 'deposit');
insert into bank_tx_type VALUES(2, 'withdraw');

select * from bank_tx_type;
-- READ

Select b.account_number, b.balance, u.username
FROM bank_account b
INNER JOIN users u ON u.users_id = b.users_id;

select * from bank_tx;


SELECT * FROM bank_tx;
-- UPDATE

CREATE OR REPLACE PROCEDURE deposit_into_account(amt INT, accNum INT)
AS
BEGIN
UPDATE bank_account SET balance = balance + amt
WHERE account_number = accNum;
INSERT INTO bank_tx(tx_timestamp, tx_amt, tx_type_id, account_number) VALUES ((SELECT systimestamp FROM dual), amt, 1, accNum);
COMMIT;
END;
/

-- Anonymous function
BEGIN
    deposit_into_account(1000.25, 3);
END;
/

CREATE OR REPLACE PROCEDURE withdraw_from_account(amt INT, accNum INT)
AS
BEGIN
UPDATE bank_account SET balance = balance - amt
WHERE account_number = accNum;
INSERT INTO bank_tx(tx_timestamp, tx_amt, tx_type_id, account_number) VALUES ((SELECT systimestamp FROM dual), amt, 2, accNum);
COMMIT;
END;
/

BEGIN
    withdraw_from_account(3000, 2);
END;


CREATE OR REPLACE PROCEDURE create_user_and_bank_account
( un IN VARCHAR2, pw IN VARCHAR2, fname IN VARCHAR2, lname IN VARCHAR2)
IS
BEGIN
INSERT INTO users(username, password, fname, lname) VALUES(un, pw, fname, lname);
INSERT INTO bank_account(balance, users_id) VALUES (0,(SELECT users_id FROM users WHERE un = users.username));
COMMIT;
END;
/

BEGIN
create_user_and_bank_account('pichu', '***', 'Ash', 'Ketchum');
END;
/

SELECT * FROM USERS u
INNER JOIN bank_account b ON u.users_id = b.users_id;




-- Get all transaction history for one 
CREATE OR REPLACE PROCEDURE get_transaction_history_proc(acc_num IN NUMBER, cursorParam OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN cursorParam FOR
    SELECT tx.tx_timestamp, tx.tx_amt, t.tx_type, tx.account_number
    FROM bank_tx tx
    INNER JOIN bank_tx_type t ON tx.tx_type_id = t.tx_type_id
    WHERE tx.account_number = acc_num;
END;
/

DECLARE
  tx_cursor SYS_REFCURSOR;
  someTime bank_tx.tx_timestamp%TYPE;
  someAmt bank_tx.tx_amt%TYPE;
  someType bank_tx_type.tx_type%TYPE;
  someAcc bank_account.account_number%TYPE;
BEGIN
  
  get_transaction_history_proc(12345678, tx_cursor);
  LOOP
    FETCH tx_cursor INTO someTime, someAmt, someType, someAcc;
    EXIT WHEN tx_cursor%NOTFOUND;
    
    DBMS_OUTPUT.PUT_LINE(someTime || ' ' || someAmt || ' ' || someType || ' ' || someAcc);
    
  END LOOP;
  CLOSE tx_cursor;
END;
/

SELECT tx.tx_timestamp, tx.tx_amt, t.tx_type, tx.account_number
    FROM bank_tx tx
    INNER JOIN bank_tx_type t ON tx.tx_type_id = t.tx_type_id
    WHERE tx.account_number = 12345678
    ORDER BY Convert(datetime,tx.tx_timestamp,100) DESC;


-- Sequence statements
CREATE SEQUENCE tx_id_seq 
  START WITH 1 
  INCREMENT BY 1;
/

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1;
/

CREATE SEQUENCE bank_account_seq
    START WITH 1
    INCREMENT BY 1;
/

--TRIGGER FOR ID INCREMENT
CREATE OR REPLACE TRIGGER tx_id_seq_trigger
BEFORE INSERT ON bank_tx
FOR EACH ROW 
BEGIN
  IF :new.tx_id IS NULL THEN
    SELECT tx_id_seq.nextval INTO :new.tx_id FROM DUAL;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER user_id_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    IF :new.users_id IS NULL THEN
      SELECT USERS_ID_SEQ.nextval INTO :new.users_id FROM DUAL;
    END IF;
END;
/


DROP TRIGGER bank_account_seq_trigger;
CREATE OR REPLACE TRIGGER bank_account_seq_trigger
BEFORE INSERT ON bank_account
FOR EACH ROW 
BEGIN   
    IF :new.account_number IS NULL THEN
      SELECT BANK_ACCOUNT_SEQ.nextval INTO :new.account_number FROM DUAL;
    END IF;
END;
/
    


