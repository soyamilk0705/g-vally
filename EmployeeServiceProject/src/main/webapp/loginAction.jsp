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
			System.out.println(emp);
			request.setAttribute("emp", emp);
			Cookie login = new Cookie("login", emp.getName());	// Cookie 는 String 만 넘길 수 있음
			System.out.println(emp.getName());
			response.addCookie(login);		// 여러 개 담을 수 있어서 set이 아닌 add
			/* System.out.println(request.getCookies()[0].getValue());	// request가 온게 아니기 때문에 cookie에 sessionID 밖에 없음 */
			System.out.println("loginAction.jsp::" + login.getValue());	// 
			// session.invalidate();	// session 파기
%>		
		
		<a href="index.jsp">직원목록</a>	<%-- 문서 안에서 특정한 위치에 가고 싶으면 이용하면 됨 --%>
		<jsp:forward page="viewLogin.jsp"></jsp:forward>
	</body>
</html>