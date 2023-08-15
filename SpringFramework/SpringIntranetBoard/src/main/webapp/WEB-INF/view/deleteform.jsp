<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="index.khs" %>
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
<title>글삭제</title>
<script type="text/javascript">
	function deletepro(){
		if(document.f.pwd.value ==""){
			alert("비밀번호를 입력해주세요!");
			document.f.pwd.focus();
		}else{
			document.f.submit();
		}
	}
</script>

<style type="text/css">
	th {text-align: left; background: orange ; width:80px}

</style>
</head>
<body>
<h1>글 삭제</h1>
<a href="list.khs?pg=${param.pg}">리스트</a>
<form name="f" action ="delete.khs" method="post">
<table width="400">
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="hidden" name="pg" value="${param.pg}" />
			<input type="hidden" name="num" value="${param.num}" />
			<input type="password" name="pwd" size="12" maxlength="12"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="left">
			<input type="button" value="삭제" onclick="deletepro()"/>
			<input type="button" value="취소"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>