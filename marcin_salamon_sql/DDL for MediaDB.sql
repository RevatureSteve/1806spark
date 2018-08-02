--DDL for media db
DROP TABLE actor;

CREATE TABLE actor (
actor_id INT,
name VARCHAR2(4000) NOT NULL UNIQUE,
film VARCHAR2(4000),
birth_day DATE,
years_acting INT DEFAULT 0,
PRIMARY KEY (actor_id)
);

--ALTER... name can be broken down to first_name, last_name
ALTER TABLE actor
ADD ( first_name VARCHAR2(4000), last_name VARCHAR2(4000));
ALTER TABLE actor 
DROP COLUMN name;

TRUNCATE TABLE actor;

CREATE TABLE role(
role_id INT,
role_name VARCHAR2(100),
PRIMARY KEY (role_id)
);