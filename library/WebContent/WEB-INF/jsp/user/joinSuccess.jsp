<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinSuccess</title>
</head>
<jsp:include page="../common/menu.jsp" />

<body>

	<div align="center">
		<h1>${vo.mName }님가입축하드립니다.</h1>
		<input type="button" onclick="location.href='main.do'" value="HOME">&nbsp;&nbsp;
		<input type="button" onclick="location.href='main.do'" value="로그인">
	</div>

</body>
</html>