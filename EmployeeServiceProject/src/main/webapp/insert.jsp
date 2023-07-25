<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>직원정보입력</h3>
	<form method="get" action="insertAction.jsp">	<%-- 전달 되는 과정을 보기 위해서 get 방식으로 사용(추후에 변경할 예정) --%>
		이름 : <input type="text" name="name"><br>
		아이디 : <input type="text" name="id" ><br>
		비밀번호 : <input type="text" name="pwd" ><br>
		휴대전화 : <input type="text" name="phone"><br>
		이메일 : <input type="text" name="email"><br>
		<input type="submit" value="저장">
		<input type="reset" value="취소">
	</form>
</body>
</html>