<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<spring:hasBindErrors name="jsr303BoardVo"/>

<form method="post" action="/validator/jsr303ValidatorResult">
제목		<input type="text" name="title" value="${boardVo.title}"/> <form:errors path="jsr303BoardVo.title"/> <br/> <!-- 제목 미입력시 -->
내용		<input type="text" name="cont" value="${boardVo.cont}"/> <form:errors path="jsr303BoardVo.cont"/> <br/>	<!-- 내용 미입력시 -->
등록자	<input type="text" name="userId" value="${boardVo.userId}"/> <form:errors path="jsr303BoardVo.userId"/> <br/> <!-- 사용자 미입력시 -->
<input type="submit" value="전송"/>
</form>
</body>
</html>









