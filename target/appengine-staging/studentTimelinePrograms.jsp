<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <title>Learning Opportunities</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/studentPage.css" rel="stylesheet">
</head>

<body>

        <nav class="navbar navbar-light bg-light justify-content-between">
                <a class="nav-link" href = "http://creddle.io/">Don't Have a Resume Yet? Get One Now!</a>
                <a role="button" class="btn btn-outline-primary my-2 my-sm-2" href="loginPage.jsp">Logout</a>
              </nav>

    <div class="limiter">
        <div class="container-login">

            <div class="jumbotron">
                <div class="row ">
                        <div class="col text-center" style="margin-top: 10px;">
                                <a role="button" id = "opp" class="btn btn-primary btn-lg" href="https://iworks.appspot.com/programs">Learning Opportunities</a>
                                <a role="button" id = "intern" class="btn btn-secondary btn-lg" href="https://iworks.appspot.com/jobs">Jobs / Internships</a>
                                <br>
                                <br>
                                <br>
                        </div>
                </div>
								
                <div class="row ">
					<c:forEach items="${programs}" var="program">
                    <div class="card col-lg-4 col-md-4 mb-4">
                        <div class="card-body">
                            <p>
                                <h5>Title: </h5><c:out value="${program.getTitle()}" />
                            </p>
                            <p>
                                <h5>Institution: </h5><c:out value="${program.getInstitution()}" />
                            </p>
                            <p>
                                <h5>Period: </h5><c:out value="${program.getPeriod()}" />
                            </p>
                            <p>
                                <h5>Location: </h5><c:out value="${program.getLocation()}" />
                            </p>
                            <p>
                                <h5>Description: </h5><c:out value="${program.getDescription()}" />
                            </p>
                            <a href="${program.getLink()}" class="btn btn-primary stretched-link">Go To Employer Website</a>
                        </div>
                    </div>
					</c:forEach>		
                </div>

            </div>
        </div>
    </div>

    <script src="../vendor/jquery/jquery.min.js"></script> 
    <!-- <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
    <script src="https://www.google.com/jsapi"></script>
    <script>
            var Opportunities = "btn btn-primary btn-lg";// document.getElementById("opp").className;
            var Internships = "btn btn-secondary btn-lg";// document.getElementById("id").className;
            
            if (document.title === "Learning Opportunities")
            {
                document.getElementById("opp").className = Opportunities;
                document.getElementById("intern").className = Internships;
            }
            else
            {
                document.getElementById("opp").className = Internships;
                document.getElementById("intern").className = Opportunities;
            }
    
        </script>
</body>

</html>