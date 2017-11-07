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
	$("#language").on("change", function(){
		console.log($(this).val());
	});
});
</script>
</head>

<form:form commandName="boardVo">

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
</form:form>

<p>
<select id="language" name="language">
	<c:forEach items="${countryMap}" var="vo">
		<option value="${vo.key}">${vo.value}</option>
	</c:forEach>
</select>	
</p>


<spring:message code="NotEmpty.jsr303BoardVo.reg_id"/>

</body>
</html>