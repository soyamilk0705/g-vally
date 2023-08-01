<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList,test.jdbc.oracle.EmployeeDTO, test.jdbc.oracle.EmployeeService" %>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"></jsp:useBean>
<jsp:useBean id="service" class="test.jdbc.oracle.EmployeeService" scope="application"></jsp:useBean>
<jsp:setProperty property="*" name="emp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String name = (String) session.getAttribute("login");
	String loginMsg = "";
	
	if ((name == null) || (name.trim().equals(""))) {

%>
		<center>로그인이 되지 않았습니다. <a href='index.jsp'>여기</a>를 누르면 메인페이지로 갑니다.</center>
<%
		return;
	} else {
		loginMsg = "직원(" + name + ")이 로그인하셨습니다.<a href='logout.jsp'>로그아웃</a>";
	}
%>
<%
	String id = request.getParameter("id");
	emp = service.selectById(id);
	request.setAttribute("emp", emp);
%>
<h6 align="right"><%=loginMsg %></h6> 
<jsp:forward page="viewDelete.jsp"></jsp:forward>
<body>
	
	
	
</body>
</html>