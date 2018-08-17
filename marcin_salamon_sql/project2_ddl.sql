CREATE TABLE users(
u_id INT,
email VARCHAR2(4000) NOT NULL UNIQUE,
password VARCHAR2(4000) NOT NULL,
fname VARCHAR2(4000) NOT NULL,
lname VARCHAR2(4000) NOT NULL,
pos_id INT,
PRIMARY KEY (u_id),
FOREIGN KEY (pos_id) REFERENCES position (pos_id)
);

CREATE TABLE reimbursement(
r_id INT,
emp_u_id INT NOT NULL,
mgr_u_id INT,
amount NUMBER(38,2) NOT NULL,
description VARCHAR2(4000),
img BLOB,
timesubmission TIMESTAMP NOT NULL,
rq_type_id INT,
rq_status_id INT,
PRIMARY KEY (r_id),
FOREIGN KEY (rq_type_id) REFERENCES rq_type (rq_type_id),
FOREIGN KEY (rq_status_id) REFERENCES rq_status (rq_status_id),
FOREIGN KEY (mgr_u_id) REFERENCES users (u_id),
FOREIGN KEY (emp_u_id) REFERENCES users (u_id)
);

CREATE TABLE position(
pos_id INT,
pos_type VARCHAR2 UNIQUE NOT NULL,
PRIMARY KEY (pos_id)
);

CREATE TABLE rq_status(
rq_status_id INT,
rq_status VARCHAR2(4000) NOT NULL UNIQUE,
PRIMARY KEY (rq_status_id)
);

CREATE TABLE rq_type(
rq_type_id INT,
rq_type VARCHAR2(4000),
PRIMARY KEY (rq_type_id)
);