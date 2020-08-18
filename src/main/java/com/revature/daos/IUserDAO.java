package com.revature.daos;


import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;

public interface IUserDAO {
	
	public List<User> findAll();
	public User findById(int id);
	public User findByUserName(String user_name);
	public User findByPassword(String user_name,String password);
	
	public boolean addUser(User u);
	public boolean updateUser(User u);
}