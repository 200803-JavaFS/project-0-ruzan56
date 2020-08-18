package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtility;

public class UserDAO implements IUserDAO {

	@Override
	public List<User> findAll() {
		
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM Users;";
			
			Statement statement = conn.createStatement();
			
			List<User> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				User u = new User();
				u.setUser_name(result.getString("user_name"));
				u.setPassword(result.getString("user_password"));
				u.setZip(result.getString("user_zip"));
				u.setFirst_name(result.getString("first_name"));
				u.setLast_name(result.getString("last_name"));
				list.add(u);
			}
			
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	@Override
	public User findByUserName(String user_name) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM Users WHERE user_name = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, user_name);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				User u = new User();
//				(String user_name, String password, String first_name, String last_name, String zip
				u.setUser_name(result.getString("user_name"));
				u.setPassword(result.getString("password"));
				u.setFirst_name(result.getString("first_name"));
				u.setLast_name(result.getString("last_name"));
				u.setZip(result.getString("user_zip"));
				return u;
			} else {
				//good place to log a failed query.
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User u) {
		
		try(Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "INSERT INTO Users (user_name, user_password, user_zip, first_name, last_name)"
					+ "VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, u.getUser_name());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getZip());
			statement.setString(++index, u.getFirst_name());
			statement.setString(++index, u.getLast_name());
			
			statement.execute();
			return true; 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User findByPassword(String user_name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}
	

}