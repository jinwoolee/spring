<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="ro-RO">
<head profile="http://gmpg.org/xfn/11">
<title>Traffic Custom Error Pages</title>
<meta charset="utf-8"/>
<meta http-equiv="Content-Language" content="ro"/>
<meta name="robots" content="all,index,follow"/>
<meta name="keywords" content="mogoolab, templates, 404 error page"/>
<meta name="description" content="Traffic HTML Error Pages v 1.0 . Developed by MogooLab - www.mogoolab.com"/>
<meta name="publisher" content="mogoolab.com" />
<meta name="author" content="mogoolab.com" />
<meta http-equiv="X-UA-Compatible" content="IE=8">
<link href='http://fonts.googleapis.com/css?family=Istok+Web|Chivo|Lekton' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/error/404/js/impromptu/css.css" />
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/error/404/style.css" />


<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/error/404/js/impromptu/jquery-impromptu.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/error/404/js/jquery-global.js"></script>

</head>

<body>

<div class="wrapper">

	<div class="mainWrapper">
        <div class="mainHolder">
            <div class="message">페이지를 찾을수가 없어요....</div>
            <!-- end .message -->
            <div class="errorNumber">404</div> 
            <!-- end .errorNumber -->
            <!-- Search Form -->
            <!-- <div class="search">
            <form action="" method="post">
              <div class="searchInput">
                <input type="text" name="search_term" value="Search" />
              </div>
              <div class="searchButton">
                <input type="submit" name="submit" value="" />
              </div>
            
            </form>
            </div> -->
            <!-- end .search -->
            
            <div class="trafficLight">404 Error</div>
            
        </div>
        <!-- end .mainHolder -->
      
      
        
	</div>
     <!-- end .mainWrapper -->

</div>
<!-- end .wrapper -->


</body>
</html>