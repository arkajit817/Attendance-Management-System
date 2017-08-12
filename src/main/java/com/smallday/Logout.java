package com.smallday;



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


    public Logout() {
        super();
    }



    //This method checks the username & password of the emnployee & sets the value of the exit time in the database
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empid = request.getParameter("empid");
        String password = request.getParameter("password");

        Connect connect = new Connect();
        Connection con = connect.getConnection();

        try {
            //checks the empid & password
            String strQuery = "select * from employeedet where empid='" + empid + "' and password='" + password + "'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strQuery);
            //After validation
            if (rs.next()) {
                java.sql.Timestamp date = new Timestamp(new java.util.Date().getTime());
                int id = rs.getInt("empid");


                //sets the exit time Of the employee in the database
                PreparedStatement ps = con.prepareStatement("UPDATE Employeetime SET logout ='" + date
                        + "'WHERE empid ='" + id + "'" + " AND logout is null");

                int j = ps.executeUpdate();
                System.out.println(date);
                if (j > 0) {

                    //After execution of the query,it sends a message in the homepage displaying the status
                    String message = "Exit done";
                    response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

                }

            } else {

                //If credentials are wrong
                String message = "Wrong Credentials";
                response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

