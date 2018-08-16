INSERT INTO position VALUES (1, 'Employee');
INSERT INTO position VALUES (2, 'Manager');

INSERT INTO rb_status VALUES (1, 'Pending');
INSERT INTO rb_status VALUES (2, 'Approved');
INSERT INTO rb_status VALUES (3, 'Denied');

INSERT INTO rb_type VALUES (1, 'something');

INSERT INTO users VALUES (1, 'ad@gmail.com', '111', 'Alicia', 'Douglas', 1);

INSERT INTO reimbursement (r_id, emp_u_id, mgr_u_id, amt, time_submission, rb_type_id, rb_status_id) 
        VALUES (1, 1, 1, 20, CURRENT_TIMESTAMP, 1,1); 

commit;



--SEQUENCE

--Sequence for u_id
CREATE SEQUENCE users_seq
START WITH 1
INCREMENT BY 1;

--Sequence for p_id
CREATE SEQUENCE reimbursement_seq
START WITH 1
INCREMENT BY 1;


--TRIGGERS

--Trigger for users_seq
CREATE OR REPLACE TRIGGER users_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
    IF :new.u_id IS NULL THEN
        SELECT users_seq.nextval INTO :new.u_id FROM DUAL;
    END IF;
END;
/


--Trigger for reimbursement_seq
CREATE OR REPLACE TRIGGER reimbursemant_seq_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
    IF :new.r_id IS NULL THEN
        SELECT reimbursement_seq.nextval INTO :new.r_id FROM DUAL;
    END IF;
END;
/





--Stored Procedures


--get reimbursements by emp_u_id and join tables
CREATE OR REPLACE PROCEDURE get_reimbursements_by_emp_id(emp_id IN INT, reimbursements OUT SYS_REFCURSOR)
IS
BEGIN 
    OPEN reimbursements FOR
    SELECT * FROM reimbursement r
    INNER JOIN rb_status rs
    ON r.rb_status_id = rs.rb_status_id
    INNER JOIN rb_type rt
    ON r.rb_type_id = rt.rb_type_id
    WHERE emp_u_id = emp_id;
END;
/

--get all reimbursements and join tables
CREATE OR REPLACE PROCEDURE get_reimbursements(reimbursements OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN reimbursements FOR 
    SELECT * FROM reimbursement r
    INNER JOIN rb_status rs
    ON r.rb_status_id = rs.rb_status_id
    INNER JOIN rb_type rt
    ON r.rb_type_id = rt.rb_type_id;
END;
/

--Create new reimbursement
CREATE OR REPLACE PROCEDURE create_reimbursement(emp_id IN INT, amount IN NUMBER, description IN VARCHAR2, image IN BLOB, rb_type IN INT)
IS
BEGIN
    INSERT INTO reimbursement (emp_u_id, amt, description, img, time_submission, rb_type_id, rb_status_id)
    VALUES (emp_id, amount, description, image, CURRENT_TIMESTAMP, rb_type, 1);
END;
/
        










   
























