 CREATE TABLE users (
u_id INT,
email VARCHAR2 (100) UNIQUE NOT NULL,
password VARCHAR2(40) NOT NULL,
fname VARCHAR2 (40) NOT NULL,
lname VARCHAR2 (40) NOT NULL,
pos_id INT NOT NULL,
PRIMARY KEY (u_id),
FOREIGN KEY (pos_id) REFERENCES position(pos_id)
);


CREATE TABLE position (
pos_id INT,
pos_type VARCHAR2 (40) UNIQUE NOT NULL,
PRIMARY KEY (pos_id)
);

CREATE TABLE rb_type (
rb_type_id INT,
rb_type VARCHAR2(4000) UNIQUE NOT NULL,
PRIMARY KEY (rb_type_id)
);

CREATE TABLE rb_status (
rb_status_id INT,
rb_status VARCHAR2(4000),
PRIMARY KEY (rb_status_id)
);


CREATE TABLE reimbursement (
r_id INT,
emp_u_id INT NOT NULL,
mgr_u_id INT,
amt NUMBER (18,2) NOT NULL,
description VARCHAR2 (4000),
img BLOB,
time_submission TIMESTAMP NOT NULL,
rb_type_id INT NOT NULL,
rb_status_id INT NOT NULL,
PRIMARY KEY (r_id),
FOREIGN KEY (emp_u_id) REFERENCES users(u_id),
FOREIGN KEY (mgr_u_id) REFERENCES users (u_id),
FOREIGN KEY (rb_type_id) REFERENCES rb_type(rb_type_id),
FOREIGN KEY (rb_status_id) REFERENCES rb_status (rb_status_id)
);
