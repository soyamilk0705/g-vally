<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList,test.jdbc.oracle.EmployeeDTO,test.jdbc.oracle.EmployeeService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 스크립트릿 : java 코드 삽입
	EmployeeService service = new EmployeeService();
	ArrayList<EmployeeDTO> listEmp =  service.selectAll();
	System.out.println(listEmp);
	session.setAttribute("listEmp", listEmp);
%>			
<jsp:include page="viewListEmp.jsp" ></jsp:include>			
</body>
</html>