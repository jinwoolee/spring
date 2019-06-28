<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.userTr:hover {
	cursor: pointer;
}
</style>

<script>
	$(document).ready(function() {
		//사용자 tr 태그 이벤트 등록
		$(".userTr").on("click", function() {
			console.log("userTr click");
			//userId를 획득하는 방법
			//$(this).find(".userId").text();
			//$(this).data("userid");

			//사용자 아이디를 #userId 값으로 설정해주고
			var userId = $(this).find(".userId").text();
			$("#userId").val(userId);

			//#frm 을 이용하여 submit();
			$("#frm").submit();
		});
	});
</script>


<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자 (tiles)</h2>

		<!-- 사용자 상세조회 : userId가 필요 -->
		<form id="frm" action="${cp }/user/user" method="get">
			<input type="hidden" id="userId" name="userId" />
		</form>

		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>

				<!-- 향상된 for -->
				<c:forEach items="${userList }" var="vo" varStatus="status">
					<tr class="userTr" data-userid="${vo.userId }">
						<td class="userId">${vo.userId }</td>
						<td>${vo.name }</td>
						<td>${vo.alias }</td>
						<td></td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<a href="${cp }/user/form" class="btn btn-default pull-right">사용자
			등록</a> <a href="${cp }/user/userListExcel?filename=userList"
			class="btn btn-default pull-right">엑셀 다운</a>

		<!-- 사용자수 : 105건
							 페이지네이션 : 11건
						 -->
		<div class="text-center">
			<ul class="pagination">
				<c:choose>
					<c:when test="${pageVo.page == 1 }">
						<li class="disabled"><span>«</span></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="${cp}/user/pagingList?page=${pageVo.page - 1}&pageSize=${pageVo.pageSize}">«</a>
						</li>
					</c:otherwise>
				</c:choose>

				<c:forEach begin="1" end="${paginationSize }" var="i">
					<c:choose>
						<c:when test="${pageVo.page == i }">
							<li class="active"><span>${i }</span></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${cp}/user/pagingList?page=${i }&pageSize=${pageVo.pageSize}">${i }</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${pageVo.page == paginationSize}">
						<li class="disabled"><span>»</span></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="${cp}/user/pagingList?page=${pageVo.page+1}&pageSize=${pageVo.pageSize}">»</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>