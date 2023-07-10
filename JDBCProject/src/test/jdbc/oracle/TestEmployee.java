package test.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * JDBC를 활용하여 Oracle DBMS에 연결하고
 * EmpTBL에 update(insert/delete/update)와 select를 테스트한다.
 * 
 * @author user04
 *
 */
public class TestEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String className = "oracle.jdbc.driver.OracleDriver";
		
//		1. 드라이버 로딩 및 등록
		// 프로젝트 오른쪽 버튼 클릭 -> Build Path -> Configure Build Path -> Libraries 
		// -> Add External JARs 클릭 -> C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 찾아가서 objdbc6 선택 -> Apply	
		Class.forName(className);	// DriverManager에 등록은 자동
		
//		2. 연결 얻어오기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	// jdbc:oracle:thin: -> 프로토콜(약속된 서비스, ex. http, smtp 등등) @localhost -> 도메인, 1521 -> 포트번호, xe -> 서비스 id(어디까지 쓸 수 있는지 알려줌)
		String user = "hr";
		String password = "hr";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
//		3. 명령문 생성하기
		Statement stmt = conn.createStatement();
		
//		4. 명령 실행하기
//		Employee[] emps = new Employee[10];
//		int i =0;
		
		ArrayList<Employee> listEmp = new ArrayList<Employee>();
		Employee emp;
		String result;
//		listEmp.add("hello"); String type 이여서 오류남
		
		// 1. 사용자 입력
		Scanner in = new Scanner(System.in);
		System.out.println("직원이름을 입력하세요>");
		String name = in.nextLine();
//		
//		// 2. name으로 직원 정보를 찾아오는 함수 : select()
//		emp = selectByName(stmt, name);
//		System.out.println(emp);
		
		// 직원 추가(신입, 경력 직원 입사) : insert()
//		result = insert(stmt, in);
//		System.out.println(result);
		
		// TODO
		// 과제1. 직원정보를 삭제 함수 : delete()
//		emp = selectByName(stmt, name);
//		System.out.println(emp);
//		result = delete1(stmt, emp.getId());
//		System.out.println(result);
		
		// 과제2. 직원정보를 변경 함수 : update()
		emp = selectByName(stmt, name);		// 검증하기 위해서 한번 더 사용
		System.out.println(emp);
		result = update(stmt, in, emp.getId());
		System.out.println(result);
		
		// 전체 직원 검색
		listEmp = selectAll(stmt, listEmp);
		System.out.println(listEmp);
		
