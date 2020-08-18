package com.revature.utils;

import java.util.List;
import java.util.Scanner;


import com.revature.daos.UserDAO;
import com.revature.daos.AccountDAO;

import com.revature.services.AccountServices;

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
		
		System.out.println
			("Welcome to the Best bank of the world ! "
				+ "What would you like to do: \n"
				+ "1 -Log in to your account \n"
				+ "2-Sign up new account? \n"
				+ "3-Exit program\n");
				
		String answer = scan.nextLine(); }
}
//		answerSwitch(answer);
//	}
//
//	private void answerSwitch(String answer) {
//		
//		switch(answer){
//			case "1": 
//				login();
//				break;
//			case "2":
//				createAccount());
//				break;
//
//			case "3":
//				System.out.println("Thank you for using the application. Reminder, do not play Mario Cart with Bruce Banner. If you do, you will be liable for Hulk related damage.");
//				break;	
//			default:
//				System.out.println("You have entered an incorrect value. Please try again. ");
//				beginApp();
//				break;
//		}
//	}
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
//		logIn=true;
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
//
//			
//		
//		
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
////	private void addAvenger() {
////		System.out.println("What is the code name of the Avenger you would like to add?");
////		String supName = scan.nextLine();
////		System.out.println("What is the super power of the Avenger?");
////		String power = scan.nextLine();
////		System.out.println("What is the first name of the Avenger?");
////		String fName= scan.nextLine();
////		System.out.println("What is the last name of the Avenger?");
////		String lName= scan.nextLine();
////		System.out.println("What is the power level of the Avenger?");
////		int pLevel = scan.nextInt();
////		scan.nextLine();
////		System.out.println("Does the Avenger have a home?");
////		Home h = null;
////		if(scan.nextLine().toLowerCase().equals("yes")) {
////			h = findHome();
////		}
////		Avenger a = new Avenger(supName, power, fName, lName, pLevel, h);
////		
////		if(as.insertAvenger(a)) {
////			System.out.println("Your avenger was added to the database");
////			beginApp();
////		} else {
////			System.out.println("Something went wrong please try again");
////			beginApp(); 
////		}
////		
////			
////	}
//
////	private Home findHome() {
////		System.out.println("Does your Avenger's home already exist in the Database? \n"
////				+ "if so, enter the name of the home. \n"
////				+ "if not enter 'no'");
////		String res = scan.nextLine();
////		Home h = null;
////		if(res.toLowerCase().equals("no")) {
////			h = buildHome();
////		} else {
////			h = hd.findByName(res);
////		}
////		return h;
////	}
////
////	private Home buildHome() {
////		System.out.println("What is the name of the new home?");
////		String name = scan.nextLine();
////		System.out.println("What is the user's street address?");
////		String addr = scan.nextLine();
////		System.out.println("What is your home's city?");
////		String city = scan.nextLine();
////		System.out.println("What is the home's state?");
////		String state = scan.nextLine();
////		System.out.println("What is the home's zipcode?");
////		String zip = scan.nextLine();
////		Home h = new Home(name, addr, city, state, zip);
////		return h;
////	}
////
////	private void getOneAvenger() {
////		System.out.println("What is the id of the avenger you would like to look at?");
////		int i = scan.nextInt();
////		scan.nextLine();
////		Avenger a = as.findById(i);
////		System.out.println("Your avaenger is: "+a);
////		beginApp();
////	}
////	
////	private void getAllAvengers() {
////		List<Avenger> list = as.findAll();
////		
////		System.out.println("Here are all the Avengers in the database:");
////		for(Avenger a:list) {
////			System.out.println(a);
////		}
////		beginApp();
////	}
//	
//	
//
//}
