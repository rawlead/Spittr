<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<s:url value="/spitter/register" var="registerUrl" scope="request" />

<s:url value="/spittles" var="spittleUrl" htmlEscape="true" >
    <s:param name="max" value="24" />
    <s:param name="count" value="14"/>
</s:url>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css"/>" >
</head>
<body>
<%--welcome message from a properties file--%>
<h1><s:message code="spittr.welcome"/> </h1>
<div class="homeNav">
    <a href="${spittleUrl}">Spittles</a>
 | <a href="${registerUrl}">Register</a>
</div>
</body>
</html>