<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
file 명 : ${fileNm }

<img src="/upload/${fileNm }" />
<h3> <a href="/hello/pictureDownload?fileNm=${fileNm }" >이미지 다운로드 </a> </h3>
 


</body>
</html>