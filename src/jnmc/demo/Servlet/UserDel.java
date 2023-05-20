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
public class UserDel extends HttpServlet {
    private  static final long serialVersionUID = 1L;
    public void init() throws ServletException {
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] delId = request.getParameterValues("Ids");
//        for (int i = 0; i < delId.length; i++){
//            System.out.println(delId[i]);
//        }
        UserlListDao listDao = new UserlListDao();
        try {
            listDao.delAll(delId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int f1 = Integer.parseInt(request.getParameter("f1"));
        String f2 = request.getParameter("f2");
        String f3 = request.getParameter("f3");
        System.out.println(f1);
        UserlListDao listDao = new UserlListDao();
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(f1);
        user.setUsername(f2);
        user.setPassword(f3);
        try {
            listDao.del(user);
            request.setAttribute("list", list);
            PrintWriter writer = response.getWriter();
            writer.write(list.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
