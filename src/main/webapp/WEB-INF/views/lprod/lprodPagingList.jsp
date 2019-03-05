<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="${cp }/css/dashboard.css"
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
				<h1 class="page-header">전체 제품 카테고리 리스트</h1>

				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>카테고리 아이디</th>
								<th>카테고리</th>
								<th>카테고리명</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lprodList }" var="lprod">
								<tr class="lprodTr" data-lgu="${lprod.lprod_gu}">
									<td>${lprod.lprod_id}</td>
									<td>${lprod.lprod_gu}</td>
									<td>${lprod.lprod_nm}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<c:set var="lastPage"
						value="${Integer(totalCnt/pageSize + (totalCnt%pageSize > 0 ? 1 : 0)) }" />

					<nav style="text-align: center;">
						<ul class="pagination">
							<c:choose>
								<c:when test="${page == 1 }">
									<li class="disabled"><a aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="${cp }/lprodPagingList" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
								</c:otherwise>
							</c:choose>
							
							
							<c:forEach begin="1" end="${lastPage }" var="i">
								<c:set var="active" value=""/>
								<c:if test="${i == page }">
									<c:set var="active" value="active"/>
								</c:if>
								
								<li class="${active }">
									<a href="${cp }/lprodPagingList?page=${i }">${i }</a>
								</li>
								
							</c:forEach>
							
							
							<%--여기서부터 --%>
							<c:choose>
								<c:when test="${page == lastPage }">
									<li class="disabled">
										<a aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="${cp }/lprodPagingList?page=${lastPage}"
											aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</nav>
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
		$(document).ready(function() {
			console.log("document ready");

			//제품 카테고리 tr 태그 클릭시 이벤트 핸들러
			$(".lprodTr").on("click", function() {

				var lgu = $(this).data("lgu");

				// /user
				// 1. docuemnt
				document.location = "/prodList?lgu=" + lgu;

			});
		});
	</script>


</body>
</html>








