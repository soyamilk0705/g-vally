<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe="true" errorPage="loginFail.html"%>
<jsp:useBean id="emp" class="emp.model.EmpDTO" scope="request"/>
<jsp:useBean id="service" class="emp.service.EmpServiceImpl" scope="application"/>
<jsp:setProperty property="*" name="emp" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
<%	
		String result = "";
		emp = service.login(emp);
		System.out.println(emp);
		request.setAttribute("emp", emp);
		
		session.setAttribute("login", emp.getName());
		System.out.println("loginAction.jsp :: session :: " + session.getAttribute("login"));
	
%>
		
	<jsp:forward page="viewLogin.jsp"></jsp:forward>
	</body>
</html> 