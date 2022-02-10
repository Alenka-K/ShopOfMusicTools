<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create producer</title>
</head>
<body>
<h2>Enter information about the producer</h2>
<form:form action="saveProducer" method="post">
<table style="with:50%">
    <tr>
        <td>Company name</td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td>Company location (country)</td>
        <td><form:input path="country"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" /></td>
    </tr>
    </form:form>
</body>
</html>
