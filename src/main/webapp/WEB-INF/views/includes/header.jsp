<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nepal Engineering College CPS</title>
<link rel="stylesheet"
	href='<spring:url value="/resources/css/bootstrap/css/bootstrap.min.css"></spring:url>'>
<link rel="stylesheet"
	href='<spring:url value="/resources/css/bootstrap/css/custom.css"></spring:url>'>
<link rel="stylesheet"
	href='<spring:url value="/resources/css/bootstrap/css/bootstrap-select.min.css"></spring:url>'>	
<link rel="stylesheet"
	href='<spring:url value="/resources/css/bootstrap/css/jquery.calendars.picker.css"></spring:url>'>	
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href='<c:url value="/"></c:url>'>nec CPS IS</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href='<c:url value="/"></c:url>'>Home</a></li>
				<li><a href='<c:url value="/Program/"></c:url>'>Program</a></li>
				<li><a href='<c:url value="/Batch/"></c:url>'>Batch</a></li>
				<li><a href='<c:url value="/Student/"></c:url>'>Student</a></li>
				<li><a href='<c:url value="/Payment/"></c:url>'>Account</a></li>
				<li><a href='<c:url value="/IssueReturn/"></c:url>'>IssueReturn</a></li>
				<li><a href='<c:url value="/ExamResult/"></c:url>'>ExamResult</a></li>
				<li><a href='<c:url value="/Thesis/"></c:url>'>Thesis</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<sec:authorize access="authenticated" var="authenticated" />
			<c:choose>
				<c:when test="${authenticated}">
					<li><a href="<c:url value="#" />"> Welcome <span
						class="glyphicon glyphicon-user"> </span> <sec:authentication property="name"/>
						</a></li>
					<li><a href="<c:url value="/logout" />"><span
						class="glyphicon glyphicon-log-out"> </span> Logout</a></li>	
				</c:when>
				<c:otherwise>
					<li><a href="<c:url value="/login" />"><span
						class="glyphicon glyphicon-log-in"> </span> LogIn</a></li>	
				</c:otherwise>
			</c:choose>			
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
<div class="container" id="top">