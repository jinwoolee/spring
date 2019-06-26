<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

<form action="/main/process" method="post">
	useIdList <input type="text" name="userIdList" value="brown"/><br>
	useIdList <input type="text" name="userIdList" value="sally"/><br><br>
	
	nameList <input type="text" name="nameList" value="브라운"/><br>
	nameList  <input type="text" name="nameList" value="샐리"/><br><br>
	
	addrVoList[0].addr1 <input type="text" name="addrVoList[0].addr1" value="대전시 중구"/><br>
	addrVoList[0].addr2 <input type="text" name="addrVoList[0].addr2" value="중앙로76"/><br>
	
	addrVoList[1].addr1 <input type="text" name="addrVoList[1].addr1" value="대전시 중구"/><br>
	addrVoList[1].addr2 <input type="text" name="addrVoList[1].addr2" value="중구청"/><br>
	<input type="submit" value="전송"/>
</form>
</body>
</html>