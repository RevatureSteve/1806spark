CREATE SEQUENCE task_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER task_trigger
BEFORE INSERT ON TASK 
FOR EACH ROW
BEGIN
    IF :new.t_id IS NULL THEN
        SELECT task_seq.nextval
        INTO :new.t_id FROM dual;
    END IF;
END;
/

INSERT INTO users VALUES(1, 'Marcin', '123');
INSERT INTO users VALUES(2, 'Mary', 'qwerty');
INSERT INTO users VALUES(3, 'John', 'wow');

SELECT * FROM users;

INSERT INTO task(u_id, t_name, ts_id) VALUES (1, 'read a book', 1);
INSERT INTO task(u_id, t_name, ts_id) VALUES (1, 'go for a run', 1);
INSERT INTO task(u_id, t_name, ts_id) VALUES (1, 'go climb', 2);

INSERT INTO task(u_id, t_name, ts_id) VALUES (2, 'go shopping', 1);
INSERT INTO task(u_id, t_name, ts_id) VALUES (2, 'walk my dog', 1);
INSERT INTO task(u_id, t_name, ts_id) VALUES (2, 'go on a hike', 2);

INSERT INTO task(u_id, t_name, ts_id) VALUES (3, 'write a novel', 3);
INSERT INTO task(u_id, t_name, ts_id) VALUES (3, 'go on a walk', 2);
INSERT INTO task(u_id, t_name, ts_id) VALUES (3, 'read Harry Potter', 1);

INSERT INTO task_status VALUES (1, 'pending');
INSERT INTO task_status VALUES (2, 'done');
INSERT INTO task_status VALUES (3, 'cancelled');

SELECT * FROM task;