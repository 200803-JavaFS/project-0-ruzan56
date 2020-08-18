package com.revature.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtility;




public class AccountDAO implements IAccountDAO {

	private IUserDAO uDAO = new UserDAO();
			
	@Override
	public List<Account> findAll() {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts;";

			Statement statement = conn.createStatement();

			List<Account> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Account a = new Account(
						result.getInt("account_id"),
						result.getDouble("account_number"),
						result.getInt("account_balance"),
						result.getString("account_status"),
						null);
				
				if (result.getString("user_id_fk") != null) {
					a.setUser(uDAO.findById(result.getInt("user_id_fk")));
				}
				list.add(a);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account findById(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM Accounts WHERE account_id =" + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				//public Account(int account_id, double account_number, int account_balance, String account_status, User user)
				Account a = new Account
						(result.getInt("_account_id"), 
						result.getDouble("account_number"),
						result.getInt("account_balance"), result.getString("account_status"),null);
				if (result.getString("user_id_fk") != null) {
					a.setUser(uDAO.findByUserName(result.getString("user_base_fk")));
				}
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		try (Connection conn = ConnectionUtility.getConnection()) {

			String sql = "INSERT INTO Accounts (account_id, account_number, account_balance, account_status, user_base_fk)"
					+ "VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setInt(++index, a.getAccount_id());
			statement.setDouble(++index, a.getAccount_number());
			statement.setDouble(++index, a.getAccount_balance());
			statement.setString(++index, a.getAccount_status()); 

			if(a.getUser()!=null) {
				User u = a.getUser();
				statement.setString(++index, u.getZip());
			}else {
				statement.setInt(++index, 0);
			}
			statement.setInt(++index, a.getAccount_id());
			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAccount(Account a) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE Accounts SET account_number = ?, account_balance= ?, "
					+ "account_status = ?, user_id_fk = ? WHERE account_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, a.getAccount_number());
			statement.setDouble(++index, a.getAccount_balance());
			statement.setString(++index, a.getAccount_status()); 

			if(a.getUser()!=null) {
				User u = a.getUser();
				statement.setString(++index, u.getUser_name());
			}else {
				statement.setString(++index, null);
			}
			statement.setInt(++index, a.getAccount_id());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}



}