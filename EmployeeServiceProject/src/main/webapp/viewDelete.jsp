<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp">직원목록</a>
	<h3>직원 탈퇴</h3>
	<form method="get" action="deleteAction.jsp">
		아이디: <input type="text" name="id" value="<%=emp.getId() %>"><br>
		이름: <input type="text" name="name" value="<%=emp.getName() %>"><br>
		전화번호: <input type="text" name="phone" value="<%=emp.getPhone() %>"><br>
		이메일: <input type="text" name="email" value="<%=emp.getEmail() %>"><br>
		입사일: <input type="text" name="hireDT" value="<%=emp.getHireDT() %>"><br>
		<input type="submit" value=탈퇴>
	</form> 
	
</body>
</html>