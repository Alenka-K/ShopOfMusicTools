<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create customer</title>
</head>
<body>
<h2>Enter info about new customer:</h2>
<form:form action="saveCustomer" method="post" commandName="command">
    <table style="with: 50%">
    <tr>
        <td>Name: <font color="red"><form:errors path="name"/></font></td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td>Phone(+38 (XXX) XXX-XXXX): <font color="red"><form:errors path="phone"/></font></td>
        <td><form:input path="phone"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" /></td>
    </tr>
</form:form>
</body>
</html>
