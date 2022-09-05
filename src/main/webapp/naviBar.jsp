<%@page import="webProjectDAO.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<div class="topnav">
	<a href="${contextRoot}/m001">最新消息</a> 
	<a class="active" href="${contextRoot}/m002">訂單資料</a> 
	<a href="${contextRoot}/about">個人資料</a>
	<a href="index.html" style="float: right;">${userInfo.cName}  登出</a>
	
</div>