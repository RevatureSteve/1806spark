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
CREATE TABLE bank_account (

account_number INT,
balance NUMBER(18,2),
users_id INT,
PRIMARY KEY (account_number),
FOREIGN KEY (users_id) REFERENCES users(users_id) 

);


DROP TABLE Bank_Tx;


--BANK TRANSACTION
CREATE TABLE Bank_Tx (

tx_id INT,
tx_amt NUMBER(18,2),
tx_timestamp TIMESTAMP,
tx_type_id INT,
account_number INT, 
PRIMARY KEY(tx_id),

FOREIGN KEY(account_number) REFERENCES bank_account(account_number),
FOREIGN KEY(tx_type_id) REFERENCES bank_tx_type(tx_type_id)


);


--BANK Transaction_Type
CREATE TABLE Bank_tx_type(

tx_type_id INT,
tx_type VARCHAR(20),
PRIMARY KEY (tx_type_id)

);