package com.tpadsz.servlet.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDemo {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String url = "jdbc:mysql://10.132.55.23:3306/test?useUnicode=true&characterEncoding=UTF8";
        String user = "hongjian";
        String password = "hongjian";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url, user, password);
            Statement e = conn.createStatement();
            String sql = "insert into hongjianTest values(\'104\',\'test04\',\'1234\')";
            int result = e.executeUpdate(sql);
            if(result != -1) {
                System.out.println("创建数据表成功:" + conn);
            }

            ResultSet rs = e.executeQuery("select * from hongjianTest");
            System.out.println("name\tpwd");

            while(rs.next()) {
                System.out.println(rs.getString(2) + "\t" + rs.getString(3));
            }
        } catch (SQLException var13) {
            System.out.println("MySQL操作错误");
            var13.printStackTrace();
        } catch (Exception var14) {
            var14.printStackTrace();
        } finally {
            conn.close();
        }

    }
}
