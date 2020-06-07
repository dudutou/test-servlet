package com.dudutou;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String message;

    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "Hello World";

        System.out.println("init called.");
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

        System.out.println("doGet called.");

        ServletContext context = request.getServletContext();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();

        message += "¥n contextPath = " + contextPath;
        message += "¥n servletPath = " + servletPath;
        // 设置响应内容类型
        response.setContentType("text/html");

        response.sendError(404, "Error happened.");
    }

    public void destroy()
    {
        System.out.println("destroy called.");
    }
}

