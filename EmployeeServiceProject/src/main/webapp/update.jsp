<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.Connection, java.sql.DriverManager, java.sql.ResultSet, java.sql.SQLException,
								java.sql.Statement, java.util.ArrayList,test.jdbc.oracle.EmployeeDTO,test.jdbc.oracle.EmployeeService" %>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>
<jsp:useBean id="service" class="test.jdbc.oracle.EmployeeService" scope="request"/>
<jsp:setProperty property="*" name="emp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>직원변경</h3>
<%
	//session 방식은 Client가 못봄(내장 객체)
	session.putValue("updateId", emp.getId());		// updateAction에서 id를 검증하기 위해 사용		
	// userBean에 의해서 emp 객체 만들어지고 setProperty를 통해서 emp 데이터들이 채워지는데 update?id=XXX request로 id만 들어와서 
	// 결국 나머지는 null이 됨-> 그리고 그 나머지 값들을 selectById를 통해서 채워짐
	System.out.println(emp.getId() + "   " + emp.getName() + "   " + emp.getEmail());
	emp = service.selectById(emp.getId());	// useBean을 사용하여 내장 객체처럼 사용하게 만듦
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