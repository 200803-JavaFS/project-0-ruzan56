package com.revature;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.utils.ConsoleUtil;

public class Driver {

	//private static HomeDAO dao = new HomeDAO();
	
	public static void main(String[] args) {
//		List<Home> homes = dao.findAll();
//		
//		for (Home h: homes) {
//			System.out.println(h);
//		}
//		
	User us = new User("ruzan", "55555", "ruza", "yolchyan", null);
//		
//		System.out.println(dao.addHome(h));
		
		ConsoleUtil cons = new ConsoleUtil();
		cons.beginApp();
	
		
	}

}