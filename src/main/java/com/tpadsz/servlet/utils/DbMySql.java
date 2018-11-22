package com.tpadsz.servlet.utils;


import java.sql.*;

/**
 * Created by hongjian.chen on 2017/9/14.
 */
public class DbMySql {

    public static int getTaskNum() {
        int times = 0;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql;
        String url = "jdbc:mysql://10.10.11.57:3306/ctc_hq?user=hongjian&password=hongjian&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url);
            sql = "SELECT COUNT(1) FROM `log_task` where app_id='9' and result_code='000' and DateDiff(create_date,CURDATE())=0";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                times = rs.getInt(1);
                System.out.println(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null && pstm != null && conn != null) {
                try {
                    rs.close();
                    pstm.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return times;
    }

    //数据库连接对象
    private static Connection conn = null;

    private static String driver = "oracle.jdbc.driver.OracleDriver"; //驱动

    private static String url = "jdbc:oracle:thin:@//122.112.229.195:1521/xe"; //连接字符串

    private static String username = "root"; //用户名

    private static String password = "root"; //密码


    // 获得连接对象
    private static synchronized Connection getConn() {
        if (conn == null) {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
                String sql = "SELECT * FROM person ORDER BY age ASC";
                PreparedStatement pstm = conn.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
//                    String times = rs.getString(1);
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
                }
                System.out.println(conn);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void main(String[] args) {
        getConn();
//        getTaskNum();
    }
}
