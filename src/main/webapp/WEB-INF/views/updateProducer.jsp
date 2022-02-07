<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update information about producer</title>
</head>
<body>
<h2>Update information about producer:</h2>
<form:form  action="/saveUpdateProducer" method="post">
<table style="with: 50%">
    <tr>
        <td>Id</td>
        <td><form:input path="id" readonly="true"/></td>
    </tr>
    <tr>
        <td>Company name:</td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td>Company location (country):</td>
        <td><form:input path="country"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save"/></td>
    </tr>
    </form:form>
</body>
</html>
