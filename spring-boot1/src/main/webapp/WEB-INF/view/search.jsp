<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="a" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a:form action="search" modelAttribute="x" method="POST">
Username:<a:input path="username"/><br>
Password:<a:input path="password"/>
<input type="submit">
</a:form>
<c:forEach items="${ls}" var="b">
${b.id }
${b.username }
${b.password }
<a href="editData.html?id=${b.id}">UPDATE</a>
<a href="deleteData.html?id=${b.id}">DELETE</a>
</c:forEach>
</body>
</html>