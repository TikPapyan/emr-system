package com.example.med_app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrganizationRegistrationServlet", value = "/OrganizationRegister")
public class OrganizationRegistrationServlet extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Organization o = new Organization();
        o.setOrganizationName(request.getParameter("orgname"));
        o.setCountry(request.getParameter("country"));
        o.setCity(request.getParameter("city"));
        o.setState(request.getParameter("state"));
        o.setDistrict(request.getParameter("district"));
        o.setPostalCode(request.getParameter("postal_code"));
        o.setContactPurpose(request.getParameter("contact_purpose"));
        o.setFirstName(request.getParameter("fname"));
        o.setLastName(request.getParameter("lname"));
        o.setTelecom(request.getParameter("telecom"));

        OrganizationDAO.registerOrganization(o);

        RequestDispatcher dispatcher = request.getRequestDispatcher("super_admin_homepage.jsp");
        dispatcher.forward(request,response);
    }

    public void destroy() {
    }
}