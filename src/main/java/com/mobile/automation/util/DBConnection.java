package com.mobile.automation.util;

/**
 * @Author: Lulu
 * @Description: 数据库相关操作
 * @DateTime: 2022/7/13 22:12
 **/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DBConnection {
    private static final Logger log = LoggerFactory.getLogger(DBConnection.class);
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/automaiton?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
    private static Connection conn = null;

    static{
        try{
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e){
            log.error("can not load jdbc driver", e);
        }
    }


    //建立数据库连接
    public static Connection getConn(){
        try{
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            log.error("get connection failure", e);
        }
        return conn;
    }

    //获取user name
    public String[] getUserName(){
        String query = "select * from user";
        String[] user = new String[2];

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                user[0] = rs.getString(1);
                user[1] = rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //关闭数据库连接
    public void closeDBConnection() {
        try{
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            log.error("close connection failure", e);
        }
    }

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        DBConnection.getConn();
        for(int i = 0; i < dbConnection.getUserName().length; i++){
            System.out.println(dbConnection.getUserName()[i]);
        }
        dbConnection.closeDBConnection();
    }
}
