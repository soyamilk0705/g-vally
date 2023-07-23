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
		private Employee selectByName(Statement stmt, String name) throws SQLException {
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
		
		private String insert(Statement stmt, Employee emp) throws SQLException {
			String returnResult;		
			String id =emp.getId();
			String sql = "insert into EmpTBL (seq, id, pwd, name, phone, email, hireDT)\n"
					+ " values (seq_EmpTBL.NEXTVAL, '"+ emp.getId() +"', '"+ emp.getPwd() +"', '"+ emp.getName() +"', '"+ emp.getPhone() +"', '"+ emp.getEmail() + "', sysdate)";
			int result  = stmt.executeUpdate(sql);	// insert, delete, update 실행 시 사용

			if (result == 1) {	// 성공
				emp = selectByName(stmt, emp.getName());	// emp(현재) : 사용자 입력 데이터
																					// emp(new) : DB에서 가져온 데이터
				if (emp.getId().equals(id)) {						
					returnResult = "직원정보가 정상적으로 입력되었습니다.<br />" + emp;
				} else {
					returnResult = "직원정보가 등록되지 않았습니다. <br />다시 입력해주세요.";
				}
			} else {	// 실패 : return 0
				returnResult = "직원정보가 등록되지 않았습니다.<br /> 다시 입력해주세요.";
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
		<h3>직원 등록 결과</h3>
		
		<%	// 스크립트릿 : java 코드 삽입
			String className = "oracle.jdbc.driver.OracleDriver";		
		
			Class.forName(className);
		
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
		
			Connection conn = DriverManager.getConnection(url, user, password);
									
			Statement stmt = conn.createStatement();
		
			String name = request.getParameter("name");			// 사용자 요청 : 사용자가 입력한 입력값
			Employee emp = new Employee(
					request.getParameter("id"), 
					request.getParameter("pwd"), 
					name, 
					request.getParameter("phone"), 
					request.getParameter("email"),
					null);
			
			// 직원 등록
			String result = insert(stmt, emp);
			
			stmt.close();
			conn.close();
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