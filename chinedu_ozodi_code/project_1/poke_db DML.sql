-- POSITION
INSERT INTO position VALUES (1,'trainer');
INSERT INTO position VALUES (2,'manager');
-- RQ STATUS
INSERT INTO rq_status VALUES (1,'sent');
INSERT INTO rq_status VALUES (2,'processing');
INSERT INTO rq_status VALUES (3,'rejected');
INSERT INTO rq_status VALUES (4,'approved');
-- RQ TYPE
INSERT INTO rq_type VALUES (1,'pokemon');
INSERT INTO rq_type VALUES (2,'berry');
INSERT INTO rq_type VALUES (3,'pokeball');
-- USERS
COMMIT;
INSERT INTO users(email,password,fname,lname,pos_id) VALUES ('chin2413@gmail.com','p4ssw0rd','Chinedu','Chinedu',2);
INSERT INTO users(email,password,fname,lname,pos_id) VALUES ('chin2413@gmail.com','p4ssw0rd','Chinedu','Ozodi',2);
DELETE FROM users WHERE email = 'chin2413@gmail.com';
Commit;
SELECT * FROM users u
RIGHT OUTER JOIN position p on (u.pos_id = p.pos_id)
WHERE email = 'chin2413@gmail.com';
SELECT * FROM users u INNER JOIN position p ON u.pos_id = p.pos_id;

-- REIMBURSEMENT
SELECT * FROM reimbursement r RIGHT OUTER JOIN rq_status rs ON (r.rq_status_id = rs.rq_status_id) INNER JOIN rq_type rt ON (r.rq_type_id = rt.rq_type_id);
SELECT * FROM reimbursement r RIGHT OUTER JOIN rq_status rs ON (r.rq_status_id = rs.rq_status_id) JOIN rq_type rt ON (r.rq_type_id = rt.rq_type_id)
JOIN users u ON (r.emp_u_id = u.u_id) LEFT OUTER JOIN users m ON (r.mgr_u_id = m.u_id);