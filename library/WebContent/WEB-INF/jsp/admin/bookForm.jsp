<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맴버관리</title>
<style type="text/css">
td {
	text-align: center;
}
</style>
<script type="text/javascript">
	function bookInsertAlert() {
		frm.action = "bookInsertForm.do";
		frm.submit();

	}
	function bookView(str) {
		frm.bCode.value = str;
		frm.action = "bookView.do";
		frm.submit();
	}
</script>

</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>도서관리</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<input type="hidden" id="bCode" name="bCode">
			<div>
				<table border="1">
					<tr>
						<th width="100">도서코드</th>
						<th width="200">도서명</th>
						<th width="100">기본수량</th>
						<th width="100">현재수량</th>
					</tr>
					<c:if test="${empty list }">
						<tr>
							<th><h1>목록이 없습니다...</h1></th>
						</tr>
					</c:if>
					<c:if test="${not empty list }">
						<c:forEach var="vo" items="${list}">
							<tr class="row" onclick="bookView('${vo.bCode}')">
								<td width="100">${vo.bCode}</td>
								<td width="100">${vo.bName}</td>
								<td width="100">${vo.bQty}</td>
								<td width="100">${vo.bCount}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<br>
			</div>
		</form>
		<div>
			<button type="button" onclick="bookInsertAlert()">등록</button>
		</div>
	</div>
</body>
</html>