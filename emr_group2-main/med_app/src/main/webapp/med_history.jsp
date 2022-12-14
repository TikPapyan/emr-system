<%@ page import="com.example.med_app.PractitionerDAO" %>
<%@ page import="com.example.med_app.PatientDAO" %>
<%@ page import="com.example.med_app.MedHistoryDAO" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/18/2022
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/med_history.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<!-- Header -->
<div class="header">
    <h1>Medical History</h1>
</div>

<!-- Navigation Bar -->
<div class="navbar">
    <a href="#news">Home</a>
    <div class="dropdown" >
        <button class="dropbtn"><img src="images/account.png" alt="Account" style="height:23px;width:23px">
            <%=
            PractitionerDAO.getLoggedInPractitionerNickname()
            %>

        </button>
        <div class="dropdown-content">
            <a href="LogoutPractitioner">logout</a>
        </div>
    </div>
</div>

<!-- The flexible grid (content) -->
<div class="row">
    <div class="side">
        <div class="ppimg">
            <h1><center>Personal information</center></h1>
            <img class="profilePic" src="images/profilepic.jpg">
        </div><br>
        <%=
        PatientDAO.getSelectedPatientDisplayInfo()
        %>
        <%--<div class="border" style="height:50px;">Address</div>--%>
    </div>
    <div class="main">
        <br><br><br>
        <a href="ClinicalNote?patientId=<%=PatientDAO.getCurrentPatientId()%>"><input type="submit" value="Create Clinical Note"></a>
        <table>
            <thead>
            <tr>
                <th>Diagnose</th>
                <th>Description</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <%=
                MedHistoryDAO.getDiagnoseDisplayInfo()
            %>
<%--            <tr>--%>
<%--                <td>Autism</td>--%>
<%--                <td>Autism is a complex, lifelong developmental disability that typically appears during early childhood and can impact a person’s social skills, communication, relationships, and self-regulation. Autism is defined by a certain set of behaviors and is a “spectrum condition” that affects people differently and to varying degrees.</td>--%>
<%--                <td>In progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Diabetes</td>--%>
<%--                <td>With diabetes, your body either doesn't make enough insulin or can't use it as well as it should. Diabetes is a chronic (long-lasting) health condition that affects how your body turns food into energy. Most of the food you eat is broken down into sugar (also called glucose) and released into your bloodstream.</td>--%>
<%--                <td>To Do</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Insomnia</td>--%>
<%--                <td>Insomnia is a common sleep disorder that can make it hard to fall asleep, hard to stay asleep, or cause you to wake up too early and not be able to get back to sleep. You may still feel tired when you wake up.</td>--%>
<%--                <td>Done</td>--%>
<%--            </tr>--%>
            </tbody>
        </table>

    </div>
</div>
<div></div>
<!-- Footer -->

<div class="footer-basic">
    <footer>
        <div class="inner-footer">
            <ul class="in-line">
                <li class="list-inline-item"><a href="#">Home</a></li>
                <li class="list-inline-item"><a href="#">Services</a></li>
                <li class="list-inline-item"><a href="#">About</a></li>
                <li class="list-inline-item"><a href="#">Terms</a></li>
                <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
            </ul>
            <div class="right">
                <div class="phone" >
                    <button class="phonebtn"><img src="images/phone.svg" alt="Account" style="height:23px;width:23px"></button>
                    <div class="phone-content">
                        <a href="tel:+123-456-789" target="_blank">+123-456-789</a>
                    </div>
                </div>
                <div class="phone" >
                    <button class="phonebtn"><img src="images/envelope.svg" alt="Account" style="height:23px;width:23px"></button>
                    <div class="phone-content">
                        <a href="mailto:john.doe@domain.com" target="_blank">john.doe@domain.com</a>
                    </div>
                </div>
            </div>
        </div>
        <p class="copyright">IMA © 2022</p>
    </footer>
</div>

</body>
</html>
