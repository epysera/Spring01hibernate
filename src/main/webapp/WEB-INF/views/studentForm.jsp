<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<%--@elvariable id="student" type="pl.coderslab.entity.Student"--%>
<form:form modelAttribute="student" method="post">
    <p>FirstName <form:input path="firstName"/> </p>
    <p>LastName <form:input path="lastName"/></p>
    <p>Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="F"/></p>
    <p>Country: <form:select path="country" items="${countries}" /></p>
    <p>Notes: <form:textarea path="notes"/></p>
    <p>Mailinglist:<form:checkbox path="mailingList"/> </p>
    <p>ProgrammingSkills: <form:select path="programmingSkills" multiple="true" items="${programmingSkills}"/></p>
    <p>Hobbies: <form:checkboxes items="${hobbies}" path="hobbies"/> </p>

    <input type="submit">
</form:form>
</body>
</html>
