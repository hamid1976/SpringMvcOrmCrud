<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>

<h1>Edit Employee</h1>
<form:form method="POST" action="/SpringMvc/update">
    <table>
        <tr>

            <td><form:hidden path="employeeNo" /></td>
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
            <td><input type="submit" value="Update Data" /></td>
        </tr>
    </table>
</form:form>
<a href="http://localhost:8080/SpringMvc/">View New Employee</a>
</body>
</html>
