<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employees List</title>
</head>
<body>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Employee No</th>
        <th>Name</th>
        <th>CNIC</th>
        <th>Email</th>
        <th>Mobile No</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <td>${emp.employeeNo}</td>
            <td>${emp.name}</td>
            <td>${emp.cnic}</td>
            <td>${emp.email}</td>
            <td>${emp.mobileNo}</td>
            <td>${emp.address}</td>
            <td><a href="editemp/${emp.employeeNo}">Edit</a></td>
            <td><a href="deleteemp/${emp.employeeNo}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="addEmployee">Add New Employee</a>
<a href="employeebyid">Employee By Id</a>

</body>
</html>
