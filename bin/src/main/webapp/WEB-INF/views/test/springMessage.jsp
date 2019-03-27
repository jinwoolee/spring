<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script src="/js/jquery/jquery-1.12.4.js"></script>
<script>
$(document).ready(function(){
	
	//language 선택시 페이지 재요청
	$("#language").on("change", function(){
		//$("#language").val($(this).val());
		$("#frm").submit();
	});
});
</script>
</head>

<spring:htmlEscape defaultHtmlEscape="true"/>

<form:form id="frm" commandName="boardVo" method="post" action="/springMessageController/springMessageView">

<p>
	<form:label path="reg_id"><spring:message code="reg_id"/></form:label>
	<form:input path="reg_id" />
	<form:errors path="reg_id" />
</p>

<p>
	<form:label path="title"><spring:message code="title"/></form:label>
	<form:input path="title" />
	<form:errors path="title" />
</p>

<p>
	<form:label path="cont"><spring:message code="cont"/></form:label>
	<form:input path="cont" />
	<form:errors path="cont" />
</p>
<p>
	<form:label path="language"><spring:message code="language"/></form:label>
	<form:select path="language">
		<c:forEach items="${countryMap}" var="vo">
			<c:set var="selected" value="${language == vo.key ? 'selected' : '' }"> </c:set>
			<option value="${vo.key}"  ${selected}>${vo.value}</option>
		</c:forEach>
	</form:select>	
</p>
</form:form>

</body>
</html>