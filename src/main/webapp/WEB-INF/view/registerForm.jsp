<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"  errorPage="index.khs" %>
<%	// 회원가입은 로그인을 안한 상태에서만 가능하다.
	String name = (String) session.getAttribute("login");
	String result = "";
	
	if (name == null){
		result = "";			// 로그인 안되어 있으면 forward 안함, 밑에 코드 실행(forward page에 "" 들어가면 아무것도 안함)
	} else {
		result = "index.html";
%>
	<script>
    	top.location.href = '<%=result %>';
	</script>
<%
	}
%>
<html>
<head>
    <title>회원등록</title>
    <meta charset="UTF-8">
</head>

<body>
    <center>
    <form name="enrollForm" action="registerAction.khs" method="post">
    <table border="0" width="500">
        <tr>
            <th colspan="2"></th>
        </tr>
        <tr>
            <th colspan="2">회원 가입</th>
        </tr>
        <tr>
            <td width="130" align="right">
                <b>ID :</b>&nbsp;
            </td>
            <td>
                <input type="text" name="id" size="15" maxlength="12">
            </td>
        </tr>
        <tr> 
            <td width="130" align="right"> 
                <b>이름 :</b>&nbsp;
            </td>
            <td> 
                <input type="text" name="name" size="15" maxlength="20">
            </td>
        </tr>
        <tr> 
            <td width="130" align="right">
                <b>암호 :</b>&nbsp;
            </td>
            <td>
                <input type="password" name="pwd" size="15" maxlength="8">  
            </td>
        </tr>
        
        <tr>
            <td colspan=2 align="center">
                <input type="submit" value="작성완료">
                <input type="reset" value="다시쓰기">
            </td>
        </tr>
    </table>
    </form>
    </center>
</body>
</html>

