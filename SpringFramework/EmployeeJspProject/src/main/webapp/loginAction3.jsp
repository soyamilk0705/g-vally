<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isThreadSafe="true" %> <%-- errorPage="loginFail.html" --%>
<!-- 로그인 객체 : 세션에 담을 데이터 -->
<!--  jsp:useBean id="login" class="java.lang.String" scope="session"/ -->
<!--  사용자가 입력한 로그인 정보를 담기 위한 객체 : web -> java (session에 담는다)-->
<jsp:useBean id="login" class="test.jdbc.oracle.EmployeeDTO" scope="session"/>
<!-- 사용자 입력 데이터를 emp에 담기  -->
<jsp:setProperty property="*" name="login"/>
<!-- 세션에 로그인 정보를 넣기 -->
<jsp:getProperty property="login" name="login" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<jsp:forward page="viewLogin.jsp"></jsp:forward>		
	</body>
</html>