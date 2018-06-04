    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h1>
<c:choose>
<c:when test="${not empty param.role}">
 <c:out value="${param.role}" escapeXml="false"/>
</c:when>
<c:otherwise>Role is empty</c:otherwise>
</c:choose>
</h1>


</body>
</html>