<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Get Employee By Id</title>
</head>
<body>
<c:if test="${not empty msg}">
    <p style="color: green;">${msg}</p>
</c:if>

<h1>Get Employee By Id</h1>

  <!-- Adjust the form action and URL in the href accordingly -->
<form:form method="post" action="getEmployeeById" modelAttribute="emp">
    <table>
        <tr>
            <td>Enter Employee No:</td>
            <td><form:input path="employeeNo" /></td>
        </tr>
        <!-- Add other input fields for employee details as needed -->
    </table>
    <button type="submit">Get Employee</button>
</form:form>

<!-- Adjust the URL accordingly -->
<a href="http://localhost:8080/SpringMvc/">View New Employee</a>
  

</body>
</html>
  
  
  
  
  
