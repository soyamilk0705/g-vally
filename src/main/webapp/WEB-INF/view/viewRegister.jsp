<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe="true" errorPage="error.jsp" %>
<jsp:useBean id="emp" class="emp.model.EmpDTO" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	회원(<jsp:getProperty name="emp" property="name"/>) 등록 결과 
	<%=request.getAttribute("result") %>	<br/>
	<jsp:include page="loginForm.html"></jsp:include>

</body>
</html>