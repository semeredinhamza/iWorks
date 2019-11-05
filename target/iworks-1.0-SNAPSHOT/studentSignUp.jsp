<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iworks.StudentSignUpServlet" %>

<html lang="en">

<head>
    <title>Student Sign Up</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/loginFormat.css" rel="stylesheet">
</head>

<body>

    <div class="limiter">
        <div class="container-login">
            <div class="jumbotron">
                <div class="">
                    <a role="button" class="btn btn-primary btn-lg" href="studentSignUp.jsp">Student Sign Up</a>
                    <a role="button" class="btn btn-secondary btn-lg" href="EmployerRegister.jsp">Employer Sign Up</a>
                    <br>
                    <h1>Student Sign Up</h1>
                    <br>
                </div>

                <form method="POST" action="/signUpStudent">
                    <div class="form-group">
                        <label for="first name"> First Name  </label>
                        <input type="text" class="form-control" name="firstName" id="firstName" aria-describedby="emailHelp" placeholder="ex: John">
                    </div>

                    <div class="form-group">
                        <label for="last Name"> Last Name </label>
                        <input type="text" class="form-control" name="lastName" id="lastName" aria-describedby="emailHelp" placeholder="ex: Smith">
                    </div>

                    <div class="form-group">
                        <label for="age"> Age </label>
                        <input type="text" class="form-control" name="age" id="age" aria-describedby="emailHelp" placeholder="ex: 15">
                    </div>


                    <div class="form-group">
                        <label for="school"> School </label>
                        <input type="email" class="form-control" name="school" id="school" aria-describedby="emailHelp" placeholder="High School">
                    </div>

                    <div class="form-group">
                        <label for="student grade"> Grade </label>
                        <input type="text" class="form-control" name="grade" id="grade" placeholder="ex: 11">
                    </div>

                    <div class="form-group">
                        <label for="emailInput"> Email address </label>
                        <input type="email" class="form-control" name="emailInput" id="emailInput" aria-describedby="emailHelp" placeholder="ex: johnSmith@iWorks.com">
                    </div>


                    <div class="form-group">
                        <label for="Password Input"> Password </label>
                        <input type="password" class="form-control" name="passInput" id="passInput" placeholder="Password">
                    </div>

                    <div class="form-group">
                        <label for="Confirm password"> Confirm Password </label>
                        <input type="password" class="form-control" id="confirmPass" placeholder="Confirm Password">
                    </div>

                    <div class="">
                        <a role="button" type="submit" class="btn btn-outline-primary">Sign Up</a>
                    </div>
                    <br>

                </form>
            </div>
        </div>
    </div>

    <script src="../vendor/jquery/jquery.min.js"></script>
    <!-- <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
    <script src="https://www.google.com/jsapi"></script>

</body>

</html>