<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe="true" errorPage="errorLogin.jsp"%>
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
			
			// emp == null, NullPointException 발생
			session.setAttribute("login", emp.getName());
			System.out.println("loginAction.jsp :: session :: " + session.getAttribute("login"));
			
			// session을 통한 로그인
			/* if (emp != null) {
				session.setAttribute("login", emp.getName());
				System.out.println("loginAction.jsp :: session :: " + session.getAttribute("login"));
			} // else의 경우는 session에 login 정보를 넣지 않는다. */
			
%>		
		
		<a href="index.jsp">직원목록</a>	<%-- 문서 안에서 특정한 위치에 가고 싶으면 이용하면 됨 --%>
		<jsp:forward page="viewLogin.jsp"></jsp:forward>
	</body>
</html>