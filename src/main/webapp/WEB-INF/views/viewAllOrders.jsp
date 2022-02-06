<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </tr>
    <c:forEach var="order" items="${list}">
        <tr>
            <td>${order.id}</td>
            <td>${order.date}</td>
            <td>${order.customer.name}: ${order.customer.phone}</td>
            <td>${order.tool.model} ${order.tool.title}</td>
            <td>${order.quantity}</td>
            <td><a href="updateOrder/${order.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<div><a href="./addOrder">Add new order</a></div>
<div><a href="./menu">Back to main menu</a></div>
</body>
</html>
