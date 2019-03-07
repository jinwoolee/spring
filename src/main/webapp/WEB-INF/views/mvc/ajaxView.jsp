<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td {
		border : 1px solid black;
	}
</style>
<script src="${cp }/js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	console.log("ajaxView.jsp");
	
	//jsonData요청
	$("#jsonReqBtn").on("click", function(){
		//jsonView();
		//responseBody();
		requestBody();
	});
});

function requestBody(){
	var data = { userId : "brown", userNm : "브라운"};
	
	$.ajax({
		url : "${cp}/ajax/requestBody",
		method : "post",
		//data : "userId=brown&userNm=브라운",
		//data : $("#frm").serialize(),
		data : JSON.stringify(data),	//data를 json 문자열로 전송한다
		dataType : "json",		//server에게 희망하는 리턴타입을 명시
		contentType : "application/json; charset=utf-8",//client 전송하는 데이터 타입
		success : function(data){
			
			$("#jsonRecvTbody").html("<tr><td>" + data.userId + "</td></tr>");
			
			/*var html ="";
			for(var i = 0; i < data.length; i++ ){
				var ranger = data[i];
				html += "<tr><td>" + ranger + "</td></tr>";
			}
			
			$("#jsonRecvTbody").html(html);*/
		}
	});
}

function responseBody(){
	$.ajax({
		url : "${cp}/ajax/responseBody",
		method : "post",
		dataType : "json",		//server에게 희망하는 리턴타입을 명시
		success : function(data){
			var html ="";
			for(var i = 0; i < data.length; i++ ){
				var ranger = data[i];
				html += "<tr><td>" + ranger + "</td></tr>";
			}
			
			$("#jsonRecvTbody").html(html);
		}
	});
}

function jsonView(){
	$.ajax({
		url : "${cp}/ajax/jsonView",
		method : "post",
		success : function(data){
			var html ="";
			for(var i = 0; i < data.rangerList.length; i++ ){
				var ranger = data.rangerList[i];
				html += "<tr><td>" + ranger + "</td></tr>";
			}
			
			$("#jsonRecvTbody").html(html);
		}
	});
}
</script>
</head>
<body>
	<form id="frm">
		<input type="text" name="userId" value="brown"/>
		<input type="text" name="userNm" value="브라운"/>
	</form>
	
	<h2>ajaxView.jsp</h2>
	<h3>json 수신</h3>
	<div>
		<button id="jsonReqBtn">jsonData요청</button>
		<div id="jsonRecv">
			<table>
				<thead>
					<tr>
						<th>이름</th>
					</tr>
				</thead>
				<tbody id="jsonRecvTbody">
<!-- 					<tr> -->
<!-- 						<td>brown</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>cony</td> -->
<!-- 					</tr>	 -->
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>












