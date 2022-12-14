package com.example.med_app;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PatientRegistrationServlet", value = "/RegisterPatient")
public class PatientRegistrationServlet extends HttpServlet {
    public void init() {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException{

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Patient p = new Patient();
        p.setOrganizationID(Integer.parseInt(request.getParameter("organization")));
        p.setFirstName(request.getParameter("fname"));
        p.setLastName(request.getParameter("lname"));
        p.setEmail(request.getParameter("email"));
        p.setComLang(request.getParameter("language"));
        p.setGender(request.getParameter("gender"));
        p.setBirthDate(request.getParameter("yyyy")+"-"+request.getParameter("mm")+"-"+request.getParameter("dd"));
        p.setMaritalStatus(request.getParameter("marital_status"));
        p.setPhoneNumber(request.getParameter("phone"));
        p.setCountry(request.getParameter("country"));
        p.setCity(request.getParameter("city"));
        p.setState(request.getParameter("state"));
        p.setDistrict(request.getParameter("district"));
        p.setPostalCode(request.getParameter("postal_code"));

        PatientDAO.registerPatient(p);

        RequestDispatcher dispatcher = request.getRequestDispatcher("patients_list.jsp");
        dispatcher.forward(request,response);
    }
}
