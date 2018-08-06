INSERT INTO users VALUES(2, 'rhys', 'rhys', 'Rhys', 'Rhys');
INSERT INTO bank_account VALUES(2, 600, 2);
COMMIT;
  
INSERT INTO bank_tx_type VALUES(1, 'deposit');
INSERT INTO bank_tx_type VALUES(2, 'withdraw');

CREATE OR REPLACE PROCEDURE deposit_money (bank_account_id NUMBER, tx_amount NUMBER)
AS
BEGIN
    INSERT INTO bank_tx VALUES (tx_id_seq.nextval, (SELECT systimestamp FROM dual), tx_amount, 1, bank_account_id);
    UPDATE bank_account SET balance = balance + tx_amount WHERE account_number = bank_account_id;
    COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE withdraw_money (bank_account_id NUMBER, tx_amount NUMBER)
AS
BEGIN
    INSERT INTO bank_tx VALUES (tx_id_seq.nextval, (SELECT systimestamp FROM dual), tx_amount, 2, bank_account_id);
    UPDATE bank_account SET balance = balance - tx_amount WHERE account_number = bank_account_id;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE create_new_user (username VARCHAR2, password VARCHAR2, firstname VARCHAR2, lastname VARCHAR2)
AS
    seq INT;
BEGIN
    seq := USERS_ID_SEQ.nextval;
    INSERT INTO users VALUES (seq, username, password, firstname, lastname);
    INSERT INTO bank_account VALUES (seq, 0, seq);
    COMMIT;
END;
/
CREATE SEQUENCE tx_id_seq
  START WITH 1 
  INCREMENT BY 1;
CREATE SEQUENCE users_id_seq
  START WITH 1
  INCREMENT BY 1;
  
 SELECT * FROM users WHERE username = 'rhys' AND password = 'rhys';
 SELECT * FROM bank_tx;
 SELECT * FROM bank_tx_type;
SELECT bank_tx.tx_id, bank_tx.tx_timestamp, bank_tx.tx_amt, bank_tx_type.tx_type, bank_tx.account_number
FROM bank_tx FULL OUTER JOIN bank_tx_type 
ON bank_tx.tx_type_id = bank_tx_type.tx_type_id
WHERE account_number = 2;

CREATE OR REPLACE PROCEDURE get_transactions_by_account