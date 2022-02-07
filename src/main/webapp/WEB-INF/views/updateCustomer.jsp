<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update information about customer</title>
</head>
<body>
<h2>Update information about customer:</h2>
<form:form  action="/saveUpdateCustomer" method="post">
<table style="with: 50%">
    <tr>
        <td>Id</td>
        <td><form:input path="id" readonly="true"/></td>
    </tr>
    <tr>
        <td>Name:</td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td>Customer's phone:</td>
        <td><form:input path="phone"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save"/></td>
    </tr>
    </form:form>
</body>
</html>
