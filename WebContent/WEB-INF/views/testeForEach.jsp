<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/testeForEach" var="linkTesteForEach"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<form action="${ linkTesteForEach }" method="post">

	<c:forEach var="i" begin="1" end="10" step="2">
       ${i} <br />
     </c:forEach>

</body>
</html>