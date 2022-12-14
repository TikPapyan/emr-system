<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-image:  url("images/online-medical-consultation-doctor-working-laptop-computer-clinic-office-copy-space-164626747.jpg"); height: 800px; width: 1800px;
            /* Background image is centered vertically and horizontally at all times */
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
        .registerbtn {
            background-color: #000000;
            color: white;
            padding: 16px 30px;
            margin: 8px 0;
            border-radius: 5px;

            border: none;
            cursor: pointer;
            opacity: 0.9;


        }

        .registerbtn:hover {
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
        .check{
            margin-bottom: 26px;
        }


    </style>
</head>
<body>

<form action="/SuperAdminRegister" method="post">
<div class="container">

    <div class="title" >
        Super Admin Registration
    </div>
    <p >Please fill in this form to create an account.</p>
    <hr >
    <div >
        <label for="email"><b>Email</b></label>
        <input type="email" placeholder="Enter Email" name="email" id="email" required >
    </div>
    <div >
        <label for="psw" ><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
    </div>
    <div >
        <label for="pswRepeat"><b>Repeat Password </b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" id="pswRepeat" required>
    </div>

    <hr >
    <div class="check" >
            <input type="checkbox" required id="checkox" name="checkbox">
            <label for="checkox"> I agree to <a href="terms&privacy.jsp">Terms & Privacy</a></label><br>
    </div>

    <div align="center">
            <button type="submit" class="registerbtn" onclick="validatePassword()" >Register</button>
    </div>
</div>
</form>


</body>

</html>
<script>
    var password = document.getElementById("psw")
        , confirm_password = document.getElementById("pswRepeat");

    function validatePassword(){
        if(password.value != confirm_password.value) {
            confirm_password.setCustomValidity("Passwords Don't Match");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
</script>