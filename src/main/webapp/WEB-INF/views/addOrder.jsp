<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create order</title>
</head>
<body>
<h2>Enter order details</h2>
<form:form action="/saveOrder" method="post" commandName="command">
    <table style="with: 50%">
    <tr>
        <td>Tool</td>
        <td><form:input path="tool.id" id="tool" value="${tool.id}" /></td>
    </tr>
    <tr>
        <td>Customer</td>
        <td>
            <form:select path="customer.id" id="customer">
            <c:forEach items="${customerList}" var="customer">
                <form:option value="${customer.id}">${customer}</form:option>
            </c:forEach>
            </form:select>
        </td>
    </tr>
    <tr>
        <td>Quantity:<font color="red"><form:errors path="quantity"/></font></td>
        <td><form:input path="quantity" id="quantity" /></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save" /></td>
    </tr>
</table>
</form:form>
</body>
</html>
