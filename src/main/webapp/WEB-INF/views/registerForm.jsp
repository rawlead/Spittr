<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value=" "/>">
    <title>Spitter</title>
</head>
<body>
<h1>Register</h1>
<form method="post">
    First Name: <input type="text" name="firstName"/> <br>
    Last Name: <input type="text" name="lastName"/> <br>
    Username: <input type="text" name="userName"/> <br>
    Password: <input type="password" name="password"/> <br>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
