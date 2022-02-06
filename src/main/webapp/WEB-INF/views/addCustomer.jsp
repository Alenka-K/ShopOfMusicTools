<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create customer</title>
</head>
<body>
<h2>Enter info about new customer</h2>
<form:form action="saveCustomer" method="post">
    <table style="with: 50%">
    <tr>
        <td>Name</td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td>Phone</td>
        <td><form:input path="phone"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" /></td>
    </tr>
</form:form>
</body>
</html>
