<%@ page contentType="text/html;charset=UTF-8"  %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update order</title>
</head>
<body>
<h2>Change quantity</h2>
<form:form action="/saveUpdateOrder"  method="post">
<table style="with: 50%">
    <tr>
        <td>Customer</td>
        <td><form:input path="customer.id"  readonly="true"/></td>
    </tr>

    <tr>
        <td>Tool</td>
        <td><form:input path="tool.id"  readonly="true"/></td>
    </tr>
    <tr>
        <td>Quantity: <font color="red"><form:errors path="quantity"/></font></td>
        <td><form:input path="quantity"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" /></td>
    </tr>
    </form:form>
</body>
</html>