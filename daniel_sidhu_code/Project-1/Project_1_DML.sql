--DML for Project 1

--For my Users TABLE
DROP TABLE users;

INSERT INTO users VALUES(1,'dan@yahoo.com', 'dan123', 'Daniel', 'Sidhu', 1);
INSERT INTO users VALUES(2,'leon@rcpd.com', 'leon123', 'Leon', 'Kennedy', 2);
INSERT INTO users VALUES(3,'Marvin@rcpd.com', 'Marvin', 'Marvin', 'Branagh', 2);
INSERT INTO users VALUES(4,'Neil@rcpd.com', '123', 'Neil', 'Carlsen', 2);
INSERT INTO users VALUES(5,'Kevin@rcpd.com', 'Kevin123', 'Kevin', 'Dooley', 2);
INSERT INTO users VALUES(6,'Raymond@rcpd.com', 'Raymond123', 'Raymond', 'Douglas', 2);
INSERT INTO users VALUES(7,'Elliot@rcpd.com', 'Elliot123', 'Elliot', 'Edward', 2);
INSERT INTO users VALUES(8,'David@rcpd.com', 'David123', 'David', 'Ford', 2);
INSERT INTO users VALUES(9,'Tyler@rcpd.com', 'Tyler123', 'Tyler', 'Hamilton', 2);
INSERT INTO users VALUES(10,'Rita@rcpd.com', 'Rita123', 'Rita', 'Phillips', 2);
INSERT INTO users VALUES(11,'KevinR@rcpd.com', 'Kevin123', 'Kevin', 'Ryman', 2);
INSERT INTO users VALUES(12,'George@rcpd.com', 'George123', 'George', 'Scott', 2);
INSERT INTO users VALUES(13,'Brian@rcpd.com', 'Brian123', 'Brian', 'Irons', 1);
INSERT INTO users VALUES(14,'Richard@rcpd.com', 'Richard123', 'Richard', 'Aiken', 1);
INSERT INTO users VALUES(15,'Barry@rcpd.com', 'Barry123', 'Barry', 'Burton', 1);
INSERT INTO users VALUES(16,'Rebecca@rcpd.com', 'Rebecca123', 'Rebecca', 'Chambers', 1);
INSERT INTO users VALUES(17,'Edward@rcpd.com', 'Edward123', 'Edward', 'Dewey', 1);
INSERT INTO users VALUES(18,'Joseph@rcpd.com', 'Joseph123', 'Joseph', 'Frost', 1);
INSERT INTO users VALUES(19,'Enrico@rcpd.com', 'Enrico123', 'Enrico', 'Marini', 1);
INSERT INTO users VALUES(20,'Forest@rcpd.com', 'Forest123', 'Forest', 'Speyer', 1);
INSERT INTO users VALUES(21,'Kenneth@rcpd.com', 'Kenneth123', 'Kenneth', 'Speyer', 1);
INSERT INTO users VALUES(22,'Chris@rcpd.com', 'Chris123', 'Chris', 'Redfield', 1);
INSERT INTO users VALUES(23,'Jill@rcpd.com', 'Jill123', 'Jill', 'Valentine', 1);
INSERT INTO users VALUES(24,'Brad@rcpd.com', 'Brad123', 'Brad', 'Vickers', 1);
INSERT INTO users VALUES(25,'Albert@rcpd.com', 'Albert123', 'Albert', 'Wesker', 1);
INSERT INTO users VALUES(26,'Alexander@rcpd.com', 'Alexander123', 'Alexander', 'Hudson', 2);
INSERT INTO users VALUES(27,'RichardI@rcpd.com', 'Richard123', 'Richard', 'Iskra', 2);
INSERT INTO users VALUES(28,'TylerA@rcpd.com', 'TylerA123', 'Tyler', 'Atkinson', 2);
INSERT INTO users VALUES(29,'Christopher@rcpd.com', 'Christopher123', 'Christopher', 'Holmes', 2);
INSERT INTO users VALUES(30,'Beck@rcpd.com', 'Beck123', 'Beck', 'Larson', 1);
INSERT INTO users VALUES(31,'Chinedu@rcpd.com', 'Chinedu123', 'Chinedu', 'Ozodi', 1);
INSERT INTO users VALUES(32,'Marcin@rcpd.com', 'Marcin123', 'Marcin', 'Salamon', 1);
INSERT INTO users VALUES(33,'Eddie@rcpd.com', 'Eddie', 'Eddie', 'Grays', 1);
INSERT INTO users VALUES(34,'Stephen@rcpd.com', 'Stephen', 'Stephen', 'Hong', 1);
INSERT INTO users VALUES(35,'Alex@rcpd.com', 'Alex', 'Alex', 'Moraga', 2);
INSERT INTO users VALUES(36,'Jasmine@rcpd.com', 'Jasmine', 'Jasmine', 'Onwuzulike', 2);
INSERT INTO users VALUES(37,'Alicia@rcpd.com', 'Alicia', 'Alicia', 'Douglas', 2);
INSERT INTO users VALUES(38,'Chester@rcpd.com', 'Chester', 'Chester', 'Gilfillian', 2);
INSERT INTO users VALUES(39,'Drake@rcpd.com', 'Drake', 'Drake', 'Mapel', 2);
INSERT INTO users VALUES(40,'Humphrey@rcpd.com', 'Humphrey', 'Humphrey', 'Minott', 2);
INSERT INTO users VALUES(41,'Joey@rcpd.com', 'Joey', 'Joey', 'Shannon', 2);
INSERT INTO users VALUES(43,'Joshua@rcpd.com', 'Joshua', 'Joshua', 'Maciejewski', 2);
INSERT INTO users VALUES(44,'Nisat@rcpd.com', 'Nisat', 'Nisat', 'Chowdhury', 2);
INSERT INTO users VALUES(45,'Obosa@rcpd.com', 'Obosa', 'Obosa', 'Obosa', 2);
INSERT INTO users VALUES(46,'Rhys@rcpd.com', 'Rhys', 'Rhys', 'Yamasaki', 2);
INSERT INTO users VALUES(47,'Tosin@rcpd.com', 'Tosin', 'Tosin', 'Tosin', 2);
INSERT INTO users VALUES(42,'Steven@rcpd.com', 'Steven', 'Steven', 'Kelsey', 1);

