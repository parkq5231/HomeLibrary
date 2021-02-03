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
	function idCheck() {
		var url = "idCheck.do?id=" + frm.mId.value;
		if (!frm.mId.value) {
			alert("아이디를 입력하세요.");
			frm.mId.focus();
		} else {
			window.open(url, "아이디중복체크", "width=400, height=350");
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
						<th width="50">아이디</th>
						<td width="50"><input type="text" id="mId" name="mId"
							size="13" required="required"> <input type="button"
							value="중복" onclick="return idCheck()"></td>
					</tr>
					<tr>
						<th width="50">이 름</th>
						<td width="50"><input type="text" id="mName" name="mName"
							size="20" required="required"></td>
					</tr>
					<tr>
						<th width="50">패스워드</th>
						<td width="50"><input type="password" id="mPassword"
							size="20" name="mPassword" required="required"></td>
					</tr>
					<tr>
						<th width="100">전화번호</th>
						<td width="100"><input type="tel" id="mTel" name="mTel"
							size="20" required="required"></td>
					<tr>
						<th width="50">주 소</th>
						<td width="50"><input type="text" id="mAddress" size="20"
							name="mAddress" required="required"></td>
					<tr>
						<th width="50">권 한</th>
						<td width="50"><input type="text" id="mAuth" name="mAuth"
							size="20" required="required"></td>
					</tr>
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