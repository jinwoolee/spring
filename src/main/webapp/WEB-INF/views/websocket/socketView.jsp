<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script>
	webSocket = {
		init : function(oParam) {
			this._url = oParam.url || "";
			this._initSocket();
			this._initEvent();
		},
		_initSocket : function() {
			this._socket = new SockJS(this._url);
			this._socket.onmessage = function(evt) {
				$("#data").append(evt.data + "<br/>");
			};
			this._socket.onclose = function(evt) {
				$("#data").append("연결 끊김");
			}
		},
		_initEvent : function() {
			$("#sendBtn").on("click", (function() {
				var msg = $("#message").val();
				this._socket.send(msg);
			}).bind(this));
		}
	};

	$(document).ready(function() {
		var userId = "${param.userId}";
		userId = userId == "" ? "brown" : userId;
		
		$("#userId").text(userId);
				
		webSocket.init({
			url : "/ws/chat?userId="+userId
		});	

	});
</script>
</head>
<body>
	<h1 id="userId"></h1>
	
	<input type="text" id="message"/> <br>
	<button id="sendBtn">전송</button><br>
	
	<div id="data" style=" width:500px; height:500px; border:1px solid black;"></div>
</body>
</html>