package com.smallday;



        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.net.URLEncoder;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import java.util.Properties;
        import java.util.Random;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Register() {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }




   // This method takes the inout value & sets the values in Database by setter method & generates an employee id of four digit no

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String doj = request.getParameter("doj");
        String email = request.getParameter("email");
        String role = request.getParameter("Role");


        Properties props = new Properties();
        java.io.InputStream in = null;
        Connection con = null;

        try {
            in = new Login().getClass().getResourceAsStream("/dbconfig.properties");

            props.load(in);

            Class.forName(props.getProperty("DB_DRIVER"));
            con = DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USER"),
                    props.getProperty("DB_PASSWORD"));



                PreparedStatement ps = con.prepareStatement("insert into employeedet values(?,?,?,?,?,?)");
                Random random = new Random();
                int value = random.nextInt(10000);
                String id=String.valueOf(value);
                ps.setString(1, name);
                ps.setString(2, password);
                ps.setString(3, doj);
                ps.setString(4, email);
                ps.setString(5, id);
                ps.setString(6, role);
                int j = ps.executeUpdate();
                if (j > 0) {
                    String message = "Thank You for registering & your id is"+id;
                    response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));


                }
                out.close();


        }

        catch (Exception e2) {
            System.out.println(e2);
        }
    }

}

