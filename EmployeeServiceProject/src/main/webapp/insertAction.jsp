<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.Connection, java.sql.DriverManager, java.sql.ResultSet, java.sql.SQLException,
								java.sql.Statement, java.util.ArrayList, test.jdbc.oracle.Employee, test.jdbc.oracle.EmployeeService" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<h3>직원 등록 결과</h3>
		
		<%	// 스크립트릿 : java 코드 삽입
			EmployeeService service = new EmployeeService();

			Employee emp = new Employee(
						request.getParameter("id"), 
						request.getParameter("pwd"), 
						request.getParameter("name"), 
						request.getParameter("phone"), 
						request.getParameter("email"),
						null);
			
			// 직원 등록
			String result = service.insert(emp);
			
			service.close();
		%>		
		
		<%=result %><br/>
		
		<a href="index.jsp">직원목록</a>	<%-- 문서 안에서 특정한 위치에 가고 싶으면 # 이용하면 됨 --%>
		<p />
		
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