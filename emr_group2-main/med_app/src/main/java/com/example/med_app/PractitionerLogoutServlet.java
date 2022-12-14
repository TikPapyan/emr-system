package com.example.med_app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PractitionerLogoutServlet", value = "/LogoutPractitioner")
public class PractitionerLogoutServlet extends HttpServlet {
    public void init() {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (null != PractitionerDAO.loggedInPractitioner) {
            PractitionerDAO.doLogout();
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}