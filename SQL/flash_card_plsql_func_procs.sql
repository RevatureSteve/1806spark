CREATE USER flash_card_db IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO flash_card_db;

DROP USER flash_card_db CASCADE;

CREATE TABLE flash_cards
(
fc_id INT,
fc_question VARCHAR2(4000) UNIQUE,
fc_answer   VARCHAR2(4000),
PRIMARY KEY(fc_id)
);

--DML insert
INSERT INTO flash_cards VALUES (6, 'this is 4?', 'yessir!');
INSERT INTO flash_cards (fc_id, fc_question) VALUES(2, 'what is java?');

COMMIT;
--DML select
SELECT fc_id, fc_question q, fc_answer an FROM flash_cards;

--DML update
UPDATE flash_cards SET fc_answer = 'awesome' WHERE fc_question = 'what is java?';
UPDATE flash_cards SET fc_question = 'what is .net', fc_answer='allows us to C#' WHERE fc_id=1;

--DML delete
DELETE FROM flash_cards;INSERT INTO flash_cards (fc_question, fc_answer) VALUES ('what is life', 42);


-- SELECT requires a FROM statement so we use a fake table called DUAL
SELECT * FROM DUAL;

-- Procedural Language/ SQL is oracles implementation of SQL
--PL/SQL sequences
CREATE SEQUENCE fc_seq 
  START WITH 1 
  INCREMENT BY 1;
  
/*
CREATE [OR REPLACE] TRIGGER trig_name
BEFORE | AFTER  - INSERT | UPDATE | DELETE 
ON table_name
FOR EACH ROW 
DECLARE - for variables 
BEGIN
EXCEPTION
END;
*/

CREATE OR REPLACE TRIGGER fc_seq_trigger
BEFORE INSERT ON flash_cards
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.fc_id IS NULL THEN
    --embedded SQL
    SELECT fc_seq.nextval INTO :new.fc_id FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/

--CREATE [OR REPLACE] PROCEDURE proc_name [list of parameters]
--IS
--       *Declaration section*
--BEGIN
--       *Execution section*
--EXCEPTION
--       *Exception section*
--END;

-----------------------------PROCEDURE hello world
CREATE OR REPLACE PROCEDURE hello_world_procedure
IS
BEGIN
  
  DBMS_OUTPUT.PUT_LINE('hello world!');
  
END;
/
--Find the View tab and select DBMS OUTPUT then in that new DBMS Output tab hit the green + and select the current db
BEGIN
  hello_world_procedure();
END;
/

-----------------------------INSERT Stored Procedure
CREATE OR REPLACE PROCEDURE insert_fc_procedure(some_q IN VARCHAR2, some_a IN flash_cards.fc_answer%TYPE, 
					fc_error_msg OUT VARCHAR2) --OUT parameter doesn't specify size
IS
BEGIN
  
  INSERT INTO flash_cards(fc_question, fc_answer) VALUES(some_q, some_a);

  COMMIT;--ALWAYS COMMIT!!
  
EXCEPTION
  WHEN OTHERS THEN
  fc_error_msg := SQLERRM;
END;
/
--Anonymous Function to test Insert stored proc with Declaring our exception
DECLARE 
  fc_error_msg VARCHAR2(4000);
BEGIN
  
  insert_fc_procedure('Can we write stored procedures?', 'Absolutely!', fc_error_msg);
  DBMS_OUTPUT.PUT_LINE('FC_ERROR_MSG = ' || FC_ERROR_MSG);
END;
/


-----------------------------Stored Proc with out parameter
CREATE OR REPLACE PROCEDURE get_answer_procedure(some_q IN VARCHAR2, some_a OUT VARCHAR2)
IS
BEGIN
  
  SELECT fc_answer INTO some_a FROM flash_cards WHERE fc_question = some_q;
 
END;
/
--Anonymous Function to test getProc with out parameter stored proc
DECLARE
  answer VARCHAR2(4000);
BEGIN
  
  get_answer_procedure('Can we write stored procedures?', answer);
  DBMS_OUTPUT.PUT_LINE('answer: ' || answer);
  
END;
/

/*
A cursor is a pointer to this context area, PL/SQL controls the context area through a cursor
A cursor holds a row (one more) returned by a SQL statement. 
*/ 
-----------------------------Stored Proc with out parameter
CREATE OR REPLACE PROCEDURE get_all_fc_procedure(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR
  SELECT * FROM flash_cards;
END;
/

--Anonymous test of Stored Proc with Cursor
DECLARE
  fc_cursor SYS_REFCURSOR;
  someId flash_cards.fc_id%TYPE;
  someQ flash_cards.fc_question%TYPE;
  someA flash_cards.fc_answer%TYPE;
BEGIN
  
  get_all_fc_procedure(fc_cursor);
  LOOP
    FETCH fc_cursor INTO someId, someQ, someA;
    EXIT WHEN fc_cursor%NOTFOUND;
    
    DBMS_OUTPUT.PUT_LINE(someId || ' ' || someQ || ' ' || someA);
    
  END LOOP;
  CLOSE fc_cursor;
END;
/

-----------------------------------------------------------FUNCTIONS

-----------------------------Func getMax id
CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS
  max_id NUMBER;
BEGIN
  
  SELECT MAX(fc_id) INTO max_id FROM flash_cards;
  RETURN max_id;
  
END;
/

--------Anonymous Test getMax Id
DECLARE
  max_id NUMBER;
BEGIN 
  
  max_id := get_max_id();
  DBMS_OUTPUT.PUT_LINE('max id is: ' || max_id);
  
END;
/



CREATE OR REPLACE FUNCTION findMax(x IN NUMBER, y IN NUMBER)
RETURN NUMBER
IS
  z NUMBER;
BEGIN
  
  IF x > y THEN
    z := x;
  ELSE
    z := y;
  END IF;
  
  RETURN z;
 
END;

---------Anonymous Test
DECLARE
  firstNum  NUMBER;
  secondNum NUMBER;
  maxNum    NUMBER;
BEGIN
  firstNum  := 23;
  secondNum := 45;
  
  maxNum := findMax(firstNum, secondNum);
  DBMS_OUTPUT.PUT_LINE('Max of 23 and 45 is: ' || maxNum);

END;
/

---Function called from Select Statement
SELECT findMax(55, 23) AS Max_NUM FROM DUAL;









select * from user_source where NAME = 'INSERT_FC_PROCEDURE';









