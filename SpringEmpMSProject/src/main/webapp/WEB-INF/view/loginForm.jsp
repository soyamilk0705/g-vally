<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="common.js"></script>
</head>
<body>
	<center>
		<form name="frmLogin" action="loginAction.khs" target="_top" method="get" onsubmit="return checkLogin(document.frmLogin);">
			<table border="0" width="500">
				<tr>
	            	<th colspan="2"></th>
	        	</tr>
		        <tr>
		            <th colspan="2">로그인</th>
		        </tr>
				<tr>
					<td width="130" align="right">
						<b>ID</b>&nbsp;
					</td>
					<td>
						<input type="text" name="id" size="30" maxlength="12">
					</td>
				</tr>
				<tr>
					<td width="130" align="right"> 
						<b>비밀번호</b>&nbsp;
					</td>
					<td>
						<input type="password" name="pwd" size="30" maxlength="12">
					</td>
				 </tr>
				 <tr>
		            <td colspan=2 align="center">
		                <input type="submit" value="로그인">
		                <input type="reset" value="취소">
		            </td>
       	 		</tr>
				 
			</table>
		</form>
	</center>
</body>
</html>