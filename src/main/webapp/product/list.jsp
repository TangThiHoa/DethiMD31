<%--
  Created by IntelliJ IDEA.
  User: AE
  Date: 6/1/2022
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${pro}" var="p">
    <h1>${p.id},${p.name},${p.color},${p.quatity},${p.price}</h1>
</c:forEach>

</body>
</html>
