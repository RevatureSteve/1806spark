-- DDL for media_db


drop table actor;
-- Always want a primary key, somekind of unique identifier
-- after you specify attributes add constraints
-- Primary key = Unique, not null, never change
CREATE TABLE actor(
actor_id INT,
name VARCHAR2 (4000) NOT NULL UNIQUE,
film VARCHAR2 (4000),
birth_day DATE,
years_acting INT DEFAULT 0,
PRIMARY KEY (actor_id)
);

-- ALTER name can be broken down to first_name last_name

ALTER TABLE actor
ADD(first_name VARCHAR2(4000), last_name VARCHAR(4000));

ALTER TABLE actor 
DROP(name);

TRUNCATE TABLE actor;

-- Make another table
CREATE TABLE role (
role_id INT,
role_name VARCHAR2 (100),
PRIMARY KEY (role_id)
);


CREATE TABLE actor_role(

    --Take the primary key of both tables
    actor_id INT,
    role_id INT,
    
    -- The primary key here will be made up of 2 or more columns that will be identified as the primary key is called a composite key
    -- Junction/Join table usually have a composite key
    PRIMARY KEY(actor_id, role_id),
    --Now state that the 2 columns are foreigh keys
    -- Foreign key is a primary key in another table
    FOREIGN KEY (actor_id) REFERENCES actor(actor_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
    -- FOREIGN KEY (this table's col_name)
                -- REFENCES table_name(priamry key table's colum_name)
)






























































