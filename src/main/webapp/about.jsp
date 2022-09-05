<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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

      table,
      th,
      td {
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
      <tbody>
      	
      	<c:forEach var="info" items="${user}">
      	
        <tr>
          <td style="background-color: gray;">帳號</td>
          <td>testname</td>
          <td style="background-color: gray;">證號</td>
          <td>A111111111</td>
        </tr>
        <tr>
          <td style="background-color: gray;">中文名稱</td>
          <td>${info.cName}</td>
          <td style="background-color: gray;">英文名稱</td>
          <td>${info.eName}</td>
        </tr>
        <tr>
          <td style="background-color: gray;">姓別</td>
          <td>男</td>
          <td style="background-color: gray;">生日</td>
          <td>1988-01-01</td>
        </tr>
      	
      	</c:forEach>
      
      </tbody>
    </table>
  </body>
</html>