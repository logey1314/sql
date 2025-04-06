package com.my.util;

import java.sql.*;

public class jdbcUtil {
    private static final String url="jdbc:mysql://localhost:3306";
    private static final String username="root";
    private static final String password="";
    //注册驱动
    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    //数据库连接
    public static  Connection getJdbcconect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    //资源释放
    public static void close(Connection conn, PreparedStatement preSatment, ResultSet rs) throws SQLException {
        rs.close();
        preSatment.close();
        conn.close();
    }

}
