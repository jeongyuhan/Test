<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	
	<h1>회원 관리 프로그램</h1>
	<form action="login.do" method="post">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="text" name="name" placeholder="이름"><br>
		<button>로그인</button>
		<a href="joinPage.do">회원가입</a>
	</form>
	
</body>
</html>