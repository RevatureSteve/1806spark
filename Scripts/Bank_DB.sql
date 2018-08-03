--user
CREATE TABLE users (
users_id INT PRIMARY KEY,
username VARCHAR2(20) UNIQUE NOT NULL,
password VARCHAR2(20) NOT  NULL,
f_name VARCHAR2(4000),
l_name VARCHAR2(4000)

)

--bank account 
CREATE TABLE bank_account (
account_number INT PRIMARY KEY,
balance NUMBER (18,2),
userss_id INT
);

--bank transaction 
CREATE TABLE bank_ts (
ts_id INT PRIMARY KEY,
ts_timestamp TIMESTAMP,
ts_amt NUMBER(18,2),
ts_type_id INT
)
--FOREIGN KEY (ts_type_id) REFERENCES (bank_ts_type. ts_type_id),
--FOREIGN KEY (account_number) REFERENCES (bank_account.account_number)



--bank transaction type
CREATE TABLE bank_ts_type (
ts_type_id INT PRIMARY KEY,
ts_type VARCHAR2(20)
);