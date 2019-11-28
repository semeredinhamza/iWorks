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
                    <h1> New Posting </h1>
                    <br>
                </div>
                <form>
        
                    <div class="form-group">
                        <label for="Listing Title"> Title </label>
                        <input type="text" class="form-control" id="title" aria-describedby="" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="typeExp">Type of Experience</label>
                        <select class="form-control" id="expOptions">
                            <option value="Intership">Intership</option>
                            <option value="Learing">Learning Oppourtunity </option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="Company/Institution name"> Company / Institution </label>
                        <input type="text" class="form-control" id="name" aria-describedby="" placeholder="">
                    </div>


                    <div class="form-group">
                        <label for="Period"> Period </label>
                        <input type="text" class="form-control" id="Period" aria-describedby="" placeholder="">
                    </div>

                    <div class="form-group">
                        <label for="Location"> Location </label>
                        <input type="text" class="form-control" id="Location" placeholder="">
                    </div>

                    <div class="form-group">
                        <label for="Description"> Description </label>
                        <input type="text" class="form-control" id="Description" aria-describedby="" placeholder="" 
                        style="height: calc(2.5em + 4.75rem + 2px); width: calc(10em + 10rem + 2px);">
                    </div>

                    <div class="form-group">
                        <label for="link"> Link </label>
                        <input type="text" class="form-control" id="link" aria-describedby="" placeholder="">
                    </div>


                    <div class="">
                        <a role="button" class="btn btn-outline-primary" href=""> Submit </a>
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