--DDL for media_db

DROP TABLE actor;
CREATE TABLE actor(
a_id INT,
name VARCHAR2(4000) NOT NULL UNIQUE,
film VARCHAR2(4000),
birth_day DATE,
years_acting INT DEFAULT 0,
PRIMARY KEY (a_id)
);


---ALTER--- name can be broken down to first_name, last_name
ALTER TABLE actor
ADD (first_name VARCHAR2(4000), last_name VARCHAR2(4000)
);

ALTER TABLE actor
DROP ( name);

TRUNCATE TABLE actor;


--MAKE ANOTHER TABLE
CREATE TABLE role (
role_id INT,
role_name VARCHAR2(100),
PRIMARY KEY (role_id)
);

--create a junction/join table to show the relationship between actors and roles
--they typically follow the naming convention: table1_table2

CREATE TABLE a_role(
--primary key of both tables
a_Id INT,
role_id INT,
--TWO OR MORE COLUMN THAT WILL BE IDENTIFIED AS THE PRIMARY KEY IS CALL A COMPOSIT KEY
--JUNCTION/JOIN TABLE USUALLY HAVE A COMPOSITE KEY
PRIMARY KEY(a_id, role_id),
--now state that the two columns are forgien keys
FOREIGN KEY(a_id) REFERENCES actor(a_id),
FOREIGN KEY(role_id) REFERENCES role(role_id)
--foreign key (this table's col) References table_name(primary key col_name)

);





