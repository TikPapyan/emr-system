package com.example.med_app;

import java.sql.*;

public class PractitionerDAO {
    public static Practitioner loggedInPractitioner = null;
    public static String getLoggedInPractitionerNickname() {
        if (null != loggedInPractitioner) {
            return loggedInPractitioner.getEmail();
        }
        return "";
    }
    public static void fillPractitioner(Practitioner p, int practitionerId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select practitionerID, active, firstName, lastName, nickname, email, phone, gender, birthdate, Organization_organizationID, Qualifications_qualificationID from Practitioner;");
            while (rs.next()) {
                if (rs.getInt(1) == practitionerId) {
                    p.setId(practitionerId);
                    p.setActive(rs.getInt(2));
                    p.setFirstName(rs.getString(3));
                    p.setLastName(rs.getString(4));
                    p.setEmail(rs.getString(6));
                    p.setPhoneNumber(rs.getInt(7));
                    p.setGender(rs.getString(8));
                    p.setBirthDate(rs.getString(9));
                    p.setOrganizationId(rs.getInt(10));
                    p.setQualificationId(rs.getInt(11));
                    con.close();
                    return;
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static int isValidLogin(PractitionerCredentials pc) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select practitioner_id, login, password from PractitionerCredential;");
                while (rs.next()) {
                    if (rs.getString(2).equals(pc.getEmail()) && rs.getString(3).equals(pc.getPassword())) {
                        int pId = rs.getInt(1);
                        con.close();
                        return pId;
                    }
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    public static void doLogout() {
        if (null != loggedInPractitioner) {
            loggedInPractitioner = null;
        }
    }
    public static void doLogin(int practitionerId) {
        if (null == loggedInPractitioner) {
            loggedInPractitioner = new Practitioner();
            fillPractitioner(loggedInPractitioner, practitionerId);
        }
    }
    public static int registerPractitioner(Practitioner p) {
        int result = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select count(*) from Practitioner;");
                rs.next();
                int practCount = rs.getInt(1);
                int newPractId = practCount + 1;
                PreparedStatement practPreparedStatement = con.prepareStatement("insert into Practitioner(practitionerID, active, firstName, lastName, nickname, email, phone, gender, birthdate, Organization_organizationID, Qualifications_qualificationID) values(?,?,?,?,?,?,?,?,?,?,?);");
                practPreparedStatement.setInt(1, newPractId);
                practPreparedStatement.setInt(2, 1); // active, randomly set it to 1
                practPreparedStatement.setString(3, p.getFirstName());
                practPreparedStatement.setString(4, p.getLastName());
                practPreparedStatement.setString(5, p.getEmail());
                practPreparedStatement.setString(6, p.getEmail());
                practPreparedStatement.setInt(7, p.getPhoneNumber());
                practPreparedStatement.setString(8, p.getGender());
                practPreparedStatement.setString(9, p.getBirthDate());
                practPreparedStatement.setInt(10, p.getOrganizationId());
                practPreparedStatement.setInt(11, p.getQualificationId());
                result = practPreparedStatement.executeUpdate();

                PreparedStatement practcrdlPreparedStatement = con.prepareStatement("insert into PractitionerCredential(practitioner_id, login, password) values(?,?,?);");
                practcrdlPreparedStatement.setInt(1, newPractId);
                practcrdlPreparedStatement.setString(2, p.getEmail());
                practcrdlPreparedStatement.setString(3, p.getPassword());
                result = practcrdlPreparedStatement.executeUpdate();

                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
