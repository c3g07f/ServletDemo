package jnmc.demo.test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author C3g07f
 * @date 2023/5/9 19:29
 */
public class Fliter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入过滤器2");
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpServletRequest req = (HttpServletRequest)servletRequest;
//        Enumeration<String> parameterNames = req.getParameterNames();
//       String s = parameterNames.nextElement();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String s = req.getParameter("username");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        if (s.equals("小红")){
out.println("<h1>小红禁止访问</h1>");
//out.println("<h1>XIAOHONGJINZHI!</h1>");
            System.out.println("小红禁止访问");
        }
        else {
            filterChain.doFilter(req, resp);
//            out.println("<h1>"+s1+"，您好！</h1>");

        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName() + "被初始化了");
    }
    @Override
    public void destroy() {
    }
}
