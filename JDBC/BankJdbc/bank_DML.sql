--This is my Data Manipulation Language page

--inserting values into my transaction type table
INSERT INTO bank_tx_type VALUES (1, 'Withdrawal');
INSERT INTO bank_tx_type VALUES (2, 'Deposit');

--inserting values into my users table
SELECT * FROM users;

INSERT INTO users VALUES(3, 'username', 'password', 'daniel', 'sidhu');
INSERT INTO users VALUES(2, 'name', 'pass', 'sid','nevil');

commit;

SELECT * FROM bank_account;



--inserting values into my bank account table
SELECT * FROM bank_account;

INSERT INTO bank_account VALUES(24, 123, 3);

commit;

--inserting values into bank account
 INSERT INTO bank_tx
    (tx_timestamp, tx_amt, tx_type_id, account_number)
    VALUES((SELECT systimestamp FROM dual), deposit, 1, account_id);

--Senquences
--users_id in Users
CREATE SEQUENCE users_seq 
  START WITH 1 
  INCREMENT BY 1;
  
--tx_id in bank_tx
CREATE SEQUENCE bank_tx_seq 
  START WITH 1 
  INCREMENT BY 1;

--account_number in bank_account
CREATE SEQUENCE bank_account_seq 
  START WITH 1 
  INCREMENT BY 1;



--Triggers
--Users_id in bank_account
CREATE OR REPLACE TRIGGER users_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
  IF :new.users_id IS NULL THEN
    SELECT users_seq.nextval INTO :new.users_id FROM DUAL;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER bank_tx_seq_trigger
BEFORE INSERT ON bank_tx
FOR EACH ROW
BEGIN
    IF :new.tx_id IS NULL THEN
        SELECT bank_tx_seq.nextval INTO :new.tx_id FROM DUAL;
    END IF;
END;

  
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

--This is my deposit procedure

CREATE OR REPLACE PROCEDURE deposit(deposit IN INT, account_id IN INT)
IS 
BEGIN
    UPDATE bank_account
    SET balance = (balance + deposit)
    WHERE account_number = account_id;
    
    INSERT INTO bank_tx
    (tx_timestamp, tx_amt, tx_type_id, account_number)
    VALUES((SELECT systimestamp FROM dual), deposit, 1, account_id);
    COMMIT;
END;
/


insert into users (users_id,username,password,fname,lname) values(5,'dan','van','Daniel','Sidhu');
insert into bank_account (account_number,balance,users_id) values (5,0,5);
select * from bank_account;
select * from users;

commit;
BEGIN
    deposit(17, 24);
END;
/

--This is my withdrawl procedure
--{deposit (?,?)} for java
CREATE OR REPLACE PROCEDURE withdrawl(withdrawl IN INT, account_id IN INT)
IS 
BEGIN
    UPDATE bank_account
    SET balance = (balance - withdrawl)
    WHERE account_id = account_number;
    
    INSERT INTO bank_tx
    (tx_timestamp, tx_amt, tx_type_id, account_number)
    VALUES((SELECT systimestamp FROM dual), withdrawl, 2, account_id);
    COMMIT;
END;
/


select * from users;
select * from bank_tx_type;
select * from bank_account;
select * from bank_tx order by tx_timestamp desc;
COMMIT;








