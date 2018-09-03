CREATE TABLE users
(
u_id INT,
username VARCHAR2(4000) UNIQUE NOT NULL,
password VARCHAR2(4000) NOT NULL,
email VARCHAR2(4000) NOT NULL,
f_name VARCHAR2(4000) NOT NULL,
l_name VARCHAR2(4000) NOT NULL
);

CREATE TABLE category
(
category_id INT,
category_name VARCHAR2(4000),
PRIMARY KEY (category_id)
);

CREATE TABLE ingredient
(
ingredient_id INT,
ingredient_name VARCHAR2(4000) NOT NULL,
PRIMARY KEY (ingredient_id)
);

CREATE TABLE recipe
(
recipe_id INT,
category_id INT,
name VARCHAR2(4000) NOT NULL,
serving_size VARCHAR2(4000) NOT NULL,
difficulty VARCHAR2(4000),
popularity VARCHAR2(4000),
prep_time INT NOT NULL,
cook_time INT NOT NULL,
img BLOB,
PRIMARY KEY (recipe_id),
FOREIGN KEY (category_id) REFERENCES category (category_id)
);


CREATE TABLE lookup
(
recipe_id INT,
ingredient_id INT,
FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id),
FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id)
);

commit;
