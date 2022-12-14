package com.example.med_app;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SuperAdminDAO {
    public static boolean isValidLogin(SuperAdmin s) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select login, password from SuperAdminCredential;");
                while (rs.next()) {
                    if (rs.getString(1).equals(s.getEmail()) && rs.getString(2).equals(s.getPassword())) {
                        con.close();
                        return true;
                    }
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public static boolean registerSuperAdmin(SuperAdmin s) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                PreparedStatement preparedStatement = con.prepareStatement("insert into SuperAdminCredential(login, password) values(?,?);");
                preparedStatement.setString(1, s.getEmail());
                preparedStatement.setString(2, s.getPassword());
                preparedStatement.executeUpdate();
                con.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
