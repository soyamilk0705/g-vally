package test.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TestEmp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String className = "oracle.jdbc.driver.OracleDriver";

		// 1. 드라이버 로딩 및 등록
		Class.forName(className);

		// 2. 연결 얻어오기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		Connection conn = DriverManager.getConnection(url, user, password);

		// 3. 명령문 생성하기
		Statement stmt = conn.createStatement();

		// 4. 명령문 실행하기
		ArrayList<Employee> listEmp = new ArrayList<Employee>();
		Employee emp;
		String result;

		// select()
		Scanner in = new Scanner(System.in);
		System.out.println("직원 이름을 입력하세요>");
		String name = in.nextLine();
		
		emp = select(stmt, name);
		System.out.println(emp);
		
		// update()
		System.out.println("전화번호를 수정할 직원의 이름을 입력하세요>");
		name = in.nextLine();
		
		emp = select(stmt, name);
		result = updatePhone(stmt, name, in);
		System.out.println(result);
		
		// delete()
		System.out.println("삭제할 직원의 이름을 입력하세요>");
		name = in.nextLine();
		
		emp = select(stmt, name);
		result = delete(stmt, name);
		System.out.println(result);
		
		// selectAll()
		List<Employee> emps = new ArrayList<>();
		emps = selectAll(stmt, emps);
		System.out.println(emps);
	}
	
	

	private static Employee select(Statement stmt, String name) throws SQLException {
		Employee emp;
		String sql = "select * from EmpTBL where name = '" + name + "'";
		ResultSet result = stmt.executeQuery(sql);
		
		if(result.next()) {
			emp = new Employee(result.getString("id"),
												result.getString("pwd"),
												result.getString("name"),
												result.getString("phone"),
												result.getString("email"),
												result.getString("hireDT"));
		} else {
			emp = null;
		}
		
		result.close();
		return emp;
	}
	
	private static String updatePhone(Statement stmt, String name, Scanner in) throws SQLException {
		Employee emp;
		String message;
		
		emp = select(stmt, name);
		if (emp == null) {
			message = "삭제된 직원입니다.";
			return message;
		}
		
		System.out.println("수정 전화번호를 입력하세요>");
		String phone = in.nextLine();
		
		String sql = "update EmpTBL set phone = '" + phone + "' where name = '" + name + "'";
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			message = "전화번호가 수정되었습니다.";
		} else {
			message = "전화번호 수정에 실패했습니다.";
		}
		
		return message;
	}
	
	private static String delete(Statement stmt, String name) throws SQLException {
		Employee emp;
		String message;
		
		emp = select(stmt, name);
		if (emp == null) {
			message = "이미 삭제된 직원입니다.";
			return message;
		}
		
		String sql = "delete from EmpTBL where name = '" + name + "'";
		int result = stmt.executeUpdate(sql);
		
		if(result == 1) {
			message = "직원 정보가 삭제되었습니다.";
		} else {
			message = "직원 정보 삭제에 실패했습니다. 다시 입력해주세요";
		}
		
		return message;
	}
	
	private static List<Employee> selectAll(Statement stmt, List<Employee> empList) throws SQLException {
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
			empList.add(emp);
			
		}
		
		result.close();
		return empList;
	}

}
