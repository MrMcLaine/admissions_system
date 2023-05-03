<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Fill your exam scores</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
<div class="container">

    <!-- Sidebar -->
    <div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
        <h3 class="w3-bar-item">Menu</h3>
        <a href="/home" class="w3-bar-item w3-button">Home</a>
        <a href="/examScores" class="w3-bar-item w3-button">Fill in exam scores</a>
        <a href="/apply-admission" class="w3-bar-item w3-button">Apply for admission to the faculty</a>
        <a href="/applicantsByFaculty" class="w3-bar-item w3-button">View all applicants by selected faculty</a>

    </div>

    <!-- Page Content -->
    <div style="margin-left: 10%">

        <div class="w3-container w3-teal">
            <h1>Faculty students</h1>
        </div>

        <div class="w3-container">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>

                <h2>Welcome ${pageContext.request.userPrincipal.name} | <a
                        onclick="document.forms['logoutForm'].submit()">Logout</a>
                </h2>

            </c:if>

            <div>
                <h2>Profile Information</h2>
                <p>Id: ${applicant.id}</p>
                <p>First name: ${applicant.firstName}</p>
                <p>Last name: ${applicant.lastName}</p>
                <p>Email: ${applicant.email}</p>
            </div>
        </div>

        <form:form method="POST" action="${contextPath}/submitExamScores" modelAttribute="applicantDto">
            <table>
                <tr>
                    <th>Subject</th>
                    <th>Score</th>
                </tr>
                <c:forEach var="examScore" items="${applicantDto.scores}" varStatus="loop">
                    <tr>
                        <td>${examScore.name}</td>
                        <td><form:hidden path="scores[${loop.index}].name" value="${examScore.name}" /></td>
                        <td><form:input path="scores[${loop.index}].score" type="number" max="100" min="0"/></td>
                    </tr>
                </c:forEach>
            </table>
            <button type="submit">Submit</button>
        </form:form>

    </div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>