
CREATE TABLE users(
u_id INT,
email VARCHAR2 (4000) NOT NULL UNIQUE,
password VARCHAR2 (4000) NOT NULL,
fname VARCHAR2 (4000) NOT NULL,
lname VARCHAR2 (4000) NOT NULL,
position_id INT NOT NULL,
PRIMARY KEY (u_id),
FOREIGN KEY (position_id) REFERENCES position(pos_id)
);

CREATE TABLE position(
pos_id INT,
pos_name VARCHAR2 (4000) UNIQUE NOT NULL,
PRIMARY KEY (pos_id)
)


CREATE TABLE reimbursement(
r_id INT,
rq_type_id INT NOT NULL,
r_submission_uID INT NOT NULL,
r_resolved__uID INT,
rq_status_id INT NOT NULL,
amount INT CHECK (amount > 0) NOT NULL,
description VARCHAR2 (4000),
img BLOB,
time_submission TIMESTAMP NOT NULL,
PRIMARY KEY (r_id),
FOREIGN KEY (rq_type_id) REFERENCES request_type(rq_type_id),
FOREIGN KEY (r_submission_uID) REFERENCES users(u_id),
FOREIGN KEY (r_resolved__uID) REFERENCES users(u_id),
FOREIGN KEY (rq_status_id) REFERENCES request_status(rq_status_id)
);


CREATE TABLE request_type(
rq_type_id INT,
rq_type VARCHAR2(4000)UNIQUE NOT NULL,
PRIMARY KEY (rq_type_id)
);

CREATE TABLE request_status(
rq_status_id INT,
rq_status VARCHAR2(4000),
PRIMARY KEY (rq_status_id)
);


CREATE SEQUENCE users_Id_sequence
  START WITH 138
  INCREMENT BY 41;
  
CREATE SEQUENCE reimburse_id_sequence
  START WITH 354
  INCREMENT BY 28;


CREATE OR REPLACE TRIGGER random_u_id_trigger BEFORE INSERT ON users FOR EACH ROW
BEGIN
  IF :new.u_id IS NULL THEN
    SELECT users_Id_sequence.nextval INTO :new.u_id FROM DUAL;
    
  END IF;
END;
/


CREATE OR REPLACE TRIGGER random_r_id_trigger BEFORE INSERT ON reimbursement FOR EACH ROW
BEGIN
  IF :new.r_id IS NULL THEN
    SELECT reimburse_id_sequence.nextval INTO :new.r_id FROM DUAL;
    
  END IF;
  IF :new.rq_status_id IS NULL THEN
    :new.rq_status_id:= 1;
    
  END IF;
  IF :new.time_submission IS NULL THEN
         :new.time_submission:= CURRENT_TIMESTAMP;
    
  END IF;
END;
/

commit;


ALTER TABLE reimbursement ADD CONSTRAINT defaultManager DEFAULT 1 FOR R_RESOLVED__UID;



Insert into Reimbursement(rq_type_id,r_submission_uId,RQ_STATUS_ID,AMOUNT,DESCRIPTION) VALUES(2,958,3,500,'hard insert-Denied');

SELECT * FROM request_status;
SELECT * FROM REIMBURSEMENT;
SELECT *FROM users;
commit;

update users set email = 'humphreyminott@gmail.com' where u_id=138;

Update reimbursement set R_RESOLVED__UID = null where RQ_STATUS_ID = 1;

SELECT r_id,rq_type,fname,lname,R_RESOLVED__UID,rq_status,amount,description,img,time_submission FROM 
					(SELECT REIMBURSEMENT.*,REQUEST_STATUS.*,Request_type.*,users.* FROM reimbursement INNER JOIN 
					request_status ON reimbursement.rq_status_id = request_status.rq_status_id INNER JOIN 
					request_type ON reimbursement.rq_type_id=request_type.rq_type_id INNER JOIN USERS ON 
					reimbursement.R_SUBMISSION_UID = users.u_id) WHERE rq_status='pending' AND R_SUBMISSION_UID=958;

SELECT * FROM REIMBURSEMENT where rq_status_Id=1 AND R_SUBMISSION_UID=958;



SELECT * FROM REIMBURSEMENT INNER JOIN USERS ON REIMBURSEMENT.R_SUBMISSION_UID = users.u_id WHERE RQ_STATUS_ID = 1;


SELECT r_id,rq_type,fname,lname,R_RESOLVED__UID,rq_status,amount,description,img,time_submission FROM (SELECT REIMBURSEMENT.*,REQUEST_STATUS.*,Request_type.*,users.* FROM reimbursement INNER JOIN request_status ON reimbursement.rq_status_id = request_status.rq_status_id INNER JOIN request_type ON reimbursement.rq_type_id=request_type.rq_type_id INNER JOIN USERS ON reimbursement.R_SUBMISSION_UID = users.u_id) WHERE rq_status= 'pending';



































