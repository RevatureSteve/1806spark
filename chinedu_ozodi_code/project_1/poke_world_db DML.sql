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

-- WORLD TILES

SELECT * FROM world_tiles wt
RIGHT OUTER JOIN wt_types wtt on (wt.wt_type_id = wtt.wt_type_id);
WHERE email = 'chin2413@gmail.com';

-- LOCAL TILES

SELECT * FROM local_tiles lt
RIGHT OUTER JOIN lt_types ltt on (lt.lt_type_id = ltt.lt_type_id);
WHERE email = 'chin2413@gmail.com';
