--DDL for BankDB

--USER
CREATE TABLE users (
users_id INT,
username VARCHAR2(20) UNIQUE NOT NULL,
password VARCHAR2(20) NOT NULL,
fname VARCHAR2(4000),
lname VARCHAR2(4000),
PRIMARY KEY(users_id)
);

--BANK ACCOUNT
CREATE TABLE bank_account(
account_number INT,
balance NUMBER(18,2),
users_id INT,
PRIMARY KEY(account_number),
FOREIGN KEY(users_id) REFERENCES users(users_id)
);

--Bank Transaction
CREATE TABLE bank_tx(
tx_id INT,
tx_timestamp TIMESTAMP,
tx_amt NUMBER(18,2),
tx_type_id INT,
account_number INT,
PRIMARY KEY(tx_id),
FOREIGN KEY(tx_type_id) REFERENCES bank_tx_type(tx_type_id),
FOREIGN KEY(account_number) REFERENCES bank_account(account_number)
);

--Bank Transaction Type
CREATE TABLE bank_tx_type(
tx_type_id INT,
tx_type VARCHAR2(20),
PRIMARY KEY(tx_type_id)
);

--DML for BankDB

--Users
INSERT INTO users VALUES(1, 'Hotshirt', 'butter', 'Eddie', 'Grays');
INSERT INTO users VALUES(2, 'TheSnake', 'venom', 'Kevin', 'Durant');
INSERT INTO users VALUES(3, 'TheKing', 'crown', 'Lebron', 'James');

--Bank Accounts
INSERT INTO bank_account VALUES(1, 300.50, 1);
INSERT INTO bank_account VALUES(2, 26540000.66, 2);
INSERT INTO bank_account VALUES(3, 35650000.33, 3);

--Testing
SELECT * FROM users
WHERE username = 'Hotshirt' AND password = 'butter';

SELECT balance FROM bank_account
WHERE users_id = 1;

CREATE OR REPLACE PROCEDURE deposit_trans(id_num IN INT, deposit_amount IN NUMBER)
IS
BEGIN
UPDATE bank_account
SET balance = (SELECT balance FROM bank_account WHERE users_id = id_num) + deposit_amount
WHERE balance = (SELECT balance FROM bank_account WHERE users_id = id_num);
COMMIT;
END;
/

CALL deposit_trans(2, 1);

CREATE OR REPLACE PROCEDURE withdraw_trans(id_num IN INT, withdraw_amount IN NUMBER)
IS
BEGIN
UPDATE bank_account
SET balance = (SELECT balance FROM bank_account WHERE users_id = id_num) - withdraw_amount
WHERE balance = (SELECT balance FROM bank_account WHERE users_id = id_num);
COMMIT;
END;
/

CALL withdraw_trans(2,1);

COMMIT;

