--Insert into positons.
INSERT INTO position VALUES (1, 'Manager');
INSERT INTO position VALUES (2, 'Employee');

--Insert into users.(
INSERT INTO users
VALUES
(001, 'M', '.', 'm@bss.com', 'm', 1);
INSERT INTO users
VALUES
(002, 'Sean', 'Connery', 'sc@bss.com', '02', 2);
INSERT INTO users
VALUES
(003, 'Roger', 'Moore', 'rm@bss.com', '03', 2);
INSERT INTO users
VALUES
(004, 'Pierce', 'Brosan', 'pb@bss.com', '04', 2);
INSERT INTO users
VALUES
(007, 'Daniel', 'Craig', 'dc@bss.com', '07', 2);
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
(04, 'Gadgets');
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
(001,20000, 'Goldfinger','01-JAN-63',002, 1, 1, 2);
INSERT INTO reimbursement
VALUES 
(002, 10000, 'Moonraker', '01-JUL-79', 003, 1, 4,2);
INSERT INTO reimbursement
VALUES 
(003, 50000, 'Goldeneye', '01-MAY-95', 004, 1, 2 ,2);
INSERT INTO reimbursement
VALUES 
(004, 100000, 'Skyfall', '01-JAN-12', 007, 1, 1,3);
INSERT INTO reimbursement
VALUES 
(005, 10000, 'Spectre', '01-AUG-15', 007, 1, 3,1);
commit;