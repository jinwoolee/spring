<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jquery ui css -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<!-- daum 주소 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- jquery ui api -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		//개발 과정에서 사용한 기본 값 설정

		//생일 input datepicker 적용
		$("#birth").datepicker({
			yearRange : "1997:2018",
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd"
		});

		//주소 검색 버튼 이벤트 핸들러
		$("#addrSearchBtn").click(function() {
			//주소 검색 버튼 클릭이벤트가 발생 했을때 실행
			new daum.Postcode({
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
					// 예제를 참고하여 다양한 활용법을 확인해 보세요.
					console.log(data);
					//주소 : roadAddress
					//상세주소 : ""
					//우편번호 : zonecode

					//주소 inpunt value 설정 : data.roadAddress
					//우편번호 input value 설정 : data.zonecode
					$("#addr1").val(data.roadAddress);
					$("#zipcd").val(data.zonecode);
				}
			}).open();
		});
	});
</script>

<form action="/user/userUpdate" method="post" class="form-horizontal"
	role="form" enctype="multipart/form-data">

	<%
		UserVo user = (UserVo) request.getAttribute("userVo");
	%>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<c:choose>
				<c:when test="${userVo.profile == null}">
					<img src="/profile/noimage.png">
				</c:when>
				<c:otherwise>
					<img src="${userVo.profile }">
				</c:otherwise>
			</c:choose>

			<input type="file" name="profilePic">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<input type="hidden" name="userId" value="${userVo.userId}">
			<label class="control-label">${userVo.userId}</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="pass" name="pass"
				placeholder="패스워드" value="">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="name" name="name"
				placeholder="이름" value="${userVo.name}">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="addr1" name="addr1"
				readonly placeholder="주소" value="${userVo.addr1}">
			<button id="addrSearchBtn" type="button" class="btn btn-default">주소검색</button>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="addr2" name="addr2"
				placeholder="상세주소" value="${userVo.addr2}">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="zipcd" name="zipcd"
				readonly placeholder="우편번호" value="${userVo.zipcd}">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">생년월일</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="birth" name="birth"
				placeholder="생년월일" value="${userVo.formattedBirth}">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">이메일</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="email" name="email"
				placeholder="이메일" value="${userVo.email}">
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">연락처</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="tel" name="tel"
				placeholder="연락처" value="${userVo.tel}">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">사용자 수정</button>
		</div>
	</div>
</form>
