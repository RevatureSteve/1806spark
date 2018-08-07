-- users_id++ on creation

CREATE SEQUENCE act_seq 
  START WITH 1 
  INCREMENT BY 1;
  
  CREATE OR REPLACE TRIGGER act_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.users_id IS NULL THEN
    --embedded SQL
    SELECT act_seq.nextval INTO :new.users_id FROM DUAL;
    

  END IF;
END;
/
-- account_number++ on creation
CREATE SEQUENCE bact_seq 
  START WITH 1 
  INCREMENT BY 1;
  
  CREATE OR REPLACE TRIGGER bact_seq_trigger
AFTER INSERT ON USERS
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
INSERT INTO bank_account (balance, users_id) VALUES (0, :new.users_id);
  IF :new.account_number IS NULL THEN
    --embedded SQL
    SELECT bact_seq.nextval INTO :new.account_number FROM DUAL;
    
  END IF;
END;
/
drop trigger bact_seq_trigger;
CREATE SEQUENCE tx_seq 
  START WITH 1 
  INCREMENT BY 1;
  
  CREATE OR REPLACE TRIGGER tx_seq_trigger
BEFORE INSERT ON bank_tx
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.tx_id IS NULL THEN
    --embedded SQL
    SELECT tx_seq.nextval INTO :new.tx_id FROM DUAL;
    

  END IF;
END;
/
                -- NEW USER COMMAND
INSERT INTO USERS(username, password, fname,lname)
        VALUES('Dimma','dimma','Doug','DimmaDome');
                -- NEW ACCOUNT COMMAND
INSERT INTO bank_account(balance,users_id) values(0,1);
        
        SELECT * FROM bank_account where users_id = 1;
        select * from users;
        SELECT * from bank_account;
        
        
        
CREATE OR REPLACE PROCEDURE createUser
    (newU in VARCHAR2, newP in VARCHAR2, newFN in VARCHAR2, newLN in VARCHAR2)
IS
BEGIN
  
  INSERT INTO USERS(username, password, fname,lname)
        VALUES(newU,newP,newFN,newLN);
        createAccount(0);
  
END;
/
--Find the View tab and select DBMS OUTPUT then in that new DBMS Output tab hit the green + and select the current db
BEGIN
  createUser('billy','billy','billy','billy');
END;
/
CREATE OR REPLACE PROCEDURE createAccount
    (bal IN NUMBER, users_id IN NUMBER)
IS
BEGIN
  
  INSERT INTO bank_account(balance,users_id)
        VALUES(bal,users_id);
  
END;
/

--Find the View tab and select DBMS OUTPUT then in that new DBMS Output tab hit the green + and select the current db
BEGIN
  createAccount();
END;
/


SELECT * FROM BANK_TX;
SELECT * FROM bank_account;
-- DEPOSIT INTO ACCOUNT
CREATE OR REPLACE PROCEDURE deposit(myD in NUMBER, myU in NUMBER)
IS
BEGIN
  UPDATE bank_account
  SET balance = (balance+myD)
  WHERE users_id = myU;
  
  INSERT INTO bank_tx
  (tx_timestamp, tx_amt,tx_type_id,account_number)
  VALUES((SELECT systimestamp from dual),myD,1,myU);
END;
/
--Find the View tab and select DBMS OUTPUT then in that new DBMS Output tab hit the green + and select the current db
BEGIN
  deposit(10,0);
END;
/
select * from bank_account;
--WITHDRAW FROM ACCOUNT
CREATE OR REPLACE PROCEDURE withdraw(myW in NUMBER, myU in NUMBER)
IS
BEGIN
  UPDATE bank_account
  SET balance = (balance-myW)
  WHERE users_id = myU;
  
  INSERT INTO bank_tx
  (tx_timestamp, tx_amt,tx_type_id,account_number)
  VALUES((SELECT systimestamp from dual),myW,2,myU);
END;
/

--Find the View tab and select DBMS OUTPUT then in that new DBMS Output tab hit the green + and select the current db
BEGIN
  withdraw(100,1);
END;
/
select * from bank_account;

CREATE OR REPLACE PROCEDURE transactions
(
myU in NUMBER,
t_txid out NUMBER,
t_actnum out NUMBER, 
t_txty out VARCHAR2,  
t_amt out NUMBER, 
t_time out VARCHAR2 
)
AS
BEGIN
  SELECT btx.tx_id,btx.account_number,btxty.tx_type, btx.tx_amt, btx.tx_timestamp
FROM bank_tx btx
inner join bank_tx_type btxty ON btx.tx_type_id = btxty.tx_type_id
WHERE account_number = 1 AND btx.tx_type_id = 2;
END;
/

select * from bank_tx_type;
update bank_tx_type set tx_type = 'D' where tx_type_id = 1;
--Find the View tab and select DBMS OUTPUT then in that new DBMS Output tab hit the green + and select the current db
BEGIN
  transactions(1);
  
END;
/

SELECT * FROM bank_tx;


SELECT password FROM users where username = 'Dimma' ;

SELECT * from users;
SELECT * FROM bank_account;
SELECT * FROM bank_account where users_id = 1;

INSERT INTO bank_account VALUES (1,0,1);
commit;

-- wiping a user
select * from users;
select * from bank_tx;
select * from bank_account;
delete from bank_account where users_id = 0;
delete from bank_tx where account_number = 0;
delete from users where users_id = 0;

SELECT balance FROM bank_account where users_id = 1;

