<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="restaurantapp.model.VacantData"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.time.LocalDateTime" %>

<%
	VacantData vde = (VacantData)session.getAttribute("vacantDataEntity");
	System.out.println(vde);
	Map<LocalDateTime, Integer> map = vde.getDataMap();
	int numOfPeople = vde.getNumberOfPeople();
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
<h1>レストラン空席検索</h1>

<form action="/restaurantapp/ResultController" method="post">
	<p>
	お名前 <input type="text" name="name" size="20">
	</p>
	<p>予約したい日をクリックすると予約されます。
	<div class="mx-auto w-75">
	<table class="table">
		<thead class="thead-dark">
	  		<tr>
		    <%
		    	for(Map.Entry<LocalDateTime, Integer> entry : map.entrySet()){
		    		LocalDateTime ldt = entry.getKey();
		    		String displayDate = ldt.getMonthValue() + "月" + ldt.getDayOfMonth() + "日(" + vde.parseWeekDay(ldt) + ") ";
		    		out.print("<th>" + displayDate + "</th>" );
		    	}
		    %>
	  		</tr>
	  	</thead>
	  	<tbody>
	  <tr class="table-light">
	    <%
	    	for(Map.Entry<LocalDateTime, Integer> entry : map.entrySet()){
	    		String displayVacant = vde.parseVacant(entry.getValue());
	    		String strCross = "<td><div class=\"btn btn-outline-warning\">×</div></td>";
	    		String strCircle = "<td><button class=\"btn btn-warning\" type=\"submit\" name=\"date\"s value=\"" + entry.getKey().getYear() + "_" + entry.getKey().getMonthValue() + "_" + entry.getKey().getDayOfMonth() + "_" + entry.getKey().getHour() + "_" + entry.getKey().getMinute() + "_" + numOfPeople + "\">" + displayVacant + "</button></td>";
	    		String output = displayVacant.equals("×") ? strCross : strCircle;
	    		out.print(output);
	    	}
	    %>
	  </tr>
	  </tbody>
	</table>
	</div>
	</p>
	◎ : 空きあり　△: 残りわずか　×: 満席
</form>
</body>
</html>