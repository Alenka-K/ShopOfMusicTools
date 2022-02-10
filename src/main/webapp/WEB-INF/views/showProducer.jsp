<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Information about producer</title>
</head>
<body>
<h2>Information about producer</h2>
<table style="with: 50%">
    <tr>
        <td>Company ID:</td>
        <td>${producer.id}</td>
    </tr>
    <tr>
        <td>Company name:</td>
        <td>${producer.name}</td>
    </tr>
    <tr>
        <td>Company location(country) :</td>
        <td>${producer.country}</td>
    </tr>
</table>
<div><a href="/viewAllTools">Back</a></div>
</body>
</html>

