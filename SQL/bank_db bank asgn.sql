

SELECT * FROM bank_account;

INSERT INTO bank_account balance VALUES (2, 20, 2);

COMMIT;

UPDATE bank_account SET balance = 120
WHERE users_id = 2;

UPDATE bank_account SET balance = 100 WHERE users_id = 1;


       
        DELETE FROM users WHERE users_id = 60;
        DELETE FROM bank_account WHERE account_number > 2;
    
    BEGIN
    newlogin('idkrick', '****', 'Rick', 'Sanchez' );
    END;
    /
   COMMIT;  

    
    



--New User Triggers and Seq
CREATE SEQUENCE new_id
    START WITH 3
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER populate_users_id
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
IF :new.users_id IS NULL THEN
    SELECT new_id.nextval INTO :new.users_id FROM DUAL;
    END IF;
END;
/

CREATE OR REPLACE PROCEDURE new_transaction(user_id INT, deposit INT)
IS
BEGIN
INSERT INTO bank_tx (tx_id, tx_timestamp, tx_amt, account_number)
VALUES(A_NEW_TRANSACTION.nextval, CURRENT_TIMESTAMP, deposit, user_id);
END;
/


BEGIN
new_transaction(1, 200);
END;
/

CREATE OR REPLACE PROCEDURE newlogin(uname VARCHAR2,pword VARCHAR2, fname VARCHAR2, lname VARCHAR2)
    IS
    BEGIN
    INSERT INTO users ( username, password, fname, lname) VALUES (uname, pword, fname, lname);
    INSERT INTO bank_account(balance, users_id) VALUES (0,(SELECT users_id FROM users WHERE uname = users.username));
    INSERT INTO bank_tx(tx_id, account_number) VALUES (accountNum.nextval, (SELECT users_id FROM users WHERE uname = users.username));
    END;
    /
    
--seq
CREATE SEQUENCE a_new_transaction
    START WITH 100
    INCREMENT BY 1;

CREATE SEQUENCE accountNum
    START WITH 3
    INCREMENT BY 1;
--new users account num
CREATE OR REPLACE TRIGGER newacc
BEFORE INSERT ON bank_account
FOR EACH ROW
BEGIN
    IF : new.account_number IS NULL THEN
        SELECT accountNum.nextval INTO :new.account_number FROM DUAL;
    END IF;
   
END;
/

