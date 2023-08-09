<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe = "true"%>		<%--insert, delete, update는 db에 영향을 끼치기 때문에 설정 해줘야함 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<center><h1>주식회사 대빵</h1></center>
		
<%-- <%	// Cookie를 사용한 로그인 체크
		String name = "";
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies){
			if (c.getName().equals("login")) {
				name = c.getValue();
			}
		}
		
		String loginMsg = ((name == null) || (name.equals(""))) 
				? "<a href='login.jsp'>로그인</a>" : "직원(" + name + ") 이 로그인하셨습니다.";
		
%>	 --%>

<% // HttpSession을 사용한 로그인 체크
	String name = (String) session.getAttribute("login");		// session은 hashMap으로 구현되어 있어서 for문 안돌리고 찾을 수 있음

	String loginMsg = ((name == null) || (name.trim().equals("")))
			? "<a href='login.jsp'>로그인</a><a href='login2.jsp'>로그인2</a><a href='login3.jsp'>로그인3</a>" 
			: "<a href='logout.jsp'>로그아웃</a>직원(" + name + ")이 로그인하셨습니다.<a href='logout2.jsp'>로그아웃2</a>";
	
%>
<%=loginMsg %> 
		<!-- include-forward 같이 사용하면 include에 들어갈 컨텐츠 forward로 덮어씌워짐 -->
		<jsp:include page="selectAll.jsp"></jsp:include>
		
	</body>
</html>

