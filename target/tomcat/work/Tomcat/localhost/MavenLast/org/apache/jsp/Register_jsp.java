/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-08-08 06:09:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"http://code.jquery.com/ui/1.11.4/jquery-ui.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("<link href=\"https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script src=\"http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.7.0/moment.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style2.css\">\r\n");
      out.write("\r\n");
      out.write("                 <script>\r\n");
      out.write("           $(function() {\r\n");
      out.write("\r\n");
      out.write("             $( \"#jQueryValidateTest\" ).validate();\r\n");
      out.write("\r\n");
      out.write("             $( \"[type=date]\" ).datepicker({\r\n");
      out.write("               onClose: function() {\r\n");
      out.write("                 $( this ).valid();\r\n");
      out.write("               }\r\n");
      out.write("             });\r\n");
      out.write("           });\r\n");
      out.write("                 </script>\r\n");
      out.write("\r\n");
      out.write("<title>Register</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1> Please fill the required form</h1>\r\n");
      out.write("\t<form action=\"Register\" method=\"post\">\r\n");
      out.write("\t\t<input id=\"name\" name=\"name\" required=\"required\" type=\"text\"placeholder=\"my name \" /></br>\r\n");
      out.write("\t\t <input id=\"password\" name=\"password\" required=\"required\" type=\"password\" placeholder=\"password\" /></br>\r\n");
      out.write("          <input id=\"email\" name=\"email\" required=\"required\" type=\"email\" placeholder=\"email@gmail.com\" /></br>\r\n");
      out.write("                    <input id=\"jQueryValidateTest\" type=\"date\" name=\"doj\" required=\"required\" id=\"date\" placeholder=\"mm/dd/yyyy\"></br>\r\n");
      out.write("\r\n");
      out.write("\t\t     <select name=\"Role\" id=\"text\">\r\n");
      out.write("             <option value=\"Software\">Software</option>\r\n");
      out.write("             <option value=\"Analyst\">Analyst</option>\r\n");
      out.write("             <option value=\"Consultant\">Consultant</option>\r\n");
      out.write("             </select></br>\r\n");
      out.write("\t\t<button type=\"submit\">Submit</button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
