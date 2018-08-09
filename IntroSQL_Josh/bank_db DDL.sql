--User

CREATE TABLE users (
users_id INT,
username VARCHAR (20) UNIQUE NOT NULL,
password VARCHAR (20) NOT NULL,
fname VARCHAR2 (4000),
lname VARCHAR2 (4000),
PRIMARY KEY (users_id)
);


-- bank account 

CREATE TABLE bank_account (
account_number INT,
balance NUMBER(18,2),
users_id INT,
PRIMARY KEY(account_number),
FOREIGN KEY (users_id) REFERENCES users(users_id)
);


--bank transaction

CREATE TABLE bank_tx (
tx_id INT,
tx_timestamp TIMESTAMP,
tx_amt NUMBER (18,2),
tx_type_id INT,
account_number INT,
PRIMARY KEY (tx_id),
FOREIGN KEY (account_number) REFERENCES bank_account(account_number),
FOREIGN KEY (tx_type_id) REFERENCES bank_tx_type(tx_type_id)
);

--transaction type 

CREATE TABLE Bank_tx_type(
tx_type_id INT,
tx_type VARCHAR2 (20),
PRIMARY KEY (tx_type_id)
);
