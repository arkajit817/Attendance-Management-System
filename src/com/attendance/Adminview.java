package com.attendance;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminview
 */
@WebServlet("/Adminview")
public class Adminview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Adminview() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");

		//response.setContentType("text/html");

		PrintWriter out=response.getWriter();
		String from = request.getParameter("from");
		String upto = request.getParameter("upto");
		String empid = request.getParameter("empid");
		
		 SimpleDateFormat fromm = new SimpleDateFormat("MM/dd/yyyy");
		 SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String reformattedStr1="";
		String reformattedStr2="";
		
		try {
		 reformattedStr1 = myFormat.format(fromm.parse(from));
		reformattedStr2 = myFormat.format(fromm.parse(upto));
		
		 } catch (ParseException e1) {
		 //TODO Auto-generated catch block
		 e1.printStackTrace();
		 }

		// System.out.println(reformattedStr1);
		
		Connect connect=new Connect();
		Connection con=connect.getConnection();

		try {
			String strQuery="";
			if(empid==""){
				strQuery = "select employeedet.name,employeetime.login,employeetime.logout from employeetime LEFT JOIN employeedet on employeedet.empid=employeetime.empid where  employeetime.login between '" + reformattedStr1
						+ "' and '" + reformattedStr2 + "'";
				
			} else{
			strQuery = "select employeedet.name,employeetime.login,employeetime.logout from employeetime LEFT JOIN employeedet on employeedet.empid=employeetime.empid where employeetime.empid='" + empid + "' and employeetime.login between '" + reformattedStr1
					+ "' and '" + reformattedStr2 + "'";
			}
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(strQuery);

		Map<String, String>  map = new HashMap<String, String>();
			ArrayList<Employee> arr = new ArrayList<>();
			
			//String str="<table><tr><th> Emp Id </th><th>Entry</th><th>Exit</th></tr>";
			int noOfRecords=0;
            int recordsPerPage = 20;
            int page=1;

			while (rs.next())
			{	String name=rs.getString(1);
				String entry = rs.getString(2);
				String exit = rs.getString(3);
				
				
				SimpleDateFormat form = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SS");
				Date ent = form.parse(entry);
				Date exi = form.parse(exit);
				
				long en = ent.getTime();
				long ex = exi.getTime();
				
				String diff = (Long.toString((ex-en)/60000));
				Employee emp=new Employee();
				/*map.put("name", name);
				map.put("entry", rs.getString(2));
				map.put("exit", rs.getString(3));
				map.put("diff", diff);
				arr.add(map);*/
				//str+="<tr><td>"+empid+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>";
				emp.setName(rs.getString(1));
				emp.setEntry(entry);
				emp.setExit(exit);
				emp.setDiff(diff);
				arr.add(emp);
				
				noOfRecords++;
				
			}
			
			
//			str+="</table";
//			out.println(str);
			
		//out.print(arr);
		
			
			//System.out.println(arr);
             int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		
		request.setAttribute("arr",arr);
		request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);

		getServletContext().getRequestDispatcher("/Adminview.jsp").forward(request,response);
			
			/* try {
	             

	             request.setAttribute("arr", arr);
	            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("Adminview.jsp");
	            dispatcher.forward(request, response);
	         } catch (Exception e) {
	         }*/

			// HttpSession session=request.getSession();
			// response.sendRedirect("Adminview.jsp");
			/*request.setAttribute("data", arr);
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/Adminview.jsp");
             rd.forward(request, response);
*/
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			out.close();
		}

	}
	

}
