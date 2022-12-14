package com.example.med_app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MedHistoryDAO {
    public static String getDiagnoseDisplayInfo() {
        String res = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                if (null != PractitionerDAO.loggedInPractitioner && -1 != PatientDAO.getCurrentPatientId()) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select d.`Diagnose Codes_diagnoseCode`, dc.description, d.status from encounter e join Diagnose d on e.encounterid = d.encounter_encounterid join `diagnose codes` dc on dc.diagnosecode=d.`Diagnose Codes_diagnoseCode` where e.practitioner_practitionerid=" + PractitionerDAO.loggedInPractitioner.getId() + " and e.patient_patientid=" + PatientDAO.getCurrentPatientId() + " and e.organization_organizationid=" + PractitionerDAO.loggedInPractitioner.getOrganizationId() + ";");
                    while (rs.next()) {
                        res += "<tr>\n" +
                                "                <td>" + rs.getInt(1) +"</td>\n" +
                                "                <td>" + rs.getString(2) + "</td>\n" +
                                "                <td>" + rs.getString(3) + "</td>\n" +
                                "            </tr>\n";
                    }
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }
}
