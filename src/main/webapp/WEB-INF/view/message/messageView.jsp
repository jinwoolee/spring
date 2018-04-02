<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script>
$(function(){
	$("select[name=language]").val("${boardVo.language}");
});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="/message/messageView">

<%-- ${boardVo.userId } 가 존재할 경우 welcome 인사  --%>
<c:if test="${boardVo.userId != ''}">
	<spring:message code="welcome" arguments="${boardVo.userId }"/> <br/>
</c:if>


<spring:message code="userId" /> : <input type="text" name="userId" value="${boardVo.userId }"/> <br/>
<spring:message code="title"/>: <input type="text" name="title" value="${boardVo.title }"/>	<br/>
<spring:message code="cont"/> :<input type="text" name="cont" value="${boardVo.cont }"/>	<br/>
<spring:message code="language"/> : <select name="language" value="${boardVo.language }">	<br/>
		<c:forEach var="map" items="${languageMap}">
		<option value="${map.key }">${map.value }</option>
		</c:forEach>
	</select><br/>
<input type="submit" value="전송"/>	
</form>
	
	

</body>
</html>





