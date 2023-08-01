<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="listEmp" class="java.util.ArrayList<test.jdbc.oracle.EmployeeDTO>" scope="request"/>
	<h3>직원변경</h3>
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