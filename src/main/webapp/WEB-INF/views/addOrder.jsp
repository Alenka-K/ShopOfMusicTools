<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create order</title>
</head>
<body>
<h2>Enter order details</h2>
<form:form action="/saveOrder" method="post" >
<table style="with: 50%">
    <tr>
        <td>Customer</td>
        <td>
        <form:select path="customer" >
            <c:forEach items="${customerList}" var="customer">
                <form:option value="${customer.id}">${customer.name} ${customer.phone}</form:option>
            </c:forEach>
        </form:select>
        </td>
    </tr>

    <tr>
        <td>Tool</td>
        <td><form:input path="tool" value="${tool.id}"/></td>
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
