<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IssueTracker</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <c:redirect url="/users"/>
    </c:when>
    <c:otherwise>
        <c:redirect url="/login"/>
    </c:otherwise>
</c:choose>
</body>
</html>
