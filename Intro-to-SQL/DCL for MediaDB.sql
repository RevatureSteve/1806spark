-- DCL: Data Contorl Language heavily used by DBAs (Database administrators)
-- boilerplate code that you'll always need to use to create a user:
CREATE USER media_db IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO media_db;