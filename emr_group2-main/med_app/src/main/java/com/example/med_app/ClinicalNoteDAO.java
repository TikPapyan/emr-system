package com.example.med_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class ClinicalNoteDAO {
    public static void createClinicalNode(ClinicalNote c){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DBConnection.getDefaultConnection();
            if (null != con) {
                //Encounter table
                Statement stmt=con.createStatement();
                ResultSet re=stmt.executeQuery("select count(*) from Encounter;");
                re.next();
                int encounterCount = re.getInt(1);
                int newEncounterId = encounterCount + 1;
                PreparedStatement encounterPreparedStatement = con.prepareStatement("insert into Encounter(encounterId, status, type, startDate, reason, Organization_organizationID, Practitioner_practitionerID, Patient_patientID, description, note) values(?,?,?,?,?,?,?,?,?,?);");
                encounterPreparedStatement.setInt(1, newEncounterId);
                encounterPreparedStatement.setString(2, "default_status"); // status
                encounterPreparedStatement.setString(3, "default_type"); // type
                encounterPreparedStatement.setString(4, c.getLast_update_ob() + " 00:00:00"); // startDate
                encounterPreparedStatement.setString(5, "default_reason"); // reason
                encounterPreparedStatement.setInt(6, PractitionerDAO.loggedInPractitioner.getOrganizationId());
                encounterPreparedStatement.setInt(7, PractitionerDAO.loggedInPractitioner.getId());
                encounterPreparedStatement.setInt(8, PatientDAO.getCurrentPatientId());
                encounterPreparedStatement.setString(9, "default_description"); // description
                encounterPreparedStatement.setString(10, "default_note"); // note
                encounterPreparedStatement.executeUpdate();

                //Subjective table
                ResultSet rs=stmt.executeQuery("select count(*) from Subjective;");
                rs.next();
//                int subjectiveCount = rs.getInt(1);
//                int newSubjectiveId = subjectiveCount + 1;
                PreparedStatement subjectivePreparedStatement = con.prepareStatement("insert into Subjective(mainComplains, anamnesisMorbi, development, epidemiologicalAnamnesis, note, Encounter_encounterID) values(?,?,?,?,?,?);");
                //subjectivePreparedStatement.setInt(1, newSubjectiveId);
                subjectivePreparedStatement.setString(1, c.getMainComplaints());
                subjectivePreparedStatement.setString(2, c.getAnamnesisMorbi());
                subjectivePreparedStatement.setString(3, c.getGrowthAndDevelopment());
                subjectivePreparedStatement.setString(4, c.getEpidemiologicalAnamnesis());
                subjectivePreparedStatement.setString(5, c.getNotes());
                subjectivePreparedStatement.setInt(6, newEncounterId);
                subjectivePreparedStatement.executeUpdate();

                // Diagnose table
                ResultSet rd=stmt.executeQuery("select count(*) from Diagnose;");
                rd.next();
                int diagnoseCount = rd.getInt(1);
                int newDiagnoseId = diagnoseCount + 1;
                PreparedStatement diagnosePreparedStatement = con.prepareStatement("insert into Diagnose(diagnoseCodeID, status, clinicalStatus, note, Encounter_encounterID, `Diagnose Codes_diagnoseCode`) values(?,?,?,?,?,?);");
                diagnosePreparedStatement.setInt(1, newDiagnoseId);
                diagnosePreparedStatement.setString(2, c.getDiagnoseStatus());
                diagnosePreparedStatement.setString(3, c.getDiagnoseClinicalStatus());
                diagnosePreparedStatement.setString(4, "default_note"); // note
                diagnosePreparedStatement.setInt(5, newEncounterId);
                diagnosePreparedStatement.setInt(6, c.getDiagnoseCode());
                diagnosePreparedStatement.executeUpdate();

                //Procedure
                ResultSet rp=stmt.executeQuery("select count(*) from `Procedure`;");
                rp.next();
                int procedureCount = rp.getInt(1);
                int newProcedureId = procedureCount + 1;
                PreparedStatement procedurePreparedStatement = con.prepareStatement("insert into `Procedure`(procedureID, description, lastUpdatedTIme, status, note, Encounter_encounterID) values(?,?,?,?,?,?);");
                procedurePreparedStatement.setInt(1, newProcedureId);
                procedurePreparedStatement.setString(2, c.getDescription_pr());
                procedurePreparedStatement.setString(3, c.getLast_update_pr() + " 00:00:00");
                procedurePreparedStatement.setString(4, c.getStatus_pr());
                procedurePreparedStatement.setString(5, c.getProcedure()); // note
                procedurePreparedStatement.setInt(6, newEncounterId);
                procedurePreparedStatement.executeUpdate();

                //Observation
                ResultSet ro=stmt.executeQuery("select count(*) from Observation");
                ro.next();
                int observationCount = ro.getInt(1);
                int newObservationId = observationCount + 1;
                PreparedStatement observationPreparedStatement = con.prepareStatement("insert into Observation(observationID, description, lastUpdatedTIme, status, note, Encounter_encounterID) values(?,?,?,?,?,?);");
                observationPreparedStatement.setInt(1, newObservationId);
                observationPreparedStatement.setString(2, c.getDescription_ob());
                observationPreparedStatement.setString(3, c.getLast_update_ob() + " 00:00:00");
                observationPreparedStatement.setString(4, c.getStatus_ob());
                observationPreparedStatement.setString(5, c.getObservation()); // note
                observationPreparedStatement.setInt(6, newEncounterId);
                observationPreparedStatement.executeUpdate();

                //Medication
                ResultSet rm=stmt.executeQuery("select count(*) from Medication");
                rm.next();
                int medicationCount = rm.getInt(1);
                int newMedicationId = medicationCount + 1;
                PreparedStatement medicatonPreparedStatement = con.prepareStatement("insert into Medication(medicationID, description, lastUpdatedTIme, status, note, Encounter_encounterID) values(?,?,?,?,?,?);");
                medicatonPreparedStatement.setInt(1, newMedicationId);
                medicatonPreparedStatement.setString(2, c.getDescription_med());
                medicatonPreparedStatement.setString(3, c.getLast_update_med() + " 00:00:00");
                medicatonPreparedStatement.setString(4, c.getStatus_med());
                medicatonPreparedStatement.setString(5, c.getMedication()); // note
                medicatonPreparedStatement.setInt(6, newEncounterId);
                medicatonPreparedStatement.executeUpdate();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
