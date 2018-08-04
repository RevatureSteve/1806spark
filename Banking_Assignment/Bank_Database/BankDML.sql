


--Create a sequence that will be used in trigger

CREATE SEQUENCE theUserId_sequence
  START WITH 138
  INCREMENT BY 41;
  
  

-- Use sequence in trigger that will be invoked before an insert on flash_cards
CREATE OR REPLACE TRIGGER userId_sequence_trigger BEFORE INSERT ON users FOR EACH ROW
BEGIN
  IF :new.users_id IS NULL THEN
    SELECT theUserId_Sequence.nextval INTO :new.users_id FROM DUAL;
  END IF;
END;
/

SELECT * FROM users;

