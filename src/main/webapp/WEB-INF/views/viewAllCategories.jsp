<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All categories</title>
</head>
<body>
<h2>Categories:</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Discount</th>
    </tr>
    <c:forEach items="${list}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.discount}</td>
            <td><a href="/updateCategory/${category.id}">Edit</a></td>
            <td><a href="deleteCategory/${category.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
    <div><a href="./addCategory">Add category</a></div>
    <div><a href="./viewAllTools">View all music tools</a></div>
    <div><a href="./menu">Back to main menu</a></div>

</body>
</html>