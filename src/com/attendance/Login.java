package com.attendance;

import java.io.FileInputStream;
import java.io.*;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.portable.InputStream;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		    Properties props = new Properties();
			
		
		    Connect connect=new Connect();
		    Connection con=connect.getConnection();
		    
		    
		    try {
				

		        String strQuery = "select * from employeedet where empid='"
		                + empid + "' and password='" + password + "'";
		        
		        Statement st = con.createStatement();
		        ResultSet rs = st.executeQuery(strQuery);
		        
		        if (rs.next()) {
		        	/*HttpSession session=request.getSession();
		        	session.setAttribute("username",username);*/	        	
	        	 java.sql.Timestamp date=new Timestamp(new java.util.Date().getTime());
		        	
		        	/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		        	Calendar cal = Calendar.getInstance();
		        	String dtStr = dateFormat.format(cal);
		        	java.sql.Date date= new Date(dtStr);*/
		        			//new Date();
		        	System.out.println(date);
                     PreparedStatement ps=con.prepareStatement("insert into employeetime values(?,?,?)");
                     int id = rs.getInt("empid");
     		        System.out.println(id);
                     ps.setInt(1,id);
                     ps.setTimestamp(2, date);
                     ps.setDate(3, null);
                     
                     int j=ps.executeUpdate();
                     if(j>0){
                    	out.println("entry done");
                    	//out.println("<html><body><script>alert('Hello World!');</script></body></html>");
                    	
                    	String message = "Entry done";
                    	response.sendRedirect("Home.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

                    	
                    
                    	
                            
                    	 
                    	 
                    	 
                    	 
                    	 
                    	/* String str="select * from employeetime where empid='"+id+"'";
      		           Statement s=conn.createStatement();
      		           ResultSet r=s.executeQuery(str);
      		           
      		           request.setAttribute("id", id);
      		           request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
      		         HttpSession session=request.getSession();
 		        	session.setAttribute("empid",id);
 		        	session.setAttribute("time", date);
 		           response.sendRedirect("Dashboard.jsp");*/
                    	 
                     }
                     
                     
		           

		        } else {
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
