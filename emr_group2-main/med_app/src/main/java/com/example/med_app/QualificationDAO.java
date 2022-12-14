package com.example.med_app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class QualificationDAO {
    public static String getQualificationOptions() {
        String res = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select qualificationID, description from Qualifications;");
                while (rs.next()) {
                    res += "<option value=\"" + rs.getInt(1) + "\">" + rs.getString(2) + "</option>\n";
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
}
