INSERT INTO users (users_id, username, password, fname, lname) VALUES (1111, 'JimJam', 'GoGo', 'Jim', 'Jimson');
INSERT INTO users (users_id, username, password, fname, lname) VALUES (2222, 'Koolickles4', 'goodstuff', 'John', 'Johnson');
INSERT INTO users (users_id, username, password, fname, lname) VALUES (3333, 'Coding1', 'timeToCode', 'Becky', 'Beckyson');
INSERT INTO users (users_id, username, password, fname, lname) VALUES (4444, 'Flordidia', 'Florida', 'Kim', 'Kimson');
INSERT INTO users (users_id, username, password, fname, lname) VALUES (5555, 'Revature1', 'coder', 'Tim', 'Timson');

select * from users;

INSERT INTO bank_account (account_number, balance, users_id) VALUES (123456, 800.15, 1111);
INSERT INTO bank_account (account_number, balance, users_id) VALUES (456789, 78800.19, 2222);
INSERT INTO bank_account (account_number, balance, users_id) VALUES (147852, 1.15, 3333);
INSERT INTO bank_account (account_number, balance, users_id) VALUES (369852, 2485.56, 4444);
INSERT INTO bank_account (account_number, balance, users_id) VALUES (753951, 1800.98, 5555);

select * from bank_account;

INSERT INTO bank_tx_type (tx_type_id, tx_type) VALUES (1, 'withdrawl');
INSERT INTO bank_tx_type (tx_type_id, tx_type) VALUES (2, 'deposit');


CREATE OR REPLACE PROCEDURE deposit (amount NUMBER, acc_num NUMBER)
IS

BEGIN
    UPDATE bank_account
    SET balance = balance + amount
    WHERE account_number = acc_num;

END;

BEGIN
    deposit;
END;
/

CREATE OR REPLACE PROCEDURE withdrawal (amount NUMBER, acc_num NUMBER)
IS

BEGIN
    UPDATE bank_account
    SET balance = balance - amount
    WHERE account_number = acc_num;

END;

BEGIN
    deposit;
END;
/

CREATE OR REPLACE PROCEDURE new_user (username VARCHAR2, pass VARCHAR2, fname VARCHAR2, lname VARCHAR2)
IS

BEGIN
    
    INSERT INTO users(users_id, username, password, fname, lname) VALUES (8888, username, pass, fname, lname);

END;
/
BEGIN
    new_user;
END;
/

INSERT INTO 
select * 
from 
users u, bank_account b
where u.users_id = b.users_id;


select * from bank_account;


select * from users;




BEGIN
    deposit;
END;


select * 
from users u, bank_account b
where u.users_id = b.users_id;



select * from bank_account;


create or replace PROCEDURE withdrawal (amount NUMBER, acc_num NUMBER)
IS
BEGIN
    UPDATE bank_account
    SET balance = balance - amount
    WHERE account_number = acc_num;

END;
/

CREATE SEQUENCE users_id_seq 
  START WITH 7777 
  INCREMENT BY 1111;
/

CREATE SEQUENCE account_number_seq 
  START WITH 900000
  INCREMENT BY 100;
/

CREATE OR REPLACE TRIGGER users_id_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.users_id IS NULL THEN
    --embedded SQL
    SELECT users_id_seq.nextval INTO :new.users_id FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/


drop trigger account_number_seq_trigger;
/
CREATE OR REPLACE TRIGGER account_number_seq_trigger
BEFORE INSERT ON bank_account
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.account_number IS NULL THEN
    --embedded SQL
    SELECT account_number_seq.nextval INTO :new.account_number FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/
