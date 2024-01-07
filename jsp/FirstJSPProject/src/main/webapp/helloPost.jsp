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
POST 요청
	<form method="post" action="hello.jsp">
		<input type="text" name="name" value="홍길동">
		<input type="text" name="mail" value="hong@domain.com">
		<input type="submit" value="보내기">
	</form>
</body>
</html>