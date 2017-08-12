package com.smallday;



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


@WebServlet("/Adminview")
public class Adminview extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public Adminview() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        response.setContentType("text/html;charset=UTF-8");



        PrintWriter out = response.getWriter();
       String from = request.getParameter("from");
        String upto = request.getParameter("upto");
        String empid = request.getParameter("empid");

        //connecting with the database
        Connect connect = new Connect();
        Connection con = connect.getConnection();

        try {
            String strQuery = "";
            //If Admin does'nt give any employeeid
            if (empid == "") {
                strQuery = "select employeedet.name,employeetime.login,employeetime.logout from employeetime LEFT JOIN employeedet on employeedet.empid=employeetime.empid where  employeetime.login between '"
                        + from + "' and '" + upto + "'";
            //With employeeid
            } else {
                strQuery = "select employeedet.name,employeetime.login,employeetime.logout from employeetime LEFT JOIN employeedet on employeedet.empid=employeetime.empid where employeetime.empid='"
                        + empid + "' and employeetime.login between '" + from + "' and '" + upto
                        + "'";
            }

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strQuery);

            Map<String, String> map = new HashMap<String, String>();
            ArrayList<Employee> arr = new ArrayList<>();

            int noOfRecords = 0;

            //If there exist any data between the dates
            while (rs.next()) {

                //etch the name,entry & exit time from database
                String name = rs.getString(1);
                String entry = rs.getString(2);
                String exit = rs.getString(3);

                SimpleDateFormat form = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SS");
                Date ent = form.parse(entry);
                long ex;

                //If someone has exited till the date
                if (exit != null) {
                    Date exi = form.parse(exit);
                    ex = exi.getTime();

                }

                //Exit is yet to be done till the Upto date
                else {
                    ex = 0;
                }
                //Calculating the difference between entry & exit time
                long en = ent.getTime();

                String diff = (Long.toString((ex - en) / 60000));
                Employee emp = new Employee();

                emp.setName(rs.getString(1));
                emp.setEntry(entry);
                emp.setExit(exit);
                emp.setDiff(diff);

                //Adding the datas in ArrayList
                arr.add(emp);

                noOfRecords++;

            }
            if (noOfRecords == 0) {

                out.println("<script type=\"text/javascript\">");
                out.println("alert('No datas found ');");
                out.println("location='Admin.jsp';");
                out.println("</script>");


            }

            else {

                request.setAttribute("arr", arr);
                //Passing
                getServletContext().getRequestDispatcher("/Adminview.jsp").forward(request, response);


            }

        }

        catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }

}
