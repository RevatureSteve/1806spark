--USERS
CREATE TABLE U_sers (
u_id INT,
email VARCHAR2(50) UNIQUE NOT NULL,
pass_word VARCHAR2(25) NOT NULL,
fname VARCHAR2(20) NOT NULL,
lname VARCHAR2(20) NOT NULL,
pos_id INT,
PRIMARY KEY (u_id),
FOREIGN KEY (pos_id) REFERENCES Positions(pos_id)
);

--Positions
CREATE TABLE Positions (
pos_id INT,
pos_type VARCHAR2(15) UNIQUE NOT NULL,
PRIMARY KEY (pos_id)
);

--Reimbursement
CREATE TABLE Reimbursement (
r_id INT,
emp_u_id INT,
mgr_u_id INT,
amt NUMBER(18,2) NOT NULL,
descript VARCHAR2(4000),
img BLOB,
time_submission TIMESTAMP,
rq_type_id INT,
rq_status_id INT,
PRIMARY KEY (r_id),
FOREIGN KEY (emp_u_id) REFERENCES U_sers(u_id),
FOREIGN KEY (mgr_u_id) REFERENCES U_sers(u_id),
FOREIGN KEY (rq_type_id) REFERENCES Rq_Type(rq_type_id),
FOREIGN KEY (rq_status_id) REFERENCES Rq_Status(rq_status_id)
);

--Request Type
CREATE TABLE Rq_Type (
rq_type_id INT,
rq_type VARCHAR2(15),
PRIMARY KEY (rq_type_id)
);

--Request Status
CREATE TABLE Rq_Status (
rq_status_id INT,
rq_status VARCHAR2(10),
PRIMARY KEY (rq_status_id)
);