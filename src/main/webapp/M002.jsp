<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<head>
<style>
/* Add a black background color to the top navigation */
.topnav {
	background-color: #333;
	overflow: hidden;
	margin-bottom: 10px;
}

/* Style the links inside the navigation bar */
.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
	background-color: #04aa6d;
	color: white;
}

table, th, td {
	border: solid 1px #000;
	padding: 10px;
}

table {
	border-collapse: collapse;
	caption-side: bottom;
	width: 100%;
}

caption {
	font-size: 16px;
	font-weight: bold;
	padding-top: 5px;
}
</style>
</head>
<body>

	<jsp:include page="naviBar.jsp"></jsp:include>
	
	<form action="m002" method="get">
		<input type="hidden" name="page" value=1>
		<table>
			<tbody>
				<tr>
					<td style="background-color: gray;">訂單編號</td>
					<td><input type="text" name="orderNum" value="${orderNum}"></td>
					<td style="background-color: gray;">商品名稱</td>
					<td><input type="text" name="productName"
						value="${productName}"></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3"><button type="submit">查詢</button></td>
				</tr>
			</tbody>
		</table>
	</form>
	<BR>
	<table>
		<thead>
			<tr>
				<th>訂單編號</th>
				<th>商品名稱</th>
				<th>單價</th>
				<th>數量</th>
				<th>總價</th>
				<th>訂單時間</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order" items="${tempOrder}">
				<tr>
					<td><a href="#">${order.orderNo}</a></td>
					<td>${order.product}</td>
					<td>${order.unitAmt}</td>
					<td>${order.qty}</td>
					<td>${order.totalAmt}</td>
					<td>${order.buyTime}</td>
				</tr>
			</c:forEach>
			

		</tbody>
		<caption>
			<c:forEach var="i" begin="1" end="${pages}">
			
				<a href="/servletHw/m002?orderNum=&productName=&page=${i}" style='padding: 5px;'>${i}</a>
			
			</c:forEach>
		</caption>
	</table>
</body>
</html>
