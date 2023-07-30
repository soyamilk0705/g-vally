<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList,test.jdbc.oracle.EmployeeDTO, test.jdbc.oracle.EmployeeService" %>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"></jsp:useBean>
<jsp:useBean id="service" class="test.jdbc.oracle.EmployeeService" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="emp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	emp = service.selectById(emp.getId());
	String result = service.delete(emp.getId());
	request.setAttribute("result", result);
%>

<body>
	<jsp:include page="viewDelete.jsp"></jsp:include>
	<!-- <h3>직원 탈퇴</h3>
	<form method="get" action="deleteAction.jsp">
		아이디: <input type="text" name="id" value="아이디"><br>
		비밀번호: <input type="text" name="pwd" value="비밀번호"><br>
		이름: <input type="text" name="name" value="이름"><br>
		전화번호: <input type="text" name="phone" value="전화번호"><br>
		이메일: <input type="text" name="email" value="이메일"><br>
		입사일: <input type="text" name="hireDT" value="입사일"><br>
		<input type="submit" value=탈퇴>
	</form> -->
	
	
	
</body>
</html>