<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe="true" isErrorPage="true"%>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>		<%-- useBean : 객체가 존재하면 존재하는걸 사용하고 없으면 새로 생성 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
<%
		
		System.out.println("errorLogin.jsp :: error :: " + exception.getMessage() + "\n" + emp);
		
%>
		
		<h3>직원 로그인이 실패했습니다.</h3>
		
			
		<a href="index.jsp">직원목록</a>
		<%-- <jsp:include page="index.jsp"></jsp:include> --%>

		
	</body>
</html>