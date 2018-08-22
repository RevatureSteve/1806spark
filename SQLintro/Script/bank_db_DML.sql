INSERT INTO USERS 
VALUES(1, 'humphy', 'veggies', 'Humphrey', 'Minott');

INSERT INTO USERS
VALUES(2, 'derry', 'hockey', 'Derek', 'Hunter');

INSERT INTO USERS
VALUES(3, 'davy', 'jiggy', 'David', 'Myers');

INSERT INTO USERS
VALUES(4, 'zay', 'chilly', 'Isaiah', 'Hightower');
COMMIT;

INSERT INTO bank_account
VALUES(145, 50, 1);

INSERT INTO bank_account
VALUES(151, 75, 2);

INSERT INTO bank_account
VALUES(149, 25, 3);

INSERT INTO bank_account
VALUES(148, 10, 4);
COMMIT;

SELECT * FROM USERS;
SELECT * FROM bank_account;


CREATE SEQUENCE id_seq 
  START WITH 1 
  INCREMENT BY 1;
COMMIT;

CREATE OR REPLACE TRIGGER id_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.users_id IS NULL THEN
    --embedded SQL
    SELECT id_seq.nextval INTO :new.users_id FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/









CREATE OR REPLACE PROCEDURE deposit(some_user IN INT, some_amount IN INT)
IS
BEGIN
  
  UPDATE bank_account
  SET BALANCE = balance + some_amount
  WHERE users_id = some_user;
 
END;
/

DROP PROCEDURE withdraw;

CREATE OR REPLACE PROCEDURE withdraw(some_user IN INT, some_amount IN INT, rowsAffected OUT NUMBER)
IS
balance NUMBER(8,2);
CURSOR resultset is
SELECT balance
FROM bank_account
WHERE users_id = some_user;

BEGIN

    open resultset;
    fetch resultset into balance;
    close resultset;
    
IF

  balance >= some_amount THEN  
  UPDATE bank_account
  SET BALANCE = balance - some_amount
  WHERE users_id = some_user;
  rowsAffected :=1;
 END IF;
END;
/
COMMIT;

--Anonymous Function to test getProc with out parameter stored proc
DECLARE
  answer VARCHAR2(4000);
BEGIN
  
  get_answer_procedure('Can we write stored procedures?', answer);
  DBMS_OUTPUT.PUT_LINE('answer: ' || answer);
  
END;
/