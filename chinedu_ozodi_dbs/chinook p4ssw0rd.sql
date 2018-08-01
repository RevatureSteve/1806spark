---Part 2.1 SELECT
-- A
SELECT *
FROM employee;
-- B
SELECT *
FROM employee
WHERE lastname = 'King';
-- C
SELECT *
FROM employee
WHERE firstname = 'Andrew'
AND reportsto IS NULL;
---Part 2.2 ORDER
--A
SELECT *
FROM album
ORDER BY title DESC;
--B
SELECT firstname, city
FROM customer
ORDER BY city ASC;
---Part 2.3 INSERT
--A
--SELECT *
--FROM genre; 
--ORDER BY name ASC;
INSERT INTO genre
VALUES (26, 'Country');
INSERT INTO genre
VALUES(27, 'Bubstep');
--B
--SELECT *
--FROM employee;
INSERT INTO employee
VALUES (9,'Brickman','Bob','Builder',1,TO_DATE('19720519','YYYYMMDD'),TO_DATE('20040117','YYYYMMDD'), '3334 Construction Ln', 'Edmonton', 'AB', 'Canada', 'T5K 3N1', '+1 (780) 428-5500',NULL,'bob@chinookcorp.com');
INSERT INTO employee
VALUES (10,'Doe','Jane','Secretary',1,TO_DATE('19870929','YYYYMMDD'),TO_DATE('20050307','YYYYMMDD'), '1323 Rick St', 'Houston', 'TX', 'United States', '77054', '+1 (737) 441-5350','+ (403) 665-3442','jane@chinookcorp.com');
--C
--SELECT *
--FROM customer;
INSERT INTO customer
VALUES (60,'Rick','Johnson','Revature', '1234 Null Ave', 'Impliciton', NULL, 'USA',NULL,NULL,NULL,'rick.johnson@gnomail.com',4);
INSERT INTO customer
VALUES (61,'Private','Eye',NULL, NULL,NULL, NULL, NULL,NULL,NULL,NULL,'private@gnomail.com',3);
---Part 2.4 UPDATE
--A
UPDATE customer
Set firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;
--B
--SELECT *
--FROM artist
--WHERE name = 'Creedence Clearwater Revival';
UPDATE artist
SET name = 'CCR'
WHERE artistid = 76;
---Part 2.5 LIKE
