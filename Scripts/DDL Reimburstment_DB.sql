

--Table for users
CREATE TABLE users (
u_id INT,
f_name VARCHAR2(50) NOT NULL,
l_name VARCHAR2(50) NOT NULL,
email VARCHAR2(100) UNIQUE NOT NULL,
password VARCHAR2(20) NOT NULL,
post_id INT NOT NULL,
PRIMARY KEY (u_id),
FOREIGN KEY (post_id) REFERENCES position (pos_id)
)

--Table for reimbursment.
CREATE TABLE reimburstment (
r_id INT,
amount INT NOT NULL CHECK  (amount > 0),
r_description VARCHAR2(4000) ,
img BLOB,
time_submitted TIMESTAMP NOT NULL,
emp_u_id INT NOT NULL,
mang_u_id INT NOT NULL,
rq_type_id INT NOT NULL,
rq_status_id INT NOT NULL,
PRIMARY KEY (r_id),
FOREIGN KEY (emp_u_id) REFERENCES users (u_id),
FOREIGN KEY (mang_u_id) REFERENCES  users (u_id),
FOREIGN KEY (rq_type_id) REFERENCES rq_type (rq_type_id),
FOREIGN KEY (rq_status_id) REFERENCES rq_status (rq_status_id)
) 

--Table for reimbursment type.
CREATE TABLE rq_type (
rq_type_id INT,
rq_type VARCHAR2(100)  NOT NULL,
PRIMARY KEY (rq_type_id)
)

--Table for reimburment status.
CREATE TABLE rq_status (
rq_status_id INT,
rq_status VARCHAR2(500),
PRIMARY KEY (rq_status)
)

--Table for user position.
CREATE TABLE position (
pos_id INT,
pos_type VARCHAR2(1000),
PRIMARY KEY (pos_id)
);


