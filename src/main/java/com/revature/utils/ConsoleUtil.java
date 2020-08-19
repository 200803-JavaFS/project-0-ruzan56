package com.revature.utils;

import java.util.List;
import java.util.Scanner;


import com.revature.daos.UserDAO;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.daos.AccountDAO;

import com.revature.services.AccountServices;
import com.revature.services.UserServices;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//public class BankApp {
//	//Scanner class to put info in
//	private static Scanner sc = new Scanner(System.in);
//	
//	private static User u = null;
//	private static Account a = null;
//	//Gets data from DBAAccessorInstance
//	
//	private static final Scanner scan = new Scanner(System.in);
//    private AccountServices as = new AccountServices();
//    private UserServices us = new UserServices();
//	private static UserDAO ud = new UserDAO(); 
//	private AccountDAO ad = new AccountDAO();
//	//Logs
//	final static Logger logger = LogManager.getLogger(BankApp.class);
//
//	public static void main(String[] args) throws Exception {
//		// ALL, TRACE, DEBUG, INFO, WARN, ERROR and FATAL
//		
//		logger.info("info level - System start");
//		System.out.println("Welcome to PetGlad bank. ");
//		
//
//		// input loop
//		// no user logged in
//		loop: while (true) {
//			System.out.println("Our bank options:");
//			System.out.println("Press 1 to if you want to log into your account");
//			System.out.println("Press 2 to create a customer account");
//			System.out.println("Press 3 to create an admin account");
//			System.out.println("Press 0 to exit system");
//			System.out.println("Make your choice : ");
//			int option = sc.nextInt();
//			sc.nextLine();
//			//Logger TRACE the choice
//			logger.trace("option entered: " + option);
//
//			switch (option) {
//			// Login log out
//			case 1:
//				login();
//				break;
//			// create customer account
//			case 2:
//				createCustomer();
//				break;
//			// create admin account
//			case 3:
//				createAdmin();
//				break;
//			// exit system
//			case 0:
//				break loop;
//			}
//
//			if (u != null) {
//				loggedIn();
//			}
//		}
//
//		sc.close();
//		logger.trace("end of main.");
//	}
//
//	public static void loggedIn() {
//		if (!u.approved) {
//			System.out.println(u.getUser_name() + " are not approved for deposits and withdrawals by an admin. Logging out...\n");
//			u = null;
//			return;
//		}
//
//		while (true) {
//			System.out.println("Options:");
//			System.out.println("1 to deposit");
//			System.out.println("2 to withdraw");
//			if (a.admin) {
//				System.out.println("3 to approve users");
//			}
//			System.out.println("0 to log out of: " + u.getUser_name());
//			System.out.println("Enter option: ");
//
//			int option = sc.nextInt();
//			sc.nextLine();
//			logger.trace("option entered: " + option);
//			if (!a.admin && option > 2) {
//				System.out.println("Invalid option for a customer. Retry...");
//				continue;
//			}
//			switch (option) {
//			// log out
//			case 0:
//				System.out.println(u.getUser_name() + " logging out...");
//				u = null;
//				return;
//			case 1:
//				deposit();
//				break;
//			case 2:
//				withdraw();
//				break;
//			case 3:
//				approveUsers();
//
//			}
//		}
//	}
//
//	public static void login() throws IOException {
//		System.out.println("Log in...");
//
//		boolean authenticated = false;
//		while (!authenticated) {
//			System.out.println("Enter your user name: ");
//			String name = sc.nextLine();
//			u = ud.getUser(name);
//			if (u == null) {
//				System.out.println("Invalid user name: " + name);
//				continue;
//			}
//
//			System.out.println("Enter your password: ");
//			String password = sc.nextLine();
//
//			if (!u.getPassword().equals(password)) {
//				System.out.println("Invalid password for : " + name);
//				logger.trace("password entered : " + password);
//				logger.trace("password expected: " + u.getPassword());
//			} else
//				authenticated = true;
//		}
//		// Runtime.getRuntime().exec("clear");
//		System.out.println("Welcome " + u.getUser_name());
//		logger.trace("User logged in: " + u);
//
//		loggedIn();
//	}
//
//	public static void createCustomer() {
//		System.out.println("Create a customer account");
//		createUser(false);
//		System.out.println("Customer account created, username: " + u.getUser_name());
//	}
//
//	public static void createAdmin() {
//		System.out.println("Create an admin account");
//		createUser(true);
//		System.out.println("Admin account created, username: " + u.getUser_name());
//	}
//
//	public static void createUser(boolean admin) {
//		String name = null;
//		while (true) {
//			System.out.println("Enter a new user name: ");
//			name = sc.nextLine();
//			if ( u.getUser_name) == null)
//				break;
//			System.out.println("User name already exists!");
//		}
//		// logger.debug("Entered name: " + name);
//		// logger.trace("name length: " + name.length());
//		System.out.println("Enter a password: ");
//		String password = sc.nextLine();
//
//		u = new User(name, password, 0, admin, false); // logs in
//		boolean inserted = dao.insertUser(u);
//		if (inserted) {
//			logger.debug("User created: " + u);
//		} else {
//			logger.debug("User could NOT be created: " + u);
//		}
//	}
//
//	private static void approveUsers() {
//		System.out.println("Approve users");
//
//		Map<String, User> m = dao.getAllUsers();
//		if (m.isEmpty()) {
//			System.out.println("No users in the system.");
//			return;
//		}
//		System.out.println("Users in the system:");
//		for (String k : m.keySet()) {
//			User t = m.get(k);
//			System.out.println(k + " " + t.approved);
//		}
//
//		System.out.println("Enter the name of the user to approve: ");
//		String name = sc.nextLine();
//		logger.debug("name: " + name);
//		User enteredUser = m.get(name); 
//		enteredUser.approved = true;
//		dao.updateUser(enteredUser);
//		System.out.println(enteredUser.name + " approved.");
//		logger.trace("" + dao.getUser(enteredUser.name));
//	}
//
//	public static void deposit() {
//		System.out.println(u.getUser_name() + " your current balance is : $" + a.getAccount_balance());
//		System.out.println("Enter the amount to deposit: ");
//		System.out.print("$");
//		float deposit = sc.nextFloat();
//		logger.trace("amount entered: " + deposit);
//		u.deposit(deposit);
//
//		System.out.println(u.getUser_name + " your new balance is : $" + u.balance);
//	}
//
//	public static void withdraw() {
//		System.out.println(u.getUser_name + " your current balance is : $" + u.balance);
//		System.out.println("Enter the amount to withdraw: ");
//		System.out.print("$");
//		float withdrawal = sc.nextFloat();
//		logger.trace("amount entered: " + withdrawal);
//		u.withdraw(withdrawal);
//
//		System.out.println(u.getUser_name + " your new balance is : $" + a.balance);
//	}
//
//	// @Override
//	protected void finalize() throws Throwable {
//		super.finalize();
//
//	}
//}

