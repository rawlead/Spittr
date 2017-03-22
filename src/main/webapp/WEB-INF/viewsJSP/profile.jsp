<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Your profile</h1>
<h3><c:out value="${spitter.username}"/></h3>
<p><c:out value="${spitter.email}"/></p>
<p><c:out value="${spitter.firstName}"/> <c:out value="${spitter.lastName}"/></p>