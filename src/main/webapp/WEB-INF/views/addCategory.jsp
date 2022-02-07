<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create category</title>
</head>
<body>
<h2>Enter category details</h2>
<form:form action="saveCategory" method="post">
<table style="with: 50%">
    <tr>
        <td>Name</td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td>Discount</td>
        <td><form:input path="discount"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" /></td>
    </tr>
    </form:form>
</body>
</html>
