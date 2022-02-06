<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update category</title>
</head>
<body>
<h2>Update category details:</h2>
<form:form  action="saveUpdateCategory" method="post" >
<table style="with: 50%">
    <tr>
        <td>ID</td>
        <td><form:input path="id"/></td>
    </tr>
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
        <td><input type="submit" value="Save changes"/></td>
    </tr>
    </form:form>
</body>
</html>
