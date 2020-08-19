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

public class UserServices {
	private static final Logger log = LogManager.getLogger(AccountServices.class);
	private static IAccountDAO adao = new AccountDAO();
	private static IUserDAO udao = new UserDAO();

	
	public List<User> findAll(){
		log.info("Retrieving all accounts");
		List<User> list = udao.findAll();
		return list;
		
	}

	public User findById(int id) {
		log.info("Finding User with id "+ id);
		return udao.findById(id);
	}
	public User findByUseName(String username) {
		log.info("Finding User with type "+ username);
		return findByUseName(username);
	}
	public User findByUserPassword(String username, String password) {
		log.info("Finding User with username: "+ username + " and password: " + password);
		return udao.findByPassword(username, password);
	}

	public boolean insertUser(User u) {
		log.info("Inserting User: "+ u);
		if (udao.addUser(u)) {
			return true;
		}
		return false;
	}
	
	public boolean updateUser(User u) {
		log.info("Updating User: "+ u);
		if (udao.updateUser(u)) {
			return true;
		}
		return false;
	}
}