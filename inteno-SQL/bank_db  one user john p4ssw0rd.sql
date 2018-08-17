-------------------creating user------------

insert into users values (1,'john','123','jonny','brovo');
commit;
select * from users;

-- jonny bank account 
insert into bank_account values(101112,4000, 1);
select * from bank_account;
select * from bank_tx;
----------------bank_tx------------------
insert into bank_tx values(1,(select systimestamp from dual), 100, 1, 101112); --deposit
insert into bank_tx values(2,(select systimestamp from dual), 50, 2, 101112); --withdraw

select * from bank_tx;



--------------------- bank_tx_type-----------------------------------------------------
INSERT INTO bank_tx_type VALUES(1,'deposit');
INSERT INTO bank_tx_type values(2, 'withdraw');
select * from bank_tx_type;


--------------------------stored procedure--------------------------------------------------------------
create or replace procedure deposit_trans(amount in number, account_num in number)
 is 
 Begin
  update bank_account
   set balance =(balance + amount)
    where account_number = account_num;
    
    Insert into bank_tx
     (tx_timestamp, tx_amount, tx_type_id, account_number)
     values ((select systimestamp from dual), amount, 1, account_num);
 end;
 /
 -- find the view and select dbms output then in that new dbms output hit the green + select current db
 begin
   deposit_trans(10,101112);
end;
/

---------------------------------withdraw procedure--------------------------------------------

create or replace procedure withdraw_money(amount in number, account_num in number)
 is 
 Begin
  update bank_account
   set balance =(balance - amount)
    where account_number = account_num;
    
    Insert into bank_tx
     (tx_timestamp, tx_amount, tx_type_id, account_number)
     values ((select systimestamp from dual), amount, 1, account_num);
 end;
 /
 -- find the view and select dbms output then in that new dbms output hit the green + select current db
 begin
   withdraw(10,101112);
end;
/
----------------------------------trigger --------------------------------------------------
create or replace trigger bank_tx_trig
 before insert on bank_tx  
    for each row 
 begin
    if:new.tx_id is null then 
      Select tx_id_seq.nextval into :new.tx_id From Dual;
    end if;
end;
/

-----------------------------------sequence-------------------
CREATE SEQUENCE tx_id_seq
START WITH 1
INCREMENT BY 1;

select * from bank_tx;
