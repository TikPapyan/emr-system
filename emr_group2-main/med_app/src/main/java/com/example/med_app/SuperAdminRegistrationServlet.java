package com.example.med_app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SuperAdminRegistrationServlet", value = "/SuperAdminRegister")
public class SuperAdminRegistrationServlet extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SuperAdmin s = new SuperAdmin(request.getParameter("email"), request.getParameter("psw"));
        if (SuperAdminDAO.registerSuperAdmin(s)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("super_admin_homepage.jsp");
            dispatcher.forward(request,response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("super_admin_registration.jsp");
            dispatcher.forward(request,response);
        }
    }

    public void destroy() {
    }
}