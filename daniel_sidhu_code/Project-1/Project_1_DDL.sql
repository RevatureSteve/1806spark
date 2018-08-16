--DDL for Project 1

--TABLES
--USERS TABLE
CREATE TABLE users 
(

    U_Id NUMBER,
    Email VARCHAR2(4000) UNIQUE NOT NULL,
    Password VARCHAR(4000)NOT NULL,
    fname VARCHAR(4000) NOT NULL,
    lname VARCHAR(4000) NOT NULL,
    Pos_Id NUMBER NOT NULL,
    PRIMARY KEY (U_Id),
    FOREIGN KEY (Pos_Id) REFERENCES position(Pos_Id)

);

--POSITION TABLE
CREATE TABLE position
(

    Pos_Id NUMBER,
    Pos_Type VARCHAR2(4000),
    PRIMARY KEY (Pos_Id)
    
);

--REIMBURSEMENT TABLE
CREATE TABLE reimbursement 
(

    R_Id NUMBER,
    Emp_U_Id NUMBER NOT NULL,
    Mgr_U_Id NUMBER NOT NULL,
    Amt NUMBER(38,2)NOT NULL,
    Description VARCHAR2(4000),
    Img BLOB,
    Timesubmission TIMESTAMP,
    Rq_Type_Id NUMBER,
    Rq_Status_Id NUMBER,
    CONSTRAINT PK_reimbursement PRIMARY KEY (R_Id),
    FOREIGN KEY (Emp_U_Id) REFERENCES users(U_Id),
    FOREIGN KEY (Mgr_U_Id) REFERENCES users(U_Id),
    FOREIGN KEY (rq_type_id) REFERENCES rq_type (rq_type_id),
    FOREIGN KEY (rq_status_id) REFERENCES rq_status (rq_status_id)
    
);

--REQUEST TYPE TABLE
CREATE TABLE rq_type
(

    Rq_Type_Id NUMBER,
    Rq_Type VARCHAR2(4000),
    PRIMARY KEY (Rq_Type_Id)

);

--REQUEST STATUS TABLE(inserted values are completed)
CREATE TABLE rq_status
(

    Rq_Status_Id NUMBER,
    Rq_Status VARCHAR2(4000),
    PRIMARY KEY (Rq_Status_Id)

);