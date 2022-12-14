package com.example.med_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientDAO {
    private static int currentPatientId = -1;
    public static int getCurrentPatientId() {
        return currentPatientId;
    }
    public static void setCurrentPatientId(int id) {
        currentPatientId = id;
    }
    public static String getSelectedPatientDisplayInfo() {
        if (-1 != currentPatientId) {
            Patient p = getPatient(currentPatientId);
            return "<div class=\"border\" style=\"height:50px;\">" + p.getFirstName() + " " + p.getLastName() + "</div>\n" +
                    "        <div class=\"border\" style=\"height:50px;\">" + "Date of birth: " + p.getBirthDate() + "</div>\n" +
                    "        <div class=\"border\" style=\"height:50px;\">" + p.getGender() + "</div>\n" +
                    "        <div class=\"border\" style=\"height:50px;\">" + "language: " + p.getComLang() + "</div>\n" +
                    "        <div class=\"border\" style=\"height:50px;\">" + "Tel: " + p.getPhoneNumber() + "</div>\n" +
                    "        <div class=\"border\" style=\"height:50px;\">" + p.getEmail() + "</div>\n";
            // TODO:"        <div class=\"border\" style=\"height:50px;\">Address</div>";
        }
        return "";
    }
    public static Patient getPatient(int patientId){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select firstName, lastName, gender, birthDate, phone, email, communicationLanguage from Patient where patientid =" + patientId + ";");
                rs.next();
                Patient p = new Patient();
                p.setFirstName(rs.getString(1));
                p.setLastName(rs.getString(2));
                p.setGender(rs.getString(3));
                p.setBirthDate(rs.getString(4));
                p.setPhoneNumber(rs.getString(5));
                p.setEmail(rs.getString(6));
                p.setComLang(rs.getString(7));
                // TODO:address and later other parts!
                con.close();
                return p;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void registerPatient(Patient p){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select count(*) from Patient;");
                rs.next();
                int patientCount = rs.getInt(1);
                int newPatientId = patientCount + 1;
                // Patient table
                PreparedStatement patientPreparedStatement = con.prepareStatement("insert into Patient(patientID, RecordActive, firstName, lastName, gender, birthDate, deceased, maritalStatus, multipleBirth, phone, email, communicationLanguage) values(?,?,?,?,?,?,?,?,?,?,?,?);");
                patientPreparedStatement.setInt(1, newPatientId);
                patientPreparedStatement.setInt(2, 1); // active, randomly set it to 1
                patientPreparedStatement.setString(3, p.getFirstName());
                patientPreparedStatement.setString(4, p.getLastName());
                patientPreparedStatement.setString(5, p.getGender());
                patientPreparedStatement.setString(6, p.getBirthDate());
                patientPreparedStatement.setInt(7, 1); // deceased, randomly set it to 1
                patientPreparedStatement.setString(8, p.getMaritalStatus());
                patientPreparedStatement.setInt(9, 1); // multipleBirth, randomly set it to 1
                patientPreparedStatement.setString(10, p.getPhoneNumber());
                patientPreparedStatement.setString(11, p.getEmail());
                patientPreparedStatement.setString(12, p.getComLang());
                patientPreparedStatement.executeUpdate();


                // PatientContacts table
                Statement stmt2=con.createStatement();
                ResultSet rs2=stmt2.executeQuery("select count(*) from PatientContacts;");
                rs2.next();
                int patientContactsCount = rs2.getInt(1);
                int newPatientContactsId = patientContactsCount + 1;

                PreparedStatement patientContactsPreparedStatement = con.prepareStatement("insert into PatientContacts(contactID, firstName, lastName, gender, phone, email, organization, Patient_patientID) values(?,?,?,?,?,?,?,?);");
                patientContactsPreparedStatement.setInt(1, newPatientContactsId);
                patientContactsPreparedStatement.setString(2, p.getFirstName());
                patientContactsPreparedStatement.setString(3, p.getLastName());
                patientContactsPreparedStatement.setString(4, p.getGender());
                patientContactsPreparedStatement.setString(5, p.getPhoneNumber());
                patientContactsPreparedStatement.setString(6, p.getEmail());
                patientContactsPreparedStatement.setString(7, OrganizationDAO.getOrganizationName(PractitionerDAO.loggedInPractitioner.getOrganizationId()));
                patientContactsPreparedStatement.setInt(8, newPatientId);
                patientContactsPreparedStatement.executeUpdate();

                // PatientAddress table
                Statement stmt3=con.createStatement();
                ResultSet rs3=stmt2.executeQuery("select count(*) from PatientAddress;");
                rs3.next();
                int patientAddressCount = rs3.getInt(1);
                int newPatientAddressId = patientAddressCount + 1;

                PreparedStatement patientAddressPreparedStatement = con.prepareStatement("insert into PatientAddress(addressID, city, district, state, postalCode, country, Patient_patientID) values(?,?,?,?,?,?,?);");
                patientAddressPreparedStatement.setInt(1, newPatientAddressId);
                patientAddressPreparedStatement.setString(2, p.getCity());
                patientAddressPreparedStatement.setString(3, p.getDistrict());
                patientAddressPreparedStatement.setString(4, p.getState());
                patientAddressPreparedStatement.setString(5, p.getPostalCode());
                patientAddressPreparedStatement.setString(6, p.getCountry());
                patientAddressPreparedStatement.setInt(7, newPatientId);
                patientAddressPreparedStatement.executeUpdate();

                // Patient_has_Practitioner
                PreparedStatement patientHasPractitionerPreparedStatement = con.prepareStatement("insert into Patient_has_Practitioner(Practitioner_practitionerID, Patient_patientID) values(?,?);");
                patientHasPractitionerPreparedStatement.setInt(1, PractitionerDAO.loggedInPractitioner.getId());
                patientHasPractitionerPreparedStatement.setInt(2, newPatientId);
                patientHasPractitionerPreparedStatement.executeUpdate();

                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String getPatientsListContent(int practitionerId) {
        String res = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select firstName, lastName, patientid from Patient\n" +
                        "join patient_has_practitioner\n" +
                        "on patient_has_practitioner.patient_patientid = Patient.patientid\n" +
                        "where patient_has_practitioner.practitioner_practitionerid = " + practitionerId + ";");
                while (rs.next()) {
                    res += "<div class=\"xclass\">\n" +
                            "    <div class=\"row\">\n" +
                            "        <img src=\"images/account.png\" alt=\"patient image\" style=\"width:100%\">\n" +
                            "        <p>" + rs.getString(1) + " " + rs.getString(2) + "</p>\n" +
                            "        <button type=\"button\" class=\"button7\"> <a href=\"MedHistory?patientId=" + rs.getInt(3) + "\">VIEW HISTORY</a>\n" +
                            "        </button>\n" +
                            "       <button type=\"button\" class=\"button8\"> <a href=\"ClinicalNote?patientId=" + rs.getInt(3) + "\">CREATE CLINICAL NOTE</a>\n" +
                            "        </button>\n" +
                            "    </div>\n" +
                            "</div>\n" +
                            "<p></p>";
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

}
