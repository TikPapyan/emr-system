<%--
  Created by IntelliJ IDEA.
  User: Nare
  Date: 11/05/2022
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-image: url("images/doctor-hospital-medical-service-professional-healthcare-business-208840998.jpg"); height: 820px; width: 1800px;
            background-position: center center;

            /* Background image doesn't tile */
            background-repeat: no-repeat;

            /* Background image is fixed in the viewport so that it doesn't move when
            the content's height is greater than the image's height */
            background-attachment: fixed;

            /* This is what makes the background image rescale based
            on the container's size */
            background-size: cover;

            display: grid;
            place-items: center;
            height: 100%;
            width: 100%;


        }

        * {
            box-sizing: border-box;
            margin:0;
            padding: 0;

        }
        /* Add padding to containers */
        .container {
            padding: 16px ;
            width: 380px;
            background-color: white;
            border-radius: 5px;
            margin-top: 50px;
            /*max-width: 500px;*/
            /*max-height: 1000px;*/
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;

        }
        input[type=text], input[type=email] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=email]:focus {
            background-color: #ddd;
            outline: none;

        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 20px;
            margin-top: 10px;
        }

        /* Set a style for the submit button */
        .loginbtn {
            background-color: #000000;
            color: white;
            padding: 16px 30px;
            margin: 8px 0;
            border-radius: 5px;

            border: none;
            cursor: pointer;
            opacity: 0.9;
        }

        .loginbtn:hover {
            opacity: 0.6;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
            text-decoration: none;
        }
        a:hover{
            text-decoration:underline;
        }
        .title{
            line-height: 50px;
            font-size: 28px;
            font-weight: 600;

        }

    </style>
</head>
<body>

<form action="/LoginPractitioner" method="post">
    <p >
    <div class="container">
        <div class="title"  >
            Practitioner Login
        </div>
        <hr>
        <div >
            <label for="email"><b>Email</b></label>
            <input type="email" placeholder="Enter Email" name="email" id="email" required >
        </div>
        <div >
            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
        </div>

        <hr >
        <div align="center">
            <button type="submit" class="loginbtn" >Login</button>
        </div>
    </div>

</form>

</body>

</html>

