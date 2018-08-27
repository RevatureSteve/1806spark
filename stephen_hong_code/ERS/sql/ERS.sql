DROP TABLE ers_reimbursement;
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_users;
DROP TABLE ers_user_roles;

DROP SEQUENCE user_seq;
DROP SEQUENCE reimb_seq;

CREATE TABLE ers_user_roles(
    ers_user_role_id    NUMBER,
    user_role           VARCHAR2(10),
    
    CONSTRAINT ers_user_roles_pk
        PRIMARY KEY (ers_user_role_id)
);

CREATE TABLE ers_users(
    ers_users_id        NUMBER,
    ers_username        VARCHAR2(50)    UNIQUE,
    ers_password_hash   VARCHAR2(64),
    ers_password_salt   VARCHAR2(16),
    user_first_name     VARCHAR2(100),
    user_last_name      VARCHAR2(100),
    user_email          VARCHAR2(150)   UNIQUE,
    user_role_id        NUMBER,
    
    CONSTRAINT ers_users_pk
        PRIMARY KEY (ers_users_id),
    
    CONSTRAINT user_roles_fk
        FOREIGN KEY (user_role_id)
        REFERENCES ers_user_roles (ers_user_role_id)
);

CREATE TABLE ers_reimbursement_status(
    reimb_status_id     NUMBER,
    reimb_status        VARCHAR2(10),
    
    CONSTRAINT reimb_status_pk
        PRIMARY KEY (reimb_status_id)
);

CREATE TABLE ers_reimbursement_type(
    reimb_type_id       NUMBER,
    reimb_status        VARCHAR2(10),
    
    CONSTRAINT reimb_type_pk
        PRIMARY KEY (reimb_type_id)
);

CREATE TABLE ers_reimbursement(
    reimb_id            NUMBER,
    reimb_amount        NUMBER,
    reimb_submitted     TIMESTAMP,
    reimb_resolved      TIMESTAMP,
    reimb_description   VARCHAR2(250),
    reimb_receipt       BLOB,
    reimb_author        NUMBER,
    reimb_resolver      NUMBER,
    reimb_status_id     NUMBER,
    reimb_type_id       NUMBER,
    
    CONSTRAINT ers_reimbursement_pk
        PRIMARY KEY (reimb_id),
    
    CONSTRAINT ers_users_fk_auth
        FOREIGN KEY(reimb_author)
        REFERENCES ers_users (ers_users_id),
    
    CONSTRAINT ers_users_fk_reslvr
        FOREIGN KEY(reimb_author)
        REFERENCES ers_users (ers_users_id),  
    
    CONSTRAINT ers_reimbursement_status_fk
        FOREIGN KEY (reimb_status_id)
        REFERENCES ers_reimbursement_status (reimb_status_id),
    
    CONSTRAINT ers_reimbursement_type_fk
        FOREIGN KEY(reimb_type_id)
        REFERENCES ers_reimbursement_type (reimb_type_id)
);




CREATE SEQUENCE user_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_users
BEFORE INSERT ON ers_users
FOR EACH ROW
BEGIN
    :NEW.ers_users_id := user_seq.NEXTVAL;
END;
/


CREATE SEQUENCE reimb_seq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_reimb
BEFORE INSERT ON ers_reimbursement
FOR EACH ROW
BEGIN
    :NEW.reimb_id := reimb_seq.NEXTVAL;
END;
/


INSERT INTO ers_reimbursement_type VALUES(1, 'LODGING');
INSERT INTO ers_reimbursement_type VALUES(2, 'TRAVEL');
INSERT INTO ers_reimbursement_type VALUES(3, 'FOOD');
INSERT INTO ers_reimbursement_type VALUES(4, 'OTHER');

INSERT INTO ers_reimbursement_type VALUES (1, 'Certification');
INSERT INTO ers_reimbursement_type VALUES (2, 'Relocation to Client');
INSERT INTO ers_reimbursement_type VALUES (3, 'Relocation to Training');
INSERT INTO ers_reimbursement_type VALUES (4, 'Interview Expense');
INSERT INTO ers_reimbursement_type VALUES (5, 'Sales Expense');
INSERT INTO ers_reimbursement_type VALUES (6, 'Associate Travel Expense');
INSERT INTO ers_reimbursement_type VALUES (7, 'Other');

INSERT INTO ers_user_roles VALUES(1, 'USER');
INSERT INTO ers_user_roles VALUES(2, 'MANAGER');

INSERT INTO ers_reimbursement_status VALUES(1, 'PENDING');
INSERT INTO ers_reimbursement_status VALUES(2, 'APPROVED');
INSERT INTO ers_reimbursement_status VALUES(3, 'DENIED');

DELETE FROM ers_reimbursement;
DELETE FROM ers_users;
DELETE FROM ers_reimbursement_type;

COMMIT;