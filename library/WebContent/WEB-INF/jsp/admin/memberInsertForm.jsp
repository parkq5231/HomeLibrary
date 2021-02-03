<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<style type="text/css">
td {
	text-align: center;
}
</style>
<script>
	function memberInsert() {
		var yn = confirm("등록하시겠습니까?");
		if (yn) {
			frm.action = "memberInsert.do";
			frm.submit();
		}

	}
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>맴버관리-등록</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">아이디</th>
						<th width="100">이 름</th>
						<th width="100">패스워드</th>
						<th width="200">전화번호</th>
						<th width="100">주 소</th>
						<th width="100">권 한</th>
					</tr>
					<tr>
						<td width="100"><input type="text" id="mId" name="mId"
							required="required"></td>
						<td width="100"><input type="text" id="mName" name="mName"
							required="required"></td>
						<td width="100"><input type="password" id="mPassword"
							name="mPassword" required="required"></td>
						<td width="100"><input type="tel" id="mTel" name="mTel"
							required="required"></td>
						<td width="100"><input type="text" id="mAddress"
							name="mAddress" required="required"></td>
						<td width="100"><input type="text" id="mAuth" name="mAuth"
							required="required"></td>
				</table>
				<br>
			</div>
			<div>
				<button type="button" onclick="memberInsert()">등 록</button>
				&nbsp;&nbsp;
			</div>
		</form>
	</div>
</body>
</html>