package com.mugbya.injection.util;

import java.sql.*;

/**
 * Created by mugbya on 2015/3/30.
 */
public class DBUtil {
    public static Connection getConnection()
            throws Exception{
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/sql_injection" +
                                    "?useUnicode=true&characterEncoding=utf8",
                            "root","123456");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return conn;
    }
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(getConnection());
    }

}