public class ConsoleUtil {

	private static final Scanner scan = new Scanner(System.in);
	private AccountServices as = new AccountServices();
	private UserDAO ud = new UserDAO(); 
	
	
		   
	 
 
	public void beginApp() {
		int i, j, row=6;   
		//outer loop for rows  
		for(i=0; i<row; i++)   
		{   
		//inner loop for columns  
		for(j=0; j<=i; j++)   
		{   
		//prints stars   
		System.out.print("* ");   
		}   
		//throws the cursor in a new line after printing each line  
		System.out.println();   
		}   
		
		System.out.println("Select one of the options and press 'enter':\n\n"
				+ "[1]\t Log into existing account\n"
				+ "[2]\t Create a new account\n"
				+ "[3]\t Close the application\n");
		
		String answer = scan.nextLine(); 

		answerSwitch(answer);
	}

	private void answerSwitch(String answer) {
	
		switch(answer)	{
		
		case "1" : 
			login();
			break;
		case "2":
			CreateAccount();
			break;
		case "3" :
			System.out.println("Thank you for trusting us. Have great day");
		default:
			System.out.println("Invalid choice try again");
			beginApp();
			
			break;
	}
}

private void login() {
		
	System.out.println("Welcome back, Who are you ?%n"
			+ "[1] Client\n "
			+ "[2] Employee\n"
			+ "[3] Admin \n"
			+  "[0]  Exit");
	System.out.println("\n**************************************************************\n");

		String choice 	=scan.next();
		System.out.println("your choice is" + choice);
		System.out.println();
}
}
//		
//case "1":
//	userType = "client";
//	logInUser(userType, logIn);
//	break;
//case "2":
//	userType = "employee";
//	logInEmployee(userType, logIn);
//	break;
//case "3":
//	userType = "admin";
//	logInAdmin(userType, logIn);
//	break;
//case "4":
//	System.out.println("Thank you for trusting us your money. Bye bye.");
//	System.exit(0);
//	break;
//default:
//	System.out.println("You have entered an incorrect value. Please try again. ");
//	System.out.println("\n**************************************************************\n");
//	logInAccount();
//	break;		
//}
////
////			
////		
////		
////	
////	
////	
////	
////	
////	
////	
////	
////	
////	
//////	private void addAvenger() {
//////		System.out.println("What is the code name of the Avenger you would like to add?");
//////		String supName = scan.nextLine();
//////		System.out.println("What is the super power of the Avenger?");
//////		String power = scan.nextLine();
//////		System.out.println("What is the first name of the Avenger?");
//////		String fName= scan.nextLine();
//////		System.out.println("What is the last name of the Avenger?");
//////		String lName= scan.nextLine();
//////		System.out.println("What is the power level of the Avenger?");
//////		int pLevel = scan.nextInt();
//////		scan.nextLine();
//////		System.out.println("Does the Avenger have a home?");
//////		Home h = null;
//////		if(scan.nextLine().toLowerCase().equals("yes")) {
//////			h = findHome();
//////		}
//////		Avenger a = new Avenger(supName, power, fName, lName, pLevel, h);
//////		
//////		if(as.insertAvenger(a)) {
//////			System.out.println("Your avenger was added to the database");
//////			beginApp();
//////		} else {
//////			System.out.println("Something went wrong please try again");
//////			beginApp(); 
//////		}
//////		
//////			
//////	}
////
//////	private Home findHome() {
//////		System.out.println("Does your Avenger's home already exist in the Database? \n"
//////				+ "if so, enter the name of the home. \n"
//////				+ "if not enter 'no'");
//////		String res = scan.nextLine();
//////		Home h = null;
//////		if(res.toLowerCase().equals("no")) {
//////			h = buildHome();
//////		} else {
//////			h = hd.findByName(res);
//////		}
//////		return h;
//////	}
//////
//////	private Home buildHome() {
//////		System.out.println("What is the name of the new home?");
//////		String name = scan.nextLine();
//////		System.out.println("What is the user's street address?");
//////		String addr = scan.nextLine();
//////		System.out.println("What is your home's city?");
//////		String city = scan.nextLine();
//////		System.out.println("What is the home's state?");
//////		String state = scan.nextLine();
//////		System.out.println("What is the home's zipcode?");
//////		String zip = scan.nextLine();
//////		Home h = new Home(name, addr, city, state, zip);
//////		return h;
//////	}
//////
//////	private void getOneAvenger() {
//////		System.out.println("What is the id of the avenger you would like to look at?");
//////		int i = scan.nextInt();
//////		scan.nextLine();
//////		Avenger a = as.findById(i);
//////		System.out.println("Your avaenger is: "+a);
//////		beginApp();
//////	}
//////	
//////	private void getAllAvengers() {
//////		List<Avenger> list = as.findAll();
//////		
//////		System.out.println("Here are all the Avengers in the database:");
//////		for(Avenger a:list) {
////			System.out.println(a);
////		}
////		beginApp();
////	}
//	
//	
//
//}
