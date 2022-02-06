<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Page with problem</title>
</head>
<body>
    <h3>Problem was happened</h3>
    <div>Details: <%=exception.getMessage()%></div>
</body>
</html>
