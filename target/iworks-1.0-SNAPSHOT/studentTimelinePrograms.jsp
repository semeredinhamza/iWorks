<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <title>Opportunities</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/studentPage.css" rel="stylesheet">
</head>

<body>

    <nav class="navbar navbar-light bg-light navbar-right">

        <a role="button" class="btn btn-outline-primary my-2 my-sm-2" href="loginPage.jsp" style="margin-left:1400px;">Logout</a>

    </nav>

    <div class="limiter">
        <div class="container-login">

            <div class="jumbotron">
                <div class="" style="margin-left: 500px;margin-top: 10px;">
                    <a role="button" class="btn btn-primary btn-lg" href="https://iworks.appspot.com/programs">Learning Opportunities</a>
                    <a role="button" class="btn btn-secondary btn-lg" href="https://iworks.appspot.com/jobs">Jobs / Internships</a>
                    <br>
                    <br>
                    <br>
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

</body>

</html>