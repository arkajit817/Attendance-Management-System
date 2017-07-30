package com.attendance;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
	   	  response.setContentType("text/html"); 
	   	  PrintWriter out = response.getWriter();

	   	  
	   	  String u=request.getParameter("name"); 
	   	  String p=request.getParameter("password"); 
	   	  String d=request.getParameter("doj");
	   	  String m=request.getParameter("email");
	   	  String id=request.getParameter("empid");
	   	  String Role=request.getParameter("Role");

	   	  System.out.println(id);

	   	Properties props = new Properties();
	    java.io.InputStream in=null;
		Connection con = null;

	   	 try{
	   		 in= new Login().getClass().getResourceAsStream("/dbconfig.properties");

		    	props.load(in);
	   		 
	      	  Class.forName(props.getProperty("DB_DRIVER")); 
	      	  con=DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USER"),props.getProperty("DB_PASSWORD"));
	      	  

	      	  PreparedStatement ps=con.prepareStatement("insert into employeedet values(?,?,?,?,?,?)");

	      	 
	      	  ps.setString(1,u);
	      	  ps.setString(2,p); 
	      	  ps.setString(3,d); 
	      	  ps.setString(4,m);
	      	  ps.setString(5,id); 
	      	  ps.setString(6,Role);


	      	  
	      	  String str="Select * from employeedet where empid="+ id;
	      	  
	         Statement st = con.createStatement();
	         ResultSet rs=st.executeQuery(str);
	         
	         if(rs.next()){
	       	  response.sendRedirect("Home.jsp");
	         }
	      	  
	      	  

	      	  int j=ps.executeUpdate(); 
	      	  if(j>0) 
	      	  out.print("You are successfully registered...");
	      	  
	      	  out.close(); 
	    }
	   	 catch (Exception e2) {
	      		  System.out.println(e2);}
	   	}

	      	
	            

	   	
	   	  
		
		
		
		
		
		
	}


