package com.my.demo1;

import org.junit.Test;

import java.sql.*;

public class jdbc {


    @Test
    public void myTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
        String sql="select id, name, age, brithy, sex, address, score from db4.student";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.getInt("id"));

        }
        rs.close();
        st.close();
        con.close();

    }
}
