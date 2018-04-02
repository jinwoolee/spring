<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery-3.2.1.js" type="text/javascript"></script>
<script>
$(function(){
	console.log("test");
	var jsonData = {"userId" : "brown", "userNm" : "brown", "userAlias" : "brownAs"};
	$("#jsonData").html(JSON.stringify(jsonData));
	
	
	//전송버튼 클릭
	/* json 응답 보내고 json / xml 응답결과 리턴 */
	$("#jsonSubmit, #xmlSubmit").on("click", function(){
		console.log(JSON.stringify(jsonData));
		
		var btnId = $(this).attr("id");
		var dataType = "";

		if(btnId == "jsonSubmit")
			dataType = "json";
		else if(btnId == "xmlSubmit")
			dataType = "xml";

		else
			return false;
		
		jQuery.ajax({
			url : "/ajax/requestJson",
			type : "post",
			dataType : dataType,		//json / xml
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(jsonData),
			success : function(data){
				if(btnId == "jsonSubmit"){
					$("#responseData").html("");
					$("#responseData").html(JSON.stringify(data));
				}
				else if(btnId == "xmlSubmit"){
					console.log(data);
				}
			}
		});	
	});
});


</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
요청 json 데이타 : <span id="jsonData"></span>
<button id="jsonSubmit">json결과받기</button>
<button id="xmlSubmit">xml결과받기</button> <br/>

응답 데이타 : <span id="responseData"></span> <br/>

</body>
</html>





