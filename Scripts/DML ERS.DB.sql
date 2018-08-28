--Insert into positons.
INSERT INTO position VALUES (1, 'Manager');
INSERT INTO position VALUES (2, 'Employee');

--Insert into users.(
INSERT INTO users
VALUES
(1, 'Mallory', 'Archer', 'ms@is.com', 'ma', 1);
INSERT INTO users
VALUES
(2, 'Sterling', 'Archer', 'sa@is.com', 'sa', 2);
INSERT INTO users
VALUES
(3, 'Lana', 'Kane', 'lk@is.com', 'lk', 2);
INSERT INTO users
VALUES
(4, 'Pam', 'Poovey', 'pp@is.com', 'pp', 2);
INSERT INTO users
VALUES
(7, 'Cyril', 'Figgis', 'cf@is.com', 'cf', 2);
commit;

--Insert into requst_type
INSERT INTO rq_type
VALUES
(01, 'Traning');
INSERT INTO rq_type
VALUES
(02, 'Loding/Food');
INSERT INTO rq_type
VALUES
(03, 'Travel');
INSERT INTO rq_type
VALUES
(04, 'Weapons');
commit;

--Insert into request_status
INSERT INTO rq_status 
VALUES
(1, 'Pending');
INSERT INTO rq_status
VALUES
(2, 'Approved');
INSERT INTO rq_status
VALUES
(3, 'Denied');
commit;

--Insert into reimbursement
INSERT INTO reimbursement
VALUES
(001,20000, 'Skytanic','01-JUL-16',2, 1, 1, 2);
INSERT INTO reimbursement
VALUES 
(002, 10000, 'Skytanic', '01-JUL-16', 3, 1, 4,2);
INSERT INTO reimbursement
VALUES 
(003, 50000, 'Space Race', '01-MAY-16', 2, 1, 2 ,2);
INSERT INTO reimbursement
VALUES 
(004, 100000, 'Jeu Monegasque', '01-JAN-18', 3, 1, 3,3);
INSERT INTO reimbursement
VALUES 
(005, 10000, 'Space Race', '01-AUG-17', 7, 1, 1,1);
commit;