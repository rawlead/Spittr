<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value=" "/>">
    <title>Profile</title>
</head>
<body>
<h1>Your profile</h1>
<h3><c:out value="${spitter.username}"/></h3>
<p><c:out value="${spitter.email}"/></p>
<p><c:out value="${spitter.firstName}"/> <c:out value="${spitter.lastName}"/></p>
</body>
</html>
