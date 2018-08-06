

-- CREATE

-- Insert statements to users table
INSERT INTO USERS VALUES (1, 'loti', 'bananas', 'lo', 'ti');
INSERT INTO USERS VALUES (2, 'Roti', 'bananas', 'Ro', 'ti');
INSERT INTO USERS VALUES (3, 'Dude', 'hello', 'man', 'hi');
commit;

select * from users;

-- Insert statements for BankAccount
INSERT INTO bank_account VALUES (12345678, 1000, 1);
INSERT INTO bank_account VALUES (2, 100, 2);
INSERT INTO bank_account VALUES (3, 2000, 3);
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

BEGIN
    deposit_into_account(1000, 2);
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
    WHERE tx.account_number = 2;


-- Sequence statements
CREATE SEQUENCE tx_id_seq 
  START WITH 1 
  INCREMENT BY 1;
/


--TRIGGER FOR ID INCREMENT
CREATE OR REPLACE TRIGGER tx_id_seq_trigger
BEFORE INSERT ON bank_tx
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.tx_id IS NULL THEN
    --embedded SQL
    SELECT tx_id_seq.nextval INTO :new.tx_id FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/

