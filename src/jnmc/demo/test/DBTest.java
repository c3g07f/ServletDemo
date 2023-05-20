package jnmc.demo.test;

import jnmc.demo.Dao.UserDao;
import jnmc.demo.bean.User;

/**
 * 数据库测试
 *
 * @author C3g07f
 * @date 2023/5/12 11:35
 */
public class DBTest {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        User user = dao.findOne("1");
        System.out.println(user);

    }
}
