<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8" />
    	<jsp:include page="/WEB-INF/script.jsp" />

    	</head>
	<title>レストラン予約システム</title>
<body class="text-center">
<jsp:include page="/WEB-INF/header.jsp" />

	<p>
		<h1>レストラン空席検索</h1>
	</p>
	<form action="/restaurantapp/SearchController" method="post">
		<p>ご来店人数をお選びください : <select name="numofpeople">
		<!-- <option value=''>指定なし</option> -->
		<% for(int i = 1; i < 9 ; i++){
			out.print("<option value='" + i + "'>" + i + "人" + "</option>");
		}
		%>
		<option value='10'>10人以上</option>
		</select>
	</p>
	<p>ご来店時間をお選びください : <select name="time">
		<!--  <option value=''>指定なし</option> -->
		<%
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		cal.set(2020, 1, 1, 15, 0);
		for(int i = 0; i < 18 ; i++){
			String displayTime = sdf.format(cal.getTime());
			String propetyTime = displayTime.replace(":", "");
			out.print("<option value='" +  propetyTime +  "'>" + displayTime + "</option>");
			cal.add(Calendar.MINUTE, 30 );
		}
		%>
		</select>
	</p>
	<button class="btn btn-primary" type="submit">空席照会</button>
	</form>
</body>
</html>