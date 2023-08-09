<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isThreadSafe="true" %>
<jsp:useBean id="login" class="intranet.entity.EmployeeDTO" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% System.out.println("viewLogin.jsp :: " + login);
	String name = login.getName();
	String result  = "";
	if((name == null)||(name.trim().equals(""))){
		result = "loginFail.html";
	}else
		result = "loginSuccess.jsp";
%>
	<jsp:forward page="<%=result %>"></jsp:forward>
<p/>
</body>
</html>