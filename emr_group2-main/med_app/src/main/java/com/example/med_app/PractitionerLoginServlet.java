package com.example.med_app;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PractitionerLoginServlet", value = "/LoginPractitioner")
public class PractitionerLoginServlet extends HttpServlet {
    public void init() {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException{

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PractitionerCredentials pc = new PractitionerCredentials();

        pc.setEmail(request.getParameter("email"));
        pc.setPassword(request.getParameter("psw"));

        int pId = PractitionerDAO.isValidLogin(pc);
        if (-1 != pId) {
            PractitionerDAO.doLogin(pId);
            RequestDispatcher dispatcher = request.getRequestDispatcher("patients_list.jsp");
            dispatcher.forward(request,response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("practitioner_login.jsp");
            dispatcher.forward(request,response);
        }
    }
}