<%@ page contentType="text/html; charset=UTF-8" %>





<!--  수강생 작성 -->

<%
	String id = (String) session.getAttribute("login");
%>


<html>
<head>
<title>사내 인트라넷 시스템</title>
</head>
<body bgcolor="#eeeeff">
<table align="left" cellspacing="0" cellpadding="0">
   	<tr height="25">
   		<td colspan="3">로그인ID: <%=id %></td>
   	</tr>


<!--  수강생 작성 -->




</table>
</body>
</html>
