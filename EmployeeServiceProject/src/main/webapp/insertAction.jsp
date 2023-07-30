<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList,test.jdbc.oracle.EmployeeDTO, test.jdbc.oracle.EmployeeService" %>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>
<%-- <jsp:useBean id="result" class="java.lang.String" scope="request"/> --%>
<jsp:setProperty property="*" name="emp" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		
		<%	// 스크립트릿 : java 코드 삽입
			EmployeeService service = new EmployeeService();

			// 직원 등록
			String result = service.insert(emp);
			// session.setAttribute("result", result);
			request.setAttribute("result", result);
		%>		
		
		<a href="index.jsp">직원목록</a>	<%-- 문서 안에서 특정한 위치에 가고 싶으면 이용하면 됨 --%>
		<p />
		<jsp:forward page="viewInsert.jsp"></jsp:forward>
	</body>
</html>