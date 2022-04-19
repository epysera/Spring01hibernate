<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Person Form</title>
</head>
<body>
<%--@elvariable id="person" type="pl.coderslab.entity.Person"--%>
<form:form modelAttribute="person" method="post">
    Email <form:input path="email"/>
    Login <form:input path="login"/>
    Password <form:password path="password"/>
    <input type="submit">
</form:form>
</body>
</html>
