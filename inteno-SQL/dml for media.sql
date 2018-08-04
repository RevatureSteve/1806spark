-- dml data manuplication language 
-- insert, select, update, delete

insert into actor values(1, 'big daddy 3', TO_DATE('19960425', 'YYYYMMDD'), 50, 'ADAM', 'SANDLER');
insert into actor values(2, 'avengers', TO_DATE('19800830', 'YYYYMMDD'), 10, 'chris', 'pratt');
insert into actor values(3, 'dr. strange', TO_DATE('19950425', 'YYYYMMDD'),20 , 'ben', 'cumberbatch');
insert into actor values(4, 'dr. strange', TO_DATE('19950426', 'YYYYMMDD'),20 , 'ben', 'cumberbatch');

select * from actor;
update actor
set year_acting = 15
where actor_id = 1;

delete from actor
where first_name = 'ben';
-- note what is the difference between turncate and delete
-- delete dont need a where clause
-- but turncate is faster because it automacaly commited and cannot to rolledback
-- when deeeting that will do an extra step for temporary saving it to a file
--incase of rollback, turncate will not do this extra step