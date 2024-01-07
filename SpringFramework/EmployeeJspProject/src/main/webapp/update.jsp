<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h3>직원변경</h3>

<%
	//session 방식은 Client가 못봄(내장 객체)
	session.putValue("updateId", emp.getId());		// updateAction에서 id를 검증하기 위해 사용
	// userBean에 의해서 emp 객체 만들어지고 setProperty를 통해서 emp 데이터들이 채워지는데 update?id=XXX request로 id만 들어와서 
	// 결국 나머지는 null이 됨-> 그리고 그 나머지 값들을 selectById를 통해서 채워짐
	// System.out.println(emp.getId() + "   " + emp.getName() + "   " + emp.getEmail());
	emp = service.selectById(emp.getId());	// useBean을 사용하여 내장 객체처럼 사용하게 만듦
	
	/*
		<jsp:> : jsp action tag는 script tag <% 보다 시점이 빠르기 때문에 변경된 emp 가 전달되지 않음
		따라서, 아래처럼 같은 scope에 변경된 데이터를 업데이트 해줘야함
	*/
	request.setAttribute("emp", emp);	// <jsp:forward 에 변경된 emp를 전달한다. 
	
%>		
	
		
<jsp:forward page="viewUpdate.jsp"></jsp:forward>	<%-- forward 실행 된 후에 java 코드 실행이 되서 emp가 id 빼고 null값으로 전달됨 --%>
</body>
</html>