
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <%--@elvariable id="publishers" type="java.util.List<pl.coderslab.entity.Publisher>"--%>
    <c:forEach var="item" items="${publishers}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td><a href="/publisher/saftydelete/${item.id}">delete</a></td>
            <td><a href="/update-publisher/${item.id}">update</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/add-publisher">Add Publisher</a>
</body>
</html>
