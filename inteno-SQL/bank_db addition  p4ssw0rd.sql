--depoisit into account
create or replace procedure  deposit(  in number, myU in number)
 is 
 Begin
  update bank_account
   set balance =(balance+myD)
    where account_number = myU;
    
    Insert into bank_tx
     (tx_timestamp, tx_amt, tx_type_id, account_number)
     values ((select systimestamp from dual) myD, 1, myU);
 end;
 /
 -- find the view and select dbms output then in that new dbms output hit the green + select current db
 begin
   (deposit(10,0);
end;
/

select * from bank_account;


---withdraw from account 
create or replace withdraw(myW in number, myU in number)
is 
begin
    update bank_account
    set balance = (balance-myW)
    where users_id = myU;
    
    insert into bank_tx
    (tx_timestamp, tx_amt, tx_type_id, account_number)
    values ((select systimestamp from dual), myW,2, myU);
end;
/
 -- find the view and select dbms output then in that new dbms output hit the green + select current db

