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
	function bookInsert() {
		var yn = confirm("등록하시겠습니까?");
		if (yn) {
			frm.action = "bookInsert.do";
			frm.submit();
		}

	}
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>도서관리-등록</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">도서코드</th>
						<th width="200">도서명</th>
						<th width="100">기본수량</th>
						<th width="100">현재수량</th>
					</tr>
					<tr>
						<td width="100"><input type="text" id="bCode" name="bCode" required="required"></td>
						<td width="100"><input type="text" id="bName" name="bName" required="required"></td>
						<td width="100"><input type="text" id="bQty" name="bQty" required="required"></td>
						<td width="100"><input type="text" id="bCount" name="bCount"
							required="required"></td>
				</table>
				<br>
			</div>
			<div>
				<button type="button" onclick="bookInsert()">등 록</button>
				&nbsp;&nbsp;
				<button type="button" onclick="location.href='bookForm.do'">목록</button>
			</div>
		</form>
	</div>
</body>
</html>