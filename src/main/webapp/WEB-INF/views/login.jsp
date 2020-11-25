<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/login" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		userid : <input type="text" name="userid" value="brown"/> <br> 
		pass : <input type="password" name="pass" value="12345"/> <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>