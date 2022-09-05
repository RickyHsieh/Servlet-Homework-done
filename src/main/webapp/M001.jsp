<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<table>
		<thead>
			<tr>
				<th>序號</th>
				<th>主旨</th>
				<th>時間</th>
				<th>作者</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="wb" items="${wbInfo}">
				<tr>
					<td>${wb.id}</td>
					<td><a href="${wb.link}">${wb.title}</a></td>
					<td>${wb.beginTime}</td>
					<td>${wb.auth}</td>
				</tr>

			</c:forEach>

		</tbody>
	</table>
</body>
</html>