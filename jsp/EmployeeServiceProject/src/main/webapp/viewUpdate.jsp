<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>
<jsp:useBean id="listEmp" class="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>직원변경</h3>
	<form method="get" action="updateAction.jsp">
	이름 : <input type="text" name="name" value='<jsp:getProperty property="name" name="emp"/>'><br>
	아이디 : <input type="text" name="id" value='<jsp:getProperty property="id" name="emp"/>'><br>
	비밀번호 : <input type="text" name="pwd" value='<jsp:getProperty property="pwd" name="emp"/>'><br>
	전화번호 : <input type="text" name="phone" value='<jsp:getProperty property="phone" name="emp"/>'><br>
	이메일 : <input type="text" name="email" value='<jsp:getProperty property="email" name="emp"/>'><br>

	<input type="submit" value="수정">
	<input type="reset" value="취소">
	</form>
	
</body>
</html>