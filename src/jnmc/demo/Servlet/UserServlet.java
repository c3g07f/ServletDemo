package jnmc.demo.Servlet;

import jnmc.demo.Dao.UserDao;
import jnmc.demo.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author C3g07f
 * @date 2023/5/12 11:22
 *
 */
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void init() throws ServletException {
        System.out.println("login初始化成功.......");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);//创建session
        Date createTime = new Date(session.getCreationTime());//获取session创建的时间)
        Date lastAccessTime = new Date(session.getLastAccessedTime());//获取session最后访问的时间

        //设置日期输出的格式
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("用户名"+username);
        System.out.println("密码"+password);
        UserDao dao = new UserDao();
        User user = dao.findOne(username);
        session.setAttribute("user",user);
        System.out.println(user);
        if(user.getUsername() ==null){
            response.getWriter().write("<h1>用户名不存在</h1>");
            System.out.println("用户名不存在");
        } else if (!user.getPassword().equals(password)) {
response.getWriter().write("密码错误");
            System.out.println("密码错误");
        } else {
//            response.getWriter().write("登录成功");
            System.out.println("登录成功");
            request.getSession().setAttribute("name", user.getUsername());
            request.getSession().setAttribute( "date", date);
//            request.getRequestDispatcher("main.jsp").forward(request, response);
            response.sendRedirect("main.jsp");
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("正在执行doGet方法......");
    }

public  void destroy() {
}
}

