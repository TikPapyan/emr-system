package com.example.med_app;

public class ClinicalNote {
    // ----------------------- Subjective ----------//
    private String mainComplaints;
    private String anamnesisMorbi;
    private String growthAndDevelopment;
    private String epidemiologicalAnamnesis;
    private String notes;
    // ---------------------- Diagnose -----------//
    private int diagnoseCode;
    private String diagnoseStatus;
    private String diagnoseClinicalStatus;
    // ---------------- Core Plan --------------//
    private String procedure;
    private String last_update_pr;
    private String status_pr;
    private String description_pr;

    private String observation;
    private String last_update_ob;
    private String status_ob;
    private String description_ob;

    private String medication;
    private String last_update_med;
    private String status_med;
    private String description_med;

    public String getMainComplaints() {
        return mainComplaints;
    }

    public void setMainComplaints(String mainComplaints) {
        this.mainComplaints = mainComplaints;
    }

    public String getAnamnesisMorbi() {
        return anamnesisMorbi;
    }

    public void setAnamnesisMorbi(String anamnesisMorbi) {
        this.anamnesisMorbi = anamnesisMorbi;
    }

    public String getGrowthAndDevelopment() {
        return growthAndDevelopment;
    }

    public void setGrowthAndDevelopment(String growthAndDevelopment) {
        this.growthAndDevelopment = growthAndDevelopment;
    }

    public String getEpidemiologicalAnamnesis() {
        return epidemiologicalAnamnesis;
    }

    public void setEpidemiologicalAnamnesis(String epidemiologicalAnamnesis) {
        this.epidemiologicalAnamnesis = epidemiologicalAnamnesis;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDiagnoseCode() {
        return diagnoseCode;
    }

    public void setDiagnoseCode(int diagnoseCode) {
        this.diagnoseCode = diagnoseCode;
    }

    public String getDiagnoseStatus() {
        return diagnoseStatus;
    }

    public void setDiagnoseStatus(String diagnoseStatus) {
        this.diagnoseStatus = diagnoseStatus;
    }

    public String getDiagnoseClinicalStatus() {
        return diagnoseClinicalStatus;
    }

    public void setDiagnoseClinicalStatus(String diagnoseClinicalStatus) {
        this.diagnoseClinicalStatus = diagnoseClinicalStatus;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getLast_update_pr() {
        return last_update_pr;
    }

    public void setLast_update_pr(String last_update_pr) {
        this.last_update_pr = last_update_pr;
    }

    public String getStatus_pr() {
        return status_pr;
    }

    public void setStatus_pr(String status_pr) {
        this.status_pr = status_pr;
    }

    public String getDescription_pr() {
        return description_pr;
    }

    public void setDescription_pr(String description_pr) {
        this.description_pr = description_pr;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getLast_update_ob() {
        return last_update_ob;
    }

    public void setLast_update_ob(String last_update_ob) {
        this.last_update_ob = last_update_ob;
    }

    public String getStatus_ob() {
        return status_ob;
    }

    public void setStatus_ob(String status_ob) {
        this.status_ob = status_ob;
    }

    public String getDescription_ob() {
        return description_ob;
    }

    public void setDescription_ob(String description_ob) {
        this.description_ob = description_ob;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getLast_update_med() {
        return last_update_med;
    }

    public void setLast_update_med(String last_update_med) {
        this.last_update_med = last_update_med;
    }

    public String getStatus_med() {
        return status_med;
    }

    public void setStatus_med(String status_med) {
        this.status_med = status_med;
    }

    public String getDescription_med() {
        return description_med;
    }

    public void setDescription_med(String description_med) {
        this.description_med = description_med;
    }
}
