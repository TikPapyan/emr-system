<%@ page import="com.example.med_app.OrganizationDAO" %>
<%@ page import="com.example.med_app.Utilities" %><%--
  Created by IntelliJ IDEA.
  User: papya
  Date: 5/11/2022
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/styles.css">
    <title>Patient Registration</title>
</head>
<body>

<div class="image">
    <img src="images/patient.svg" alt="Italian Trulli">
</div>

<div>

    <form action="/RegisterPatient" method="post">
        <div class="container">

            <h1>Register a Patient</h1>


            <select class="std" name="organization" required>
                <option value="" disabled selected>Choose the organization</option>
                <%=
                    OrganizationDAO.getOrganizationsOptions()
                %>
            </select> <br>

            <input type="text" class="names" placeholder="First Name" id="t1" name="fname" required>

            <input type="text" class="names" placeholder="Last Name"  name="lname" required><br>

            <input class="std" type="email" placeholder="Enter Email" id="t2" name="email" required><br>

            <select class="std" name="language" required>
                <option value="" disabled selected>Communication Language</option>
                <option value="en">English</option>
                <option value="ru">Russian</option>
                <option value="fr">French</option>
            </select> <br>

            <select class="std" name="gender" required>
                <option value="" disabled selected>Gender</option>
                <option value="female">Female</option>
                <option value="male">Male</option>
                <option value="other">Other</option>
            </select> <br><br>

            <label><b>Birthdate: </b></label>
            <br>
            <SELECT class="std1" id ="day" name = "dd" >
                <option value="" disabled selected>Day</option>
                <option value="01">1</option>
                <option value="02">2</option>
                <option value="03">3</option>
                <option value="04">4</option>
                <option value="05">5</option>
                <option value="06">6</option>
                <option value="07">7</option>
                <option value="08">8</option>
                <option value="09">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
            </SELECT>
            <SELECT class="std1"  id ="month" name = "mm">
                <option value="" disabled selected>Month</option>
                <option value="01">1</option>
                <option value="02">2</option>
                <option value="03">3</option>
                <option value="04">4</option>
                <option value="05">5</option>
                <option value="06">6</option>
                <option value="07">7</option>
                <option value="08">8</option>
                <option value="09">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </SELECT>
            <SELECT class="std1" id ="year" name = "yyyy">
                <option value="" disabled selected>Year</option>
                <%=
                    Utilities.getYearsOptions(1970, 2022)
                %>
            </SELECT><br>

            <input class="std" id="image" type="file" name="profile_photo" accept="image/*" >
            <label id='forImage' for="image">Choose a photo</label>
            <br><br>
            <select class="std" name="marital_status" required>
                <option value="" disabled selected>Marital Status</option>
                <option value="status1" >Marital Status 1</option>
                <option value="status2">Marital Status 2</option>
                <option value="status3">Marital Status 3</option>
                <option value="status4">Marital Status 4</option>
            </select><br>
            <input class="std" type="tel" id="phone" name="phone" placeholder="Phone Number" pattern="[0-9]{3}[0-9]{2}[0-9]{3}" required><br><br>

            <label><b>Address</b></label>
            <br>
            <input class="std1" type="text" placeholder="Country" id="country" name="country" required>
            <input class="std1" type="text" placeholder="City" id="city" name="city" required>
            <input class="std1" type="text" placeholder="State" id="state" name="state" required>
            <br>
            <input class="std2" type="text" placeholder="District" id="district" name="district" required>
            <input class="std2" type="text" placeholder="Postal Code" id="postal" name="postal_code" required>
            <br>
            <button type="submit">Register</button>
        </div>
    </form>


</div>

</body>
</html>