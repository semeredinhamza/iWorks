<!DOCTYPE html>

<html lang="en">

<head>
    <title>iWork LogIn</title>
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
                    <h1>Welcome to iWork</h1>
                </div>

                <form>
                    <div class="form-group">
                        <label for="emailInput"> Email address </label>
                        <input type="email" class="form-control" id="emailInput" aria-describedby="emailHelp" placeholder="ex: johnW@iworks.com">
                    </div>
                    <div class="form-group">
                        <label for="Password Input"> Password </label>
                        <input type="password" class="form-control" id="passInput" placeholder="Password">
                    </div>
                    <div class="">
                        <button type="button" class="btn btn-outline-primary">Login</button>
                    </div>
                    <br>
                </form>


                <div class="">
                    New to iWork?
                    <a class="txt2" href="studentSignUp.jsp">
                                Create Your Account
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a>
                </div>
            </div>
        </div>
    </div>


    <script src="../vendor/jquery/jquery.min.js"></script>
    <!-- <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
    <script src="https://www.google.com/jsapi"></script>

</body>

</html>