<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
  <h3 class="w3-bar-item">Menu</h3>
  <a href="/home" class="w3-bar-item w3-button">Home</a>
  <sec:authorize access="hasAuthority('APPLICANT')">
    <a href="/examScores" class="w3-bar-item w3-button">Fill in exam scores</a>
    <a href="/apply-admission" class="w3-bar-item w3-button">Apply for admission to the faculty</a>
    <a href="/applicantsByFaculty" class="w3-bar-item w3-button">View all applicants by selected faculty</a>
  </sec:authorize>
  <sec:authorize access="hasAuthority('ADMIN')">
    <a href="/adminPage" class="w3-bar-item w3-button">Admin cabinet</a>
  </sec:authorize>
  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <a href="#" class="w3-bar-item w3-button" onclick="document.forms['logoutForm'].submit()" >Logout</a>
  </c:if>
</div>
</body>
</html>
