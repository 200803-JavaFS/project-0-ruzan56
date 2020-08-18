package com.revature.daos;

import java.util.List;

import com.revature.models.Account;


public interface IAccountDAO {

	public List <Account> findAll();
	public Account findById(int id);
	public boolean updateAccount(Account a);
	public boolean addAccount(Account a);
	
	
}