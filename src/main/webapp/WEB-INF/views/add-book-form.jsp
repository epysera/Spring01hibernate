<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Book Form</title>
</head>
<body>
<%--@elvariable id="book" type="pl.coderslab.entity.Book"--%>
<form:form modelAttribute="book" method="post" >
    Title: <form:input path="title"/>
    Rating: <form:input path="rating" />
    Description <form:textarea path="description"/>
    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <form:select path="authors" items="${authors}"  itemLabel="firstName" itemValue="id" multiple="true"/>
    <input type="submit">
</form:form>

<a href="/list-book">List Books</a>
</body>
</html>