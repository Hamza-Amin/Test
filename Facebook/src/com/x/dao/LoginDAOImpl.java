package com.x.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import com.x.model.Login;
import com.x.util.DbUtil;

public class LoginDAOImpl implements LoginDAO {
	private Connection con;
	public LoginDAOImpl(){
		con=DbUtil.getConnection();
	}	

ResultSet rs;
	public void addUser(Login log) {
		  String query = "insert into registration (username,email,password,country) values (?,?,?,?)";
		  try {
			PreparedStatement prep=con.prepareStatement(query);
		   prep.setString(1, log.getUsername());
		   prep.setString(2, log.getEmail());
		   prep.setString(3, log.getPassword());
		   prep.setString(4, log.getCountry());
		   prep.executeUpdate();
           prep.close();
		  
		   } 
		  
		  
		  catch (SQLException e) {
			e.printStackTrace();
		}
		  
		  
	}
}
