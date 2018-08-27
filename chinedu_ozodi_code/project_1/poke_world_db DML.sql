-- POKEMON STATUS
INSERT INTO pokemon_status VALUES (1, 'wild');
INSERT INTO pokemon_status VALUES (2, 'captured');
INSERT INTO pokemon_status VALUES (3, 'transfered');
INSERT INTO pokemon_status VALUES (4, 'inactive');

-- WORLD TILE TYPES
INSERT INTO wt_types VALUES (1, 'grassland');
INSERT INTO wt_types VALUES (2, 'city');
INSERT INTO wt_types VALUES (3, 'path');
INSERT INTO wt_types VALUES (4, 'water');

Commit;

-- LOCAL TILE TYPES
INSERT INTO lt_types VALUES (1, 'grass');
INSERT INTO lt_types VALUES (2, 'path');
INSERT INTO lt_types VALUES (3, 'building');
INSERT INTO lt_types VALUES (4, 'tree');
INSERT INTO lt_types VALUES (5, 'water');

-- POKEMON DATA
SELECT * FROM pokemon_data;
UPDATE pokemon_data SET poke_id = 1 WHERE poke_id = 0;
COMMIT;
-- POKEMON
SELECT * FROM pokemon;
SELECT * FROM pokemon p RIGHT OUTER JOIN pokemon_data pd ON (p.pd_id = pd.poke_id) RIGHT OUTER JOIN pokemon_status ps ON (p.p_status_id = ps.p_status_id) WHERE trainer_id = 6;
SELECT * FROM pokemon p 
RIGHT OUTER JOIN pokemon_data pd ON (p.pd_id = pd.poke_id)
RIGHT OUTER JOIN pokemon_status ps ON (p.p_status_id = ps.p_status_id)
WHERE lt_id = (SELECT lt_id FROM local_tiles WHERE wt_id = 54 AND local_x = 2 AND local_y = 2);
UPDATE pokemon SET trainer_id = 6, lt_id = NULL, p_status_id = 2 WHERE trainer_id = 6;
COMMIT;
SELECT * FROM pokemon WHERE trainer_id = 6;
UPDATE pokemon p SET p.poke_name = (SELECT poke_name FROM pokemon_data pd WHERE pd.poke_id = p.pd_id); 
-- WORLD TILES
SELECT * FROM world_tiles WHERE world_id = 5 ORDER BY world_x, world_y;
SELECT * FROM world_tiles wt RIGHT OUTER JOIN wt_types wtt on (wt.wt_type_id = wtt.wt_type_id) WHERE (world_x = 0 AND world_y = 0);
SELECT * FROM world_tiles wt RIGHT OUTER JOIN wt_types wtt on (wt.wt_type_id = wtt.wt_type_id) WHERE world_id = 5 ORDER BY world_y, world_x;
COMMIT;
-- LOCAL TILES
SELECT * FROM local_tiles lt RIGHT OUTER JOIN lt_types ltt on (lt.lt_type_id = ltt.lt_type_id) WHERE wt_id = ? AND local_x = ? AND local_y = ?;
