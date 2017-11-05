<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery/jquery-1.12.4.js"></script>
<script>
$(document).ready(function() {
	var form = { userId : "brown", amount : "600", birthDay : "2017-11-01" };
	$("#jsonString").html(JSON.stringify(form));
	
	
	
	//send 버튼 클릭 이벤트
	$("#send").on("click", function() {
		$.ajax({
			url : "/requestBodyController/requestBody.do",
			method : "post",
			dataType: "json",
			contentType: "application/json; charset=UTF-8",
			//data : $("#frm").serialize(),
			//data : { userId : "brown", amonut : "600", birthDay : "2017-11-01" },           
			data : JSON.stringify(form),
			success : function(data) {
				console.log("userId : " + data.userId);
				console.log("amount : " + data.amount);
				console.log("birthDay : " + data.birthDay);
				$("#resultJsonString").html(JSON.stringify(data));
			}
		});
	});
});
</script>
</head>
<body>
	send jsonString : <span id="jsonString"></span><br/>
	
	<button id="send">json 전송</button><br/>
	
	result jsonString : <span id="resultJsonString"></span>
	
	<br/><br/><br/><br/>
	
	<!-- form 전송은 안된다.  -->
	<form id="frm" method="post" action="/requestBodyController/requestStringBody.do">
		<input type="text" name="userId" value="brown"/>
		<input type="text" name="600" value="amount"/>
		<input type="text" name="2017-11-01" value="birthDay"/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>