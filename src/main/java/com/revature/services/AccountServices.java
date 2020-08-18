package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.AccountDAO;
import com.revature.daos.IAccountDAO;
import com.revature.daos.IUserDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Account;
import com.revature.models.User;



public class AccountServices {

	//logs
	private static final Logger log = LogManager.getLogger(AccountServices.class);
	private static IAccountDAO acdao = new AccountDAO();
	private static IUserDAO usdao = new UserDAO();
	
	public List<Account>findAll(){
		log.info("Retrieving all accounts");
		List<Account> list = acdao.findAll();
		
		return list;
	}
	public Account findById(int id) {
		log.info("Finding account by id");
		return acdao.findById(id);
		
	}
	public boolean updateAccount(Account a) {
		log.info("Updating account" + a);
		if(acdao.updateAccount(a)) {
			return true ;
		}
		return false;
	}
	
	public boolean addAccount(Account a) {
		if (a.getUser() != null) {
			List<User> list = usdao.findAll();
			boolean b = false;
			for (User u: list) {
				if (u.equals(a.getUser())) {
					b = true;
				}
			}
			if (b) {
				log.info("Inserting account: " + a);
				if (acdao.addAccount(a)) {
					return true;
				}
			} else {
				log.info("Creating account: " + a + "with a new User:" + a.getUser());
				if (acdao.addAccount(a)) {
					return true;
				}
			}
		} else {
			log.info("Adding account: " + a);
			if (acdao.addAccount(a)) {
				return true;
			}
		}
		return false;
	}

//Deposit,withdraw, transfer
	
	public static double deposit(Account a, double amount) {
		if (amount <= 0) {
			System.out.println("You must deposit a positive value.");
			return a.getAccount_balance();
		} else {
			// add to balance
			System.out.println("You made a deposit.");
			return a.getAccount_balance() + amount;
		}
	}
	
	public static double withdraw(Account a, double amount) {
		if (amount <= 0) {
			System.out.println("You need to enter positive value.");
			return a.getAccount_balance();
		} else if (a.getAccount_balance() - amount >= 0) {			
			System.out.println("You made a withdrawal. Thank you.");
			return a.getAccount_balance() - amount;
		} else {
			System.out.println("You cannot withdraw more .");			
			return a.getAccount_balance();
		}
	}
	
	public static double transfer(Account a, double amount, String accountName) {
		if (amount <= 0) {
			System.out.println("You can only enter positive amount.");
			return a.getAccount_balance();
		} else if (a.getAccount_balance() - amount >= 0) {			
			System.out.println("You made a transfer to " + accountName + ".");
			return a.getAccount_balance() - amount;
		} else {
			System.out.println("You don't have enough balance to tranfer");
			return a.getAccount_balance();
		}
	}
	
	
	
}
