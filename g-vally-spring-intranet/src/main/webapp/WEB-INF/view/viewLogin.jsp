<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="emp.model.EmpDTO" scope="request"/>		<%-- useBean : 객체가 존재하면 존재하는걸 사용하고 없으면 새로 생성 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>

<%
		String name = (String) session.getAttribute("login");
		String result = "";
		
		if ((name==null) || (name.trim().equals(""))){
			result = "loginFail.jsp";
		} else {
			result = "loginSuccess.jsp";
		}
%>
		
	
	<jsp:forward page="<%=result %>"></jsp:forward>		
	</body>
</html>