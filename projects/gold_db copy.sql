CREATE TABLE users(
u_id number,
email varchar2(4000)unique not null,
password varchar2(50)not null,
fname varchar2(4000)not null,
lname varchar2(4000)not null,
Pos_ID number not null,
primary key (u_id),
foreign key (pos_id) REFERENCES position(pos_id)
);

CREATE TABLE reimbursement(
R_ID number,
emp_u_id number not null,
mgr_u_id number not null,
amt number not null,
description varchar2(4000),
img blob,
timesubmission timestamp,
rq_type_id number not null,
rq_status_id number not null,
primary key (r_id),
foreign key (rq_type_id) references rq_type(rq_type_id),
foreign key (rq_status_id) references rq_status(rq_status_id),
foreign key (emp_u_id) references users(u_id),
foreign key (mgr_u_id) references users(u_id)
);

CREATE TABLE position(
Pos_ID number,
pos_type varchar2(500)UNIQUE NOT NULL,
primary key (pos_id)
);

CREATE TABLE RQ_TYPE(
rq_type_id number,
rq_type varchar2(500)unique not null,
primary key (rq_type_id)
);

CREATE TABLE RQ_STATUS(
rq_status_id number,
rq_status varchar2(500)unique not null,
primary key (rq_status_id)
);

-- SEQUENCES AND TRIGGERS AND PROCS

-- SEQUENCE TRIGGER PROCEDURE: USER
CREATE SEQUENCE user_seq 
  START WITH 100 
  INCREMENT BY 10;
CREATE OR REPLACE TRIGGER user_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.u_id IS NULL THEN
    --embedded SQL
    SELECT user_seq.nextval INTO :new.u_id FROM DUAL;
    

  END IF;
END;
/

CREATE OR REPLACE PROCEDURE new_user
(email in varchar2, password in varchar2,
fname in varchar2, lname in varchar2, posid in number)
IS
BEGIN
insert into USERS (email,password,fname,lname,pos_id)
VALUES (email,password,fname,lname,posid);
END;
/
-- SEQUENCE TRIGGER PROCEDURE: NEW REIMBURSEMENT
CREATE SEQUENCE reim_seq 
  START WITH 1 
  INCREMENT BY 1;
CREATE OR REPLACE TRIGGER reim_seq_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW  --required if you want to see/manipulate the row's data
BEGIN
--allowed to write PL/SQL
  IF :new.r_id IS NULL THEN
    --embedded SQL
    SELECT reim_seq.nextval INTO :new.r_id FROM DUAL;
    

  END IF;
END;
/
-- CREATE REIM
CREATE OR REPLACE PROCEDURE new_reimbursement
(EUID in Number,amt in number, descr in varchar2,
img in blob,rqtype in number)
IS
BEGIN
insert into reimbursement
(emp_u_id,amt,description,img,timesubmission,rq_type_id,rq_status_id)
values(EUID,amt,descr,img,(select systimestamp from dual),rqtype,0);
END;
/

begin
new_reimbursement(100,100,'nice',null, 1);
end;
/
select * from rq_status;
-- UPDATE REIM
CREATE OR REPLACE PROCEDURE update_reimbursement
(m_u_id in number,e_u_id in number,rqstatus in number)
is
begin
  UPDATE reimbursement
  SET rq_status_id = rqstatus, mgr_u_id = m_u_id
  WHERE emp_u_id = e_u_id;
  END;
  
--------------------------------------------------
                --Manager Select by E/M ID,TYPE,STATUS
Create or Replace Procedure sel_mgr_reimbursements
(mgruid in number, empuid in number, rqtypeid in number, rqstatusid in number,
rid out number, rimg out blob,ramt out number, rdesc out VARCHAR2,
time out VARCHAR2, rqstatus out number, rqtype out number
)
is
begin
select r_id,img, amt, description,timesubmission, rq_status_id, rq_type_id
into rid,rimg,ramt,rdesc,time, rqstatus, rqtype
from reimbursement
where mgr_u_id = mgruid
and emp_u_id = empuid
and rq_type_id = rqtypeid
and rq_status_id = rqstatusid;
END;
/
Create or Replace Procedure sel_mgr_reimbursement
(mgruid in number, empuid in number,
rid out number, rimg out blob,ramt out number, rdesc out VARCHAR2,
time out VARCHAR2, rqstatus out number, rqtype out number
)
is
begin
select r_id,img, amt, description,timesubmission, rq_status_id, rq_type_id
into rid,rimg,ramt,rdesc,time, rqstatus, rqtype
from reimbursement
where mgr_u_id = mgruid
and emp_u_id = empuid;
END;
/
insert into reimbursement(emp_u_id, mgr_u_id, amt, description, img
-------------------------------------------------
             -- Employee Select by TYPE,STATUS
Create or Replace Procedure sel_emp_reimbursements
(empuid in number, rqtypeid in number, rqstatusid in number,
rid out number, rimg out blob,ramt out number, rdesc out VARCHAR2,
time out VARCHAR2, rqstatus out number, rqtype out number
)
is
begin
select r_id,img, amt, description,timesubmission, rq_status_id, rq_type_id
into rid,rimg,ramt,rdesc,time, rqstatus, rqtype
from reimbursement
where emp_u_id = empuid
and rq_type_id = rqtypeid
and rq_status_id = rqstatusid;
END;
/

select r_id,emp_u_id,mgr_u_id,amt 
from reimbursement
where mgr_u_id = 0
and emp_u_id = 0
and rq_type_id = 0
and rq_status_id = 0;
-------------------------------------------------
--UPDATE EMPLOYEE PASSWORD--
CREATE OR REPLACE PROCEDURE update_password
(pw in varchar2,em in varchar2)
is
begin
  UPDATE users
  SET password = pw
  WHERE email = em;
  END;

--------------------------------------------------
                    -- DML stuff--
                    
                    
                    --position table lookup
INSERT INTO position (pos_id, pos_type) VALUES (1, 'manager'); 
INSERT INTO position (pos_id, pos_type) VALUES (2, 'employee'); 
INSERT INTO position (pos_id, pos_type) VALUES (3, 'terminated'); 
select * from position;
                    --rq_type table lookup
INSERT INTO rq_type (rq_type_id, rq_type) VALUES (1, 'Travel Expense'); 
INSERT INTO rq_type (rq_type_id, rq_type) VALUES (2, 'Lodging'); 
INSERT INTO rq_type (rq_type_id, rq_type) VALUES (3, 'Company Purchase'); 
INSERT INTO rq_type (rq_type_id, rq_type) VALUES (4, 'Client Acquisition'); 
INSERT INTO rq_type (rq_type_id, rq_type) VALUES (5, 'Misc.'); 
select * from rq_type;
                   --rq_status table lookup
INSERT INTO rq_status (rq_status_id, rq_status) VALUES (0, 'pending');
INSERT INTO rq_status (rq_status_id, rq_status) VALUES (1, 'approved');
INSERT INTO rq_status (rq_status_id, rq_status) VALUES (2, 'denied');
INSERT INTO rq_status (rq_status_id, rq_status) VALUES (3, 'invalid');
select * from rq_status;
/
select * from reimbursement;
/
commit;