package jnmc.demo;



import java.sql.*;

/**
 * @author C3g07f
 * @date 2023/5/12 10:51
 */
public class DBConn {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///servlettest?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8";
        String user = "root";
        String pwd = "123456";
        Connection conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("连接数据库成功");
        return  conn;
    }
    public static void closeAll(ResultSet resultSet, Statement statement, Connection conn)throws  SQLException{
        if(resultSet!=null)
            resultSet.close();
        if(statement!=null) //防止空指针异常，当我们使用null去调用对应的方法来封装数据时，就会出现空指针异常
            statement.close();
        if(conn!=null)
            conn.close();
    }
}
