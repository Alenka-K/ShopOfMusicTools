<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All categories</title>
</head>
<body>
<h2>Categories:</h2>
<table border="2", cellpadding="2", width="60%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Discount %</th>
        <security:authorize access="hasRole('ADMIN')">
            <th>Update</th>
            <th>Delete</th>
        </security:authorize>
        <security:csrfInput/>
    </tr>
    <c:forEach items="${list}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.discount}</td>
            <security:authorize access="hasRole('ADMIN')">
                <td><a href="/updateCategory/${category.id}">Edit</a></td>
                <td><a href="deleteCategory/${category.id}">Delete</a></td>
            </security:authorize>
            <security:csrfInput/>
        </tr>
    </c:forEach>
</table>
    <security:authorize access="hasRole('ADMIN')">
        <div><a href="./addCategory">Add category</a></div>
    </security:authorize>
    <security:csrfInput/>
        <div><a href="./viewAllTools">Back to list of tools</a></div>

</body>
</html>