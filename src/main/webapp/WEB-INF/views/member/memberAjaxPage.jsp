<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	$(document).ready(function() {
		//clinet side에서는 서버사이드 변수나 값을 사용가능
		memberAjax("${param.userid}");
		
		$("#modifyBtn").on("click", function() {
			document.location = "/member/update?userid=${memberVo.userid}";
		});

		$("#profileDownBtn").on("click", function() {
			document.location = "/profileDownload?userid=${memberVo.userid}";
		});
	});

	function memberAjax(userid){
		$.ajax({url: "/member/memberAjax",
				//data : {userid : userid},
				data : "userid="+ userid,
				method : "get",
				success : function(data){
					var member = data.memberVo;

					$("#profile").attr("src", "${cp }/profileImg?userid=" + userid);
					$("#profileDownBtn").html(member.realFilename);
					$("#userid").html(member.userid);
					$("#usernm").html(member.usernm);
					$("#alias").html(member.alias);
					$("#addr1").html(member.addr1);
					$("#addr2").html(member.addr2);
					$("#zipcode").html(member.zipcode);
					$("#reg_dt").html(member.fmt_reg_dt);
				}
		});
	}
</script>

ajax
<form class="form-horizontal" role="form">

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<%--<img src="${cp }/profile/${memberVo.filename}"/> --%>

			<img id="profile" /><br>
			<button id="profileDownBtn" type="button" class="btn btn-default">다운로드:</button>
		</div>
	</div>

	<div class="form-group">
		<label for="userid" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<label class="control-label" id="userid"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
		<div class="col-sm-10">
			<label class="control-label" id="usernm"></label>
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">별명</label>
		<div class="col-sm-10">
			<label class="control-label" id="alias"></label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<label class="control-label">********</label>
		</div>
	</div>



	<div class="form-group">
		<label for="addr1" class="col-sm-2 control-label">주소</label>
		<div class="col-sm-10">
			<label class="control-label" id="addr1"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="addr2" class="col-sm-2 control-label">상세주소</label>
		<div class="col-sm-10">
			<label class="control-label" id="addr2"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
		<div class="col-sm-10">
			<label class="control-label" id="zipcode"></label>
		</div>
	</div>

	<div class="form-group">
		<label for="reg_dt" class="col-sm-2 control-label">등록일자</label>
		<div class="col-sm-10">
			<label class="control-label" id="reg_dt"></label>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="modifyBtn" type="button" class="btn btn-default">사용자
				수정</button>
		</div>
	</div>
</form>
