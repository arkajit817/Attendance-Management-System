package com.attendance;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  System.out.println("yooo");
	  response.setContentType("text/html");
	    


	  String empid = request.getParameter("empid");
	    String password = request.getParameter("password");
	    

		Properties props = new Properties();
	    java.io.InputStream in=null;
		Connection con = null;
	    
	    try {
	    	 in= new Login().getClass().getResourceAsStream("/dbconfig.properties");

		    	props.load(in);
	        Class.forName(props.getProperty("DB_DRIVER"));

	        Connection conn=DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USER"),props.getProperty("DB_PASSWORD"));  

	        String strQuery = "select * from employeedet where empid='"
	                + empid + "' and password='" + password + "' and Role='Admin'";
	        
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery(strQuery);
	        
	        
	        if (rs.next()) {
	        	response.sendRedirect("Admin.jsp");
	        	return;
	        }
	        
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		response.setContentType("text/html");
		
		 String from = request.getParameter("from");
		    String upto = request.getParameter("upto");
		    String empid=request.getParameter("empid");
//		    System.out.println(from);
//		    SimpleDateFormat fromm = new SimpleDateFormat("MM/dd/yyyy");
//		    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
//		    String reformattedStr1="";
//		    String reformattedStr2="";
//
//		    try {
//				reformattedStr1 = myFormat.format(fromm.parse(from));
//				reformattedStr2 = myFormat.format(fromm.parse(upto));
//
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}

//		    System.out.println(reformattedStr1);
		    try {
		        Class.forName("com.mysql.jdbc.Driver");

		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","arka");  

		        String strQuery = "select * from employeetime where empid='"
		                + empid + "' and login between'" + from + "'and '"+upto+"'";
		        
		        Statement st = conn.createStatement();
		        ResultSet rs = st.executeQuery(strQuery);
		       
		        Map<String, String> map = new LinkedHashMap<String, String>();
//		        List<Map<String, String>> arr=new ArrayList<Map<String, String>>();
		        ArrayList<Map<String, String>> arr=new ArrayList<>();
		     while(rs.next()) {
		    	 String exit=rs.getString(3);
		    	 
		    	 System.out.println(exit);
		         map.put("entry", rs.getString(2));
		         map.put("exit", exit);
		         arr.add(map);
		     }
		     
		     System.out.println(arr);
		     
		     HttpSession session=request.getSession();
		    session.setAttribute("data", arr );
	           request.getRequestDispatcher("Adminview.jsp").forward(request, response);;

		    
		    
		    
		    
		    
		    
		    }
		    
		    
	catch(Exception e){
		e.printStackTrace();
}

}
	
}
