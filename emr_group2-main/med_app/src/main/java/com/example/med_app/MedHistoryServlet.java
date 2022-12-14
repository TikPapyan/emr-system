package com.example.med_app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MedHistoryServlet", value = "/MedHistory")
public class MedHistoryServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientDAO.setCurrentPatientId(Integer.parseInt(request.getParameter("patientId")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("med_history.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}