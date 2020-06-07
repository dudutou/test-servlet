package com.dudutou;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

// 扩展 HttpServlet 类
public class HelloWorld extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(HelloWorld.class.getName());

    private String message;
    private int count;

    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "Hello World";
        count = 0;

        System.out.println("init called.");
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

        System.out.println("doGet called.");
        logger.debug("debug - doGet called.");
        logger.info("info - doGet called.");
        
        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error Message!");
        logger.fatal("Fatal Message!");

        ServletContext context = request.getServletContext();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        
        response.setIntHeader("Refresh", 3);
        
        // 设置响应内容类型
        response.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        
        ++ count;
        out.println("<h1>" + count + "</h1>");

    }

    public void destroy()
    {
        System.out.println("destroy called.");
    }
}
