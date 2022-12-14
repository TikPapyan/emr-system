package com.example.med_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrganizationDAO {
    public static boolean registerOrganization(Organization o) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select count(*) from Organization;");
                rs.next();
                int orgCount = rs.getInt(1);
                int newOrgId = orgCount + 1;
                int result = 0;
                PreparedStatement orgPreparedStatement = con.prepareStatement("insert into organization(organizationID, active, name) values(?,?,?);");
                orgPreparedStatement.setInt(1, newOrgId);
                orgPreparedStatement.setInt(2, 1); // active, randomly set it to 1
                orgPreparedStatement.setString(3, o.getOrganizationName());
                result = orgPreparedStatement.executeUpdate();

                stmt=con.createStatement();
                rs=stmt.executeQuery("select count(*) from OrganizationAddress;");
                rs.next();
                int orgaddressCount = rs.getInt(1);
                int newOrgAddressId = orgaddressCount + 1;

                PreparedStatement orginfoPreparedStatement = con.prepareStatement("insert into OrganizationAddress(AddressID, Organization_organizationID, country, city, state, district, postalCode) values(?,?,?,?,?,?,?);");
                orginfoPreparedStatement.setInt(1, newOrgAddressId);
                orginfoPreparedStatement.setInt(2, newOrgId);
                orginfoPreparedStatement.setString(3, o.getCountry());
                orginfoPreparedStatement.setString(4, o.getCity());
                orginfoPreparedStatement.setString(5, o.getState());
                orginfoPreparedStatement.setString(6, o.getDistrict());
                orginfoPreparedStatement.setInt(7, Integer.parseInt(o.getPostalCode()));
                result = orginfoPreparedStatement.executeUpdate();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    public static String getOrganizationsOptions() {
        String res = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select organizationID, name from Organization;");
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
    public static String getOrganizationName(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select organizationID, name from Organization;");
                while (rs.next()) {
                    if (rs.getInt(1) == id) {
                        String name = rs.getString(2);
                        con.close();
                        return name;
                    }
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
