<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"></jsp:useBean>
<jsp:useBean id="service" class="test.jdbc.oracle.EmployeeService" scope="application"></jsp:useBean>
<jsp:setProperty property="*" name="emp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	session.putValue("deleteId", emp.getId());
	emp = service.selectById(emp.getId());
	request.setAttribute("emp", emp);
%>
<jsp:forward page="viewDelete.jsp"></jsp:forward>
<body>
	
	
	
</body>
</html>