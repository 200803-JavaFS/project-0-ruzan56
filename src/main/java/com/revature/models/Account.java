package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	
	private int account_id; // primary
	private double account_number;
	private double account_balance;
	private String account_status;
	private User user; // foregn key
	//added

	public Account() 
	//added
	
	{
		
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Account(int account_id, double account_number, int account_balance, String account_status, User user) {
		super();
		this.account_id = account_id;
		this.account_number = account_number;
		this.account_balance = account_balance;
		this.account_status = account_status;
		this.user = user;
	}


	public Account(int account_number, double account_balance, String account_status) {
		super();
		this.account_number = account_number;
		this.account_balance = account_balance;
		this.account_status = account_status;
	}
	public double getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
	
	public int getAccount_id() {
		return account_id;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(account_balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + account_id;
		temp = Double.doubleToLongBits(account_number);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((account_status == null) ? 0 : account_status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(account_balance) != Double.doubleToLongBits(other.account_balance))
			return false;
		if (account_id != other.account_id)
			return false;
		if (Double.doubleToLongBits(account_number) != Double.doubleToLongBits(other.account_number))
			return false;
		if (account_status == null) {
			if (other.account_status != null)
				return false;
		} else if (!account_status.equals(other.account_status))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_number=" + account_number + ", account_balance="
				+ account_balance + ", account_status=" + account_status + ", user=" + user + "]";
	}
	
	
	
	
	
	
}

