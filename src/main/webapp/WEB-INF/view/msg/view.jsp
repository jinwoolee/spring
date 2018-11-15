<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
hello : <spring:message code="hello"/><br>
visitor : <spring:message code="visitor" arguments="brown,sally"/><br>

<form action="/messageView" method="post">
<select name="lang">
	<option value="ko">한국어</option>
	<option value="ja">日本語</option>
	<option value="en">english</option>
</select>
<input type="submit" value="전송">
</form>

<c:set var="lang" value="${param.lang == null ? 'ko' : param.lang }"></c:set>

<script>
	console.log("lang : ${lang}");	
	document.getElementsByTagName("select")[0].value="${lang}";
</script>
</body>
</html>










