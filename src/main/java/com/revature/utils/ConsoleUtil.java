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
//		

public class ConsoleUtil {

	private static final Scanner scan = new Scanner(System.in);
	private AccountServices as = new AccountServices();
	private UserDAO ud = new UserDAO(); 

	private static final Logger log = LogManager.getLogger(ConsoleUtil.class);

		   
	 
 
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
		
		System.out.println("Welcome to the Broken Bank of Ruzan. Select one of the options and press 'enter':\n\n"
				+ "[1]\t Log into existing account\n"
				+ "[2]\t Create a new account\n"
				+ "[3]\t Close the application\n");
		
		String answer = scan.nextLine(); 

		answerSwitch(answer);
	}

	private void answerSwitch(String answer) {
	
		switch(answer)	{
		
		case "1" : 
			beginLogin();
			Scanner in = new Scanner(System.in);
			
			
            int userChoice;

            boolean quit = false;

            float balance = 0f;

            do {
            		
                  System.out.println("1. Deposit money");

                  System.out.println("2. Withdraw money");

                  System.out.println("3. Check balance");

                  System.out.print("Your choice, 0 to quit: ");

                  userChoice = in.nextInt();


                  switch (userChoice) {

                  case 1:

                        float amount;

                        System.out.print("Amount to deposit: ");

                        amount = in.nextFloat();

                        if (amount <= 0)

                             System.out.println("Can't deposit nonpositive amount.");

                        else {

                             balance += amount;

                             System.out.println("$" + amount + " has been deposited.");
         						log.info("deposit successful!");


                        }
                        

                        break;

                  case 2:

                        System.out.print("Amount to withdraw: ");

                        amount = in.nextFloat();

                        if (amount <= 0 || amount > balance)


                             System.out.println("Withdrawal can't be completed.Negative amount");
                        		
                        

                        else {

                             balance -= amount;

                             System.out.println("$" + amount + " has been withdrawn.");
      						log.info("Withdrawn successful!");

                        }

                        break;

                  case 3:

                        System.out.println("Your balance: $" + balance);
                        log.info("Balance accessed ");

                        break;

                  case 0:

                        quit = true;

                        break;

                  default:

                        System.out.println("Wrong choice.");

                        break;

                  }

                  System.out.println();

            } while (!quit);

            System.out.println("Bye!");

      
           case "2":
		 registerCustomer();
		
		case"3":
			System.out.println("Bye bye, Hope to see you again");
			log.info("Application quitted");
		break;
		}
	}

