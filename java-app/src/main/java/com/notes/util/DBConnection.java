package com.notes.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String host = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "localhost";
            String url = "jdbc:mysql://" + host + ":3306/notesdb?useSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(url, "notesuser", "notespass");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
