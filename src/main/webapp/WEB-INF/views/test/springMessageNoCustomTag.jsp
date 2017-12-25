<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script src="/js/jquery/jquery-1.12.4.js"></script>
<script>
$(document).ready(function(){
	$("#language").val("${language}");
	
	//language 선택시 페이지 재요청
	$("#language").on("change", function(){
		$("input[name=language]").val($(this).val());
		$("#frm").submit();
	});
});
</script>
</head>

<spring:htmlEscape defaultHtmlEscape="true"/>

<p>
	<label for="reg_id"><spring:message code="reg_id"/></label>
	<input type="text" name="reg_id" value="${boardVo.reg_id}"/>
</p>

<p>
	<label for="title"><spring:message code="title"/></label>
	<input type="text" name="title" value="${boardVo.title}"/>
</p>

<p>
	<label for="cont"><spring:message code="cont"/></label>
	<input type="text" name="cont" value="${boardVo.cont}" />
</p>




<form id="frm" method="post" action="/springMessageController/springMessageViewNoCtag">
<p><spring:message code="language"/>:
	<select id="language" name="language" >
		<c:forEach items="${countryMap}" var="vo">
			<c:set var="selected" value="${language == vo.key ? 'selected' : '' }"> </c:set>
			<option value="${vo.key}"  ${selected}>${vo.value}</option>
		</c:forEach>
	</select>	
	</p>
</form>

</body>
</html>