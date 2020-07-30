<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8" />
    	<jsp:include page="/WEB-INF/script.jsp" />
    	</head>
	<title>レストラン予約システム</title>
<body class="text-center">
<jsp:include page="/WEB-INF/header.jsp" />

	<h1>Login</h1>
	<form method="post" action="/restaurantapp/LoginAdminController">
		<lable>ユーザーID</lable>
		<input name="user_id" type="text" /><br />
		<br />
		<lable>パスワード</lable>
		<input name="password" type="password" /><br />
		<br />
		<button class="btn btn-primary" type="submit">ログイン</button>
	</form>

</body>
</html>