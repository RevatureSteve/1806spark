DROP TABLE position;
DROP TABLE Rq_Type;
DROP TABLE Rq_Status;
DROP TABLE users;
DROP TABLE Reimbursement;

--POSITION
CREATE TABLE position (
pos_id INT,
pos_type VARCHAR2 (4000) UNIQUE NOT NULL,
PRIMARY KEY (pos_id)
);

--REQUEST TYPE
CREATE TABLE Rq_Type (
rq_type_id INT,
rq_type VARCHAR2 (4000),
PRIMARY KEY (rq_type_id)
);

--REQUEST STATUS
CREATE TABLE Rq_Status (
rq_status_id INT,
rq_status VARCHAR2 (4000),
PRIMARY KEY (rq_status_id)
);

--USER
CREATE TABLE users (
u_id INT,
email VARCHAR2 (4000) UNIQUE NOT NULL,
password VARCHAR2 (4000) NOT NULL,
fname VARCHAR2 (4000) NOT NULL,
lanme VARCHAR2 (4000) NOT NULL,
PRIMARY KEY (u_id),
FOREIGN KEY (pos_id) REFERENCES position(pos_id)
);

--REIMBURSEMENT
CREATE TABLE reimbursement (
r_id INT,
amt number (18,2) NOT NULL,
description VARCHAR2 (4000),
img BLOB,
timesubmission TIMESTAMP,
PRIMARY KEY (r_id),
FOREIGN KEY (emp_u_id) REFERENCES users(u_id),
FOREIGN KEY (mgr_u_id) REFERENCES users(u_id),
FOREIGN KEY (rq_type_id) REFERENCES Rq_Type(rq_type_id),
FOREIGN KEY (rq_status_id) REFERENCES Rq_Status(rq_status_id)
);