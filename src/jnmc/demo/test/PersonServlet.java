package jnmc.demo.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author C3g07f
 * @date 2023/5/9 19:22
 */
public class PersonServlet extends HttpServlet {
    public void init() throws ServletException {
        System.out.println("init...");
    }
    public void destroy() {
        System.out.println("destroy...");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
//        Enumeration<String> parameterNames = request.getParameterNames();
//        String s = parameterNames.nextElement();
//        String parameter = request.getParameter(s);
//
//
//        String s = String.valueOf(request.getParameterNames());
//
//        System.out.println("请求参数列表：" + s);

    }
}
