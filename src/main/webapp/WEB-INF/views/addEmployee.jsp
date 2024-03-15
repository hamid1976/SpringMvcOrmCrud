
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add New Employee</title>
</head>
<body>
<c:if test="${not empty msg}">
    <p style="color: green;">${msg}</p>
</c:if>



<h1>Add New Employee</h1>

<form:form method="post" action="save" modelAttribute="emp">
    <table>
        <tr>
            <td>Employee No:</td>
            <td><form:input path="employeeNo" /></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>CNIC:</td>
            <td><form:input path="cnic" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td>Mobile No:</td>
            <td><form:input path="mobileNo" /></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><form:input path="address" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
<a href="http://localhost:8080/SpringMvc/">View New Employee</a>

</body>
</html>
 