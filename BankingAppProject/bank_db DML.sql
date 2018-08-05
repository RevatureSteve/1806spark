

INSERT INTO USERS VALUES (1, 'loti', 'bananas', 'lo', 'ti');
INSERT INTO USERS VALUES (2, 'Roti', 'bananas', 'Ro', 'ti');

commit;

select * from users
where username = 'loti';