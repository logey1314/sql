package com.my.util;

import java.sql.*;

public class Test {
    @org.junit.Test
    public void test() throws ClassNotFoundException, SQLException {
        Connection con = jdbcUtil.getJdbcconect();
        String name = "admin";
        String password = "admin123";
        String sql = "select name password from db4.user where name='"
                + name +
                "'and password='" + password + "'";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("密码错误");
        }
        resultSet.close();
        statement.close();
        con.close();

    }

    @org.junit.Test
    public void test2() throws ClassNotFoundException, SQLException {

        Connection con = jdbcUtil.getJdbcconect();
        String name = "admin";
        String password = "admin123";
        String sql = "select name password from db4.user where name=? and password=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("密码错误");
        }
        jdbcUtil.close(con, preparedStatement, resultSet);

    }
}