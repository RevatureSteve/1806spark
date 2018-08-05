--DDL for media_db

DROP TABLE actor;

CREATE TABLE actor (
actor_id INT,
name VARCHAR2(4000) NOT NULL UNIQUE,
film VARCHAR2(4000),
birthday DATE,
years_acting INT DEFAULT 0,
PRIMARY KEY (actor_id)
);

-- ALTER... name can be broken down to first_name, last_name
ALTER TABLE actor
ADD (first_name VARCHAR2(4000),last_name VARCHAR2(4000));

ALTER TABLE actor
DROP (name);

TRUNCATE TABLE actor;

-- make another table
CREATE TABLE role (
role_id INT,
role_name VARCHAR2(100),
PRIMARY KEY (role_id)
);

-- Create a junction/join table to show the relationship between actors and roles
-- They typically follow the naming convention: table1_table2
    CREATE TABLE actor_role(
    -- primary key of both tables
    actor_id INT,
    role_id INT,
    --2 or more column tha will be identified as the primary key is called a composite key
    -- Junction/Join table usually have a composite key
    PRIMARY KEY(actor_id, role_id),
    -- Now state that the 2 columns are Foreign Keys
    -- Foreign Key is a primary key in another table
    FOREIGN KEY (actor_id) REFERENCES actor(actor_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
    -- FOREIGN KEY (this table's col_name) REFERENCES table_name(primary key col_name)
);

-- Insert roles for actors
INSERT INTO actor_role VALUES(1,4);
INSERT INTO actor_role VALUES(2,5);
INSERT INTO actor_role VALUES(2,1);

--We now have relationships for actors and roles but how can we view them
--Using SQ; Joins: joing 2 or more tables for a ResultSet
-- Only join on primary key foreign key relationships!
SELECT a.first_name, a.last_name, a.film, r.role_name FROM actor a
INNER JOIN actor_role ar ON a.actor_id = ar.actor_id
INNER JOIN role r ON ar.role_id = r.role_id;
