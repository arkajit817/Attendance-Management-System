package com.smallday;



import javax.servlet.http.*;
import java.io.IOException;

public class Hello extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        httpServletResponse.getWriter().print("Hello from servlet");
    }
}
