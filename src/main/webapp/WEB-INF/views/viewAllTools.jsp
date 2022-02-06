<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <th>Price</th>
        <th>Category</th>
        <th>Producer</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="tool" items="${list}">
        <tr>
            <td>${tool.id}</td>
            <td>${tool.model}</td>
            <td>${tool.title}</td>
            <td>${tool.price}</td>
            <td>${tool.category.id}: ${tool.category.name}</td>
            <td>${tool.producer.id}: ${tool.producer.name}:</td>
            <td><a href="editTool/${tool.id}">Edit</a></td>
            <td><a href="deleteTool/${tool.id}">Delete</a></td>
            <td><a href="addOrder/${tool.id}">order</a></td>
        </tr>
    </c:forEach>
</table>
<div></div>
<div><a href="./addTool">Add new tool</a></div>
<div><a href="./menu">Back to main menu</a></div>
</body>
</html>