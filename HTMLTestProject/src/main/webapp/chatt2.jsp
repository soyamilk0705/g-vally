<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
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
	// server push
	for(JspWriter out1 : outSet){
		out1.print(msgTotal);
		out1.flush();
	} 	
	
	
	
%>
<form action="chatt.jsp">
	<input name="msg" size=25>
	<input type="submit" value="보내기">
</form>
</body>
</html>