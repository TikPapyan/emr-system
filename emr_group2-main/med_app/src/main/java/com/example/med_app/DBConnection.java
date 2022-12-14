package com.example.med_app;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static String getDatabaseName() {
        return "patient";
    }
    public static String getUser() {
        return "root";
    }
    public static String getPassword() {
        return "root";
    }
    public static Connection getDefaultConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + getDatabaseName(), getUser(), getPassword());
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}