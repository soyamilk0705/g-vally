<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="test.jdbc.oracle.EmployeeDTO,test.jdbc.oracle.EmployeeService" %>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>		<%-- useBean : 객체가 존재하면 존재하는걸 사용하고 없으면 새로 생성 --%>
<%-- <jsp:useBean id="result" class="java.lang.String" scope="request"/> --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<jsp:include page="checkLogin.jsp"></jsp:include>
	<h3>직원(<jsp:getProperty name="emp" property="name" />) 등록 결과</h3> 
	<%
		// String result = (String) session.getAttribute("result");
		String result = (String) request.getAttribute("result"); 
	%>
		<%= result %><br/>
		
		<a href="index.jsp">직원목록</a>	<%-- 문서 안에서 특정한 위치에 가고 싶으면 이용하면 됨 --%>
		<p />
		
		<form method="get" action="insertAction.jsp">	<%-- 전달 되는 과정을 보기 위해서 get 방식으로 사용(추후에 변경할 예정) --%>
			이름 : <input type="text" name="name"><br>
			아이디 : <input type="text" name="id" ><br>
			비밀번호 : <input type="text" name="pwd" ><br>
			휴대전화 : <input type="text" name="phone"><br>
			이메일 : <input type="text" name="email"><br>
			<input type="submit" value="저장">
			<input type="reset" value="취소">
		</form>
	</body>
</html>