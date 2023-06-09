<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

  <title>All applicants by faculty</title>

  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

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

      <c:if test="${not empty applicantDtos}">
        <c:forEach items="${applicantDtos}" var="currentApplicantDto">

          <div class="w3-card-4" style="width: 20%; margin:2%" >
            <img src="https://kaverisias.com/wp-content/uploads/2018/01/catalog-default-img.gif" alt="Norway" style="width: 100%">
            <div class="w3-container w3-center">
              <h3>${currentApplicantDto.firstName}${currentApplicantDto.lastName}</h3>
              <p>${currentApplicantDto.facultyName}</p>
              <p>${currentApplicantDto.enabled}</p>
            </div>
          </div>

        </c:forEach>
      </c:if>


    </div>

  </div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>