--DDL for media_db
DROP TABLE actor;
DROP TABLE actor_role;
DROP TABLE role;

CREATE TABLE actor (
actor_id INT,
name VARCHAR2(4000) NOT NULL UNIQUE,
film VARCHAR2(4000),
birth_day DATE,
years_acting INT DEFAULT 0,
PRIMARY KEY (actor_id)
);

-- ALTER...name can be broken down to first_name, last_name
ALTER TABLE actor 
ADD ( first_name VARCHAR2(4000), last_name VARCHAR2 (4000));

ALTER TABLE actor
DROP( name );

TRUNCATE TABLE actor;


--make another table
CREATE TABLE role(
role_id INT,
role_name VARCHAR2(100),
PRIMARY KEY (role_id)
);

--create a junction/join table to show the relationshiP between actors and roles
--They will tyPically follow the naming convention: table1_table2
CREATE TABLE actor_role(
     -- Primary key of both tables
     actor_id INT,
     role_id INT,
     --2 or more coluns that will be identtified as the Primary key is called a comPosite key
     -- Junction/Join table usually have a comPosite key
     PRIMARY KEY( actor_id, role_id),
     --Now state that the 2 colunms are Foreign Keys
     --Foreign key is a Primary key in another table
     FOREIGN KEY (actor_id) REFERENCES actor(actor_id),
     FOREIGN KEY (role_id) REFERENCES role (role_id)
     --FOREIGN KEY (this tables's col_name)
     -- REFERNCES table_name(Primary key col_name)
);
