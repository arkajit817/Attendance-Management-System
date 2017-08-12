package com.smallday;



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


@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }



   //This method checks the username & password of the emnployee & sets the value of the entry time in the database

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empid = request.getParameter("empid");
        String password = request.getParameter("password");
        Properties props = new Properties();

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

                //sets the entry time Of the employee in the database
                PreparedStatement ps = con.prepareStatement("insert into employeetime values(?,?,?)");
                int id = rs.getInt("empid");
                System.out.println(id);
                ps.setInt(1, id);
                ps.setTimestamp(2, date);
                ps.setDate(3, null);

                int j = ps.executeUpdate();
                if (j > 0) {
                    //After execution of the query,it sends a message in the homepage displaying the status

                    String message = "Entry done";
                    response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));


                }

            } else {
                //If credentials are wrong
                String message = "Wrong Credentials";
                response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

            }
            rs.close();
            st.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}

