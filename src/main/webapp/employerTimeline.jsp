<!DOCTYPE html>

<html lang="en">

<head>
    <title>New Listing</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/loginFormat.css" rel="stylesheet">
</head>

<body>
        <nav class="navbar navbar-light bg-light navbar-right">

                <a role="button" class="btn btn-outline-primary my-2 my-sm-2" href="loginPage.jsp" style="margin-left:1400px;">Logout</a>
        
            </nav>
    <div class="limiter">
        <div class="container-login"   >
            <div class="jumbotron">
                <div class="">
                    <br>
                    <h1> New Opportunity Posting </h1>
                    <br>
                </div>

                <form method="POST" action="/post">
                    <div class="form-group">
                        <label for="Listing Title"> Name of Opportunity </label>
                        <input type="text" class="form-control" name="title" id="title" aria-describedby="" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="typeExp">Type of Opportunity</label>
                        <select class="form-control" name="opportunityType" id="opportunityType">
                            <option value="Learning">Learning Opportunity </option>
                            <option value="Internship">Job/Internship</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="Company/Institution name"> Company / Institution </label>
                        <input type="text" class="form-control" name="companyName" id="companyName" aria-describedby="" placeholder="">
                    </div>


                    <div class="form-group">
                        <label for="Period"> Period </label>
                        <input type="text" class="form-control" name="period" id="period" aria-describedby="" placeholder="">
                    </div>

                    <div class="form-group">
                        <label for="Location"> Location </label>
                        <input type="text" class="form-control" name="location" id="location" placeholder="">
                    </div>

                    <div class="form-group">
                        <label for="Description"> Description </label>
                        <input type="text" class="form-control" name="description" id="description" aria-describedby="" placeholder="" 
                        style="height: calc(2.5em + 4.75rem + 2px); width: calc(10em + 10rem + 2px);">
                    </div>

                    <div class="form-group">
                        <label for="link"> Link </label>
                        <input type="text" class="form-control" name="link" id="link" aria-describedby="" placeholder="">
                    </div>


                    <div class="">
                        <button type="submit" class="btn btn-outline-primary">Submit</button>
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
