<%--
  Created by IntelliJ IDEA.
  User: AE
  Date: 6/1/2022
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List</h2>
<a href="/categorys?act=create">Create</a>
<c:forEach items="${cate}" var="c">
    <h1>${c.id},${c.name}
        <a href="/categorys?act=edit&id">Edit</a>
        <a href="/categorys?act=delete&id">Delete</a>
    </h1>
</c:forEach>
</form>
</body>
</html>
