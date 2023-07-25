<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.Connection, java.sql.DriverManager, java.sql.ResultSet, java.sql.SQLException,
								java.sql.Statement, java.util.ArrayList, test.jdbc.oracle.Employee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<%!	// 변수, 메소드의 선언 태그
	private Employee selectByName(Statement stmt, String name) throws SQLException {	// jsp에서 static 아닌거 선호(사실 상관 없음)
		Employee emp;
		String sql = "select * from EmpTBL where name = '" + name + "'";
		ResultSet result = stmt.executeQuery(sql);
		
		if(result.next()) {
			emp = new Employee(result.getString("id"), result.getString("pwd"), result.getString("name"),
												result.getString("phone"), result.getString("email"), result.getString("hireDT"));
		} else {
			emp = null;
		}
		
		result.close();
		return emp;
	}
	
	
	private Employee selectById(Statement stmt, String id) throws SQLException {
		Employee emp;
		String sql = "select * from EmpTBL where id = '" + id + "'";
		ResultSet result = stmt.executeQuery(sql);
		
		if(result.next()) {
			emp = new Employee(result.getString("id"), result.getString("pwd"), result.getString("name"),
												result.getString("phone"), result.getString("email"), result.getString("hireDT"));
		} else {
			emp = null;
		}
		
		result.close();
		return emp;
	}
	
	private String delete(Statement stmt, String id) throws SQLException {
		Employee emp;
		String returnResult;
		
		emp = selectById(stmt, id);
		if (emp == null) {
			returnResult = "이미 삭제된 직원입니다.";
			return returnResult;
		}
		
		String sql = "delete from EmpTBL where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		if(result == 1) {
			returnResult = "직원 정보가 삭제되었습니다.";
		} else {
			returnResult = "직원 정보 삭제에 실패했습니다. 다시 입력해주세요";
		}
		
		return returnResult;
	}
	
	private ArrayList<Employee> selectAll(Statement stmt, ArrayList<Employee> listEmp) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from EmpTBL";
		ResultSet result = stmt.executeQuery(sql);
		
		while(result.next()) {
			String id = result.getString("id");
			String pwd = result.getString("pwd");
			String name = result.getString("name");
			String phone = result.getString("phone");
			String email = result.getString("email");
			String hireDT = result.getString("hireDT");
			
			Employee emp = new Employee(id, pwd, name, phone, email, hireDT);
			listEmp.add(emp);
			
		}
		
		result.close();
		return listEmp;
	}


	%>
	<body>
		<a href="insert.jsp">직원등록</a><br />
		<h2> 직원 목록 </h2>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대전화번호</th>
				<th>이메일</th>
				<th>입사일</th>
			</tr>
			
				
<%	// 스크립트릿 : java 코드 삽입
	String className = "oracle.jdbc.driver.OracleDriver";		

	Class.forName(className);

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";

	Connection conn = DriverManager.getConnection(url, user, password);
							
	Statement stmt = conn.createStatement();

	ArrayList<Employee> listEmp = new ArrayList<Employee>();
	String result;

	// selectAll()
	listEmp = selectAll(stmt, listEmp);
	// System.out.println(listEmp);
	
	stmt.close();
	conn.close();

%>			
			
<%
	int idx = 0;
	for(Employee emp : listEmp){
		
%>			
		<tr>
			<td><%=(++idx) %></td>
			<td>
				<a href="update.jsp?id=<%=emp.getId()%>"><%=emp.getId() %></a>
			</td>		<%-- <%= : 표현식, 결과값 출력 --%>
			<td><%=emp.getName() %></td>
			<td><%=emp.getPhone() %></td>
			<td><%=emp.getEmail() %></td>
			<td><%=emp.getHireDT() %></td>
		</tr>
		
<%
	}
%>
		</table>
	</body>
</html>

