<%--
  Created by IntelliJ IDEA.
  User: papya
  Date: 5/11/2022
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/styles.css">
    <title>Organization Registration</title>
</head>
<body>

<div class="image">
    <img src="images/organization.svg" alt="Italian Trulli">
</div>
<div>
    <form action="/OrganizationRegister" method="post">
        <div class="container">

            <h1>Register an Organization</h1>

            <input type="text" class="std" placeholder="Organization Name" name="orgname" required><br><br>

            <label><b>Address</b></label>
            <br>
            <input class="std1" type="text" placeholder="Country" id="country" name="country" required>
            <input class="std1" type="text" placeholder="City" id="city" name="city" required>
            <input class="std1" type="text" placeholder="State" id="state" name="state" required>
            <br>
            <input class="std2" type="text" placeholder="District" id="district" name="district" required>
            <input class="std2" type="text" placeholder="Postal Code" id="postal" name="postal_code" required>
            <br><br>

            <label><b>Contact Purpose</b></label><br>

            <input class="std" placeholder="Contact Purpose" name="contact_purpose" required><br>

            <label><b>Contact Name</b></label><br>

            <input type="text" class="names" placeholder="First Name" id="t1" name="fname" required>
            <input type="text" class="names" placeholder="Last Name"  name="lname" required><br>

            <label><b>Telecom</b></label><br>

            <input type="text" class="std" placeholder="Telecom" name="telecom" required><br>

            <button type="submit">Register</button>
        </div>
    </form>
</div>

</body>
</html>