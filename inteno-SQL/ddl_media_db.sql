--ddl for media

create table actor(
actor_id int,
name varchar2(4000),
film varchar2(4000),
birth_day DATE,
year_acting INT default 0, 
primary key(actor_id)
);

-- CREATE ANOTHER TABLE

create TABLE role (
role_id int,
role_name varchar2(100),
primary key(role_id));

-- add data to role which will be primarily be a look up table
insert into role VALUES (1, 'Lead');
insert into role VALUES (2, 'supporting male');
insert into role VALUES (3, 'supporting female');
insert into role VALUES (4, 'sidekick');
insert into role VALUES (5, 'villan');
SELECT * FROM role order by role_id;



alter table actor 
add (first_name varchar2(4000),
last_name varchar2(4000));

ALTER TABLE actor
DROP (name);

turncate table actor;

--create a junction/join table that show the relationship between action and role
-- they typically follow the naming convention: table1_table2
CREATE TABLE actor_role(
---primary key of both tables
role_id int,
actor_id int,
-- 2 or more column that will be identified
-- as the primary key is called a composite key
--junction/join table usually have a composite key

primary key(actor_id, role_id),
-- now state the 2 line are foreign key
-- foreign key is a primary key in a nother table

FOREIGN KEY (actor_id) REFERENCES actor(actor_id),
FOREIGN KEY (role_id) REFERENCES role(role_id)

--foreign key (this table is col_name)
-- reference tatbe_name(primary key col_name)
);

INSERT INTO actor VALUES(1,4);
INSERT INTO actor VALUES(2,5);
INSERT INTO actor VALUES(2,1);
INSERT INTO actor VALUES(1,4);

-- WE NOW HAVE A RELATIONSHIP FOR ACTOR AND ROLES BUT HOW CAN WE SHOW THEM
--USING SQL JOINS: JOINNING TWO OR MORE TABLES FOR A RESULTLIST
--ONLY JOIN ON PRIMARY KEY FOREIGN KEY RELATIONSHIP
INNER JOIN actor_role ON actor.actor_id = actor_role.role_id;
INNER JOIN 
