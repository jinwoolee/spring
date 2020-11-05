<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${cp }/multi/submit" method="post">
		<input type="text" name="userid" value="brown"/> <br>
		<input type="text" name="userid" value="sally"/> <br>
		<input type="text" name="userid" value="cony"/> <br>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>