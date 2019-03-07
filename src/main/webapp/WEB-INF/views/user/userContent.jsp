<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1 class="page-header">사용자 정보조회(tiles)</h1>

<form action="${cp }/user/userModifyForm" class="form-horizontal" role="form">
	
	<input type="hidden" name="userId" value="${userVo.userId }"/>
	
	
	<div class="form-group">
		<label for="userNm" class="col-sm-3 control-label">사진</label>
		<div class="col-sm-9">
			<img src="${cp }/user/profileImg?userId=${userVo.userId }">
<%-- 		<c:set var="pic" value="${userVo.filename}"/> --%>
<%-- 		<c:if test="${userVo.filename == null }"> --%>
<%-- 			<c:set var="pic" value="noimg.png"/> --%>
<%-- 		</c:if> --%>
<%-- 		<img src="${cp }/upload/${pic }"/> --%>
		</div>
	</div>
	
						
	<div class="form-group">
		<label for="userNm" class="col-sm-3 control-label">사용자 아이디</label>
		<div class="col-sm-9">
			<label class="control-label">${userVo.userId }</label>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-3 control-label">사용자 이름</label>
		<div class="col-sm-9">
			<label class="control-label">${userVo.userNm }</label>
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-3 control-label">별명</label>
		<div class="col-sm-9">
			<label class="control-label">${userVo.alias }</label>
		</div>
	</div>
	
	<div class="form-group">
		<label for="userNm" class="col-sm-3 control-label">주소1</label>
		<div class="col-sm-9">
			<label class="control-label">${userVo.addr1 }</label>
		</div>
	</div>
	
	<div class="form-group">
		<label for="userNm" class="col-sm-3 control-label">주소2</label>
		<div class="col-sm-9">
			<label class="control-label">${userVo.addr2 }</label>
		</div>
	</div>
	
	<div class="form-group">
		<label for="userNm" class="col-sm-3 control-label">우편번호</label>
		<div class="col-sm-9">
			<label class="control-label">${userVo.zipcode }</label>
		</div>
	</div>
	
	<div class="form-group">
		<label for="pass" class="col-sm-3 control-label">등록일자</label>
		<div class="col-sm-9">
			<label class="control-label">
				<fmt:formatDate value="${userVo.reg_dt }" pattern="yyyy-MM-dd"/>
			</label>
		</div>
	</div>					

	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-9">
			<button type="submit" class="btn btn-default">사용자 수정</button>
		</div>
	</div>
</form>

	<script>
		<c:if test="${msg != null }">
			alert("${msg}");
		</c:if>		
	</script>