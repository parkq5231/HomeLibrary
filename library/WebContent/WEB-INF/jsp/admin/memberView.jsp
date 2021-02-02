<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<style type="text/css">
td {
	text-align: center;
}
</style>
<script>
	function deleteAlert() {
		var yn = confirm("삭제하시겠습니까?");
		if (yn) {
			frm.action = "memberDelete.do";
			frm.submit();
		}
	}
	function updateAlert() {
		var yn = confirm("수정하시겠습니까?");
		if (yn) {
			frm.action = "memberUpdateForm.do";
			frm.submit();
		}
	}
</script>
<jsp:include page="../common/menu.jsp" />
</head>
<body>
	<div align="center">
		<div>
			<h1>맴버관리 상세페이지</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<input type="hidden" id="mId" name="mId" value="${vo.mId}">
			<div>
				<table border="1">
					<tr>
						<th width="100">아이디</th>
						<th width="100">이 름</th>
						<th width="100">패스워드</th>
						<th width="200">전화번호</th>
						<th width="100">주소</th>
						<th width="100">권한</th>
					</tr>
					<tr>
						<td width="100">${vo.mId}</td>
						<td width="100">${vo.mName}</td>
						<td width="100">${vo.mPassword}</td>
						<td width="100">${vo.mTel}</td>
						<td width="100">${vo.mAddress}</td>
						<td width="100">${vo.mAuth}</td>
					</tr>
				</table>
				<br>
			</div>
		</form>
		<div>
			<button type="button" onclick="updateAlert()">수 정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="deleteAlert()">삭 제</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='memberForm.do'">목록
			</button>
		</div>
	</div>
</body>
</html>