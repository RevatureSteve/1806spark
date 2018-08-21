--DDL project 1

CREATE TABLE users(
u_id INT,
email VARCHAR2(100) UNIQUE NOT NULL,
password VARCHAR2(100) NOT NULL,
fname VARCHAR2(100) NOT NULL,
lname VARCHAR2(100) NOT NULL,
pos_id INT NOT NULL,
PRIMARY KEY (u_id),
FOREIGN KEY (pos_id) REFERENCES position(pos_id)
);

CREATE TABLE reimbursement(
r_id INT,
emp_u_id INT NOT NULL,
mgr_u_id INT NOT NULL,
amt NUMBER NOT NULL,
description VARCHAR2(1000),
img BLOB,
timesubmission TIMESTAMP,
rq_type_id INT,
rq_status_id INT,
PRIMARY KEY (r_id),
FOREIGN KEY (emp_u_id) REFERENCES users(u_id),
FOREIGN KEY (mgr_u_id) REFERENCES users(u_id),
FOREIGN KEY (rq_type_id) REFERENCES rq_type(rq_type_id),
FOREIGN KEY (rq_status_id) REFERENCES rq_status(rq_status_id)
);


CREATE TABLE position(
pos_id INT,
pos_type VARCHAR2(1000) UNIQUE NOT NULL,
PRIMARY KEY (pos_id)
);


CREATE TABLE rq_type (
rq_type_id INT,
rq_type VARCHAR2(1000) UNIQUE NOT NULL,
PRIMARY KEY (rq_type_id)
);


CREATE TABLE rq_status (
rq_status_id INT,
rq_status VARCHAR2(1000) UNIQUE NOT NULL,
PRIMARY KEY (rq_status_id)
);








