
-- ERS DDL


CREATE TABLE users(
u_id INT,
email VARCHAR2(100) UNIQUE NOT NULL,
password VARCHAR2(20) NOT NULL,
fname VARCHAR2(20) NOT NULL,
lname VARCHAR2(40) NOT NULL,
pos_id INT,
PRIMARY KEY (u_id),
FOREIGN KEY (pos_id) REFERENCES position (pos_id)
);


CREATE TABLE position(
pos_id INT,
pos_type VARCHAR2(4000) UNIQUE NOT NULL,
PRIMARY KEY (pos_id)
);

CREATE TABLE rq_status (
rq_status_id INT,
rq_status VARCHAR2(4000),
PRIMARY KEY (rq_status_id)
);

CREATE TABLE rq_type (
rq_type_id INT,
rq_type VARCHAR2(4000),
PRIMARY KEY (rq_type_id)
);

DROP TABLE reimbursement;
CREATE TABLE reimbursement (
r_id INT,
r_submission_id INT NOT NULL,
r_resolved_id INT NOT NULL,
amount INT NOT NULL,
description VARCHAR2(4000),
img BLOB,
time_submission TIMESTAMP NOT NULL,
rq_type_id INT NOT NULL,
rq_status_id INT NOT NULL,
PRIMARY KEY (r_id),
FOREIGN KEY (r_submission_id) REFERENCES users (u_id),
FOREIGN KEY (r_resolved_id) REFERENCES users (u_id),
FOREIGN KEY (rq_type_id) REFERENCES rq_type (rq_type_id),
FOREIGN KEY (rq_status_id) REFERENCES rq_status (rq_status_id)
);




--DML 

INSERT INTO position VALUES (1, 'employee');
INSERT INTO position VALUES (2, 'manager');
commit;

select * from position;


INSERT INTO rq_status VALUES (1, 'pending');
INSERT INTO rq_status VALUES (2, 'approved');
INSERT INTO rq_status VALUES (3, 'denied');

SELECT * FROM rq_status;


INSERT INTO rq_type VALUES (1, 'travel expense');
INSERT INTO rq_type VALUES (2, 'equipment');
select * from rq_type;


INSERT INTO users VALUES (1, 'rhys@gmail.com', '123456', 'Rhys', 'Yamasaki', 2);
INSERT INTO users VALUES (2, 'y@gmail.com', '123456', 'R', 'Y', 1);
select * from users;

SELECT * FROM users WHERE email = 'rhys@gmail.com';

-- Sequences
CREATE SEQUENCE r_id_seq
    START WITH 1
    INCREMENT BY 1;
/

CREATE SEQUENCE u_id_seq
    START WITH 1
    INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER r_id_seq_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW
BEGIN 
    IF :new.r_id IS NULL THEN
        SELECT r_id_seq.nextval INTO :new.r_id FROM DUAL;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER u_id_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    IF :new.u_id IS NULL THEN
        SELECT u_id_seq.nextval INTO :new.u_id FROM DUAL;
    END IF;
END;
/




