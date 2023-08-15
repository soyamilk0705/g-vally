<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = (String) session.getAttribute("login");
	String result = "";
	
	if (name == null){
		result = "";			// 로그인 안되어 있으면 forward 안함(forward page에 "" 들어가면 아무것도 안함)
	} else {
		result = "viewLogin.jsp";
%>
	<jsp:forward page = "<%=result %>"></jsp:forward>
<%
	}
%>


<html>
	<head>
		<title>사내 인트라넷 시스템</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<meta http-equiv="Cache-Control" content="no-cache; no-store; no-save">
	</head>
	<body bgcolor="#fffffe">
	<br/><br/>
	<center>
	<form name="frmLogin" action="loginAction.khs" method="post">
	<table border="0" cellpadding="4" cellspacing="1">
		<tr bgcolor=#eeeeff>
			<td bgcolor="#eeeeff" width="150" align="right">사용자 아이디</td>
		   	<td bgcolor="#feeeff"><input type=text name=id size=20 maxlength=20 ></td>
	    </tr>
	    <tr>
		    <td bgcolor="#eeeeff" width="150" align="right">패스워드</td>
		    <td bgcolor="#feeeff"><input type=password name=pwd size=20 maxlength=20 ></td>
	    </tr>
	    <tr>
	        <td colspan="2" align="center">
	            <br/>
	        	<input type="submit" value="로 그 인">
	    	    <input type="reset" value="다시쓰기">
	    	    <a href="registerForm.khs">회원가입</a>
	    	</td>
	    </tr>
	</table>
	</form>
	<br/><br/>
	Copyright ⓒ 2011 All rights reserved. <br/>
	</center>
	</body>
</html>
