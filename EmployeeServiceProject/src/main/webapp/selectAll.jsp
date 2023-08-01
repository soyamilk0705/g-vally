<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="service" class="test.jdbc.oracle.EmployeeService" scope="application"/>
<jsp:useBean id="listEmp" class="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 스크립트릿 : java 코드 삽입
	listEmp =  service.selectAll();
	request.setAttribute("listEmp", listEmp);	
%>			
<jsp:include page="viewListEmp.jsp" ></jsp:include>			
</body>
</html>