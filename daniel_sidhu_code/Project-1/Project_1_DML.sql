--DML for Project 1

--For my Users TABLE
DROP TABLE users;

INSERT INTO users VALUES(1,'dan@yahoo.com', 'dan123', 'Daniel', 'Sidhu', 1);
INSERT INTO users VALUES(2,'leon@rcpd.com', 'leon123', 'Leon', 'Kennedy', 2);

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

INSERT INTO reimbursement (R_Id, Emp_U_Id, Mgr_U_Id, Amt, Timesubmission, Rq_Type_Id, Rq_Status_Id)
VALUES(1, 1, 1, 25.00, CURRENT_TIMESTAMP, 1, 1);

INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(1, 25.00, 'ammp', 1);

SELECT * FROM reimbursement;
COMMIT;

--Altering reimbursements table
ALTER TABLE reimbursement MODIFY Mgr_U_Id null; 
ALTER TABLE reimbursement MODIFY Timesubmission DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE reimbursement MODIFY Rq_Status_Id DEFAULT (1);

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

--JOINS 

--For my getReimbursements()
SELECT * FROM Reimbursement
INNER JOIN Rq_Status 
    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id
INNER JOIN Rq_Type
    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Status_Id; 

--For my getPendingReimbursements()
SELECT * FROM Reimbursement
INNER JOIN Rq_Status 
    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id
INNER JOIN Rq_Type
    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Status_Id
WHERE Reimbursement.Rq_Status_Id = 1; 

--For my getApprovedReimbursements()
SELECT * FROM Reimbursement
INNER JOIN Rq_Status 
    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id
INNER JOIN Rq_Type
    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Status_Id
WHERE Reimbursement.Rq_Status_Id = 2; 

--Creating a new reimbursement(This is an attempt, not compiled yet)
CREATE PROCEDURE Create_Reimbursement (R_Id IN NUMBER, Amt IN NUMBER, Img IN BLOB, Description IN VARCHAR2, Rq_Type_Id IN NUMBER)
IS 
BEGIN
    INSERT INTO reimbursement(Emp_U_Id, Amt, Description, Img, Timesubmission, Rq_Type_Id, Rq_Status_Id)
    VALUES (Emp_U_Id, Amt, Img, Description, Rq_Type_Id, CURRENT_TIMESTAMP);
END;
/
