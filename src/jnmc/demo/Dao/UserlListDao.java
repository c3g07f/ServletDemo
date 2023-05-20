package jnmc.demo.Dao;

import jnmc.demo.DBConn;
import jnmc.demo.bean.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author C3g07f
 * @date 2023/5/15 10:20
 */
public class UserlListDao {
    public List findList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        try {
            conn = DBConn.getConnection(); //获取连接
            String sql = "select * from t_user where 1=1";
            pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        pstmt.close();
        resultSet.close();
        conn.close();
        return list;
    }
        public  List findAll(String p_id,String p_name,String p_password) throws IOException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        try {
            conn = DBConn.getConnection(); //获取连接
            String sql = "select * from t_user where 1=1";
            System.out.println("id为"+p_id);
            System.out.println("name为"+p_name);
            System.out.println("密码为"+p_password);
            if (!"".equals(p_id) ) {
                sql += " and id like '%" + p_id + "%'";
            }
            if (!"".equals(p_name) ) {
                sql += " and name like '%" + p_name + "%'";
            }
            if (!"".equals(p_password) ) {
                sql += " and password like '%" + p_password + "%'";
            }
            System.out.println(sql);
         pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        pstmt.close();
        resultSet.close();
        conn.close();
        return list;
    }

    public  void del(User user) throws IOException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        try {
            conn =DBConn.getConnection();
            String sql = "delete from t_user where id =?";
            System.out.println(user.getId());
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, user.getId());
            int count = preparedStatement.executeUpdate();//
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void delAll(String[] delList){
        Connection conn = null;
        User user = new User();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        ArrayList<User> list = new ArrayList<>();
        try {
            conn = DBConn.getConnection();
//            String sql = "delete from t_user where id in ("+delList[0];
            String sql = "delete from t_user where id in ("+delList[0]+")";
            sql = sql.replace("[","");
            sql = sql.replace("]","");
            System.out.println(sql);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            int i = preparedStatement.executeUpdate();
//            while(rs.next()){
//            user.setId(rs.getInt("id"));
//            user.setUsername(rs.getString("name"));
//            user.setPassword(rs.getString("password"));
//            list.add(user);
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  void update(User user) throws IOException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();

        try {
            conn =  DBConn.getConnection(); //获取连接
            String sql = "update t_user set name =?, password =? where id =?";
           pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public  void add(User user) throws IOException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();

        try {
            conn = DBConn.getConnection(); //获取连接
            String sql = "insert into t_user (name,password) values(?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,  user.getUsername());
            pstmt.setString(2, user.getPassword());
            System.out.println(pstmt);
            pstmt.execute();

        } catch (SQLException e) {
            throw  new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
