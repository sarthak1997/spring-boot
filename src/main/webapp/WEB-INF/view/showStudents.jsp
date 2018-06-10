<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h3>TOP STUDENTS LIST FOR CITY ${city}</h3>
<table border="1">
<tr>
<th>NAME</th>
<th>AGE</th>
<th>MARKS</th>
<th>CITY</th>
</tr>
<c:forEach var="student" items="${topStudents}">
<tr>
<td>${student.name}</td>
<td>${student.age}</td>
<td>${student.marks}</td>
<td>${student.city}</td>
</tr>
</c:forEach>

</table>
</center>
</body>
</html>