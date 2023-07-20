<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<pre>
Hello World
Java
JSP
</pre>
GET 요청
	<form method="get" action="helloPost.jsp">
		<input type="text" name="name" value="홍길동">
		<input type="text" name="mail" value="hong@domain.com">
		<input type="submit" value="보내기">
	</form>
</body>
</html>