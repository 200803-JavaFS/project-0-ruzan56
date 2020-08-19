-CREATE DATABASE demos;
--This is a SQL comment.

--DDL commands



drop table if exists USERS;

create table USERS(
user_zip VARCHAR (30) SERIAL primary KEY,
user_name VARCHAR(30),
user_password VARCHAR (30),
first_name VARCHAR(30),
last_name VARCHAR (30)
);

CREATE TABLE accounts (
	account_id SERIAL PRIMATY KEY ,
	account_number INTEGER,
	account_balance INTEGER,
	account_status VARCHAR(30),
	user_id_fk INTEGER references users(user_id)
	
	
);

--INSERT


