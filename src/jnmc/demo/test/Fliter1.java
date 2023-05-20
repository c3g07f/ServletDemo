package jnmc.demo.test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author C3g07f
 * @date 2023/5/9 19:25
 */
public class Fliter1 implements Filter {



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤器1");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 获取所有的参数名称
        String s = req.getParameter("username");//获取第一个参数值
        PrintWriter writer = resp.getWriter();


        resp.setContentType("text/html;charset=UTF-8");
         if (s.equals("小明")) {
            writer.println("<h1>小明禁止访问！</h1>");
            System.out.println("小明禁止访问");
        }else filterChain.doFilter(req, resp);
//        if (s1.equals("小明")&&s.equals("name")) {
//                System.out.println("小明禁止访问");
//                writer.println("<h1>小明禁止访问！</h1>");
//            }
//        else {
//            filterChain.doFilter(req, resp);
//        }
//        if (s1.equals("小明")&&s.equals("name")){
//            System.out.println("小明禁止访问");
//            writer.println("<h1>小明禁止访问！</h1>");
////            writer.println("<h1>XIAOMING JINZHI</h1>");
////            servletRequest.setAttribute(" Fliter2 ",false);
//        }
//        else {
//            filterChain.doFilter(req, resp);
//        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName() + "被初始化了");
    }
    @Override
    public void destroy() {
    }
}
