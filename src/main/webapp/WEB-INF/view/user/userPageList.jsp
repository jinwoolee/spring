<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.userClick {
	cursor: pointer;
}
</style>

<script>
$(document).ready(function() {
	console.log("document.ready");

	//tr에 select (class="userClick")
	//#userList => tbody id
	$("#userList").on("click", ".userClick", function() {
		console.log("userClick");
		var userId = $(this).children()[1].innerHTML;

		$("#userId").val(userId);
		$("#frm").submit();
	});
	
	//getUserList(1);
	getUserListHtml(1);				//userList html로 리턴해주는 함수
	
	
	//getUserPageationHtml(1); --> getUserPagiationHtml(1);
	
	
			
});


function getUserListHtml(page){
	var pageSize = 10;
	
	
	//parameter --> json
	$.ajax({
		url : "/user/userPageListAjaxHtml",
		type : "post",
		data : "page="+page+"&pageSize="+pageSize,
		success : function(dt){
			$("#userList").html(dt);
			getUserPaginationHtml(1);		//해당페이지의 페이지 네이션 정보를 리턴해주는 함수
		}
	});
}

function getUserPaginationHtml(page){
	var pageSize = 10;
	
	$.ajax({
		url : "/user/userPaginationAjaxHtml",
		type : "post",
		data : "page="+page+"&pageSize="+pageSize,
		success : function(dt){
			$(".pagination").html(dt);
		}
	});
}


//page인자를 받아서
//해당페이지에 속하는 사용자 리스트 정보를 가져온다
function getUserList(page){
	var pageSize = 10;
	console.log("page : " + page);
	
	//ajax call
	//사용자 리스트 데이터만 가져오기
	//html(as-is) --> json(to-be) 데이터를 받는 형태로 변경
	
	$.ajax({
		type : "GET",
		url : "/user/userPageListAjax",
		data : "page="+page+"&pageSize="+pageSize,
			   //page=1&pageSize=10
		success : function(data){
			//data.userList 10건, data.pageCnt=13
			//data(사용자 json 데이터)를 바탕으로
			//사용자 리스트를 갱신
			//1.기존 리스트를 삭제
			//2.data를 이용하여 table 태그(tr)를 작성
			//3.기존 리스트 위치에다가 붙여넣기
		
			console.log(data);
			var html = "";
			$.each(data.userList, function(idx, user){
				console.log(user);
				html += "<tr class='userClick'>";
				html += "	<td>" + user.rnum + "</td>";
				html += "	<td>" + user.userId + "</td>";
				html += "	<td>" + user.name + "</td>";
				html += "	<td>" + user.formattedBirth + "</td>";
				html += "</tr>";
			});
			
			$("#userList").html("");
			$("#userList").html(html);
			
			
			
			var paginationHtml = "";
			paginationHtml +="<li><a href='javascript:getUserList(1);' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>";
				
			
			for(var i = 1; i <= data.pageCnt; i++){	
				paginationHtml +="<li><a href='javascript:getUserList(" + i + ");'>" + i + "</a></li>";
			}

			paginationHtml +="<li><a href='javascript:getUserList("+data.pageCnt +");' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li>";
			
			$(".pagination").html(paginationHtml);
			
			
			//data.userList
			
// 			<tr class="userClick">
// 			<td>${vo.rnum}</td>
// 			<td>${vo.userId}</td>
// 			<td>${vo.name}</td>
// 			<td><fmt:formatDate value="${vo.birth }" pattern="yyyy-MM-dd" /></td>
// 		</tr>
		}
	});
	
	
}
</script>


<form id="frm" action="/user/userDetail" method="get">
	<input type="hidden" id="userId" name="userId" />
</form>




<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>사용자 아이디</th>
						<th>사용자 이름</th>
						<th>생일</th>
					</tr>
				</thead>
				
				<tbody id="userList">
				</tbody>


			</table>
		</div>

		<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
			</ul>
		</div>
	</div>
</div>





