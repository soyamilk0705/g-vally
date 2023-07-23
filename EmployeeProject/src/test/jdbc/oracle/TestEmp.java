package test.jdbc.oracle;

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
		// 프로젝트 Build Path - library에 objdbc6 등록 해야함 (잘 모르겠으면 JDBCProject 25번 주석 확인) 
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
		System.out.println("검색할 직원 이름을 입력하세요>");
		String name = in.nextLine();
		emp = selectByName(stmt, name);
		System.out.println(emp);
		
		// insert()
		result = insert(stmt, in);
		System.out.println(result);
		
		// delete()
		System.out.println("삭제할 직원의 이름을 입력하세요>");
		name = in.nextLine();
		emp = selectByName(stmt, name);
		System.out.println(emp);
		result = delete(stmt, emp.getId());
		System.out.println(result);
		
		// update()
		System.out.println("수정할 직원의 이름을 입력하세요>");
		name = in.nextLine();
		emp = selectByName(stmt, name);
		System.out.println(emp);
		result = update(stmt, in, emp.getId());
		System.out.println(result);
		
		// selectAll()
		listEmp = selectAll(stmt, listEmp);
		System.out.println(listEmp);
		
		stmt.close();
		conn.close();
		in.close();
	}
	
	

	private static Employee selectByName(Statement stmt, String name) throws SQLException {
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
	
	
	private static Employee selectById(Statement stmt, String id) throws SQLException {
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
	
	private static String insert(Statement stmt, Scanner in) throws SQLException {
		String returnResult;
		String name, id, pwd, phone, email;
		
		System.out.println("직원을 추가합니다.");
		System.out.println("직원아이디를 입력하세요>");
		id = in.nextLine();
		System.out.println("직원이름을 입력하세요>");
		name = in.nextLine();
		System.out.println("초기비밀번호를 입력하세요>");
		pwd = in.nextLine();
		System.out.println("직원 휴대폰 번호를 입력하세요>");
		phone = in.nextLine();
		System.out.println("직원 이메일을 입력하세요>");
		email = in.nextLine();
		
		String sql = "insert into EmpTBL (seq, id, pwd, name, phone, email, hireDT)\n"
				+ " values (seq_EmpTBL.NEXTVAL, '"+ id +"', '"+ pwd +"', '"+ name +"', '"+ phone +"', '"+ email + "', sysdate)";
		int result  = stmt.executeUpdate(sql);	// insert, delete, update 실행 시 사용
		Employee emp;
		
		if (result == 1) {	// 성공
			emp = selectByName(stmt, name);
			if (emp.getId().equals(id)) {
				returnResult = "직원정보가 정상적으로 입력되었습니다.";
			} else {
				returnResult = "직원정보가 등록되지 않았습니다. \n 다시 입력해주세요.";
			}
		} else {	// 실패 : return 0
			returnResult = "직원정보가 등록되지 않았습니다. \n 다시 입력해주세요.";
		}

		return returnResult;
	}
	
	/**
	 * TODO 과제1
	 * update 복습 & delete 적용, 고민(insert, select도 적용 여부)
	 * 
	 */
	private static String update(Statement stmt,  Scanner in, String id) throws SQLException {
		Connection conn = stmt.getConnection();		// stmt에서 getConnection()을 했기 때문에 close 하면 안됨
																			// (위에서 manager에서 connection을 하고 그 connection으로 stmt를 만듦
																			// 그 stmt에 connection을 받아온 것 뿐 새로 connection을 만든게 아님)
		conn.setAutoCommit(false);	// update 시 unique 값으로 주지 않은 문제 생김 -> 근데 이미 쿼리를 날려서 이미 데이터는 바뀜 
													// -> 이러한 문제를 해결하기 위해 auto commit 끔
		
		Employee emp;
		String returnResult;
		String newName, newPwd, newPhone, newEmail;
		
		emp = selectById(stmt, id);
		System.out.println(emp.getName() + "의 정보\n" + emp + "\n");
		System.out.println("[" + emp.getName() + "] : 변경할 이름(불필요시 엔터)>");
		newName = in.nextLine();
		System.out.println("[" + emp.getPwd() + "] : 변경할 비밀번호(불필요시 엔터)>");
		newPwd = in.nextLine();
		System.out.println("[" + emp.getPhone() + "] : 변경할 휴대폰 번호(불필요시 엔터)>");
		newPhone = in.nextLine();
		System.out.println("[" + emp.getEmail() + "] : 변경할 이메일(불필요시 엔터)>");
		newEmail = in.nextLine();

		String sql = "update EmpTBL set pwd = '" + (!newPwd.equals("")?newPwd:emp.getPwd()) + "', "
				+ "name = '" + (!newName.equals("")?newName:emp.getName()) + "', "
				+ "phone = '" + (!newPhone.equals("")?newPhone:emp.getPhone()) + "',  "
				+ "email = '" + (!newEmail.equals("")?newEmail:emp.getEmail()) + " "
				+ "where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			emp = selectById(stmt, id);
			returnResult = emp.getName() + "의 정보가 정상적으로 수정되었습니다.\n" + emp + "\n";
			conn.commit();
		} else if(result == 0) {
			returnResult = emp.getName() + "의 정보가 정상적으로 수정되지 않았습니다.\n" + emp + "\n수정할 정보를 다시 확인해주세요.";
			conn.rollback();
		} else {	// 같은 id가 여러명
			returnResult = emp.getId() +  "의 데이터가 2개 이상입니다. 따라서 입력한 정보가 수정되지 않았습니다."
					+ "\n 관리자에게 문의하세요.";
			conn.rollback();
		}
		
		conn.setAutoCommit(true);
		return returnResult;
	}
	
	private static String delete(Statement stmt, String id) throws SQLException {
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
	
	private static ArrayList<Employee> selectAll(Statement stmt, ArrayList<Employee> listEmp) throws SQLException {
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

}
