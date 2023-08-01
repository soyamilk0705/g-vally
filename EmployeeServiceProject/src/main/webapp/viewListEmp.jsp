<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList,test.jdbc.oracle.EmployeeDTO" %>
<jsp:useBean id="listEmp" class="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="checkLogin.jsp"></jsp:include>
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
			<th>삭제</th>
		</tr>
<%
	int idx = 0;
	for(Object o : listEmp){
		EmployeeDTO emp = (EmployeeDTO) o;
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
			<td><a href="delete.jsp?id=<%=emp.getId()%>">삭제</a></td>
		</tr>
		
<%
	}
%>

</table>
</body>
</html>


