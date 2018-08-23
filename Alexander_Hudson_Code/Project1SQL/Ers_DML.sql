--USERS

--SEQUENCE to increment/assign user id
CREATE SEQUENCE users_seq
START WITH 1
INCREMENT BY 5;

--Trigger for creating u_id
CREATE OR REPLACE TRIGGER users_seq_trigger
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
    IF :new.u_id IS NULL THEN
        SELECT users_seq.nextval INTO :new.u_id FROM DUAL;
    END IF;
END;
/

INSERT INTO users VALUES (1, 'evilMorty@emporium.com', 'EvilMorty', 'Evil', 'Morty', 1);
INSERT INTO users VALUES (3, 'TinyRick@emporium.com', 'ImTinyRick!', 'Tiny', 'Rick', 2);
INSERT INTO users VALUES (4, 'Pickle@emporium.com', 'ImPickleRick!', 'Pickle', 'Rick', 2);
INSERT INTO users VALUES (5, 'SlowJamz@emporium.com', 'Jamming', 'Slow Jamz', 'Rick', 2);
INSERT INTO users VALUES (6, 'yeehaw@emporium.com', 'CowLife', 'Cowboy', 'Rick', 2);
INSERT INTO users VALUES (7, 'weird@emporium.com', 'SuperWeird', 'Super Weird', 'Rick', 2);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--REIMBURSEMENT 

--Sequence to handle incrementing new r_id
CREATE SEQUENCE r_id_seq
START WITH 1
INCREMENT BY 1;

--Trigger for incrementing r_id if null value
CREATE OR REPLACE TRIGGER r_id_seq_trigger
BEFORE
INSERT ON reimbursement
FOR EACH ROW
BEGIN 
    IF :new.r_id IS NULL THEN SELECT 
            r_id_seq.nextval INTO :new.r_id FROM DUAL;
        END IF;
    END;
 / 

--modifying the reimbursement table
ALTER TABLE reimbursement MODIFY mgr_u_id null; 
ALTER TABLE reimbursement MODIFY time_submission DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE reimbursement MODIFY rq_status_id DEFAULT (2);

--Insert into reimbursement table
INSERT INTO reimbursement values (2, 2, 0, 1, 'Morty was vaporized', null, CURRENT_TIMESTAMP, 2, 1);
INSERT INTO reimbursement values (3, 2, null, 3 , 'I lost him somewhere around here...', null, CURRENT_TIMESTAMP, 15, 3);
INSERT INTO reimbursement values (2, 2, null, 1, 'Forgot to warn him about Mr.Meeseeks dark side', null, CURRENT_TIMESTAMP, 11, 2);


commit;