<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe = "true"%>		<%--insert, delete, update는 db에 영향을 끼치기 때문에 설정 해줘야함 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>주식회사 대빵</h1>
<%
		String name = "";
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies){
			if (c.getName().equals("login")) {
				name = c.getValue();
			}
		}
		
		System.out.println(name);
		
		String loginMsg = ((name == null) || (name.equals(""))) 
				? "<a href='login.jsp'>로그인</a>" : "직원(" + name + ") 이 로그인하셨습니다.";
%>	
<%=loginMsg %> 
		<!-- include-forward 같이 사용하면 include에 들어갈 컨텐츠 forward로 덮어씌워짐 -->
		<jsp:include page="selectAll.jsp"></jsp:include>
		
	</body>
</html>

