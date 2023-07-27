<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.Connection, java.sql.DriverManager, java.sql.ResultSet, java.sql.SQLException,
								java.sql.Statement, java.util.ArrayList, test.jdbc.oracle.Employee, test.jdbc.oracle.EmployeeService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>직원변경</h3>
<%
	String id = request.getParameter("id");
	session.putValue("updateId", id);		// session 방식은 Client가 못봄
%>

<%=id %>

<%	// 스크립트릿 : java 코드 삽입
	EmployeeService service = new EmployeeService();
	Employee emp = service.selectById(id);
	
	service.close();
%>		
	
		
	<form method="get" action="updateAction.jsp">
	이름 : <input type="text" name="name" value="<%=emp.getName()%>"><br>
	아이디 : <input type="text" name="id" value="<%=emp.getId()%>"><br>
	비밀번호 : <input type="text" name="pwd" value="<%=emp.getPwd()%>"><br>
	전화번호 : <input type="text" name="phone" value="<%=emp.getPhone()%>"><br>
	이메일 : <input type="text" name="email" value="<%=emp.getEmail()%>"><br>

	<input type="submit" value="수정">
	<input type="reset" value="취소">
	</form>
</body>
</html>