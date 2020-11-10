<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	//해당 html이 로딩이 완료 되었을 때 실행되는 이벤트 핸들러 함수
	$(document).ready(function() {
		//ajax call을 통해 1페이지에 해당하는 사용자 정보를 json으로 받는다
		//memberListAjax(1);
		memberListAjaxHTML(1);
		
		$("#memberList").on("click", "tr", function() {
			// data-userid
			var userid = $(this).data("userid");
			console.log("userid : " + userid);

			//document.location = "/member/member?userid=" + userid;
			document.location = "/member/memberAjaxPage?userid=" + userid;
		});

	});

	function memberListAjax(p){
		$.ajax({url :"/member/listAjax",
			data : {page : p, pageSize : 5},
			//data : "page=1&pageSize=5",
			//data : JSON.stringify({page : 1, pageSize : 5}),  
			//        Controller에서 @RequestBody    JSON  <---> JAVA OBJECT
			method : "get",
			success : function(data){
				var i =0;

				//memberList tbody영역에 들어갈 html 문자열 생성
				var html = "";
				for(var i = 0; i < data.memberList.length; i++){
					var member = data.memberList[i];

					html += "<tr data-userid='" + member.userid +"' >";
					html += "	<td>" + member.userid + "</td>";
					html += "	<td>" + member.usernm + "</td>";
					html += "	<td>" + member.alias + "</td>";
					html += "	<td>"+ member.fmt_reg_dt + "</td>";
					html += "</tr>"; 
				}

				$("#memberList").html(html);

				html = "";
				//페이지 내비게이션 html 문자열 동적으로 생성하기
				for(var i = 1; i <= data.pages; i++){
					if(i == data.pageVo.page){
						html += "<li class=\"active\"><span>"+ i +"</span></li>";
					}
					else{
							// <a href ="javascript:memberListAjax(1);"/>
						html += "<li><a href=\"javascript:memberListAjax(" + i + ");\">" + i + "</a></li>";	
					}
				}

				$("ul.pagination").html(html);
			}
	});
	}




	function memberListAjaxHTML(p){
		$.ajax({url :"/member/listAjaxHTML",
			data : {page : p, pageSize : 5},
			//data : "page=1&pageSize=5",
			//data : JSON.stringify({page : 1, pageSize : 5}),  
			//        Controller에서 @RequestBody    JSON  <---> JAVA OBJECT
			method : "get",
			success : function(data){
				var html = data.split("$$$SEPERRATOR$$$");
				$("#memberList").html(html[0]);
				$("ul.pagination").html(html[1]);
			}
		});
	}
</script>

<div class="row">
	tiles : memberListContent.jsp
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				<tbody id="memberList">
					
				</tbody>
			</table>
		</div>

		<a href="${cp }/member/regist" class="btn btn-default pull-right">사용자
			등록</a>
		<div class="text-center">
			<ul class="pagination">
			</ul>
		</div>
	</div>
</div>
