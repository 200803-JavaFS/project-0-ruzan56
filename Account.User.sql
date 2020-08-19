-CREATE DATABASE demos;
--This is a SQL comment.

--DDL commands



drop table if exists USERS;

create table USERS(
user_zip VARCHAR (30)  primary KEY,
user_name VARCHAR(30),
user_password VARCHAR (30),
first_name VARCHAR(30),
last_name VARCHAR (30)
);

CREATE TABLE accounts (
	account_id SERIAL primary  KEY ,
	account_number INTEGER,
	account_balance INTEGER,
	account_status VARCHAR(30),
	user_id_fk INTEGER references users(user_id)
	
	
);

--INSERT
insert  into users(user_zip ,user_name ,user_password,first_name ,last_name )
	values('1374','ruzan56','pass','ruzan','melikyolchyan')

insert into accounts (account_number,account_balance,account_status)
	values(113444,567,'active')
