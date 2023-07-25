<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.Connection, java.sql.DriverManager, java.sql.ResultSet, java.sql.SQLException,
								java.sql.Statement, java.util.ArrayList, test.jdbc.oracle.Employee, test.jdbc.oracle.EmployeeService" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<a href="insert.jsp">직원등록</a><br />
		<h2> 직원 목록 </h2>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대전화번호</th>
				<th>이메일</th>
				<th>입사일</th>
			</tr>
			
				
<%	// 스크립트릿 : java 코드 삽입
	EmployeeService service = new EmployeeService();
	ArrayList<Employee> listEmp =  service.selectAll();
	
	System.out.println(listEmp);
	service.close();
%>			
			
<%
	int idx = 0;
	for(Employee emp : listEmp){
		
%>			
		<tr>
			<td><%=(++idx) %></td>
			<td>
				<a href="update.jsp?id=<%=emp.getId()%>"><%=emp.getId() %></a>
			</td>		<%-- <%= : 표현식, 결과값 출력 --%>
			<td><%=emp.getName() %></td>
			<td><%=emp.getPhone() %></td>
			<td><%=emp.getEmail() %></td>
			<td><%=emp.getHireDT() %></td>
		</tr>
		
<%
	}
%>
		</table>
	</body>
</html>

