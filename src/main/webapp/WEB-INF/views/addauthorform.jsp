<%--
  Created by IntelliJ IDEA.
  User: emil
  Date: 15.04.2022
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="author" type="pl.coderslab.entity.Author"--%>
<form:form modelAttribute="author" method="post">
    First name: <form:input path="firstName"/><br>
    Last name: <form:input path="lastName"/><br>
    <input type="submit">
</form:form>
<a href="/list-author">List Authors</a>
</body>
</html>

