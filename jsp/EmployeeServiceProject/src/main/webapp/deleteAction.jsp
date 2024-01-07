<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"></jsp:useBean>
<jsp:useBean id="service" class="test.jdbc.oracle.EmployeeService" scope="application"></jsp:useBean>
<jsp:useBean id="result" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="emp" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String idOriginal = (String) session.getValue("deleteId");

	if (idOriginal != null) {
		result = (idOriginal.equals(emp.getId())) ? service.delete(emp) : "id가 일치하지 않습니다. <br />관리자에게 신고바랍니다.";
	}
	request.setAttribute("result", result);
%>

<jsp:forward page="viewDeleteAction.jsp"></jsp:forward>
<body>

</body>
</html>