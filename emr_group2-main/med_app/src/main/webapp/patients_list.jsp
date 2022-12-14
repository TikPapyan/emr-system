<%@ page import="com.example.med_app.PractitionerDAO" %>
<%@ page import="com.example.med_app.PatientDAO" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/13/2022
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Patients List</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/patients_list.css">
    <link rel="stylesheet" href="css/MedRecord.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
<div class="header">
    <h1>Clinical Note</h1>
</div>

<!-- Navigation Bar -->
<div class="navbar">
    <a href="#home">Home</a>
    <a href="#news">News</a>
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

<script  src="https://fontawesome.com/search?q=searcg&s=solid%2Cbrands"></script>
<title>Search box</title>
<div class="search-box">
    <input class="search-txt" type="text" name="" placeholder="Search for a patient...">
    <a class="search-btn" href="#">

        <ion-icon name="search-outline"></ion-icon>
    </a>
</div>
<a href="patient_registration.jsp">
    <button type="button" class="button ">
        <span class="button__text">Register a patient</span>
        <span class="button__icon">
        <ion-icon name="people-outline"></ion-icon>
    </span>
    </button>
</a>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>

<div class="column">
    <h1> Patient's list</h1>
    <%=
        PatientDAO.getPatientsListContent(PractitionerDAO.loggedInPractitioner.getId())
    %>
<%--    <div class="first">--%>
<%--        <div class="row">--%>
<%--            <img src="images/patients_list/photo8.jpeg" alt="Snow" style="width:100%">--%>
<%--            <button type="button" class="button3">VIEW HISTORY--%>
<%--            </button>--%>
<%--            <button type="button" class="button4">CREATE CLINICAL NOTE--%>
<%--            </button>--%>
<%--            <p>Praesent</p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <p></p>--%>

<%--    <p></p>--%>
<%--    <div class="third">--%>
<%--        <div class="row">--%>
<%--            <img src="images/patients_list/photo3.jpeg" alt="Mountains" style="width:100%">--%>
<%--            <p>Meacenas--%>
<%--            </p>--%>
<%--            </br>--%>
<%--            <button type="button" class="button5">VIEW HISTORY--%>
<%--            </button>--%>
<%--            <button type="button" class="button6" >CREATE CLINICAL NOTE--%>
<%--            </button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<p></p>--%>
<%--<div class="fourth">--%>
<%--    <div class="row">--%>
<%--        <img src="images/patients_list/photo6.jpeg" alt="Mountains" style="width:100%">--%>
<%--        <p>Curabitur</p>--%>
<%--        <button type="button" class="button7">VIEW HISTORY--%>
<%--        </button>--%>
<%--        <button type="button" class="button8">CREATE CLINICAL NOTE--%>
<%--        </button>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<p></p>--%>
<%--<div class="fifth">--%>
<%--    <div class="row">--%>
<%--        <img src="images/patients_list/photo5.jpeg" alt="Mountains" style="width:100%">--%>
<%--        <p>Cancer</p>--%>
<%--        <button type="button" class="button9">VIEW HISTORY--%>
<%--        </button>--%>
<%--        <button type="button" class="button10">CREATE CLINICAL NOTE--%>
<%--        </button>--%>
<%--    </div>--%>
<%--</div>--%>
</div>


<div class="topnav">
    <a class="active" href="#home">Home</a>
    <a href="#news">News</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
</div>
</body>
</html>