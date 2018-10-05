CREATE TABLE users(

    user_id INT,
    name VARCHAR(4000) NOT NULL,
    sex VARCHAR(4000),
    smoking INT,
    pwv INT,
    ekg INT
    PRIMARY KEY (user_id),
    FOREIGN KEY (smoking) REFERENCES smoker_status (s_id),
    FOREIGN KEY (ekg) REFERENCES ekg_value (ekg_id),
    FOREIGN KEY (pwv) REFERENCE pwv_value (pwv_id)

);

CREATE TABLE smoker(

    s_id INT,
    status VARCHAR2(4000) UNIQUE NOT NULL,
    PRIMARY KEY (s_id)

);

CREATE TABLE ekg_values(

    ekg_id INT, 
    ekg_value VARCHAR(4000),
    PRIMARY KEY (ekg_id)

);

INSERT INTO smoker VALUES (1, 'smoker');
INSERT INTO smoker VALUES (2, 'non-smoker');