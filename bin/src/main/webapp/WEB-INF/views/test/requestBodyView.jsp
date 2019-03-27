<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery/jquery-1.12.4.js"></script>
<script>
$(document).ready(function() {
	//var form = { userId : "brown", amount : "600", birthDay : "2017-11-01" };
	var form = { "userId" : "brown", "amount" : "600", "birthDay" : "2017-11-01" };
	$("#jsonString").html(JSON.stringify(form));
	
	//send 버튼 클릭 이벤트
	$("#getJson, #getXml").on("click", function() {
		var dataType = $(this).attr("id") == "getJson" ? "json" : "xml";
		var callback = $(this).attr("id") == "getJson" ? jsonCallback : xmlCallback;
		
		console.log(dataType);
		console.log(callback);
		
		$.ajax({
			url : "/requestBodyController/requestBody.do",
			method : "post",			
			data : JSON.stringify(form),						//server로 전송하려는 데이터
			contentType: "application/json; charset=UTF-8",		//server로 보내는 mediatype
			dataType: dataType,									//server로 부터 받으려는 데이터 타입
			success : function(data) {
				callbackFunction(callback, data);		
			}
		});
	});
	
});

function callbackFunction(callback, data){
	callback(data);
}
function jsonCallback(data){
	$("#resultJsonString").html(JSON.stringify(data));
}

function xmlCallback(data){
	console.log(data.getElementsByTagName("testVo")[0]);
	$("#resultJsonString").html(data.getElementsByTagName("testVo")[0]);
}

</script>
</head>
<body>
	send jsonString : <span id="jsonString"></span><br/>
	
	<button id="getXml">xml return</button> &nbsp; <button id="getJson">json return</button><br/>
	
	result jsonString : <span id="resultJsonString"></span>
	
	<br/><br/><br/><br/>
	
	<!-- form 전송은 안된다.  -->
	<form id="frm" method="post" action="/requestBodyController/requestStringBody.do">
		<input type="text" name="userId" value="brown"/>
		<input type="text" name="600" value="amount"/>
		<input type="text" name="2017-11-01" value="birthDay"/>
		<input type="submit" value="form 전송"/> <br/>
	</form>
</body>
</html>