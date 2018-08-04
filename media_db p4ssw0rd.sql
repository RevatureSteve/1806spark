--DDL for media_DB
DROP TABLE actor;

CREATE TABLE actor (
actor_id INT,
name VARCHAR2 (4000)NOT NULL UNIQUE,
film VARCHAR2 (4000),
birthday DATE,
years_acting INT DEFAULT 0,
PRIMARY KEY(actor_id)
);

---ALTER...name can be broken down further (first/last)
ALTER TABLE actor
ADD (first_name VARCHAR2(4000), last_name VARCHAR2 (4000));
--does not remove name  column
ALTER TABLE actor
DROP (name);
 

