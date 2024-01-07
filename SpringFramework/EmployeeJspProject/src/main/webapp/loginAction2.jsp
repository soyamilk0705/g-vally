<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="test.jdbc.oracle.EmployeeDTO, test.jdbc.oracle.EmployeeService" %>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>
<jsp:useBean id="service" class="test.jdbc.oracle.EmployeeService" scope="application"/>
<jsp:setProperty property="*" name="emp" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		
<%	
		// 로그인 :: publisher 가 코딩(가정) selectById() -> login(id, pwd) 변경
		emp = service.login(emp);
		request.setAttribute("emp", emp);
		
		// Cookie를 통한 로그인
		String name = "";
		name = URLEncoder.encode(emp.getName(), "UTF-8");		// 영문이나 숫자는 안바뀌고 한글만 바뀜
		Cookie login = new Cookie("login", name);	// Cookie 는 String 만 넘길 수 있음
		response.addCookie(login);		// 여러 개 담을 수 있어서 set이 아닌 add 
		System.out.println("loginAction2.jsp::" + login.getValue());
			
%>		
		
		<a href="index.jsp">직원목록</a>	<%-- 문서 안에서 특정한 위치에 가고 싶으면 이용하면 됨 --%>
		<jsp:forward page="viewLogin2.jsp"></jsp:forward>
	</body>
</html>