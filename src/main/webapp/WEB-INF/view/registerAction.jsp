<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe="true" errorPage="error.jsp"%>
<jsp:useBean id="emp" class="emp.model.EmpDTO" scope="request"></jsp:useBean>
<jsp:useBean id="service" class="emp.service.EmpServiceImpl" scope="application"></jsp:useBean>
<jsp:setProperty property="*" name="emp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String result = service.register(emp);
	request.setAttribute("result", result);
%>

<jsp:forward page="viewRegister.jsp"></jsp:forward>

</body>
</html> --%>