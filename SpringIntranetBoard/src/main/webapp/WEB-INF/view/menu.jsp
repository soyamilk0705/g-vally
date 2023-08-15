<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"  errorPage="index.khs" %>
<html>
<head>
<title>사내 인트라넷 시스템</title>
</head>
<body bgcolor="#eeeeff">
<table align="left" cellspacing="0" cellpadding="0">
<%
	String name = (String) session.getAttribute("login");
	String result = "";
	
	if (name == null){
%>
	<tr height="25">
   		<td colspan="3"><a href="loginForm.khs" target="main">로그인</a></td>
   	</tr>
   	<tr height="25">
   		<td colspan="3"><a href="registerForm.khs" target="main">회원가입</a></td>
   	</tr>
   
   	
<%
	} else {	
%>

	<tr height="25">
   		<td colspan="3"><%=name %> <a href="logout.khs" target="_top">로그아웃</a></td>
   	</tr>
   	<tr height="25">
   		<td colspan="3"><a href="myPage.khs" target="main">마이페이지</a></td>
   	</tr>
<%
	}
%>
   	
	<tr height="25">
   		<td colspan="3">&nbsp;</td>
   	</tr>
  	<tr height="25">
   		<td colspan="3"><a href="writeform.khs" target="main">글쓰기</a></td>
   	</tr>
   	
   	<tr height="25">
   		<td colspan="3"><a href="list.khs" target="main">글 목록</a> </td>
   	</tr>

</table>
</body>
</html>
