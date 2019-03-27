<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery/jquery-1.12.4.js"></script>
<script>
$(document).ready(function() {
});
</script>
</head>
<body>
	<!-- name 속성에 명시한 커맨드 객체와 관련된 에러 정보를 errors 커스턴 태그에서 사용할 수 있도록 선언 -->
	<spring:hasBindErrors name="boardVo"/>
	
	<form id="frm" method="post" action="/initBinderValidatorController/initBinderValidatorResult">		<!-- 커맨드객체.필드 -->
		작성자 id : <input type="text" name="reg_id" value="${boardVo.reg_id}" /> <form:errors path="boardVo.reg_id"/> <br/>
		글 제목 : <input type="text" name="title" value="${boardVo.title}"/> <form:errors path="boardVo.title"/> <br/>
		글 내용 : <input type="text" name="cont" value="${boardVo.cont}"/> <form:errors path="boardVo.cont"/> <br/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>