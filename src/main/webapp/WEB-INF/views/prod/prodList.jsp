<%@page import="kr.or.ddit.prod.model.ProdVo"%>
<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="java.util.List"%>
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
<link rel="icon" href="../../favicon.ico">

<title>Dashboard Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link href="${cp}/css/dashboard.css"
	rel="stylesheet">
</head>

<body>

	<%@ include file="/WEB-INF/views/module/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/WEB-INF/views/module/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">제품 리스트</h1>
				
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>제품 아이디</th>
								<th>제품명</th>
								<th>바이어 아이디</th>								
								<th>제품 가격</th>
							</tr>
						</thead>
						<tbody>
							<% 	List<ProdVo> prodList = 
										(List<ProdVo>)request.getAttribute("prodList");
								for(ProdVo vo : prodList){ %>
									<tr>
										<td><%=vo.getProd_id() %></td>
										<td><%=vo.getProd_name() %></td>
										<td><%=vo.getProd_buyer() %></td>	
										<td><%=vo.getProd_cost() %></td>
									</tr>
							<%} %>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		
	<script>
		//문서로딩이 완료된 이후 이벤트 등록
		$(document).ready(function(){
			console.log("document ready");
			
			//사용자 tr 태그 클릭시 이벤트 핸들러
			$(".userTr").on("click", function(){
				console.log("userTr click");
				//클릭한 userTr태그의 userId 값을 출력
// 				var userId = $(this).children()[1].innerText;
// 				console.log("userId : " + userId);

				var userId = $(this).data("userid");
				
				// /user
				// 1. docuemnt
				//document.location = "/user?userId=" + userId;
				
				// 2. form
				$("#userId").val(userId);
				//$("#frm").attr("action", "/userAllList");
				$("#frm").submit();
			});
		});
	</script>	

<form id="frm" 
	  action="${cp}/user" method="get">
	<input type="hidden" id="userId" name="userId"/>
</form>

</body>
</html>








