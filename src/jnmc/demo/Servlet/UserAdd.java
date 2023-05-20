package jnmc.demo.Servlet;

import jnmc.demo.Dao.UserlListDao;
import jnmc.demo.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author C3g07f
 * @date 2023/5/15 14:53
 */
public class UserAdd  extends HttpServlet {
    private  static final long serialVersionUID = 1L;
    public void init() throws ServletException {
        System.out.println("list初始化成功.......");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String f2 = request.getParameter("f2");
        String f3 = request.getParameter("f3");
        UserlListDao listDao = new UserlListDao();
//        List<User> list = new ArrayList<>();
        User user = new User();
        user.setUsername(f2);
        user.setPassword(f3);
        System.out.println(user);
        try {
            listDao.add(user);
            System.out.println("添加成功");
//            request.setAttribute("list", list);
            PrintWriter writer = response.getWriter();
//            writer.write(list.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("get请求执行.......");
    }

}
