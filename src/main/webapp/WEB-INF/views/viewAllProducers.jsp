<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All producers</title>
</head>
<body>
<h2>Producers:</h2>
<table border="2", cellpadding="2", width="60%">
    <tr>
        <th>ID</th>
        <th>Company name</th>
        <th>Location</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${list}" var="producer">
        <tr>
            <td>${producer.id}</td>
            <td>${producer.name}</td>
            <td>${producer.country}</td>
            <td><a href="/updateProducer/${producer.id}">Edit</a></td>
            <td><a href="deleteProducer/${producer.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<div><a href="./addProducer">Add producer</a></div>
<div><a href="./viewAllTools">Back to list of tools</a></div>

</body>
</html>