SELECT * FROM users;
COMMIT;
--SEQUENCE FOR users TABLES
CREATE SEQUENCE users_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

--TRIGGER for users_seq for users TABLES
CREATE OR REPLACE TRIGGER users_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
    IF :new.u_id IS NULL THEN
        SELECT users_seq.nextval INTO :new.u_id FROM DUAL;
    END IF;
END;
/

--For my Position TABLE
DROP TABLE position;

INSERT INTO position VALUES(1, 'Manager');
INSERT INTO position VALUES(2, 'Employee');
SELECT * FROM position;
COMMIT;

--For my Reimbursement TABLE
DROP TABLE reimbursement;

INSERT INTO reimbursement (R_Id, Emp_U_Id, Mgr_U_Id, Amt, Timesubmission, Rq_Type_Id, Rq_Status_Id)
VALUES(1, 1, 1, 25.00, CURRENT_TIMESTAMP, 1, 1);

--inserting pending reimbursements
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(35, 4, 'First Aid Spray', 4);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(7, 6, 'Ink Ribbon(s)', 5);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(40, 1, 'Rocket Launcher', 2);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(40, 1, 'Hexagon Crank', 5);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(3, 1, 'Magnum Revolver', 2);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(12, 1, 'Star Crest', 5);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(7, 1, 'Lock Pick', 5);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(41, 8, 'Flash Grenade(s)', 2);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(47, 1, 'Barrys 44 Magnum', 2);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(47, 12, 'Magnum Rounds', 3);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(9, 14, 'Acid Shells', 3);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(9, 1, 'Grenade Launcher', 2);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(9, 1, 'Assult Shotgun', 2);
INSERT INTO reimbursement ( Emp_U_Id, Amt, Description, Rq_Type_Id)
VALUES(9, 5, 'Old Key(s)', 5);

