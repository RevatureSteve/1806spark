INSERT INTO position
VALUES(1,'Manager');

INSERT INTO position
VALUES(2,'Employee');

INSERT INTO users
VALUES(1, 'scontrol@gmail.com', 'cooly', 'Self', 'Control', 1);

INSERT INTO users
VALUES(2, 'lifec@gmail.com', 'tough', 'Life', 'Circumstances', 1);

INSERT INTO users
VALUES(3, 'jhightower@gmail.com', 'chilly', 'Josiah', 'Hightower', 3);
COMMIT;

INSERT INTO users
VALUES(4, 'swissa@gmail.com', 'swissy', 'Aamari', 'Swiss', 3);

INSERT INTO rq_type
VALUES(1, 'Peace of mind');

INSERT INTO rq_type
VALUES(2, 'Slow down');

INSERT INTO rq_type
VALUES(3, 'Priorities');

INSERT INTO rq_type
VALUES(4, 'Aspirations');


CREATE SEQUENCE id_seq 
  START WITH 1 
  INCREMENT BY 1;
COMMIT;

CREATE OR REPLACE TRIGGER id_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.u_id IS NULL THEN
    --embedded SQL
    SELECT id_seq.nextval INTO :new.u_id FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/

CREATE SEQUENCE id_seq 
  START WITH 1 
  INCREMENT BY 1;
COMMIT;

CREATE OR REPLACE TRIGGER id_seq_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.r_id IS NULL THEN
    --embedded SQL
    SELECT id_seq.nextval INTO :new.r_id FROM DUAL;
    --DUAL is a dummy table, typically used when you don't require a table 
    --but you still need the syntax of a sql statement to be correct
  END IF;
END;
/