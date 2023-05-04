<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

    <title>Welcome</title>

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
        <sec:authorize access="hasAuthority('ADMIN')">
            <a href="/adminPage" class="w3-bar-item w3-button">Admin cabinet</a>
        </sec:authorize>
    </div>

    <!-- Page Content -->
    <div style="margin-left: 10%">

        <div class="w3-container w3-teal">
            <h1>Admin page</h1>
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

            <c:if test="${faculties != null}">
                <form:form method="POST" action="/selectFaculty" modelAttribute="adminDto">
                    <h3>Select the faculty for checking Applications for admission</h3>
                    <form:select path="selectedFacultyName">
                        <form:options items="${faculties}"/>
                    </form:select>
                    <button type="submit">Submit</button>
                </form:form>
            </c:if>

            <c:if test="${applicants != null}">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Birthday</th>
                        <th>Email</th>
                        <th>Photo</th>
                        <th>Scores</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="applicant" items="${applicants}">
                        <tr>
                            <td>${applicant.id}</td>
                            <td>${applicant.firstName}</td>
                            <td>${applicant.lastName}</td>
                            <td>${applicant.birthday}</td>
                            <td>${applicant.email}</td>
                            <td><img src="data:image/jpg;base64,${applicant.encodedImage}" alt="image" style="width: 10%"></td>
                            <td>${applicant.scores}</td>
                            <td><a href="disabled?id= ${applicant.id}">Disabled</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>

        </div>

    </div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>