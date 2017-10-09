package com.tpadsz.servlet.utils;

import com.mysql.jdbc.Connection;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hongjian.chen on 2017/9/14.
 */
public class DbMySql {

    @Test
    public void getTaskNum() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        String sql;
        String url = "jdbc:mysql://10.10.11.80:3306/boss_locker?user=ccy&password=ccy&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url);
            System.out.println(conn);
            sql = "INSERT INTO boss_locker.anniversary_activity(myself,friends) values(?,?)";
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i < 10; i++) {
                pstm.setString(1, "7344614");
                pstm.setString(2, "" + i);
                int flag = pstm.executeUpdate();
                System.out.println(flag);
            }
            sql = "SELECT COUNT(1) from anniversary_activity where myself='7344614' GROUP BY myself";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
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
    }
}
