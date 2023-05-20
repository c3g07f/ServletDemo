package jnmc.demo.Dao;

import jnmc.demo.DBConn;
import jnmc.demo.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author C3g07f
 * @date 2023/5/12 11:05
 */
public class UserDao {
    public User findOne(String name){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            conn = DBConn.getConnection(); //获取连接
            String query = "SELECT * FROM t_user WHERE name =?";//写Sql语句
            pstmt =conn.prepareStatement(query);//获取PreparedStatement对象
            pstmt.setString(1, name);//把参数写入sql语句中
            resultSet = pstmt.executeQuery();//执行查询操作
            if(resultSet.next()) {//如果有数据返回true
                user.setId(resultSet.getInt("id"));//获取列表中的第一行数据的id
                user.setUsername(resultSet.getString("name"));//获取列表中的第一行数据的username
                user.setPassword(resultSet.getString("password"));//获取列表中的第一行数据的password
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                DBConn.closeAll(resultSet, pstmt, conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return  user;
    }
}
