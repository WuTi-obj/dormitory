package com.wuti;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
class DormitorymsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void JDBCTest(){
        String driverName="com.mysql.cj.jdbc.Driver";//这是要连接的数据库加载器
        String dbURL="jdbc:mysql://localhost:3306/dormitory?useUnicode=true&characterEncoding=utf-8&useSSL=false&&allowPublicKeyRetrieval=true";//这是要连接的端口号以及数据库名称
        String userName="root";//用户名
        String userpwd="0516";//用户密码
        try {
            Class.forName(driverName);
            System.out.println("加载驱动成功");
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("加载驱动失败");
        }
        try {
            Connection dbConn= DriverManager.getConnection(dbURL,userName,userpwd);
            System.out.println("连接数据库成功");
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

    }
}
