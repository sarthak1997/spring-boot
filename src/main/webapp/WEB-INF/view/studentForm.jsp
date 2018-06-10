<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHOOSE AGE GROUP</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		CHOOSE AGE GROUP
		
		<form:select path="age">
			<form:option value="20">10-20</form:option>
			<form:option value="30">20-30</form:option>
			<form:option value="60">30-60</form:option>
		</form:select><br><br>
		
		CHOOSE CITY
		<form:select path="city">
			<form:option value="indore">INDORE</form:option>
			<form:option value="mumbai">MUMBAI</form:option>
			<form:option value="delhi">DELHI</form:option>
			<form:option value="allahabad">ALLAHABAD</form:option>
			<form:option value="gorakhpur">GORAKHPUR</form:option>
		</form:select><br><br>
		
		<input type="submit" value="GET TOP STUDENTS">
	</form:form>
</body>
</html>