--inserting approved reimbursements
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(4, 1, 1, 'Samurai Edge', 2, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(6, 42, 1, 'Broken Shotgun', 5, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(4, 31, 1, 'Moonlight Sonata', 5, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(2, 42, 1, 'Shield Key', 5, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(8, 42, 2, 'Empty Bottle(s)', 5, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(44, 25, 5, 'Green Herb(s)', 4, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(12, 34, 2, 'Mixed Herbs (G+R)', 4, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(12, 34, 1, 'Mixed Herbs (G+R)', 4, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(35, 23, 1, 'Closet Key', 5, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(40, 24, 1, 'Handgun', 2, 2);
INSERT INTO reimbursement ( Emp_U_Id, Mgr_U_Id, Amt, Description, Rq_Type_Id, Rq_Status_Id)
VALUES(41, 42, 1, 'Red Gemstone', 5, 2);


update reimbursement SET mgr_u_id = 1 WHERE r_id = 41; 
SELECT * FROM reimbursement;
COMMIT;

--Altering reimbursements table
ALTER TABLE reimbursement MODIFY Mgr_U_Id null; 
ALTER TABLE reimbursement MODIFY Timesubmission DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE reimbursement MODIFY Rq_Status_Id DEFAULT (1);
 
--SEQUENCE FOR Reimbursement TABLES
CREATE SEQUENCE reimbursement_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

--TRIGGER for reimbursement_seq for reimbursement TABLES
CREATE OR REPLACE TRIGGER reimbursement_seq_trigger
BEFORE INSERT ON reimbursement
FOR EACH ROW 
BEGIN
    IF :new.r_id IS NULL THEN
        SELECT reimbursement_seq.nextval INTO :new.r_id FROM DUAL;
    END IF;
END;
/

--For my Request Type TABLE
DROP TABLE rq_type;

INSERT INTO rq_type VALUES (1, 'food');
INSERT INTO rq_type VALUES (2, 'Weapons');
INSERT INTO rq_type VALUES (3, 'Ammunition');
INSERT INTO rq_type VALUES (4, 'Health');
INSERT INTO rq_type VALUES (5, 'Misc');

SELECT * FROM rq_type;

--For my Request Status TABLE(no more values needed)
DROP TABLE rq_status;

INSERT INTO rq_status VALUES (1, 'Pending');
INSERT INTO rq_status VALUES (2, 'Approved');
INSERT INTO rq_status VALUES (3, 'Denied');
SELECT * FROM rq_status;

--JOINS 

--For my getReimbursements()
SELECT * FROM Reimbursement
INNER JOIN Rq_Status 
    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id
INNER JOIN Rq_Type
    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Type_Id; 

--For my getPendingReimbursements()
SELECT * FROM Reimbursement
INNER JOIN Rq_Status 
    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id
INNER JOIN Rq_Type
    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Status_Id
WHERE Reimbursement.Rq_Status_Id = 1;

--For my getPendingReimbursementsById()
SELECT * FROM Reimbursement
INNER JOIN Rq_Status 
    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id
INNER JOIN Rq_Type
    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Status_Id
WHERE Reimbursement.Rq_Status_Id = 1 AND Reimbursement.Emp_U_Id = 35;

--For my getApprovedReimbursements()
SELECT * FROM Reimbursement
INNER JOIN Rq_Status 
    ON Rq_Status.Rq_Status_Id = Reimbursement.Rq_Status_Id
INNER JOIN Rq_Type
    ON Rq_Type.Rq_Type_Id = Reimbursement.Rq_Status_Id
WHERE Reimbursement.Rq_Status_Id = 2; 

--Creating a new reimbursement(This is an attempt, not compiled yet)
CREATE PROCEDURE Create_Reimbursement (R_Id IN NUMBER, Amt IN NUMBER, Img IN BLOB, Description IN VARCHAR2, Rq_Type_Id IN NUMBER)
IS 
BEGIN
    INSERT INTO reimbursement(Emp_U_Id, Amt, Description, Img, Timesubmission, Rq_Type_Id, Rq_Status_Id)
    VALUES (Emp_U_Id, Amt, Img, Description, Rq_Type_Id, CURRENT_TIMESTAMP);
END;
/
