package com.attendance;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
	   	  
		 

		  String empid = request.getParameter("empid");
		    String password = request.getParameter("password");

			Connect connect=new Connect();
			Connection con=connect.getConnection();
		    
		    
		    try {
		    	
		        String strQuery = "select * from employeedet where empid='"
		                + empid + "' and password='" + password + "'";
		        
		        Statement st = con.createStatement();
		        ResultSet rs = st.executeQuery(strQuery);
		        
		        if (rs.next()) {
		        	 java.sql.Timestamp date=new Timestamp(new java.util.Date().getTime());
		        	 int id = rs.getInt("empid");
		        	 
		        	 PreparedStatement ps=con.prepareStatement("UPDATE Employeetime SET logout ='"
                        + date + "'WHERE empid ='" + id + "'"+" AND logout is null");
		        	 
		        	 int j=ps.executeUpdate();
		        	 System.out.println(date);
		        	 if(j>0){
		        		// out.println("<html><body onload=\"alert('Exit done')\"></body></html>");

	                    	String message = "Exit done";
	                    	response.sendRedirect("Home.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	  
		        	 }
		        	 
		        } 
		        	 else {
		        		 String message = "Wrong Credentials";
		                	response.sendRedirect("Home.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		        	 }
		        	 rs.close();
				        st.close();
				        
				    
				    }
		        catch (Exception e) {
		            e.printStackTrace();
		        }


		
			    
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
