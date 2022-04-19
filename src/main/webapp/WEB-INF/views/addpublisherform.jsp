<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="publisher" type="pl.coderslab.entity.Publisher"--%>
<form:form modelAttribute="publisher" method="post">
    Name: <form:input path="name"/>
    <input type="submit">
</form:form>
<a href="/list-publisher">List Publishers</a>
</body>
</html>
