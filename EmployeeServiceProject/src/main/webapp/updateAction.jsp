<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isThreadSafe="false"%><%-- 안전 --%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.ResultSet, java.sql.SQLException,
								java.sql.Statement, java.util.ArrayList,test.jdbc.oracle.EmployeeDTO,test.jdbc.oracle.EmployeeService,java.util.Scanner;"%>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>
<%-- scope=application으로 지정:  crud를 할 때 매번 쓰기 때문에 한번 만들어서 모든 사람들이 공유해서 씀 --%>
<%-- service는 singleton pattern으로 서버 전체에서 하나만 공유해서 사용한다. --%>
<jsp:useBean id="service" class="test.jdbc.oracle.EmployeeService" scope="application"/>
<jsp:setProperty property="*" name="emp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>직원변경</h3>
<%
	String id = request.getParameter("id");
%>

	<%=id%>

<%
	// 스크립트릿 : java 코드 삽입
	String idOriginal = (String) session.getValue("updateId");
	String result = "";
	
	if (idOriginal != null){
		result = (idOriginal.equals(emp.getId())) ? service.update(emp) : "id가 일치하지 않습니다. <br />관리자에게 신고바랍니다.";	
	}
	
	// session.setAttribute("result", result);
	request.setAttribute("result", result);

%>
	<jsp:forward page="viewUpdate.jsp"></jsp:forward>

</body>
</html>