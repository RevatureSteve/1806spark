CREATE TABLE users 
(

    U_Id NUMBER,
    Email VARCHAR2(4000) UNIQUE NOT NULL,
    Password VARCHAR(4000)NOT NULL,
    fname VARCHAR(4000) NOT NULL,
    lname VARCHAR(4000) NOT NULL,
    Pos_Id NUMBER NOT NULL,
    PRIMARY KEY (U_Id)

);


CREATE TABLE position
(

    Pos_Id NUMBER,
    Pos_Type NUMBER UNIQUE NOT NULL,
    PRIMARY KEY (Pos_Id), 
    FOREIGN KEY (Pos_Id) REFERENCES users(Pos_Id)
    
);


CREATE TABLE reimbursement 
(

    R_Id NUMBER,
    Emp_U_Id NUMBER NOT NULL,
    Mgr_U_Id NUMBER NOT NULL,
    Amt NOT NULL,
    Description,
    Img BLOB,
    Timesubmission,
    Rq_Type_Id,
    Rq_Status_Id,
    CONSTRAINT PK_reimbursement PRIMARY KEY (R_Id),
    FOREIGN KEY (Emp_U_Id) REFERENCES users(U_Id),
    FOREIGN KEY (Mgr_U_Id) REFERENCES users(U_Id)
    
);


CREATE TABLE rq_type
(

    Rq_Type_Id,
    Rq_Type,
    CONSTRAINT PK_rq_Type PRIMARY KEY (Rq_Type_Id)

);


CREATE TABLE rq_status
(

    Rq_Status_Id,
    Rq_Status,
    CONSTRAINT PK_rq_type PRIMARY KEY (Rq_Status_Id)

);






