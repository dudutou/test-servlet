package com.dudutou;

import javax.servlet.*;
import java.io.PrintWriter;

public class TestFilter implements Filter  {
    public void  init(FilterConfig config) throws ServletException {
        // 获取初始化参数
        String site = config.getInitParameter("Site");

        // 输出初始化参数
        System.out.println("网站名称: " + site);
    }
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        // 输出站点名称
        System.out.println("站点网址：http://www.runoob.com");

        String name = request.getParameter("name");
        if ("miwa".equals(name)) {
            System.out.println("name is miwa. Go! Go!");
            // 把请求传回过滤链
            chain.doFilter(request,response);
        } else {
            System.out.println("name is not miwa. Error!");
            PrintWriter out = response.getWriter();
            out.print("name is not miwa. Error!");
        }
    }
    public void destroy( ){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}