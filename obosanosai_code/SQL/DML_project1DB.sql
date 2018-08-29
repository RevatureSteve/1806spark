

COMMIT;
DROP table position;
DROP table users;
DROP TABLE rq_status;
DROP TABLE reimbursement;
DROP TABLE rq_type;

CREATE TABLE position (
pos_id INT,
pos_type VARCHAR2 (4000) UNIQUE NOT NULL,
PRIMARY KEY (pos_id)
);
------------------------------
--INSERTING VALUES IN position
------------------------------
INSERT INTO position VALUES (1, 'Manager');
INSERT INTO position VALUES (2, 'Employee');

---------------------------
 CREATE TABLE users (
u_id INT,
email VARCHAR2 (4000) UNIQUE NOT NULL,
password VARCHAR2(25) NOT NULL,
fname VARCHAR2 (40) NOT NULL,
lname VARCHAR2 (40) NOT NULL,
pos_id INT NOT NULL,
PRIMARY KEY (u_id),
FOREIGN KEY (pos_id) REFERENCES position(pos_id)
);
-------------------------------
--INSERTING VALUES INTO users
-------------------------------
INSERT INTO users VALUES (1, 'wadew@gmail.com', 'unicorns1', 'Wade', 'Wilson', 1);
INSERT INTO users VALUES (2, 'negasonic@gmail.com', 'teenwarhead12', 'Nega', 'Sonic', 2);
INSERT INTO users VALUES (3, 'blindal@gmail.com', 'blindal12', 'Blind', 'Al', 2);
INSERT INTO users VALUES (4, 'dopinder@gmail.com', 'dopinder12', 'Dop', 'Inder', 2);
INSERT INTO users VALUES (5, 'van@gmail.com', 'vaness12', 'Mrs', 'Pool', 1);



SELECT * FROM users;
-------------------------------
CREATE TABLE rq_type (
rq_type_id INT,
rq_type VARCHAR2(4000) UNIQUE NOT NULL,
PRIMARY KEY (rq_type_id)
);
-------------------------------
--INSERTING VALUES INTO rq_type
-------------------------------
INSERT INTO rq_type VALUES (1, 'Amunition');
INSERT INTO rq_type VALUES (2, 'Unicorns');
INSERT INTO rq_type VALUES (3, 'Machinery');
INSERT INTO rq_type VALUES (4, 'Chimichangas');

SELECT * FROM rq_type;
-------------------------------
CREATE TABLE rq_status (
rq_status_id INT,
rq_status VARCHAR2(4000),
PRIMARY KEY (rq_status_id)
);
---------------------------------
--INSERTING VALUES INTO rq_status
---------------------------------
INSERT INTO rq_status VALUES (1, 'Pending');
INSERT INTO rq_status VALUES (2, 'Approved');
INSERT INTO rq_status VALUES (3, 'Denied');

SELECT * FROM rq_status;
------------------------------------------
CREATE TABLE reimbursement (
r_id INT,
emp_u_id INT NOT NULL,
mgr_u_id INT,
amt NUMBER (18,2) NOT NULL,
description VARCHAR2 (4000),
img BLOB,
time_submission TIMESTAMP NOT NULL,
rq_type_id INT NOT NULL,
rq_status_id INT NOT NULL,
PRIMARY KEY (r_id),
FOREIGN KEY (emp_u_id) REFERENCES users(u_id),
FOREIGN KEY (mgr_u_id) REFERENCES users (u_id),
FOREIGN KEY (rq_type_id) REFERENCES rq_type(rq_type_id),
FOREIGN KEY (rq_status_id) REFERENCES rq_status (rq_status_id)
);

SELECT * FROM reimbursement;

SELECT * FROM reimbursement where emp_u_id = 2;
SELECT * FROM reimbursement where emp_u_id = 3;
    

--------------------------------------------
--INSERTING VALUES INTO riembursement
--------------------------------------------
INSERT INTO reimbursement (r_id,emp_u_id, mgr_u_id, amt,description, time_submission, rq_type_id, rq_status_id) 
        VALUES (101,2, 1, 300, 'need a new eye ',CURRENT_TIMESTAMP, 1,2); 
INSERT INTO reimbursement (r_id,emp_u_id, mgr_u_id, amt,description, time_submission, rq_type_id, rq_status_id) 
        VALUES (202,3, 5, 370, 'non ya bidness',CURRENT_TIMESTAMP, 3,1); 
INSERT INTO reimbursement (r_id,emp_u_id, mgr_u_id, amt,description, time_submission, rq_type_id, rq_status_id) 
        VALUES (303,4, 5, 3000, 'classified aka sus', CURRENT_TIMESTAMP, 2,3); 
INSERT INTO reimbursement (r_id,emp_u_id, mgr_u_id, amt, description,time_submission, rq_type_id, rq_status_id) 
        VALUES (401,1, 1, 9000,'because im deadpool duh!', CURRENT_TIMESTAMP, 4,2); 
        

commit;

        
--SEQUENCE

--Sequence for u_id
CREATE SEQUENCE users_seque
START WITH 1
INCREMENT BY 1;

--Sequence for p_id
CREATE SEQUENCE reimb_seque
START WITH 1
INCREMENT BY 1;


--TRIGGERS

--Trigger for users_seq
CREATE OR REPLACE TRIGGER users_seque_trigga
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
    IF :new.u_id IS NULL THEN
        SELECT users_seque.nextval INTO :new.u_id FROM DUAL;
    END IF;
END;
/


--Trigger for reimbursement_seq
CREATE OR REPLACE TRIGGER reimb_seque_trigga
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
    IF :new.r_id IS NULL THEN
        SELECT reimb_seque.nextval INTO :new.r_id FROM DUAL;
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
    LEFT JOIN rq_status rs
    ON r.rq_status_id = rs.rq_status_id
    LEFT JOIN rq_type rt
    ON r.rq_type_id = rt.rq_type_id
    LEFT JOIN users u 
    ON r.emp_u_id = u.u_id
    LEFT JOIN users u
    ON r.mgr_u_id = u.u_id
    WHERE emp_u_id = emp_id;
END;
/

--get all reimbursements and join tables
CREATE OR REPLACE PROCEDURE get_reimbursements(reimbursements OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN reimbursements FOR 
    SELECT * FROM reimbursement r
    LEFT JOIN rq_status rs
    ON r.rq_status_id = rs.rq_status_id
    LEFT JOIN rq_type rt
    ON r.rq_type_id = rt.rq_type_id
    LEFT JOIN users u 
    ON r.emp_u_id = u.u_id
    LEFT JOIN users u
    ON r.mgr_u_id = u.u_id;
END;
/

--Create new reimbursement
CREATE OR REPLACE PROCEDURE create_reimbursement(emp_id IN INT, amount IN NUMBER, description IN VARCHAR2, image IN BLOB, rq_type IN INT)
IS
BEGIN
    INSERT INTO reimbursement (emp_u_id, amt, description, img, time_submission, rq_type_id, rq_status_id)
    VALUES (emp_id, amount, description, image, CURRENT_TIMESTAMP, rq_type, 1);
    commit;
END;
/
        


SELECT * FROM reimbursement r
    LEFT JOIN rq_status rs
    ON r.rq_status_id = rs.rq_status_id
    LEFt JOIN rq_type rt
    ON r.rq_type_id = rt.rq_type_id
    LEFT JOIN users u 
    ON r.emp_u_id = u.u_id
    LEFT JOIN users u
    ON r.mgr_u_id = u.u_id;



SELECT * FROM reimbursement;
TRUNCATE TABLE reimbursement;