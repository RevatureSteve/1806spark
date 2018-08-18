-- TABLES
CREATE TABLE users (
    u_id INT,
    email VARCHAR2(400) UNIQUE NOT NULL,
    password VARCHAR2(40) NOT NULL,
    fname VARCHAR2(40) NOT NULL,
    lname VARCHAR2(40) NOT NULL,
    pos_id INT,
    PRIMARY KEY (u_id),
    FOREIGN KEY (pos_id) REFERENCES position(pos_id)
);

CREATE TABLE position (
    pos_id INT,
    pos_type VARCHAR2(40),
    PRIMARY KEY (pos_id)
);

CREATE TABLE reimbursement (
    r_id INT,
    emp_u_id NOT NULL,
    mgr_u_id NOT NULL,
    amt INT NOT NULL,
    description VARCHAR2(4000),
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

CREATE TABLE rq_type (
    rq_type_id INT,
    rq_type VARCHAR2(40),
    PRIMARY KEY (rq_type_id)
);

CREATE TABLE rq_status (
    rq_status_id INT,
    rq_status VARCHAR2(40),
    PRIMARY KEY (rq_status_id)
);

-- SEQUENCES
CREATE SEQUENCE reim_seq 
  START WITH 1 
  INCREMENT BY 1;
CREATE SEQUENCE users_seq 
  START WITH 1 
  INCREMENT BY 1;

-- TRIGGERS
CREATE OR REPLACE TRIGGER reim_seq_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN
  IF :new.r_id IS NULL THEN
    SELECT reim_seq.nextval INTO :new.r_id FROM DUAL;
  END IF;
END;
/
CREATE OR REPLACE TRIGGER users_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
  IF :new.u_id IS NULL THEN
    SELECT users_seq.nextval INTO :new.u_id FROM DUAL;
  END IF;
END;
/