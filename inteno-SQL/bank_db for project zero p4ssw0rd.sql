


----------------BANK---------------
-- need to seperate schema for bank account
-- create user
----------dcl
CREATE USER bank_db IDentified by p4ssw0rd;
GRANT CONNECT, RESOURCE TO bank_db;


--follow user requirement 
-----------user--------------
create table users (
users_id int,
username varchar2(20) unique not null,
password varchar2(20) not null,
fname varchar2(4000),
lname varchar2(4000),
primary key(users_id) );


----------------------------bank account
create table bank_account (
account_number int,
balance number(18,2),
users_id int,
primary key (account_number),
foreign key (users_id) REFERENCES USERS(users_id) );

------------bank transaction
CREATE TABLE bank_tx (
tx_id int,
tx_timestamp TIMESTAMP,
tx_amount number(18,2),
tx_type_id int,
account_number int,
primary key(tx_id),
FOREIGN KEY (account_number)references bank_account(account_number),
foreign key (tx_type_id) references bank_tx_type(tx_type_id) );

------------transaction type
create table bank_tx_type (
tx_type_id int,
tx_type varchar2(20),
primary key(tx_type_id) );


