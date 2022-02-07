<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update details of tool</title>
</head>
<body>
<h2>Change information about tool</h2>
<form:form action="/saveUpdateTool" method="post" >
<table style="with: 50%">
        <form:hidden path="id"/>
            <tr>
                <td>Model</td>
                <td><form:input path="model"/></td>
            </tr>
            <tr>
                <td>Title</td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td>Category</td>
                <td>
                    <form:select path="category" >
                        <c:forEach items="${categoryList}" var="category">
                            <form:option value="${category.id}">${category.name}</form:option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Producer</td>
                <td>
                    <form:select path="producer">
                        <c:forEach items="${producerList}" var="producer">
                            <form:option value="${producer.id}">${producer.id} ${producer.name}</form:option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
        <td></td>
        <td><input type="submit" value="Save" /></td>
    </tr>
    </form:form>
</body>
</html>
