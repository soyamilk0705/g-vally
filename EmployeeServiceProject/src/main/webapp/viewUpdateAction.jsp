<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isThreadSafe="false"%><%-- 안전 --%>
<%@ page import="test.jdbc.oracle.EmployeeDTO,test.jdbc.oracle.EmployeeService;"%>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>
<jsp:useBean id="result" class="java.lang.String" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% // HttpSession을 사용한 로그인 체크
	String name = (String) session.getAttribute("login");		// session은 hashMap으로 구현되어 있어서 for문 안돌리고 찾을 수 있음
	String loginMsg = ""; 
	
	if ((name == null) || (name.trim().equals(""))) {
		
%>
	<center>로그인이 되지 않았습니다. <a href='index.jsp'>여기</a>를 누르면 메인페이지로 갑니다.</center>
	
<% 	
		return;		// 로그인이 안됐으면 위에 center 출력하고 그냥 return

	} else {
		loginMsg = "직원(" + name + ")이 로그인하셨습니다.<a href='logout.jsp'>로그아웃</a>";
	}
%>

<h6 align="right"><%=loginMsg %></h6> 
	<h3>직원변경</h3>


	<%=result %>
	
	<a href="index.jsp">직원목록</a>
	<form method="get" action="updateAction.jsp">
		이름 : <input type="text" name="name" value="<%=emp.getName()%>"><br>
		아이디 : <input type="text" name="id" value="<%=emp.getId()%>"><br>
		비밀번호 : <input type="text" name="pwd" value="<%=emp.getPwd()%>"><br>
		전화번호 : <input type="text" name="phone" value="<%=emp.getPhone()%>"><br>
		이메일 : <input type="text" name="email" value="<%=emp.getEmail()%>"><br>

		<input type="submit" value="수정"> 
		<input type="reset" value="취소">
	</form>
</body>
</html>