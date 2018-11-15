<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <%@include file="/WEB-INF/view/common/basicLib.jsp" %>
    <script>
    	$(document).ready(function(){
    		console.log("test");
    		//remember 쿠키값이 Y이면
    		if(getCookie("remember") == "Y"){
    			//remember-me 체크박스 체크
        		//userId input value를 userId 쿠키 값으로 설정
        		$("#remember-me").attr("checked", true);
        		$("#userId").val(getCookie("userId"));
    		}
    		
    	});	
    
    	function getCookie(cookieName){
    		//cookieString --> document.cookie
    		var cookies = document.cookie.split("; ");
    		
    		var cookieValue = "";
    		//for(String str : cookies){
    		for(var i = 0; i < cookies.length; i++){
    			var str = cookies[i];
    			if(str.startsWith(cookieName + "="))
    				cookieValue = str.substring((cookieName + "=").length);
    		}
    		return cookieValue;
    	}
    </script>
  </head>

  <body>

    <div class="container">

      <form action="/user/loginProcess" method="post" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="userId" name="userId" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Password" required value="brownpass">
        <div class="checkbox">
          <label>
            <input type="checkbox" id="remember-me" name="remember-me" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>
    
    
    
    
    
    
    