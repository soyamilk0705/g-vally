<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isThreadSafe="false"%><%-- 안전 --%>
<%@ page import="test.jdbc.oracle.EmployeeDTO,test.jdbc.oracle.EmployeeService;"%>
<jsp:useBean id="emp" class="test.jdbc.oracle.EmployeeDTO" scope="request"/>
<%-- scope=application으로 지정:  crud를 할 때 매번 쓰기 때문에 한번 만들어서 모든 사람들이 공유해서 씀 --%>
<%-- service는 singleton pattern으로 서버 전체에서 하나만 공유해서 사용한다. --%>
<jsp:useBean id="service" class="test.jdbc.oracle.EmployeeService" scope="application"/>
<jsp:useBean id="result" class="java.lang.String" scope="request"/>
<jsp:setProperty property="*" name="emp" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>직원변경</h3>
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
<%
	// 스크립트릿 : java 코드 삽입
	String idOriginal = (String) session.getValue("updateId");

	if (idOriginal != null){
		result = (idOriginal.equals(emp.getId())) ? service.update(emp) : "id가 일치하지 않습니다. <br />관리자에게 신고바랍니다.";	
	}
	
	// session.setAttribute("result", result);
	request.setAttribute("result", result);

%>
	<jsp:forward page="viewUpdateAction.jsp"></jsp:forward>

</body>
</html>