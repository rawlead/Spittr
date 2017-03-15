<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value=" "/>">
    <title>Spitter</title>
</head>
<body>
<h1>Register</h1>
<sf:form method="POST" commandName="spitter">
    First Name: <sf:input path="firstName"/> <br/>
    Last Name: <sf:input path="lastName"/> <br/>
    Email: <sf:input path="email"/> <br/>
    Username: <sf:input path="username"/><br/>
    Password: <sf:password path="password"/> <br/>
    <input type="submit" value="Register"/>
</sf:form>
</body>
</html>
