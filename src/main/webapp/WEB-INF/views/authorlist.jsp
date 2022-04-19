
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <%--@elvariable id="authors" type="java.util.List<pl.coderslab.entity.Author>"--%>
    <c:forEach var="item" items="${authors}">
        <tr>
            <td>${item.id}</td>
            <td>${item.firstName}</td>
            <td>${item.lastName}</td>
            <td><a href="/author/saftydelete/${item.id}">delete</a></td>
            <td><a href="/update-author/${item.id}">update</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/add-author">Add Author</a>
</body>
</html>

