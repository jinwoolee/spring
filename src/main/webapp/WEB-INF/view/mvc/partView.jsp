<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/hello/uploadPicture" enctype="multipart/form-data">
아이디 : <input type="text" name="userId" value="brown"/> <br/>
사진: <input type="file" name="picture" /> <br/>
<input type="submit" value="전송"/>
</form>
</body>
</html>