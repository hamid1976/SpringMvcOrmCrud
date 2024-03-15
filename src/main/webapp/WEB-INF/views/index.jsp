<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Home</title>
</head>
<body>

<h1>Welcome to the Employee Management System</h1>

<!-- Display the success message if available -->
<c:if test="${not empty msg}">
    <p style="color: green;">${msg}</p>
</c:if>

<!-- Your existing content -->

</body>
</html>
