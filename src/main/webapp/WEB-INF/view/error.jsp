<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%-- <%
    response.setStatus(200);
%>   --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록(오류)</title>
</head>
<body>
	<center>회원등록이 실패하였습니다.</center>
	<br>
	오류 메시지 : <%= exception.getMessage() %>
	<% exception.printStackTrace(); %>
	<br>
	<a href="registerForm.html">회원가입</a>
	<br>
	<a href="index.html" target="_top">메인페이지</a>
</body>
</html>