<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE HTML>
<html>
	<title>
	</title>
	
	<body>
	<form:form method="POST" action="/createuser" modelAttribute="user">
	    <form:label path="firstName">firstName</form:label>
	    <form:input path="firstName" />
	     
	    <form:label path="lastName">lastName</form:label>
	    <form:input path="lastName" />
	     
	    <form:label path="age">age</form:label>
	    <form:input path="age" />
	    <input type="submit" value="Submit" />
	</form:form>
	</body>
</html>