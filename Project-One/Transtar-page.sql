INSERT INTO position VALUES (1, 'Employee');
INSERT INTO position VALUES (2, 'Manager');

INSERT INTO rq_status VALUES (1, 'Pending');
INSERT INTO rq_status VALUES (2, 'Approved');
INSERT INTO rq_status VALUES (3, 'Denied');

INSERT INTO rb_type VALUES (1, 'Charges');
INSERT INTO rb_type VALUES (2, 'Upgrade Kits');
INSERT INTO rb_type VALUES (3, 'Replenishment Packs');
INSERT INTO rb_type VALUES (4, 'Material');

INSERT INTO users VALUES (1, 'admin@transtar.com', 'ark', 'Beck', 'Larson', 1);
INSERT INTO users VALUES (2, 'yu@transtar.com', 'mgr', 'Morgan', 'Yu', 2);
INSERT INTO users (email, password, fname, lname, pos_id) VALUES ( 'sho@transtar.com', 'ark', 'Danielle', 'Sho', 1);
INSERT INTO reimbursement VALUES (4,1, 1, 100, 'Research', null, CURRENT_TIMESTAMP, 4, 2);
ALTER TABLE users
RENAME COLUMN lane TO lname;

COMMIT;

CREATE SEQUENCE new_user_id
START WITH 2
INCREMENT BY 2;

CREATE OR REPLACE TRIGGER new_user_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN 
    IF :new.u_id IS NULL THEN
        SELECT new_user_id.nextval INTO :new.u_id FROM DUAL;
        END IF;
END;
/
    
CREATE OR REPLACE PROCEDURE new_reimbursement(emp_id IN INT, amount IN INT, description IN VARCHAR2, rq_type IN INT)
IS
BEGIN
    INSERT INTO reimbursement (emp_u_id, amt, description, img, time_submission, rb_type_id, rq_status_id)
    VALUES (emp_id, amount, description, null, CURRENT_TIMESTAMP, rq_type, 1);
END;
/
CREATE OR REPLACE PROCEDURE resolved(req_id IN INT, status IN INT)
IS
BEGIN
    UPDATE reimbursement 
    SET rq_status_id = status
    WHERE r_id = req_id;
END;
/
BEGIN
    new_reimbursement(1,300, 'Lost it all', 2);
END;
/

CREATE SEQUENCE new_reimbursement_id
START WITH 1
INCREMENT BY 1;



CREATE OR REPLACE TRIGGER reimbursemant_seq_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
    IF :new.r_id IS NULL THEN
        SELECT new_reimbursement_id.nextval INTO :new.r_id FROM DUAL;
    END IF;
END;
/

commit;

UPDATE reimbursement 
SET rq_status_id = 2
WHERE r_id = 27;

SELECT * FROM reimbursement INNER JOIN rb_type
ON reimbursement.rb_type_id = rb_type.rb_type_id
INNER JOIN rq_status 
ON reimbursement.rq_status_id = rq_status.rq_status_id 
WHERE rq_status.rq_status_id = 1;

SELECT u_id,fname,lname,email FROM USERS
WHERE pos_id = 1;

SELECT * FROM reimbursement
INNER JOIN rb_type 
ON reimbursement.rb_type_id = rb_type.rb_type_id 
INNER JOIN rq_status 
ON reimbursement.rq_status_id = rq_status.rq_status_id 
WHERE reimbursement.rq_status_id = 2 OR reimbursement.rq_status_id = 3;

SELECT * FROM reimbursement
INNER JOIN rb_type 
ON reimbursement.rb_type_id = rb_type.rb_type_id 
INNER JOIN rq_status 
ON reimbursement.rq_status_id = rq_status.rq_status_id 
WHERE rq_status.rq_status_id = 2 OR rq_status.rq_status_id = 1 AND reimbursement.emp_u_id = 1;