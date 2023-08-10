<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe = "true"%>		<%--insert, delete, update는 db에 영향을 끼치기 때문에 설정 해줘야함 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>

<%
	
%>
<% // HttpSession을 사용한 로그인 체크
	String name = (String) session.getAttribute("login");
	session.removeAttribute("login");
	session.invalidate();
%>
		로그아웃되었습니다. <a href="index.html">메인페이지로</a>
		
	</body>
</html>

