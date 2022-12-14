<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/18/2022
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search history</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/search_history.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<!-- Header -->
<div class="header">
    <h1>Search</h1>
</div>

<!-- Navigation Bar -->
<div class="navbar">
    <a href="#home">Home</a>
    <a href="#news">News</a>
    <div class="dropdown" >
        <button class="dropbtn"><img src="images/account.png" alt="Account" style="height:23px;width:23px">Username</button>
        <div class="dropdown-content">
            <a href="#">Log Out</a>
        </div>
    </div>
</div>

<!-- The flexible grid (content) -->
<div class="row">

    <div class="main">
        <h1>Search Medical History</h1>
        <div class="container">
            <form action="/action_page.php">
                <div class="row">
                    <div class="col-25">
                        <label for="patientname">Patient Name</label>
                    </div>
                    <div class="col-25">
                        <input type="text" id="patientname"  placeholder="Name Surname">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="timeline">Diagnose Time</label>
                    </div>
                    <div class="col-25">
                        <input type="text" id="timeline"  placeholder="Diagnose Time">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label>Diagnose Code</label>
                    </div>
                    <div class="chooseFromList col-25">
                        <select name="diagnoseCode">
                            <option value="diagnosecode">diagnosecode</option>
                            <option value="diagnosecode">diagnosecode</option>
                            <option value="diagnosecode">diagnosecode</option>
                        </select>
                    </div>
                </div>
                <input type="submit" value="Search">
            </form>
        </div>
        <br>

        <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
</div>
<!-- Footer -->
<div class="footer">
    <h2>Footer</h2>
</div>
</body>
</html>
