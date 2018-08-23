--USERS
CREATE TABLE users (
u_id INT,
email VARCHAR2 (4000) UNIQUE NOT NULL,
password VARCHAR2 (4000) NOT NULL,
fname VARCHAR2 (4000) NOT NULL,
lname VARCHAR2 (4000) NOT NULL,
pos_id INT NOT NULL,
PRIMARY KEY (u_id),
FOREIGN KEY (pos_id) REFERENCES position(pos_id)
);

--POSITION
CREATE TABLE position(
pos_id INT,
pos_type VARCHAR2(4000) UNIQUE NOT NULL,
PRIMARY KEY (pos_id)
);

--REIMBURSEMENT
CREATE TABLE reimbursement (
r_id INT,
emp_u_id INT NOT NULL,
mgr_u_id INT NOT NULL,
amt INT NOT NULL,
description VARCHAR2 (4000),
img BLOB,
time_submission TIMESTAMP,
rq_type INT,
rq_status_id INT,
PRIMARY KEY (r_id),
FOREIGN KEY (emp_u_id) REFERENCES users(u_id),
FOREIGN KEY (mgr_u_id) REFERENCES users(u_id),
FOREIGN KEY (rq_type) REFERENCES rq_type (rq_type_id),
FOREIGN KEY (rq_status_id) REFERENCES rq_status (rq_status_id)
);

--RQ_TYPE
CREATE TABLE rq_type(
rq_type_id INT,
rq_type VARCHAR2(4000),
PRIMARY KEY (rq_type_id)
);

--RQ_STATUS
CREATE TABLE rq_status (
rq_status_id INT,
rq_status VARCHAR(4000),
PRIMARY KEY (rq_status_id)
);

--SELECT ALL
Delete FROM users WHERE u_id = 1;
Delete FROM reimbursement WHERE mgr_u_id = 1;
SELECT * FROM reimbursement WHERE rq_status_id = 2;
SELECT * FROM users WHERE u_id = 2;
SELECT * FROM users;
SELECT * FROM position;
SELECT * FROM reimbursement;
SELECT * FROM rq_type;
SELECT * FROM rq_status;

commit;