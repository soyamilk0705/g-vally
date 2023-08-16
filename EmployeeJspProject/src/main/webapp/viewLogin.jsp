<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isThreadSafe="true" %>
<jsp:useBean id="login" class="test.jdbc.oracle.EmployeeDTO" scope="session"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>	
		<jsp:include page="checkLogin3.jsp"></jsp:include>
		<jsp:include page="loginSuccess.jsp"></jsp:include>
	</body>
</html>