//		6. 연결 해제 : close()
		stmt.close();
		conn.close();
		in.close();
		
		// session = 서버 안의 나만의 공간
		//	session이란 공간은 connection으로 만들어짐
				
		// www.naver.com
		// naver : 도메인(ip 주소를 그대로 사용하기 힘드니 도메인을 구매해 사람들에게 쓰기 좋게 만듦)

		// L4 스위치 : 싱글 도메인을 멀티 호스트로 할당해주는 장치
		// 네트워크 카드 
		// 포트번호
		
	}

	private static String insert(Statement stmt, Scanner in) throws SQLException {
		// TODO Auto-generated method stub
		String returnResult;
		String name, id, pwd, phone, email;
		
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
	
	private static Employee selectByName (Statement stmt, String name) throws SQLException {
		Employee emp;
		String sql = "select * from EmpTBL where name ='" + name + "'";
		ResultSet result  = stmt.executeQuery(sql);
		
		if (result.next()) {
			String id = result.getString("id");
			String pwd = result.getString("pwd");
			name = result.getString("name");
			String phone = result.getString("phone");
			String email = result.getString("email");
			String hireDT = result.getString("hireDT");
			
			emp = new Employee(id, pwd, name, phone, email, hireDT);
			
		} else {
			emp = null;
		}
		
		result.close();
		return emp;
	}
	
	
	private static Employee selectById (Statement stmt, String id) throws SQLException {
		Employee emp;
		String sql = "select * from EmpTBL where id ='" + id + "'";
		ResultSet result  = stmt.executeQuery(sql);
		
		if (result.next()) {
			emp = new Employee(result.getString("id"), result.getString("pwd"), result.getString("name"), result.getString("phone"), result.getString("email"), result.getString("hireDT"));
		} else {
			emp = null;
		}
		
		result.close();
		return emp;
	}
	
	private static String delete1(Statement stmt, String id) throws SQLException {
		Employee emp;
		String returnResult;
		
		emp = selectById(stmt, id);
		if (emp == null){
			returnResult = "ID : " + id + "의 직원정보가 이미 삭제되었습니다.\n";
			return returnResult;
		}
		
		String sql = "delete from EmpTBL where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			returnResult = "직원정보가 정상적으로 삭제되었습니다.";
		} else {
			returnResult = "직원정보가 삭제되지 않았습니다. \nid를 다시 입력해주세요.";
		}
		
		return returnResult;
	}
	
	// 삭제 후 체킹 하기 때문에 좋은 코드 아님
	private static String delete2(Statement stmt, String id) throws SQLException {
		Employee emp;
		String returnResult;
		
		String sql = "delete from EmpTBL where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		emp = selectById(stmt, id);
		if (emp == null){
			returnResult = "ID : " + id + "의 직원정보" + result + "개가 삭제되었습니다.";
		}  else {
			returnResult = "직원정보가 삭제되지 않았습니다. \nId : " + id + "를 다시 입력해주세요.";
		}
		
		return returnResult;
	}
	
	private static String update(Statement stmt, Scanner in , String id) throws SQLException {
		String newId, pwd, name, phone, email, returnResult;
		Employee emp;
		
		System.out.println("변경할 직원아이디를 입력하세요>");
		newId = in.nextLine();
		System.out.println("변경할 직원이름을 입력하세요>");
		name = in.nextLine();
		System.out.println("변경할 초기비밀번호를 입력하세요>");
		pwd = in.nextLine();
		System.out.println("변경할 직원 휴대폰 번호를 입력하세요>");
		phone = in.nextLine();
		System.out.println("변경할 직원 이메일을 입력하세요>");
		email = in.nextLine();
		
		String sql = "update EmpTBL\n"
				+ " set id = '" + newId + "' , pwd = '" + pwd + "', name = '" + name + "', phone = '" + phone + "', email = '" + email + "'\n"
				+ " where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			emp = selectByName(stmt, name);
			if (emp.getId().equals(newId)) {
				returnResult = "직원 정보가 수정되었습니다.";
			} else {
				returnResult = "직원 정보 수정에 실패했습니다.";
			}
		} else {
			returnResult = "직원 정보 수정에 실패했습니다.";
		}
		
		return returnResult;
	}

	private static ArrayList<Employee> selectAll(Statement stmt, ArrayList<Employee> listEmp) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from EmpTBL";
		ResultSet result = stmt.executeQuery(sql);
		
//		5. 결과테이블에서 데이터 추출
//		if (result.next()) {	// select 했을 때 데이터 없을 수도 있으니까
		while(result.next()) {	
//			String colStr = result.getString(1);		// sql은 1번부터 시작
			String id = result.getString("id");
			String pwd = result.getString("pwd");
			String name = result.getString("name");
			String phone = result.getString("phone");
			String email = result.getString("email");
			String hireDT = result.getString("hireDT");		// Date
			
//			System.out.println(name);
			
			// 레코드 한 개를 하나의 객체로 만들자.
//			Employee emp = new Employee();
//			emp.setId(id);
//			emp.setPwd(pwd);
//			emp.setName(name);
//			emp.setPhone(phone);
//			emp.setEmail(email);
//			emp.setHireDT(hireDT);
			
			Employee emp = new Employee(id, pwd, name, phone, email, hireDT);
//			emps[i++] = emp;	// ++i : 먼저 증가, i++ : i를 가지고 명령 실행 후 i가 증가
			listEmp.add(emp);
//			System.out.println(emp);			
		}
//		} else {
//		System.out.println("no data");	// no data 나오면 commit 했는지 확인
//	}
	
		result.close();
		
		return listEmp;
	}
	
	

}
