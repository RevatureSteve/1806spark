-- DDL for media_db
-- define objects like tables

DROP TABLE ACTOR;

CREATE Table Actor (
actor_id INT, -- clear identifier of who this is.
name VARCHAR2(4000) NOT NULL UNIQUE, --max characters, NAME NOT NULLABLE
film VARCHAR2(4000),
birth_day DATE,
years_acting INT DEFAULT 0, --DEFAULTS TO 0 YEARS ACTING
PRIMARY KEY (actor_id)--specify primary key here, unique + not null, no changing
);


-- SHOW AN EXAMPLE OF ALTER: NAME CAN BE BROKEN DOWN INTO FNAME / LNAME.

ALTER TABLE actor
ADD (first_name VARCHAR2(4000), last_name VARCHAR2(4000));

ALTER TABLE actor
DROP (name);

TRUNCATE table actor;

--Make another table
CREATE TABLE role (
role_id int,
role_name VARCHAR2(100),
PRIMARY KEY(role_id)
);

--create a junction/ join table to show the relatinship between actors and roles
--they typically follow the naming convention: table_table2
CREATE TABLE actor_role ( 
--primary key for both tables
actor_id INT,
role_id INT,
--2 or more columns that will be identified
--as the primary key is called a composite key
--junction/join table usually have a composite key
PRIMARY KEY(actor_id, role_id),
--now state the 2 columns are Foreign Keys
--Foreign Key is a primary key in another table
FOREIGN KEY (actor_id) REFERENCES actor(actor_id),
FOREIGN KEY (role_id) REFERENCES role(role_id)
--FOREIGN KEY (this tables column name) REFERENCES table name(primary key column name)
);
