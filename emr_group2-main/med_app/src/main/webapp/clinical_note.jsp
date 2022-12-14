<%@ page import="com.example.med_app.PractitionerDAO" %>
<%@ page import="com.example.med_app.PatientDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Page Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/MedRecord.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<!-- Header -->
<div class="header">
    <h1>Clinical Note</h1>
</div>

<!-- Navigation Bar -->
<div class="navbar">
    <a href="#home">Home</a>
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
            <img class="profilePic" src="images/account.png">
        </div><br>
        <%=
            PatientDAO.getSelectedPatientDisplayInfo()
        %>
        <%--<div class="border" style="height:50px;">Address</div>--%>
    </div>
    <div class="main">
        <div class="container">
            <h1>Subjective</h1>
            <form action="/ClinicalNote" method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="complaints">Main complaints</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="complaints" name="complaints" placeholder="Complaints*..." required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="morbi">Anamnesis morbi</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="morbi" name="morbi" placeholder="Anamnesis morbi *..." required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="growth">Growth and development</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="growth" name="growthanddev" placeholder="Growth and development*..." required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="anamnesis">Epidemiological anamnesis</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="anamnesis" name="Epidemiological_anamnesis" placeholder="Epidemiological anamnesis*..." required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="notes">Notes</label>
                    </div>
                    <div class="col-75">
                        <textarea id="notes" name="subjectiveNote" placeholder="Additional notes.." style="height:200px"></textarea>
                    </div>
                </div>
                <br>
                <h2>Diagnose</h2>
                <div class= "chooseFromList">
                    <label for="diagnoseCode">Diagnose code</label>
                    <select id="diagnoseCode" name="diagnoseCodey" required>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>

                    <label for="diagnoseStatus">Diagnose status</label>
                    <select id="diagnoseStatus" name="diagnoseStatus" required>
                        <option value="unconfirmed">unconfirmed</option>
                        <option value="provisional">provisional</option>
                        <option value="differential">differential</option>
                        <option value="confirmed">confirmed</option>
                        <option value="refuted">refuted</option>
                        <option value="entered-in-error">entered-in-error</option>
                    </select>
                    <label for="diagnoseClinicalStatus">Diagnose clinical status</label>
                    <select id="diagnoseClinicalStatus" name="diagnoseClinicalStatus" required>
                        <option value="active">active</option>
                        <option value="recurrence">recurrence</option>
                        <option value="relapse">relapse</option>
                        <option value="inactive">inactive</option>
                        <option value="remission">remission</option>
                        <option value="resolved">resolved</option>
                    </select>
                </div>

                <h2>Care Plan</h2>
                <div class="container">
                    <div class="row">
                        <div class="col-25">
                            <label for="Pname">Procedure</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="Pname" name="procedurename" placeholder="Procedure name.." required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="lastUpdatedTimeP">Last update:</label>
                        </div>
                        <div class="col-75">
                            <input type="date" id="lastUpdatedTimeP" name="lastUpdatedTimeP" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="statusP">Status</label>
                        </div>
                        <div class="col-75">
                            <select id="statusP" name="statusP" required>
                                <option value="active">preparation</option>
                                <option value="in-progress">in-progress</option>
                                <option value="not-done">not-done</option>
                                <option value="on-hold">on-hold</option>
                                <option value="stopped">stopped</option>
                                <option value="completed">completed</option>
                                <option value="entered-in-error">entered-in-error</option>
                                <option value="unknown">unknown</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="subjectP">Description</label>
                        </div>
                        <div class="col-75">
                            <textarea id="subjectP" name="subjectP" placeholder="Write something.." style="height:200px" required></textarea>
                        </div>
                    </div>
                    <br>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-25">
                            <label for="observationName">Observation</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="observationName" name="observationName" placeholder="Observation name.." required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="lastUpdatedTime">Last update:</label>
                        </div>
                        <div class="col-75">

                            <input type="date" id="lastUpdatedTime" name="lastUpdatedTime" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="Status">Status</label>
                        </div>
                        <div class="col-75">
                            <select id="status" name="status" required>
                                <option value="active">Active</option>
                                <option value="pasive">Passive</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="subject">Description</label>
                        </div>
                        <div class="col-75">
                            <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px" required></textarea>
                        </div>
                    </div>
                    <br>


                </div>
                <div class="container">

                    <div class="row">
                        <div class="col-25">
                            <label for="medname">Medication</label>
                        </div>
                        <div class="col-75">
                            <input type="text" id="medname" name="medname" placeholder="Medication name.." required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="lastUpdatedTimeM">Last update:</label>
                        </div>
                        <div class="col-75">

                            <input type="date" id="lastUpdatedTimeM" name="lastUpdatedTimeM" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="statusM">Status</label>
                        </div>
                        <div class="col-75">
                            <select id="statusM" name="statusM" required>
                                <option value="active">Active</option>
                                <option value="pasive">Passive</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <label for="desc">Description</label>
                        </div>
                        <div class="col-75">
                            <textarea id="desc" name="desc" placeholder="Write something.." style="height:200px" required></textarea>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <input type="submit" value="Submit">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<br>


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


