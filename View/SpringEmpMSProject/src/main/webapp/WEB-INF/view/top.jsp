<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="main.khs" target="main">[홈]</a>
	
<%
	String name = (String) session.getAttribute("login");

	if (name != null){
%>
		<a href="logout.khs" target="main">[로그아웃]</a>
<%
	} else {
%>		
		<a href="loginForm.khs" target="main">[로그인]</a>
<%
	}
%>	
	
	<a href="empMenu.khs" target="menu">[직원관리]</a>
</body>
</html>