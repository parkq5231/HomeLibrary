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
	function updateAlert() {
		var yn = confirm("수정하시겠습니까?");
		if (yn) {
			frm.action = "bookUpdate.do";
			frm.submit();
		}
	}
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>도서수정</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<input type="hidden" id="bCode" name="bCode" value="${vo.bCode }">
			<div>
				<table border="1">
					<tr>
						<th width="100">도서코드</th>
						<th width="200">도서명</th>
						<th width="100">기본수량</th>
						<th width="100">현재수량</th>
					</tr>
					<c:if test="${empty vo}">
						<tr>
							<th><h1>목록이 없습니다...</h1></th>
						</tr>
					</c:if>
					<c:if test="${not empty vo }">
						<tr>
							<td width="100">${vo.bCode}</td>
							<td width="100">${vo.bName}</td>
							<td width="100"><input type="text" id="bQty" name="bQty"
								value="${vo.bQty}"></td>
							<td width="100"><input type="text" id="bCount" name="bCount"
								value="${vo.bCount}"></td>
						</tr>
					</c:if>
				</table>
				<br>
			</div>
			<div>
				<button type="button" onclick="updateAlert()">수 정</button>
			</div>
		</form>
	</div>
</body>
</html>