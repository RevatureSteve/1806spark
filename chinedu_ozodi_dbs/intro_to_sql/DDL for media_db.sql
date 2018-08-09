--DDL for media_db
DROP TABLE actor;
CREATE TABLE actor (
actor_id INT,
name VARCHAR2(4000) NOT NULL,
film VARCHAR2(4000),
birth_day DATE,
years_acting INT DEFAULT 0,
PRIMARY KEY (actor_id)
);

--ALTER..name can e broken down to first_name, last_name
ALTER TABLE actor
ADD (first_name VARCHAR(4000), last_name VARCHAR(4000));

ALTER TABLE actor
DROP (name);

-- make another table
CREATE TABLE role (
role_id INT,
role_name VARCHAR2(100),
PRIMARY KEY (role_id)
);

SELECT chinook.get_current_time FROM DUAL;

--Create junction/join table to show the relationship between actors and roles
CREATE TABLE actor_role(
    --take the primary key of both tables
    actor_id INT,
    role_id INT,
    -- 2 or moore columns that will be identified as teh primary key is called a composite key
    -- Jucntion/Join table usually have a composite key
    PRIMARY KEY(actor_id,role_id),
    -- Now stat that the 2 columns are foreihn keys
    -- Foreign Key is a primary key in another table
    FOREIGN KEY (actor_id) REFERENCES actor(actor_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
    -- Foreign Key (this table's col) REFERENCES table_name (primary key col_name)
);