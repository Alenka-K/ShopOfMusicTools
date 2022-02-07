<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information about category</title>
</head>
<body>
<h2>Category details</h2>
<table style="with: 50%">
    <tr>
        <td>Category name:</td>
        <td>${category.name}</td>
    </tr>
    <tr>
        <td>Discount, % :</td>
        <td>${category.discount}</td>
    </tr>
</table>
<div><a href="/viewAllTools">Back</a></div>
</body>
</html>
