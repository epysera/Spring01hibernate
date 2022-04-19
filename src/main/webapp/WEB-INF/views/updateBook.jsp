<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="book" type="pl.coderslab.entity.Book"--%>
<form:form modelAttribute="book" method="post">
    Title: <form:input path="title"/>${book.title}
    Rating: <form:input path="rating"/>${book.rating}
    Description: <form:textarea path="description"/>${book.description}
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>${book.publisher.name}
    <form:select path="authors" items="${authors}" itemLabel="firstName" itemValue="id" multiple="true"/>
    <input type="submit">
</form:form>
</body>
</html>
