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
	function memberView(str) {
		document.frm.mId.value = str;
		frm.action = "memberView.do";
		frm.submit();

	}
</script>

</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>맴버관리</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<input type="hidden" id="mId" name="mId">
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
					<c:if test="${empty list }">
						<tr>
							<th><h1>목록이 없습니다...</h1></th>
						</tr>
					</c:if>
					<c:if test="${not empty list }">
						<c:forEach var="vo" items="${list}">
							<tr class="row" onclick="memberView('${vo.mId}')">
								<td width="100">${vo.mId}</td>
								<td width="100">${vo.mName}</td>
								<td width="100">${vo.mPassword}</td>
								<td width="100">${vo.mTel}</td>
								<td width="100">${vo.mAddress}</td>
								<td width="100">${vo.mAuth}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<br>
			</div>
		</form>
		<div>
			<button type="button">등록</button>
		</div>
	</div>
</body>
</html>