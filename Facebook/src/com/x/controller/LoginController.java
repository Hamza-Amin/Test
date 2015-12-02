package com.x.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.x.util.DbUtil;
import com.x.model.Login;
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
      String uname;
      String upass;
      Statement stmt;
      ResultSet rs;
      RequestDispatcher dispatch;
     Connection conn;
     public LoginController(){
			con=DbUtil.getConnection();
			
		}
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uname=request.getParameter("username");        //new work
		upass=request.getParameter("password");
//		System.out.println(uname);
//		System.out.println(upass);
			
		try {
			 String sql="SELECT * FROM facebook.registration where username='"+uname+"'and password='"+upass+"'";
			 PreparedStatement prep=con.prepareStatement(sql);
			 
			
			
		   
		    rs = prep.executeQuery(sql);
		   
		    if(rs.next()){
		    	if((uname.equalsIgnoreCase(rs.getString("username")) &&  upass.equalsIgnoreCase(rs.getString("password")))){
				//System.out.println(rs.getString("username"+"nljl"));
				dispatch=request.getRequestDispatcher("home.jsp");
				dispatch.forward(request,response);
				 
				}
		
		} 
		    else{
			 	dispatch=request.getRequestDispatcher("error.jsp");
				dispatch.forward(request,response);
		 }
		    }catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}}
