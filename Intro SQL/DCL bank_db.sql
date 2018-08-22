--need to separate schema for Bank assignment
--create a user
CREATE USER bank_db IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO bank_db;
--remember to set DBA permissions too