<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<h2>${mId}님 다시 접속해주세요..</h2><br>
		<button onclick="location.href='loginForm.do'">로그인</button>
	</div>
</body>
</html>