package com.smallday;




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


@WebServlet("/Admin")
public class Admin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Admin() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().append("Served at: ").append(request.getContextPath());
        System.out.println("yooo");
        response.setContentType("text/html");

        String empid = request.getParameter("empid");
        String password = request.getParameter("password");

        Properties props = new Properties();
        java.io.InputStream in = null;
        Connection con = null;

        try {
            in = new Login().getClass().getResourceAsStream("/dbconfig.properties");

            props.load(in);
            Class.forName(props.getProperty("DB_DRIVER"));

            Connection conn = DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USER"),
                    props.getProperty("DB_PASSWORD"));

            String strQuery = "select * from employeedet where empid='" + empid + "' and password='" + password
                    + "' and Role='Admin'";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(strQuery);

            if (rs.next()) {
                response.sendRedirect("Admin.jsp");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        response.setContentType("text/html");

        String from = request.getParameter("from");
        String upto = request.getParameter("upto");
        String empid = request.getParameter("empid");

        Connect connect = new Connect();
        Connection con = connect.getConnection();

        try {

            String strQuery = "select * from employeetime where empid='" + empid + "' and login between'" + from
                    + "'and '" + upto + "'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strQuery);

            Map<String, String> map = new LinkedHashMap<String, String>();

            ArrayList<Map<String, String>> arr = new ArrayList<>();
            while (rs.next()) {
                String exit = rs.getString(3);

                System.out.println(exit);
                map.put("entry", rs.getString(2));
                map.put("exit", exit);
                arr.add(map);
            }

            System.out.println(arr);

            HttpSession session = request.getSession();
            session.setAttribute("data", arr);
            request.getRequestDispatcher("Adminview.jsp").forward(request, response);
            ;

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}

