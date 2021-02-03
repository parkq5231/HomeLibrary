<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Page</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a, .dropbtn {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
	background-color: red;
}

li.dropdown {
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #f1f1f1;
}

.dropdown:hover .dropdown-content {
	display: block;
}

/* 로그인 멤버 알림 글자 깜박임 */
.blink {
	animation: blinker 2s linear infinite;
}

@
keyframes blinker { 50% {
	opacity: 0;
}
}
</style>
</head>
<body>
	<div align="center">
		<h1>도서 대여 관리</h1>
	</div>
	<ul>
		<li><a href="main.do">Home</a></li>
		<c:if test="${not empty mId and mAuth =='USER' }">
			<li class="dropdown"><a href="javascript:void(0)"
				class="dropbtn">마이 페이지</a>
				<div class="dropdown-content">
					<a href="bookRental.do">도서 대여</a> <a href="bookReturn.do">도서 반납</a>
				</div></li>
		</c:if>
		<c:if test="${not empty mId and mAuth =='ADMIN' }">
			<li class="dropdown"><a href="javascript:void(0)"
				class="dropbtn">관리자</a>
				<div class="dropdown-content">
					<a href="memberForm.do">맴버관리</a> <a href="bookForm.do">도서관리</a>
				</div></li>
		</c:if>
		<c:if test="${empty mId }">
			<li><a href="loginForm.do">Login</a></li>
		</c:if>
		<c:if test="${not empty mId }">
			<li><a href="logout.do">Logout</a></li>
		</c:if>
	</ul>

	<!-- 로그인 멤버 알림 -->
	<c:if test="${not empty mId }">
		<div align="right">
			<h4 class="blink" style="padding-right: 20px">${mId }님 접속을 환영합니다.</h4>
		</div>
	</c:if>

</body>
</html>