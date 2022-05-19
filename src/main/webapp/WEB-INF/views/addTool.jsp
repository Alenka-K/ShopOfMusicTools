<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Create tool</title>
</head>
<body>
  <h2>Enter tool details</h2>
<form:form action="saveTool" method="post" >
<table style="with: 50%">
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
    <td>Currency</td>
      <td><form:select path="currency" >
          <c:forEach items="${currencyCodeList}" var="currency">
              <form:option value="${currency}">${currency}</form:option>
          </c:forEach>
      </form:select>
      </td>
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
</table>
</form:form>
</body>
</html>