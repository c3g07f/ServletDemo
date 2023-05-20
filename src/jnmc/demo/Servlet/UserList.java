package jnmc.demo.Servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
 * @date 2023/5/15 10:18
 */
public class UserList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        System.out.println("list初始化成功.......");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
       String id  = request.getParameter("f1");
        String username = request.getParameter("f2");
        String password = request.getParameter("f3");
        System.out.println("userList参数为："+id+username+password);
        UserlListDao listDao = new UserlListDao();
        List<User> list = new ArrayList<>();
        try {
            list = listDao.findAll(id,username,password);
            PrintWriter writer = response.getWriter();
            JSONArray res = JSONArray.parseArray(JSON.toJSONString(list));//
            request.setAttribute("res", res);
            PrintWriter out = response.getWriter();
            out.write(res.toJSONString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserlListDao listDao = new UserlListDao();
        List<User> list = new ArrayList<>();
        try {
            list = listDao.findList();
            PrintWriter writer = response.getWriter();
            JSONArray res = JSONArray.parseArray(JSON.toJSONString(list));//
            request.setAttribute("res", res);
            PrintWriter out = response.getWriter();
            out.write(res.toJSONString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("f1"));
        User user = new User();
        user.setId(id);
        UserlListDao listDao = new UserlListDao();
        try {
            System.out.println(user);
            PrintWriter writer = response.getWriter();
            writer.write("陈功！");
            listDao.del(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}