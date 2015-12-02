package com.x.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.x.dao.LoginDAO;
import com.x.dao.LoginDAOImpl;
import com.x.model.Login;
import com.x.util.DbUtil;

@WebServlet("/UserController")

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String uname;
    String upass;
    Statement stmt;
    ResultSet rs;
    RequestDispatcher dispatch;
    private static Connection conn;
	private LoginDAO log;
   //private static final String LOGIN_PAGE ="/login.jsp";
   //private static final String LIST="list.jsp";
    public RegistrationController() {
       log=new LoginDAOImpl();
        
    }

	
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Login login = new Login();
        login.setUsername( request.getParameter( "username" ) );
        login.setPassword(request.getParameter("password"));
        login.setEmail( request.getParameter( "email" ) );
        login.setCountry(request.getParameter("country"));
       
        
        
        
       
       log.addUser(login);
   
     
		
		
	}

}
