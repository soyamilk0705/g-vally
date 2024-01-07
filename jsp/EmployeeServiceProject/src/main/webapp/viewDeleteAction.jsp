<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="result" class="java.lang.String" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="checkLogin.jsp"></jsp:include>
<%=result %>
<a href="index.jsp">목록으로</a>
</body>
</html>