//			break;
//		case "3" :
//			System.out.println("Thank you for trusting us. Have great day");
//		default:
//			System.out.println("Invalid choice try again");
//			beginApp();
//			
//			break;
//	}
//}
        	   
        	   private void registerCustomer() {
        			System.out.println("What is your first name?");
        			String firstName = scan.nextLine();
        			System.out.println("what is your last name?");
        			String lastName = scan.nextLine();
        			System.out.println("Please enter the password you would like saved for this account.");
        			String password = scan.nextLine();
        			System.out.println("What is your phone number?");
        			String phone = scan.nextLine();
        			System.out.println("What is your street address?");
        			String streetAddress = scan.nextLine();
        			System.out.println("What city do you live in?");
        			String city = scan.nextLine();
        			System.out.println("What state is that city in?");
        			String state = scan.nextLine();
        			System.out.println("What is the zip code for that area?");
        			int zipCode = scan.nextInt();
        			scan.nextLine();
        			System.out.println("Than you for registering with Broken bank");
        			beginApp();

        	   }
        	   private void beginLogin() {
        			System.out.println("What is your customer number?");
        			int id = scan.nextInt();
        			scan.nextLine();
        			System.out.println("What is your user password?");
        			String password = scan.nextLine();
        			

        			

        		}
        		
}
//
//private void login() {
//		
//	System.out.println("Welcome back, Who are you ?%n"
//			+ "[1] Client\n "
//			+ "[2] Employee\n"
//			+ "[3] Admin \n"
//			+  "[0]  Exit");
//	System.out.println("\n**************************************************************\n");
//
//		String choice 	=scan.next();
//		System.out.println("your choice is" + choice);
//		System.out.println();
//
//
//switch(choice) {
//
//case "1":
//	logInUser(typee, logIn);
//	break;
//case "2":
//	userType = "employee";
//	logInEmployee(type, logIn);
//	break;
//case "3":
//	userType = "admin";
//	logInAdmin(type, logIn);
//	break;
//case "4":
//	System.out.println("Thank you for trusting us your money. Bye bye.");
//	System.exit(0);
//	break;
//default:
//	System.out.println("You have entered an incorrect value. Please try again. ");
//	System.out.println("\n**************************************************************\n");
//	login();
//	break;	
//}
//
//private void loginUser(User logIn) {
//	System.out.println("Please enter your user name");
//	String user_name 	=scan.next();
//	System.out.println("Please enter your password");
//	String password=scan.next();
//	
//
//	
//}
//}
//ALL, TRACE, DEBUG, INFO, WARN, ERROR and FATAL
//
//logger.info("info level - System start");
//System.out.println("Welcome to PetGlad bank. ");
//
//
//// input loop
//// no user logged in
//loop: while (true) {
//	System.out.println("Our bank options:");
//	System.out.println("Press 1 to if you want to log into your account");
//	System.out.println("Press 2 to create a customer account");
//	System.out.println("Press 3 to create an admin account");
//	System.out.println("Press 0 to exit system");
//	System.out.println("Make your choice : ");
//	int option = sc.nextInt();
//	sc.nextLine();
//	//Logger TRACE the choice
//	logger.trace("option entered: " + option);
//
//	switch (option) {
//	// Login log out
//	case 1:
//		login();
//		break;
//	// create customer account
//	case 2:
//		createCustomer();
//		break;
//	// create admin account
//	case 3:
//		createAdmin();
//		break;
//	// exit system
//	case 0:
//		break loop;
//	}
//
//	if (u != null) {
//		loggedIn();
//	}
//}
//
//sc.close();
//logger.trace("end of main.");
//}
//
///public static void loggedIn() {
///if (!u.approved) {
//	System.out.println(u.getUser_name() + " are not approved for deposits and withdrawals by an admin. Logging out...\n");
//	u = null;
//	return;
//}
//
//while (true) {
//	System.out.println("Options:");
//	System.out.println("1 to deposit");
//	System.out.println("2 to withdraw");
//	if (a.admin) {
//		System.out.println("3 to approve users");
//	}
//	System.out.println("0 to log out of: " + u.getUser_name());
//	System.out.println("Enter option: ");
//
//	int option = sc.nextInt();
//	sc.nextLine();
//	logger.trace("option entered: " + option);
//	if (!a.admin && option > 2) {
//		System.out.println("Invalid option for a customer. Retry...");
//		continue;
//	}
//	
//
////	}
//}
//}
//
//public static void login() throws IOException {
//System.out.println("Log in...");
//
//boolean authenticated = false;
//while (!authenticated) {
//	System.out.println("Enter your user name: ");
//	String name = sc.nextLine();
//	u = ud.getUser(name);
//	if (u == null) {
//		System.out.println("Invalid user name: " + name);
//		continue;
//	}
//
//	System.out.println("Enter your password: ");
//	String password = sc.nextLine();
//
//	if (!u.getPassword().equals(password)) {
//		System.out.println("Invalid password for : " + name);
//		logger.trace("password entered : " + password);
//		logger.trace("password expected: " + u.getPassword());
//	} else
//		authenticated = true;
//}
//// Runtime.getRuntime().exec("clear");
//System.out.println("Welcome " + u.getUser_name());
//logger.trace("User logged in: " + u);
//
//loggedIn();
//}
//
//public static void createCustomer() {
//System.out.println("Create a customer account");
//createUser(false);
//System.out.println("Customer account created, username: " + u.getUser_name());
//}
//
//public static void createAdmin() {
//System.out.println("Create an admin account");
//createUser(true);
//System.out.println("Admin account created, username: " + u.getUser_name());
//}
//
//public static void createUser(boolean admin) {
//String name = null;
//while (true) {
//	System.out.println("Enter a new user name: ");
//	name = sc.nextLine();
//	if ( u.getUser_name) == null)
//		break;
//	System.out.println("User name already exists!");
//}
//// logger.debug("Entered name: " + name);
//// logger.trace("name length: " + name.length());
//System.out.println("Enter a password: ");
//String password = sc.nextLine();
//
//u = new User(name, password, 0, admin, false); // logs in
//boolean inserted = dao.insertUser(u);
//if (inserted) {
//	logger.debug("User created: " + u);
//} else {
//	logger.debug("User could NOT be created: " + u);
//}
//}
//
//private static void approveUsers() {
//System.out.println("Approve users");
//
//Map<String, User> m = dao.getAllUsers();
//if (m.isEmpty()) {
//	System.out.println("No users in the system.");
//	return;
//}
//System.out.println("Users in the system:");
//for (String k : m.keySet()) {
//	User t = m.get(k);
//	System.out.println(k + " " + t.approved);
//}
//
//System.out.println("Enter the name of the user to approve: ");
//String name = sc.nextLine();
//logger.debug("name: " + name);
//User enteredUser = m.get(name); 
//enteredUser.approved = true;
//dao.updateUser(enteredUser);
//System.out.println(enteredUser.name + " approved.");
//logger.trace("" + dao.getUser(enteredUser.name));
//}
//
//public static void deposit() {
//System.out.println(u.getUser_name() + " your current balance is : $" + a.getAccount_balance());
//System.out.println("Enter the amount to deposit: ");
//System.out.print("$");
//float deposit = sc.nextFloat();
//logger.trace("amount entered: " + deposit);
//u.deposit(deposit);
//
//System.out.println(u.getUser_name + " your new balance is : $" + u.balance);
//}
//
//public static void withdraw() {
//System.out.println(u.getUser_name + " your current balance is : $" + u.balance);
//System.out.println("Enter the amount to withdraw: ");
//System.out.print("$");
//float withdrawal = sc.nextFloat();
//logger.trace("amount entered: " + withdrawal);
//u.withdraw(withdrawal);
//
//System.out.println(u.getUser_name + " your new balance is : $" + a.balance);
//}
//
//// @Override
//protected void finalize() throws Throwable {
//super.finalize();
//
//}
//}

