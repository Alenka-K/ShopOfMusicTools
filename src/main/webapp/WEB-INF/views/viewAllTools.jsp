<%@ page import="com.example.shopofmusictools.CurrencyRateRequester" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>All music tools:</title>

</head>
<body>
<h2>All music tools:</h2>
<table border="2", cellpadding="2", width="60%">
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Title</th>
        <th>Price, грн</th>
        <th>Category</th>
        <th>Producer</th>
        <security:authorize access="hasRole('ADMIN')">
        <th>Update</th>
        <th>Delete</th>
        </security:authorize>
        <security:csrfInput/>
        <th>ORDER</th>
    </tr>
    <c:forEach var="tool" items="${list}">
        <tr>
            <td>${tool.id}</td>
            <td>${tool.model}</td>
            <td>${tool.title}</td>
            <td>${String.format("%.0f", CurrencyRateRequester.getCurrencyRate(tool.currency))*tool.price}</td>
            <td><a href="showCategory/${tool.category.id}">${tool.category.name}</a></td>
            <td><a href="showProducer/${tool.producer.id}">${tool.producer.name}</a></td>
            <security:authorize access="hasRole('ADMIN')">
            <td><a href="updateTool/${tool.id}">Edit</a></td>
            <td><a href="deleteTool/${tool.id}">Delete</a></td>
            </security:authorize>
            <security:csrfInput/>
            <td><a href="addOrder/${tool.id}">order</a></td>
        </tr>
    </c:forEach>
</table>
        <security:authorize access="hasRole('ADMIN')">
            <div><li><a href="./addTool">Add new tool</a></li></div>
        </security:authorize>
        <security:csrfInput/>
        <div><li><a href="./viewAllCategories">View all category</a></li></div>
        <div><li><a href="./viewAllProducers">View all producer</a></li></div>
        <div><li><a href="./viewAllCustomers">View all customer</a></li></div>
<div><a href="./">Back to main menu</a></div>
</body>
</html>
