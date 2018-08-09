--DDL: Data Definition Language
DROP TABLE users;
DROP TABLE task;
DROP TABLE task_status;

CREATE TABLE users(
u_id INT,
username VARCHAR2(40) UNIQUE NOT NULL,
PW VARCHAR2(100) NOT NULL,
PRIMARY KEY (u_id)
);

CREATE TABLE task(
t_id INT,
u_id INT NOT NULL,
t_name VARCHAR2(4000) NOT NULL,
ts_id INT,
PRIMARY KEY (t_id),
FOREIGN KEY (u_id) REFERENCES users (u_id),
FOREIGN KEY (ts_id) REFERENCES task_status (ts_id)
);

CREATE TABLE task_status(
ts_id INT,
ts_level VARCHAR2(100) UNIQUE NOT NULL,
PRIMARY KEY (ts_id)
);

--add seq & trigger
CREATE SEQUENCE task_seq
    START WITH 1
    INCREMENT BY 1;

--when a user creates a new task insert a new ID from the seq
CREATE OR REPLACE TRIGGER task_trig
BEFORE INSERT ON task
FOR EACH ROW
BEGIN
    IF :new.t_id IS NULL THEN
        SELECT task_seq.nextval INTO :new.t_id FROM DUAL;
    END IF;
END;
/

--add users
INSERT INTO users VALUES(1, 'Steve', '123');
INSERT INTO users VALUES(55, 'Mary', '555');
INSERT INTO users VALUES(60, 'Tom', '567');

SELECT * FROM users;

--add task_status
INSERT INTO task_status VALUES(1, 'Pending');
INSERT INTO task_status VALUES(2, 'Completed');
INSERT INTO task_status VALUES(3, 'Cancelled');

SELECT * FROM task_status;

--add some tasks using the trig/seq
--Steve's tasks
INSERT INTO task(u_id, t_name, ts_id) VALUES(1, 'read a book', 1);
INSERT INTO task(u_id, t_name, ts_id) VALUES(1, 'go for a run', 1);
INSERT INTO task(u_id, t_name, ts_id) VALUES(1, 'go rock climbing', 2);

--Mary's tasks
INSERT INTO task(u_id, t_name, ts_id) VALUES(55, 'go shopping', 2);
INSERT INTO task(u_id, t_name, ts_id) VALUES(55, 'walk my dog', 2);
INSERT INTO task(u_id, t_name, ts_id) VALUES(55, 'go on a hike', 1);

--Tom's tasks
INSERT INTO task(u_id, t_name, ts_id) VALUES(60, 'write a novel', 3);
INSERT INTO task(u_id, t_name, ts_id) VALUES(60, 'go on a walk', 2);
INSERT INTO task(u_id, t_name, ts_id) VALUES(60, 'read harry potter', 1);

SELECT * FROM task;

COMMIT;