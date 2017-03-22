<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resources/style.css"/>">
    <title>Spittr</title>
</head>
<body>
<div id="header">
    <%--insert the header--%>
    <t:insertAttribute name="header"/>
</div>
<div id="content">
    <%--insert the body--%>
    <t:insertAttribute name="body"/>
</div>
<div id="footer">
    <%--insert the footer--%>
    <t:insertAttribute name="footer"/>
</div>
</body>
</html>
