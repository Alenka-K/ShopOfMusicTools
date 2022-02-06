<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Create order</title>
</head>
<body>
<h2>Enter order details</h2>
<form:form action="saveOrder" method="post" >
<table style="with: 50%">
    <tr>
        <td>Customer</td>
        <td><form:input path="customer.id"/></td>
        <td><a href="/addCustomer">Add new customer</a></td>
    </tr>

    <tr>
        <td>Tool</td>
        <td><form:input path="tool"/></td>
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
