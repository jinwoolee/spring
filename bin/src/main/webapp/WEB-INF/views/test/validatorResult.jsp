<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
	작성자 id : ${boardVo.reg_id}
	글 제목 : ${boardVo.title}
	글 내용 : ${boardVo.cont}
</body>
</html>