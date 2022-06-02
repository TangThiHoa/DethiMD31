<%--
  Created by IntelliJ IDEA.
  User: AE
  Date: 6/1/2022
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <c:forEach items="sua" var="c">
    <input type="text" name="name" value="${c.name}">
    <button>Click</button>
    </c:forEach>
</form>

</body>
</html>
