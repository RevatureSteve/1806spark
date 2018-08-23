-- TABLES
DROP TABLE worlds;
ALTER TABLE worlds
    ADD (width INT, length INT);
CREATE TABLE worlds (
    world_id INT,
    length INT,
    width INT,
    world_name VARCHAR2(100),
    PRIMARY KEY (world_id)
);

CREATE TABLE world_tiles (
    wt_id INT,
    wt_name VARCHAR2(100),
    world_x INT,
    world_y INT,
    wt_type_id INT,
    world_id INT,
    PRIMARY KEY (wt_id),
    FOREIGN KEY (world_id) REFERENCES worlds(world_id),
    FOREIGN KEY (wt_type_id) REFERENCES wt_types(wt_type_id)
);

CREATE TABLE local_tiles (
    lt_id INT,
    wt_id INT,
    local_x INT,
    local_y INT,
    lt_type_id INT,
    PRIMARY KEY (lt_id),
    FOREIGN KEY (wt_id) REFERENCES world_tiles(wt_id),
    FOREIGN KEY (lt_type_id) REFERENCES lt_types(lt_type_id)
);

CREATE TABLE wt_types (
    wt_type_id INT,
    wt_type VARCHAR2(100),
    PRIMARY KEY (wt_type_id)
);

CREATE TABLE lt_types (
    lt_type_id INT,
    lt_type VARCHAR2(100),
    PRIMARY KEY (lt_type_id)
);

TRUNCATE TABLE pokemon_data;
CREATE TABLE pokemon_data (
    poke_id INT,
    poke_name VARCHAR2(100),
    base_experience INT,
    height INT,
    img_url VARCHAR2(4000),
    PRIMARY KEY (poke_id)
);
DROP TABLE pokemon;
CREATE TABLE pokemon (
    p_id INT,
    pd_id INT,
    poke_name VARCHAR2(100),
    experience INT,
    p_status_id INT DEFAULT 1,
    lt_id INT,
    trainer_id INT,   
    PRIMARY KEY (p_id),
    FOREIGN KEY (lt_id) REFERENCES local_tiles(lt_id),
    FOREIGN KEY (trainer_id) REFERENCES pokemon_trainers(trainer_id),
    FOREIGN KEY (pd_id) REFERENCES pokemon_data(poke_id),
    FOREIGN KEY (p_status_id) REFERENCES pokemon_status(p_status_id)
);

CREATE TABLE pokemon_status (
    p_status_id INT,
    p_status VARCHAR2(100),
    PRIMARY KEY (p_status_id)
);

CREATE TABLE pokemon_trainers (
    trainer_id INT,
    trainer_name VARCHAR2(100),
    pokeball_count INT,
    candy_count INT,
    PRIMARY KEY (trainer_id)
);