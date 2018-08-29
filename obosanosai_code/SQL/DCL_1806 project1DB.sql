--need a seperate schema for ERS assignment
--create a user
CREATE USER project1_db IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO project1_db;
--remember to set DBA permissions too;