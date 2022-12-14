package com.example.med_app;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.IOException;

@WebServlet(name = "ClinicalNoteRegistrationServlet", value = "/ClinicalNote")
public class ClinicalNoteRegistrationServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientDAO.setCurrentPatientId(Integer.parseInt(request.getParameter("patientId")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("clinical_note.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicalNote c = new ClinicalNote();
        c.setMainComplaints(request.getParameter("complaints"));
        c.setAnamnesisMorbi(request.getParameter("morbi"));
        c.setGrowthAndDevelopment(request.getParameter("growthanddev"));
        c.setEpidemiologicalAnamnesis(request.getParameter("Epidemiological_anamnesis"));
        c.setNotes(request.getParameter("subjectiveNote"));
        c.setDiagnoseCode(Integer.parseInt(request.getParameter("diagnoseCodey")));
        c.setDiagnoseStatus(request.getParameter("diagnoseStatus"));
        c.setDiagnoseClinicalStatus(request.getParameter("diagnoseClinicalStatus"));
        c.setProcedure(request.getParameter("procedurename"));
        c.setLast_update_pr(request.getParameter("lastUpdatedTimeP"));
        c.setStatus_pr(request.getParameter("statusP"));
        c.setDescription_pr(request.getParameter("subjectP"));
        c.setObservation(request.getParameter("observationName"));
        c.setLast_update_ob(request.getParameter("lastUpdatedTime"));
        c.setStatus_ob(request.getParameter("status"));
        c.setDescription_ob(request.getParameter("subject"));
        c.setMedication(request.getParameter("medname"));
        c.setLast_update_med(request.getParameter("lastUpdatedTimeM"));
        c.setStatus_med(request.getParameter("statusM"));
        c.setDescription_med(request.getParameter("desc"));
        ClinicalNoteDAO.createClinicalNode(c);
        RequestDispatcher dispatcher = request.getRequestDispatcher("patients_list.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
