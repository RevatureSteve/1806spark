--need a seperate schema for bank asgn.
--ceate a user

CREATE USER bank_db IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO bank_DB;

-- remember to give permissions