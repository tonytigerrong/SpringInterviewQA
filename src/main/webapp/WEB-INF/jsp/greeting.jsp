<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE HTML>
<html>
	<title>
	</title>
	
	<body>
	Hello:
	<c:forEach var="name" items="${names}">     
       <c:out value="${name}"  />
    </c:forEach>
	</body>
</html>