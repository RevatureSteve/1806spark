--DML here
-- Single quotes for strings
drop user media_db;
-----------------------------Insert (CREATE)
--All values into the row without primary key
INSERT INTO ACTOR values('Adam Sandler','Big Daddy 3', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 100.55,'20-AUG-16 07.17.54.098000000 PM');
INSERT INTO ACTOR values('Joe','Movie A', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 100.55,'20-AUG-16 07.17.54.098000000 PM');
INSERT INTO ACTOR values('Tom','Movie A', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 100.55,'20-AUG-16 07.17.54.098000000 PM');
INSERT INTO ACTOR values('Jerry','Movie B', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 100.55,'20-AUG-16 07.17.54.098000000 PM');




--Partial of row
INSERT INTO ACTOR(ACT_NAME,ACT_YEARS_IN_MEDIA) VALUES('Chris Pratt',2);


-----------------------------Select (READ)
--Select a single column
SELECT act_name FROM actor;

--Select multiple columns
--CTRL + Enter will highlighted statement or state the | is on
SELECT act_name, act_years_in_media FROM actor;

--* Will grab all columns good for testing but stick to column names that are needed
SELECT * FROM actor;

-----------------------------Update (UPDATE)
UPDATE actor
SET act_years_in_media = 25
WHERE act_years_in_media  = 100;

-----------------------------Delete (DELETE)
DELETE FROM actor
WHERE act_years_in_media = 25;


/*
AFTER BASIC
*/

--With primary keey
INSERT INTO ACTOR values(1,'Adam Sandler','Big Daddy 3', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 100.55,'20-AUG-16 07.17.54.098000000 PM');
INSERT INTO ACTOR values(2, 'Joe','Movie A', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 20.25,'20-AUG-16 07.17.54.098000000 PM');
INSERT INTO ACTOR values(3, 'Tom','Movie A', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 20.25,'20-AUG-16 07.17.54.098000000 PM');
INSERT INTO ACTOR values(4, 'Jerry','Movie A', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 45.10,'20-AUG-16 07.17.54.098000000 PM');
INSERT INTO ACTOR values(5, 'Jerry','Movie B', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 45.10,'20-AUG-16 07.17.54.098000000 PM');
INSERT INTO ACTOR values(6, 'Jerry','Movie C', to_date('19960725','YYYYMMDD'),'12345 lane rd, Reston,VA 20190', 45.10,'20-AUG-16 07.17.54.098000000 PM');
--ROLE TYPEs
INSERT INTO ROLE_TYPE VALUES(1, 'Lead');
INSERT INTO ROLE_TYPE VALUES(2, 'Sidekick');
INSERT INTO ROLE_TYPE VALUES(3, 'Antagonist');
INSERT INTO ROLE_TYPE VALUES(4, 'Female Lead');
INSERT INTO ROLE_TYPE VALUES(5, 'Lovable Dog');

--Actor and their Roles
INSERT INTO ACTOR_ROLE values(1,1);
INSERT INTO ACTOR_ROLE values(2,2);
INSERT INTO ACTOR_ROLE values(3,3);
INSERT INTO ACTOR_ROLE values(4,1);

--SELECT 
SELECT * FROM actor;
SELECT * FROM actor_role;
--SELECT * FROM actor_film; should probably have a table for film and then join this table 
SELECT * FROM role_type;

--Aggregates
--SQL aggregate functions return a single value, calculated from values in a column.
/*
AVG() - Returns the average value
COUNT() - Returns the number of rows
MAX() - Returns the largest value
MIN() - Returns the smallest value
SUM() - Returns the sum
*/
Select Avg(ACT_YEARS_IN_MEDIA) as "Average Num Yrs"
From actor;

Select Count(ACT_NAME) as "How many actors"
From actor; --only non null values

Select ACT_NAME, SUM(ACT_YEARS_IN_MEDIA) as "Total yrs combined" --3 rows of Jerry
FROM actor
GROUP BY ACT_NAME; --GROUP BY keyword: used with aggregate fn IQ


-----------------------------Subquery
/*
A Subquery or Inner query or Nested query is a query within another SQL query and embedded within the WHERE clause.

Can be used with the SELECT, INSERT, UPDATE, and DELETE statements
Can be used with operators like =, <, >, >=, <=, IN, BETWEEN etc.
*/
DELETE FROM actor WHERE act_id = (SELECT act_id FROM actor WHERE act_name = 'Jerry' and ACT_FILM = 'Movie B');


--SQL scalar functions return a single value, based on the input value.
/*
UPPER() - Converts a field to upper case
LOWER() - Converts a field to lower case
SUBSTR() - Extract characters from a text field
LENGTH() - Returns the length of a text field
ROUND() - Rounds a numeric field to the number of decimals specified
*/

SELECT UPPER(ACT_YEARS_IN_MEDIA) FROM actor;
SELECT ROUND(ACT_YEARS_IN_MEDIA) FROM actor;


/*
Joins
*/
--We can see the Role ID for movie
SELECT act_name, act_film, role_id
FROM actor a
inner join ACTOR_ROLE ar
ON a.act_id = ar.act_id;


--Add in Role Type too!
SELECT a.act_name, a.act_film, ar.role_id, rt.role_type
FROM actor a
inner join ACTOR_ROLE ar ON a.act_id = ar.act_id
inner join ROLE_TYPE rt ON rt.role_id = ar.role_id;

SELECT a.act_name, a.act_film, ar.role_id, rt.role_type
From ACTOR a, ACTOR_ROLE ar, ROLE_TYPE rt
WHERE ar.ACT_ID = a.act_id
and rt.ROLE_ID = ar.ACT_ID;


--Left Join
SELECT a.act_name, a.act_film, ar.role_id, rt.role_type
FROM actor a
LEFT JOIN ACTOR_ROLE ar ON a.act_id = ar.act_id
LEFT JOIN ROLE_TYPE rt ON rt.role_id = ar.role_id;

--Left Outter Join
SELECT a.act_name, a.act_film, ar.role_id, rt.role_type
FROM actor a
LEFT OUTER JOIN ACTOR_ROLE ar ON a.act_id = ar.act_id
LEFT OUTER JOIN ROLE_TYPE rt ON rt.role_id = ar.role_id;

--Right Join
SELECT a.act_name, a.act_film, ar.role_id, rt.role_type
FROM actor a
RIGHT JOIN ACTOR_ROLE ar ON a.act_id = ar.act_id
RIGHT JOIN ROLE_TYPE rt ON rt.role_id = ar.role_id;




--Self Join
SELECT  a.act_name, b.act_name, a.act_years_in_media 
     FROM actor a, actor b
     WHERE  a.act_years_in_media = b.act_years_in_media;
     
    
--Where name != name
SELECT  a.act_name as "A Table Name", b.act_name as "B Table Name", a.act_years_in_media 
     FROM actor a, actor b
     WHERE  a.act_years_in_media = b.act_years_in_media
     and a.act_name != b.act_name;    
     
-----------------------------Cascade w/o
DELETE FROM actor
WHERE ACT_ID = 1; --SQL Error: ORA-02292: integrity constraint

--Must Add cascade to DDL
DELETE FROM actor
WHERE ACT_ID = 1; --Now it works!