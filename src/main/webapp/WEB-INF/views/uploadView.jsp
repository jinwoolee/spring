<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function makeInput(){

	$("form input[type='text']").remove();
	var count = $("#num").val()
	for(var i = 0; i <= count; i++){
		$("form").append("<input type='text' name='list[" + i + "].test' value='30'/>");
	}
}
function uploadFile(){
	makeInput();
	
	var form = $('form')[0];
    var formData = new FormData(form);
    formData.append("file", $("#file")[0].files[0]);
    
    $.ajax({
        url: '/member/upload',
                processData: false,
                contentType: false,
                data: formData,
                type: 'POST',
                success: function(result){
                    alert("업로드 성공!!");
                }
        });
}
</script>
</head>
<body>
	<input type="text" id="num" value="200"/>
	<form action="/member/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" id="file"/> <br>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>