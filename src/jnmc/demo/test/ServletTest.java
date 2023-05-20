package jnmc.demo.test;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * ceshi
 *
 * @author C3g07f
 * @date 2023/5/8 14:38
 */
public class ServletTest extends HttpServlet {
    @Override
    public void init() throws ServletException{
        System.out.println("初始化成功.......");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
//        out.println("<html><body><div class=\"container\">\n" +
//                "        <h1>Login</h1>\n" +
//                "        <form action=\"ServletTest\" method=\"post\">\n" +
//                "            <input type=\"text\" class=\"tbx\" placeholder=\"账号\" name=\"name\">\n" +
//                "            <input type=\"password\" class=\"tbx\" placeholder=\"密码\" name=\"password\">\n" +
//                "            <input type=\"submit\" class=\"sub\" value=\"登录\">\n" +
//                "        </form>\n" +
//                "    </div></body></html>");
//        out.flush();
//        out.close();
        System.out.println("正在执行doGet方法......");
        destroy();
        System.out.println(req.getContextPath());
        System.out.println(req.getRequestURL());//请求的URL,servlet地址
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");//请求的字符编码格式,解决中文乱码
        System.out.println("正在执行doPost方法......");
        String name =req.getParameter("firstname");
        String xing =req.getParameter("lastname");
        System.out.println("名"+name+"\t\t"+"姓"+xing);
        destroy();
    }
public void service(ServletRequest req,ServletResponse resp) throws ServletException, IOException {
        //service() 方法是执行实际任务的主要方法。Servlet 容器（即 Web 服务器）
    // 调用 service() 方法来处理来自客户端（浏览器）的请求，并把格式化的响应写回给客户端。
    //每次服务器接收到一个 Servlet 请求时，服务器会产生一个新的线程并调用服务。
    // service() 方法检查 HTTP 请求类型（GET、POST、PUT、DELETE 等），并在适当的时候调用 doGet、doPost、doPut，doDelete 等方法。
    System.out.println("正在执行service方法......");
    doGet((HttpServletRequest) req, (HttpServletResponse) resp);
    doPost((HttpServletRequest) req, (HttpServletResponse) resp);
}
public void destory(){

}

}