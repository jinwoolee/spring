<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="icon" href="../../favicon.ico"> -->

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/js.cookie-2.2.1.min.js"></script>
    
	<script>
	$(function(){
		//remember me cookie 확인
		if( Cookies.get("REMEMBERME") == "Y"){
			$("input[type=checkbox]").prop("checked", true);
			$("#inputEmail").val(Cookies.get("USERNM"));	
		}

		//sign in 버튼이 클릭 되었을 때 이벤트 핸들러
		$("button").on("click", function(){
			console.log("button_click");

			if($("input[type=checkbox]").prop("checked") == true){
				Cookies.set("REMEMBERME", "Y");
				Cookies.set("USERNM", $("#inputEmail").val());
			}
			else{
				Cookies.remove("REMEMBERME");
				Cookies.remove("USERNM");
			}

			//submit
			$("form").submit();
		});	
		
	});
		function getCookieValue(cookieName){
			
			var cookies = document.cookie.split("; ");
			for(var i = 0; i < cookies.length; i++){
				var cookie = cookies[i];
				var cookieArr = cookie.split("=");

				/*cookieArr[0]  cookie name
				cookieArr[1]  cookie value*/
				if(cookieName == cookieArr[0]){
					return cookieArr[1]; 
				}
			}
			
			//원하는 쿠키가 없는경우
			return "";
		}

		function setCookie(cookieName, cookieValue, expires){

			//"USERNM=brown; path=/; expires=Wed, 07 Oct 2020 00:38:35 GMT;"
			var today = new Date();

			//현재날짜에서 미래로 + expires 만큼 한 날짜 구하기
			today.setDate( today.getDate() + expires );
			
			document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
			console.log(document.cookie);
		}

		//해당쿠키의 expires속성을 과거날짜로 변경
		function deleteCookie(cookieName){
			setCookie(cookieName, "", -1);
		}
	</script>
  </head>

  <body>

    <div class="container">
		
      <form class="form-signin" action="${pageContext.request.contextPath }/login/process" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="userid" class="form-control" placeholder="Email address" required autofocus value="brown">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Password" required value="brownPass">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>
    