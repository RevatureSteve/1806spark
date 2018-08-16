--DML for Project 1

--For my Users TABLE
DROP TABLE users;

INSERT INTO users VALUES(1,'dan@yahoo.com', 'dan123', 'Daniel', 'Sidhu', 1);
SELECT * FROM users;

--SEQUENCE FOR users TABLES
CREATE SEQUENCE users_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

--TRIGGER for users_seq for users TABLES
CREATE OR REPLACE TRIGGER users_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
    IF :new.u_id IS NULL THEN
        SELECT users_seq.nextval INTO :new.u_id FROM DUAL;
    END IF;
END;
/

--For my Position TABLE
DROP TABLE position;

INSERT INTO position VALUES(1, 'Manager');
INSERT INTO position VALUES(2, 'Employee');
SELECT * FROM position;
COMMIT;

--For my Reimbursement TABLE
DROP TABLE reimbursement;

--SEQUENCE FOR Reimbursement TABLES
CREATE SEQUENCE reimbursement_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

--TRIGGER for reimbursement_seq for reimbursement TABLES
CREATE OR REPLACE TRIGGER reimbursement_seq_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW 
BEGIN
    IF :new.r_id IS NULL THEN
        SELECT reimbursement_seq.nextval INTO :new.r_id FROM DUAL;
    END IF;
END;
/

--For my Request Type TABLE
DROP TABLE rq_type;

INSERT INTO rq_type VALUES (1, 'food');
SELECT * FROM rq_type;

--For my Request Status TABLE(no more values needed)
DROP TABLE rq_status;

INSERT INTO rq_status VALUES (1, 'Pending');
INSERT INTO rq_status VALUES (2, 'Approved');
INSERT INTO rq_status VALUES (3, 'Denied');
SELECT * FROM rq_status;




