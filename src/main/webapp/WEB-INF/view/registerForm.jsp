<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

