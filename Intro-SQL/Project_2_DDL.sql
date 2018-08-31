CREATE USER Project_2 IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE to Project_2;
--DDL for Project 1

--TABLES
--USERS TABLE
CREATE TABLE users(

    u_id INT,
    username VARCHAR2(4000) UNIQUE NOT NULL,
    pw_hash VARCHAR2(4000) NOT NULL,
    pw_salt VARCHAR2(4000) NOT NULL,
    fname VARCHAR2(4000),
    lname VARCHAR2(4000),
    email VARCHAR2(4000) UNIQUE UNIQUE,
    f_list_id INT,
    online_status INT,
    PRIMARY KEY (u_id),
    FOREIGN KEY (f_list_id) REFERENCES friends_list (u_id_1),
    FOREIGN KEY (online_status) REFERENCES online_status (status_id)
    
);

CREATE SEQUENCE users_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER users_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
    IF :new.u_id IS NULL THEN
        SELECT users_seq.nextval INTO :new.u_id FROM DUAL;
    END IF;
END;
/

CREATE TABLE message(

    m_id VARCHAR2(4000),
    u_id VARCHAR2(4000),
    timestamp DEFAULT CURRENT_TIMESTAMP,
    message NOT NULL,
    conversation_id INT,
    PRIMARY KEY (m_id),
    FOREIGN KEY (conversation_id) REFERENCES conversation (c_id)
    
);

CREATE SEQUENCE message_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER message_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
    IF :new.m_id IS NULL THEN
        SELECT users_seq.nextval INTO :new.m_id FROM DUAL;
    END IF;
END;
/

CREATE TABLE conversation(

    c_id INT,
    u_id_1 INT,
    u_id_2 INT,
    PRIMARY KEY (c_id),
    FOREIGN KEY (u_id_1) REFERENCES users (u_id),
    FOREIGN KEY (u_id_2) REFERENCES users (u_id)
    
);

CREATE SEQUENCE conversation_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER conversion_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
    IF :new.c_id IS NULL THEN
        SELECT users_seq.nextval INTO :new.c_id FROM DUAL;
    END IF;
END;
/

CREATE TABLE friends_list(

    u_id_1 INT,
    u_id_2 INT,
    PRIMARY KEY (u_id_1),
    FOREIGN KEY (u_id_2) REFERENCES users (u_id)

);

CREATE TABLE online_status(

    status_id INT,
    status VARCHAR2(4000) UNIQUE NOT NULL,
    PRIMARY KEY (status_id)
    
);




