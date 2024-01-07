<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	ArrayList<String> msgList = new ArrayList<String>();
	HashSet<JspWriter> outSet = new HashSet<JspWriter>();
%>
<%
	String msg = request.getParameter("msg");
	if(msg != null){
		msgList.add(msg);
	}
	
	outSet.add(out);
	
	String msgTotal = "";
	// client pull
	for(String msg1 : msgList){
		msgTotal += (msg1) + "<br>";
	}
%>
<%=msgTotal %>
<form action="chatt.jsp">
	<input name="msg" size=25>
	<input type="submit" value="보내기">
</form>
</body>
</html>