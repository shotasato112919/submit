<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	String name = (String)session.getAttribute("bookingName");
	String date = (String)session.getAttribute("bookingDate");
	String time = (String)session.getAttribute("bookingTime");
	Integer num = (Integer)session.getAttribute("bookingNum");
%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8" />
    	<jsp:include page="/WEB-INF/script.jsp" />
    	</head>
	<title>レストラン予約システム</title>
<body class="text-center">
<jsp:include page="/WEB-INF/header.jsp" />

	<h1>予約確認</h1>
	以下の内容で予約します。よろしいですか？
	<form action="/restaurantapp/BookingController" method="post">
	<div class="mx-auto w-50">
	<table class="table">
		<tr>
			<th>お名前</th>
			<td><%= name %></td>
		</tr>
		<tr>
			<th>日付</th>
			<td><%= date %></td>
		</tr>
		<tr>
			<th>開始時間</th>
			<td><%= time %></td>
		</tr>
		<tr>
			<th>人数</th>
			<td><%= num %></td>
		</tr>
	</table>
	<button type="submit" class="btn btn-primary">予約する</button>
	</div>
	</form>

</body>
</html>