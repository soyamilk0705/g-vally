<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe="true"%>
<jsp:useBean id="emp" class="intranet.entity.EmpEntity" scope="request"/>
<jsp:useBean id="service" class="intranet.biz.EmployeeService" scope="application"/>
<jsp:setProperty property="*" name="emp" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
<%	
		emp = service.getLoginUser(emp.getEmpLoginId(), emp.getEmpLoginPasswd());
		System.out.println(emp);
		
		if (emp != null) {
			session.setAttribute("login", emp.getEmpName());
			System.out.println("loginAction.jsp :: session :: " + session.getAttribute("login"));

%>
		<jsp:forward page="loginSuccess.jsp"></jsp:forward>
<%				
		} else {
%>
		<jsp:forward page="loginFail.html"></jsp:forward>
<%						
		}
					
%>		
		
	</body>
</html>