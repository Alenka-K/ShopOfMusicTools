<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>All orders:</title>
</head>
<body>
<h2>All orders:</h2>
<table border="2", cellpadding="2", width="60%">
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Customer</th>
        <th>Tool</th>
        <th>Quantity</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="order" items="${list}">
        <tr>
            <td>${order.id}</td>
            <td>${order.date}</td>
            <td>${order.customer.name}: ${order.customer.phone}</td>
            <td>${order.tool.model} ${order.tool.title}</td>
            <td>${order.quantity}</td>
            <td><a href="updateOrder/${order.id}">Edit</a></td>
            <td><a href="deleteOrder/${order.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<div><a href="./viewAllTools">Go to list of tools for ordering</a></div>
</body>
</html>
