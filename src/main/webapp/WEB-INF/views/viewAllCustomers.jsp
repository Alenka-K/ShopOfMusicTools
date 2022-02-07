<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>All customers</title>
</head>
<body>
<h2>Customers:</h2>
<table border="2", cellpadding="2", width="60%">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
  <c:forEach items="${list}" var="customer">
    <tr>
      <td>${customer.id}</td>
      <td>${customer.name}</td>
      <td>${customer.phone}</td>
      <td><a href="/updateCustomer/${customer.id}">Edit</a></td>
      <td><a href="deleteCustomer/${customer.id}">Delete</a></td>
    </tr>
  </c:forEach>
</table>
<div><a href="./addCustomer">Add new customer</a></div>
<div><a href="./viewAllTools">Back to list of tools</a></div>

</body>
</html>
