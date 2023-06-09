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
    <link type="text/css" href="cabinet.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <jsp:include page="sidebar.jsp"></jsp:include>

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

                <h2>Welcome  ${pageContext.request.userPrincipal.name}</h2>

            </c:if>

            <div class="container">
                <section class="mx-auto my-5" style="max-width: 23rem;">

                    <div class="card testimonial-card mt-2 mb-3">
                        <div class="card-up aqua-gradient"></div>
                        <div class="avatar mx-auto white">
<%--                            <img src="https://mdbootstrap.com/img/Photos/Avatars/img%20%2831%29.jpg" class="rounded-circle img-fluid"
                                 alt="woman avatar">--%>
                            <c:if test="${applicantDto.encodedImage != null}">
                                <img src="data:image/jpg;base64,${applicantDto.encodedImage}" alt="image" class="rounded-circle img-fluid">
                            </c:if>
                        </div>
                        <div class="card-body text-center">
                            <h4 class="card-title font-weight-bold">${applicantDto.firstName} ${applicantDto.lastName}</h4>
                            <hr>
                            <p><i class="fas fa-quote-left"></i> ID: ${applicantDto.id}</p>
                            <p><i class="fas fa-quote-left"></i> Is enrolled: ${applicantDto.enabled} </p>
                        </div>
                    </div>

                </section>
            </div>

<%--            <div>
                <h2>Profile Information</h2>
                <p>Id: ${applicantDto.id}</p>
                <p>First name: ${applicantDto.firstName}</p>
                <p>Last name: ${applicantDto.lastName}</p>
                <p>Is enrolled: ${applicantDto.enabled}</p>
                <c:if test="${applicantDto.encodedImage != null}">
                    <td><img src="data:image/jpg;base64,${applicantDto.encodedImage}" alt="image"
                             style="width: 10%"></td>
                </c:if>
            </div>--%>

            <c:if test="${applicantDto.encodedImage == null}">
                <form:form method="POST" action="${contextPath}/addImage"
                           enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td>Select your photo for cabinet to upload</td>
                            <td><input type="file" name="image"/></td>
                        </tr>

                        <tr>
                            <td><input type="submit" value="Upload"/></td>
                        </tr>
                    </table>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form:form>
            </c:if>

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
                        <td><form:hidden path="scores[${loop.index}].name" value="${examScore.name}"/></td>
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
</body>
</html>