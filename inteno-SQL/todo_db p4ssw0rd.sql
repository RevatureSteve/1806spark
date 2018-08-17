--DDL (DATA DEFINATION LANGUAGE)

-- b4 you can already 
-- you must first login to the admit account (in this case revaturechester_db)
-- then you will create new user 
--identified by passowrd
--grant user access

CREATE USER todo_db IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO todo_db;

-- create
---run this one first
CREATE TABLE users(
u_id int,
username varchar2(40) UNIQUE not null,
pw varchar2(100) not null,
primary key(u_id)
);
---run this one 3rd
CREATE TABLE task(
t_id INT,
u_id INT NOT NULL,
t_name VARCHAR(4000) NOT NULL,
ts_id int,
PRIMARY KEY(t_id),
FOREIGN KEY (u_id) REFERENCES USERS(u_id),
FOREIGN KEY (ts_id) References task_status(ts_id)
);

---run this one 2nd
create table task_status (
ts_id int,
ts_level varchar2(100) unique not null,
primary key(ts_id)

);

drop table task_status;
drop table task;
drop table users;


--create a sequence for new task
Create sequence task_seq
    start with 1
    increment by 1;

---run after you run task_seq    
create or replace trigger task_trig
 before insert on task  -- task is one of the table
    for each row 
 begin
    if:new.ts_id is null then 
      Select task_seq.nextval into :new.t_id From Dual;
    end if;
end;
/

--- add some dummy data

INSERT INTO USERS VALUES(1, 'steve', '123');
Insert Into Users Values(55, 'mary', '555');
INSERT INTO USERS VALUES(60, 'tom', '567');

select * from users;

-- add task_status
insert into task_status values(1, 'pending');
insert into task_status values(2, 'completed');
insert into task_status values(3, 'canceled');

select * from task_status;

-- add some tasks using triggers/sequence

--steve task
insert into task(u_id, t_name, ts_id)
values(1, 'read a book', 1);

insert into task(u_id, t_name, ts_id)
values(1, 'go for a run', 1);

insert into task(u_id, t_name, ts_id)
values(1, 'go rock climbing', 2);

select * from task;


--mary task
insert into task(u_id, t_name, ts_id)
values(55, 'go shopping', 2);

insert into task(u_id, t_name, ts_id)
values(55, 'walk my dog', 2);

insert into task(u_id, t_name, ts_id)
values(55, 'go n the bike', 1);

--tom task
insert into task(u_id, t_name, ts_id)
values(60, 'write a novel', 3);

insert into task(u_id, t_name, ts_id)
values(60, 'go for a walk', 2);

insert into task(u_id, t_name, ts_id)
values(60, 'read harry potter', 1);

