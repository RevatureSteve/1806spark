--REQUEST TYPE LOOKUP TABLE
CREATE TABLE RQ_TYPE (
RQ_TYPE_ID INT,
RQ_TYPE VARCHAR2(4000),

PRIMARY KEY (RQ_TYPE_ID)
);

INSERT INTO rq_type (rq_type_id, rq_type) VALUES ('5', 'Misc');
SELECT * FROM rq_type;

COMMIT;

-- RQ STATUS LOOKUP TABLE
CREATE TABLE RQ_STATUS (
RQ_STATUS_ID INT,
RQ_STATUS VARCHAR2(4000),

PRIMARY KEY (RQ_STATUS_ID)
);

INSERT INTO rq_status (rq_status_id, rq_status) VALUES ('5', 'Flagged');
SELECT * FROM rq_status;

COMMIT;

--POSITION LOOKUP TABLE
CREATE TABLE POSITION (
Pos_ID INT,
POS_Type VARCHAR2(4000),

PRIMARY KEY (Pos_ID)
);

INSERT INTO position (pos_id, pos_type)VALUES ('2', 'manager');
SELECT * FROM position;

--USERS TABLE
CREATE TABLE USERS (
U_ID INT,
FNAME VARCHAR2(4000),
LNAME VARCHAR2(4000),
EMAIL VARCHAR2(4000),
password VARCHAR2(4000),
Pos_ID INT,

PRIMARY KEY(u_id),
FOREIGN KEY (Pos_ID)REFERENCES POSITION (Pos_ID) 
);

INSERT INTO users (fname, lname, email, password, pos_id) VALUES ('Boss', 'Man', 'boss@man', 'abc', '2');

SELECT * FROM users;

--uid sequence
CREATE SEQUENCE u_id_seq
    START WITH 1
    INCREMENT BY 1;
    
--Users_ID Trigger
CREATE OR REPLACE TRIGGER U_ID_trigger
BEFORE INSERT ON USERS
FOR EACH ROW  
BEGIN
  IF :new.u_id IS NULL THEN
        SELECT u_id_seq.nextval INTO :new.u_id FROM DUAL;
  END IF;
END;
/

DROP TABLE REIMBURSEMENT;
--REIMBURSEMENT TABLE
CREATE TABLE REIMBURSEMENT(
R_ID INT,
Emp_U_ID INT,
Mgr_U_ID INT,
AMT INT,
DESCRIPTION VARCHAR2(4000),
IMG VARCHAR2 (4000),
TIMESUBMISSION TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
RQ_TYPE_ID INT,
RQ_STATUS_ID INT,

PRIMARY KEY (R_ID),
FOREIGN KEY (Emp_U_ID) REFERENCES USERS (U_ID),
FOREIGN KEY (Mgr_U_ID) REFERENCES USERS (U_ID),
FOREIGN KEY (RQ_TYPE_ID)REFERENCES RQ_TYPE (RQ_TYPE_ID),
FOREIGN KEY (RQ_STATUS_ID)REFERENCES RQ_STATUS (RQ_STATUS_ID)
);

INSERT INTO reimbursement (emp_u_id, mgr_u_id, amt, description, rq_type_id, rq_status_id) 
VALUES ('1', '2', '75.00', 'Salami Eggs and bacon', '1', '4');

SELECT * FROM REIMBURSEMENT;

SELECT * FROM REIMBURSEMENT WHERE R_ID = 1041;
COMMIT;

--procedure to add a reimbursement------------------------
CREATE OR REPLACE PROCEDURE add_reimbursement (some_emp_u_id IN NUMBER, some_mgr_u_id IN NUMBER, some_amt IN NUMBER,
some_description VARCHAR2, some_rq_type_id IN NUMBER, some_rq_status_id IN NUMBER)

IS
BEGIN
        INSERT INTO REIMBURSEMENT ( emp_u_id, mgr_u_id, amt, description, rq_type_id, rq_status_id)
        VALUES (some_emp_u_id, some_mgr_u_id, some_amt, some_description, some_rq_type_id, some_rq_status_id);     
END;
/
    
COMMIT;

EXEC add_reimbursement  (1,  1, 1, 'test', 1, 1);
--r_id sequence
CREATE SEQUENCE r_id_seq
    START WITH 1001
    INCREMENT BY 1;
    
--Users_ID Trigger
CREATE OR REPLACE TRIGGER R_ID_trigger
BEFORE INSERT ON REIMBURSEMENT
FOR EACH ROW  
BEGIN
  IF :new.R_ID IS NULL THEN
        SELECT r_id_seq.nextval INTO :new.R_ID FROM DUAL;
  END IF;
END;
/
