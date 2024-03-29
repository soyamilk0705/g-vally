<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="index.khs" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- jstl(java standard tag library): 서버에서 작동 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String name = (String) session.getAttribute("login");
	String result = "";
	
	if (name != null){
		result = "";			// 로그인 안되어 있으면 forward 안함(forward page에 "" 들어가면 아무것도 안함)
	} else {
		result = "viewLogin.jsp";
%>
	<jsp:forward page = "<%=result %>"></jsp:forward>
<%
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트</title>
<style type="text/css">
	th{background: orange};
</style>
</head>
<body>
<h1>리스트</h1>
<a href="writeform.khs">글 쓰기</a>
<table width="600" cellpadding="3">
	<tr>
		<th width="50">번호</th>
		<th width="270">제목</th>
		<th width="100">글쓴이</th>
		<th width="120">날짜</th>
		<th width="80">조회수</th>
		
	</tr>	

<c:forEach var="b" items="${list}">	<!-- ${} : 서버 자원 -->


	<tr>
		<td>${b.num}</td>
		<td>
		
		<c:forEach begin="0" end="${b.tab}">
		&nbsp;&nbsp;&nbsp;
		</c:forEach>
		
		<a href="read.khs?num=${b.num}&pg=${pg}">${b.subject}</a></td>
		<td>${b.name}</td>
		<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd"/></td>
		<td>${b.hit}</td>
	</tr>
</c:forEach>

</table>
<div style="width:600px;text-align:right"><a href="writeform.khs">글쓰기</a></div>

<table width="600">
<tr>
	<td align="center">
		<!-- 처음 이전 링크 -->
		<c:if test="${pg>block}">  <!-- 5>10 : false / 15>10 : true -->
			[<a href="list.khs?pg=1">◀◀</a>]
			[<a href="list.khs?pg=${fromPage-1}">◀</a>]		
		</c:if>
		<c:if test="${pg<=block}"> <!-- 5<=10 :true / 15<=10:false -->
			[<span style="color:gray">◀◀</span>]	
			[<span style="color:gray">◀</span>]
		</c:if>
		
		<!-- 블록 범위 찍기 -->
		<c:forEach begin="${fromPage}" end="${toPage}" var="i">
			<c:if test="${i==pg}">[${i}]</c:if>
			<c:if test="${i!=pg}">
				[<a href="list.khs?pg=${i}">${i}</a>]
			</c:if>
		</c:forEach>
		
		<!-- 다음, 이후 -->
		<c:if test="${toPage<allPage}"> <!-- 20<21 : true -->
				[<a href="list.khs?pg=${toPage+1}">▶</a>]
				[<a href="list.khs?pg=${allPage}">▶▶</a>]
		
		</c:if>	
		<c:if test="${toPage>=allPage}"> <!-- 21>=21 :true -->
				[<span style="color:gray">▶</span>]
				[<span style="color:gray">▶▶</span>]
		
		</c:if>			
		
	</td>
</tr>
</table>
</body>
</html>