create table USERS(
user_id integer (30)  primary KEY,
user_name VARCHAR(30),
user_password VARCHAR (30),
first_name VARCHAR(30),
last_name VARCHAR (30)
);
drop table if exists ACCOUNTS

CREATE TABLE accounts (
	account_id integer SERIAL primary  KEY ,
	account_number INTEGER,
	account_balance numeric(5,2),
	account_status VARCHAR(30),
	user_id_fk INTEGER references users
	
	
);
--INSERT
insert  into users(user_id ,user_name ,user_password,first_name ,last_name )
	values('100374','ruzan56','pass','ruzan','melikyolchyan');
	
	
insert into accounts (account_number,account_balance,account_status)
	values(113777744,567.5,'active')
