--Create user and make new database
CREATE USER project_one_db IDENTIFIED BY p4ssw0rd;

--//////////////////////////////// drop tables
drop table users; -- DROP SECOND 
DROP TABLE position;
drop table rq_status;
drop table rq_type;
drop table reimbursement; --drop frist

--/////////////////////////////////////////SELECT * FROM
SELECT * FROM position;
SELECT * FROM REIMBURSEMENT;
SELECT * FROM rq_type;
SELECT * FROM rq_status;
SELECT * FROM users;

--Must Grant new user permissions
GRANT CONNECT, RESOURCE TO project_one_db;
--learn how to auto_increment
CREATE TABLE users(
u_id INT, 
fname VARCHAR2(100) NOT NULL,
lname VARCHAR2(100) NOT NULL,
email VARCHAR2(100) UNIQUE NOT NULL,
pos_id INT,
PRIMARY KEY (u_id),
FOREIGN KEY (pos_id) REFERENCES position (pos_id)  );

--///////////////////////insert into users
insert into users Values(1,'chester','gil','chester@gmail.com',1); 


-------(can be created before users) project one
--(E-FOR EMPLOYEE OR M-FOR MANAGER) unique not null
CREATE TABLE position(
pos_id INT,
pos_type VARCHAR2(50) NOT NULL, --m for manager, e for employee
PRIMARY KEY (pos_id));
INSERT INTO POSITION VALUES(1,'MANAGER');
INSERT INTO POSITION VALUES(2,'EMPLOYEE');

--(last table to be created)
CREATE TABLE reimbursement (
r_id INT,
amt NUMBER(38,0) NOT NULL,
descriptions varchar2(4000),
img Blob,
time_submission TIMESTAMP,
emp_u_id INT NOT NULL,
mgr_u_id INT NOT NULL,
rq_type_id INT NOT NULL,
rq_status_id INT NOT NULL,
PRIMARY KEY (r_id),
FOReIGN KEY (emp_u_id) REFERENCES users(u_id),
FOReIGN KEY (mgr_u_id) REFERENCES users(u_id),
FOREIGN KEY (rq_type_id) REFERENCES rq_type(rq_type_id),
FOREIGN KEY (rq_status_id) REFERENCES rq_status(rq_status_id) );
--FOREIGN KEY (r_id) REFERENCES rq_type(rq_type_id),
--FOREIGN KEY (r_id) REFERENCES rq_status(rq_status_id) );
--//////////insert into reimburse
INSERT INTO  reimbursement(r_id,amt,descriptions,img,time_submission,emp_u_id,mgr_u_id,rq_type_id,rq_status_id)
VALUES(1,1000,'plane ticket to the bahamas and food expense','null','systimestamp',1,2,1,2);

--(travel Expense, purchase, etc)
CREATE TABLE rq_type(
rq_type_id INT,
rq_type VARCHAR2(120) unique NOT NULL,
PRIMARY KEY (rq_type_id) ); 

--///////////////////// insert on request type
Insert Into RQ_TYPE VALUES (1,'book purchase');
Insert Into RQ_TYPE VALUES (2,'Book Purchase');


--(processing or processed)
CREATE TABLE rq_status(
rq_status_id INT,
rq_status varchar2(120) not null,
PRIMARY KEY (rq_status_id) );

--/////////////////////////insert in rq_status

INSERT INTO rq_status VALUES(1, 'pending');
INSERT INTO rq_status VALUES(2, 'reimburse');


