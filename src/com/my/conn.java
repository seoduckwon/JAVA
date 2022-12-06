package com.my;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class conn {
 
    public static void main(String[] args) {
        // DB 접속 객체선언
        Connection conn = null;
 
        try {
            // Maria db 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");
            // 데이터베이스 접속
            conn = DriverManager.getConnection("jdbc:mariadb://172.30.1.49:3306/return", "duckwon", "tjejrdnjs1!");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        if (conn != null) {
            System.out.println("접속성공");
        }
 
    }
 
}