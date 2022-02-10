<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update information about customer</title>
</head>
<body>
<h2>Update information about customer:</h2>
<form:form  action="/saveUpdateCustomer" method="post" modelAttribute="command">
<table style="with: 50%">
    <tr>
        <td>Id</td>
        <td><form:input path="id" readonly="true"/></td>
    </tr>
    <tr>
        <td>Name:</td>
        <td><form:input path="name"/><font color="red"><form:errors path="name"/></font></td>
    </tr>
    <tr>
        <td>Customer's phone:</td>
        <td><form:input path="phone"/><font color="red"><form:errors path="phone"/></font></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save"/></td>
    </tr>
    </form:form>
</body>
</html>
