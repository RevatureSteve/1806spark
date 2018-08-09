--DDL: DATA DEFINITION LANGUAGE

CREATE TABLE users(
u_id INT,
username VARCHAR(20) UNIQUE NOT NULL, 
pw VARCHAR(100) NOT NULL,
PRIMARY KEY (u_id)
);

CREATE TABLE task (
t_id INT,
u_id INT NOT NULL,
t_name VARCHAR2(4000) NOT NULL,
ts_id INT NOT NULL,
PRIMARY KEY (t_id),
FOREIGN KEY (u_id) REFERENCES users(u_id),
FOREIGN KEY (ts_id) REFERENCES task_status(ts_id)
);

CREATE TABLE task_status (
ts_id Int,
ts_level  VARCHAR(100) UNIQUE NOT NULL, 
PRIMARY KEY (ts_id)
);

--Add seq and trigger for new tasks
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

-- dummy data
INSERT INTO users VALUES(1, 'steve', '123');
INSERT INTO users VALUES(55, 'Mary', '555');
INSERT INTO users VALUES(60, 'tom', '567');

SELECT * FROM users;

--add task_status
INSERT INTO task_status VALUES(1, 'pending');
INSERT INTO task_status VALUES(2, 'completed');
INSERT INTO task_status VALUES(3, 'cancelled');

SELECT * FROM task_status;

--add some tasks using the trig/seq
--steve's tasks
INSERT INTO task(u_id, t_name, ts_id) VALUES(1, 'read a book',1);
INSERT INTO task(u_id, t_name, ts_id) VALUES(1, 'go for a run',1);
INSERT INTO task(u_id, t_name, ts_id) VALUES(1, 'go rock-climbing',2);

--mary's tasks
INSERT INTO task(u_id, t_name, ts_id) VALUES(55, 'go shopping',2);
INSERT INTO task(u_id, t_name, ts_id) VALUES(55, 'go shopping',2);
INSERT INTO task(u_id, t_name, ts_id) VALUES(55, 'go on a hike',1);

--tom's task
INSERT INTO task(u_id, t_name, ts_id) VALUES(60, 'write a novel',3);
INSERT INTO task(u_id, t_name, ts_id) VALUES(60, 'go on a walk',2);
INSERT INTO task(u_id, t_name, ts_id) VALUES(60, 'read harry potter',1);

SELECT * FROM task;
COMMIT;
