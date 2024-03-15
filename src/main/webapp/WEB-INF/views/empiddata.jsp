<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Details</title>
</head>
<body>

<c:if test="${not empty msg}">
    <p style="color: green;">${msg}</p>
</c:if>

<h1>Employee Details</h1>

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

    <c:if test="${not empty emp}">
        <tr>
            <td>${emp.employeeNo}</td>
            <td>${emp.name}</td>
            <td>${emp.cnic}</td>
            <td>${emp.email}</td>
            <td>${emp.mobileNo}</td>
            <td>${emp.address}</td>
      
        </tr>
    </c:if>

</table>

<br/>

</body>
</html>
