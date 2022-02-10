<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
        <security:authorize access="hasRole('ADMIN')">
            <th>Update</th>
            <th>Delete</th>
        </security:authorize>
        <security:csrfInput/>
    </tr>
    <c:forEach items="${list}" var="producer">
        <tr>
            <td>${producer.id}</td>
            <td>${producer.name}</td>
            <td>${producer.country}</td>
            <security:authorize access="hasRole('ADMIN')">
                <td><a href="/updateProducer/${producer.id}">Edit</a></td>
                <td><a href="deleteProducer/${producer.id}">Delete</a></td>
            </security:authorize>
            <security:csrfInput/>
        </tr>
    </c:forEach>
</table>
    <security:authorize access="hasRole('ADMIN')">
        <div><a href="./addProducer">Add producer</a></div>
    </security:authorize>
    <security:csrfInput/>
        <div><a href="./viewAllTools">Back to list of tools</a></div>

</body>
</html>
