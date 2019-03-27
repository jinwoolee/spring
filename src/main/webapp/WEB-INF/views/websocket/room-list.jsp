<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>채팅방 목록</h1>
	<ul>
		<c:forEach items="${rooms}" var="room">
		
		<li><a href="/chat/rooms/${room.id}">${room.name}</a></li>
		</c:forEach>
	</ul>
</body>
</html>