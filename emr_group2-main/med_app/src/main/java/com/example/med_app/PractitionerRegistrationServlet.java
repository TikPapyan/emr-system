package com.example.med_app;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "PractitionerRegistrationServlet", value = "/PractitionerRegister")
@MultipartConfig
public class PractitionerRegistrationServlet extends HttpServlet {
    public void init() {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException{

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Practitioner p = new Practitioner();
        p.setOrganizationId(Integer.parseInt(request.getParameter("organization")));
        p.setFirstName(request.getParameter("fname"));
        p.setLastName(request.getParameter("lname"));
        p.setEmail(request.getParameter("email"));
        p.setPassword(request.getParameter("psw"));
        p.setQualificationId(Integer.parseInt(request.getParameter("qualification")));
        p.setCommunicationLanguage(request.getParameter("language"));
        p.setGender(request.getParameter("gender"));
        p.setBirthDate(request.getParameter("yyyy")+"-"+request.getParameter("mm")+"-"+request.getParameter("dd"));
        p.setPhoneNumber(Integer.parseInt(request.getParameter("phone")));
        p.setCountry(request.getParameter("country"));
        p.setCity(request.getParameter("city"));
        p.setState(request.getParameter("state"));
        p.setDistrict(request.getParameter("district"));
        p.setPostalCode(Integer.parseInt(request.getParameter("postal_code")));
        p.setFile_name(request.getParameter("file_name"));


        PractitionerDAO.registerPractitioner(p);
        processRequest(request,response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("super_admin_homepage.jsp");
        dispatcher.forward(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html/charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            Part part = request.getPart("file");
            String fileName = part.getSubmittedFileName();

            String path = getServletContext().getRealPath("/" + "files" + File.separator + fileName);

            InputStream is = part.getInputStream();

            uploadFIle(is,path);
        }

    }
    public boolean uploadFIle(InputStream is, String path){
        boolean test = false;
        try{
            byte[] byt = new byte[is.available()];
                is.read();
            FileOutputStream fops = new FileOutputStream(path);
            fops.write(byt);
            fops.flush();
            fops.close();
            test =true;
                }catch(Exception e){
            e.printStackTrace();
        }
        return test;
    }
}
