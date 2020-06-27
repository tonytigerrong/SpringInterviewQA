<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DocType html>
<html>
	<title>
	 
	</title>
	 
	
	<body>
	<h1><spring:message code="greeting" text="default"/></h1>
	 <span><spring:message code="lang.change" text="default"/></span>:
	<select id="locales">
	    <option value=""></option>
	    <option value="en" ><spring:message code="lang.eng" text="default"/></option>
	    <option value="fr" ><spring:message code="lang.fr" text="default"/></option>
	</select>

	</body>
</html>
