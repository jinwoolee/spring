<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fileupload view</h2>
	<form action="/mvc/fileupload" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile"> <br>
		<input type="text" name="userId" value="brown"> <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>