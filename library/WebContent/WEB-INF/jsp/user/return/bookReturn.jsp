<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 반납 Form</title>

<style>
tr {
	cursor: pointer
}

td {
	text-align: center;
}
</style>

<script>
	function returnAlert(str) {
		var msg = confirm("해당 도서를 반납하시겠습니까?");
		if (msg) {
			frm.bCode.value = str;
			frm.action = "bookReturnUpdate.do";
			frm.submit();
		}
	}
</script>
</head>
<body>

	<jsp:include page="../../common/menu.jsp" />

	<div align="center">
		<div>
			<h1>반납 예정 도서 목록</h1>
		</div>
		<div>
			<form id="frm" name="frm " method="post">
				<input type="hidden" id="bCode" name="bCode" value="${vo.bCode }">
				<table border="1">

					<tr>
						<th width="100">회원아이디</th>
						<th width="100">도서코드</th>
						<th width="100">대여일자</th>
						<th width="100">반납일자</th>
					</tr>

					<c:forEach var="vo" items="${list }">
						<c:if test="${mId eq vo.mId}">
							<tr class="row" onclick="returnAlert('${vo.bCode}')">
								<td width="100">${vo.mId }</td>
								<td width="100">${vo.bCode }</td>
								<td width="100">${vo.rentalDate }</td>
								<td width="100">${vo.returnDate }</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				<p />
				<button type="button" onclick="location.href='main.do'">HOME</button>

			</form>
		</div>
	</div>

</body>
</html>