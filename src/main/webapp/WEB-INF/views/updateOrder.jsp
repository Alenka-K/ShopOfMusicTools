<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update order</title>
</head>
<body>
<h2>Change quantity</h2>
<form:form action="/saveUpdateOrder" method="post" >
<table style="with: 50%">
    <form:hidden path="id"/>
    <tr>
        <td>Customer</td>
        <td><form:input path="customer" value="${command.customer.id}" readonly="true"/></td>
    </tr>

    <tr>
        <td>Tool</td>
        <td><form:input path="tool" value="${command.tool.id}" readonly="true"/></td>
    </tr>
    <tr>
        <td>Quantity</td>
        <td><form:input path="quantity"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" /></td>
    </tr>
    </form:form>
</body>
</html>