<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="restaurantapp.model.BookingEntity" %>
<%
	List<BookingEntity> bookingEntityList =(List<BookingEntity>)session.getAttribute("bookingEntityList");
	System.out.println(bookingEntityList);
%>

<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8" />
    	<jsp:include page="/WEB-INF/script.jsp" />
    	</head>
	<title>レストラン予約システム</title>
<body class="text-center">
<nav class="navbar navbar-dark bg-dark">
  <a href="/restaurantapp/index.jsp" class="navbar-brand">川崎レストラン</a>
  <a href="/restaurantapp/index.jsp">ログオフ</a>
</nav>
	<h1>管理者画面</h1>

	<div class="mx-auto w-75">
		<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>
					予約日
				</th>
				<th>
					予約者名
				</th>
				<th>
					予約人数
				</th>
				<th>
					テーブル番号
				</th>
				<th>
					予約番号
				</th>
				<th>
					開始時間
				</th>
				<th>
					終了時間
				</th>
			</tr>
			<%
				for(BookingEntity be : bookingEntityList){
					out.print("<tr class=\"table-light\"><td>" +  be.getDisplayBookingDate() +
					"</td><td>" + be.getBookingName() +
					"</td><td>" + be.getNumberOfPeople() +
					"</td><td>" + be.getBookingTableTaku() +
					"</td><td>" + be.getBookingId() +
					"</td><td>" + be.getDisplayStartTime() +
					"</td><td>" + be.getDisplayEndTime() +
					"</td></tr>");
				}
			%>
		</thead>
		<tbody>

		</tbody>
		</table>
	</div>
</body>
</html>