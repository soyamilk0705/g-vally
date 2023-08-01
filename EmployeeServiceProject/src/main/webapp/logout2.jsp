<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isThreadSafe = "true"%>		<%--insert, delete, update는 db에 영향을 끼치기 때문에 설정 해줘야함 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
 <%	// Cookie를 사용한 로그아웃
		String name = "";
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies){
			if (c.getName().equals("login")) {
				name = URLDecoder.decode(c.getValue(), "UTF-8");
				c.setValue("");
				c.setMaxAge(1);		// 쿠키는 지우는 메소드가 없기 때문에 1초후에 사라지게 만드는 방법을 이용할 수 밖에 없음
			}
		}
		
%>	

		<%=name %>님이 로그아웃되었습니다. <a href="index.jsp">메인페이지로</a>
		
	</body>
</html>

