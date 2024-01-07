<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="test.jdbc.oracle.EmployeeDTO,test.jdbc.oracle.EmployeeService" %>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>		<%-- useBean : 객체가 존재하면 존재하는걸 사용하고 없으면 새로 생성 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
<%-- <% // Cookie를 사용할 경우 실제 쿠키에서 꺼내서 메시지를 만든다.(실제 response가 한번이라도 일어나야함)
				// 따라서 아래의 코드는 다른 action jsp에서 사용가능
		String name = "";
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies){
			if (c.getName().equals("login")) {
				name = c.getValue();
			}
		}
		
		String result = "";
		// 현재 loginAction.jsp로부터 forward된 viewLogin.jsp에서는 request.getAttribute("emp")로 가져와야함
		name = emp.getName();
		
		if ((name==null) || (name.trim().equals(""))){
			result = emp.getId() + "로그인이 실패했습니다.";
		} else {
			result = "(" + name + ")이 로그인하셨습니다.";
		}
	
%> --%>

<%
		String name = (String) session.getAttribute("login");
		String result = "";
		// 현재 loginAction.jsp로부터 forward된 viewLogin.jsp에서는 request.getAttribute("emp")로 가져와야함
		name = emp.getName();
		
		if ((name==null) || (name.trim().equals(""))){
			result = emp.getId() + "로그인이 실패했습니다.";
		} else {
			result = "(" + name + ")이 로그인하셨습니다.";
		}
%>
		
		<h3>직원<%=result %></h3>
			
		<a href="index.jsp">직원목록</a>	<%-- 문서 안에서 특정한 위치에 가고 싶으면 이용하면 됨 --%>

		
		
	</body>
</html>