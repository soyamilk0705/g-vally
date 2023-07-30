package test.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDAO {
	private Statement stmt;
	private Connection conn;
	private ConnectionPool pool;

	// TODO Auto-generated method stub
	public EmployeeDTO selectByName(String name) throws SQLException {	// jsp에서 static 아닌거 선호(사실 상관 없음)
		conn = getConnection();
		stmt = conn.createStatement();
		
		EmployeeDTO emp;
		String sql = "select * from EmpTBL where name = '" + name + "'";
		ResultSet result = stmt.executeQuery(sql);
		
		if(result.next()) {
			emp = new EmployeeDTO(result.getString("id"), result.getString("pwd"), result.getString("name"),
												result.getString("phone"), result.getString("email"), result.getString("hireDT"));
		} else {
			emp = null;
		}
		
		result.close();
		close();
		return emp;
	}
	
	public EmployeeDTO selectById(String id) throws SQLException {
		conn = getConnection();
		stmt = conn.createStatement();
		
		EmployeeDTO emp;
		String sql = "select * from EmpTBL where id = '" + id + "'";
		ResultSet result = stmt.executeQuery(sql);
		
		if(result.next()) {
			emp = new EmployeeDTO(result.getString("id"), result.getString("pwd"), result.getString("name"),
												result.getString("phone"), result.getString("email"), result.getString("hireDT"));
		} else {
			emp = null;
		}
		
		result.close();
		close();
		return emp;
	}
	
	public int delete(String id) throws SQLException {
		conn = getConnection();
		stmt = conn.createStatement();
		
		EmployeeDTO emp;
		String returnResult;
		
		String sql = "delete from EmpTBL where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
//		emp = selectById(id);
		
		if (result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		close();
		return result;
	}
	
	public ArrayList<EmployeeDTO> selectAll() throws SQLException {
		conn = getConnection();
		stmt = conn.createStatement();
		
		String sql = "select * from EmpTBL";
		ResultSet result = stmt.executeQuery(sql);
		ArrayList<EmployeeDTO> listEmp = new ArrayList<EmployeeDTO>();
		
		while(result.next()) {
			String id = result.getString("id");
			String pwd = result.getString("pwd");
			String name = result.getString("name");
			String phone = result.getString("phone");
			String email = result.getString("email");
			String hireDT = result.getString("hireDT");
			
			EmployeeDTO emp = new EmployeeDTO(id, pwd, name, phone, email, hireDT);
			listEmp.add(emp);
			
		}
		
		result.close();
		close();
		return listEmp;
	}
	
	public int insert(EmployeeDTO emp) throws SQLException {
		conn = getConnection();
		stmt = conn.createStatement();
		
		String returnResult;		
		String id =emp.getId();
		String sql = "insert into EmpTBL (seq, id, pwd, name, phone, email, hireDT)\n"
				+ " values (seq_EmpTBL.NEXTVAL, '"+ emp.getId() +"', '"+ emp.getPwd() +"', '"+ emp.getName() +"', '"+ emp.getPhone() +"', '"+ emp.getEmail() + "', sysdate)";
		int result  = stmt.executeUpdate(sql);	// insert, delete, update 실행 시 사용
		close();
		return result;
	}
	
	public int update(EmployeeDTO emp) throws SQLException {
		conn = getConnection();
		stmt = conn.createStatement();
//		Connection conn = stmt.getConnection();		// stmt에서 getConnection()을 했기 때문에 close 하면 안됨
																			// (위에서 manager에서 connection을 하고 그 connection으로 stmt를 만듦
																			// 그 stmt에 connection을 받아온 것 뿐 새로 connection을 만든게 아님)
		conn.setAutoCommit(false);	// update 시 unique 값으로 주지 않은 문제 생김 -> 근데 이미 쿼리를 날려서 이미 데이터는 바뀜 
													// -> 이러한 문제를 해결하기 위해 auto commit 끔
		
		String sql = "update EmpTBL set pwd = '" + emp.getPwd() + "', "
				+ "name = '" + emp.getName() + "', "
				+ "phone = '" + emp.getPhone() + "', "
				+ "email = '" + emp.getEmail() + "' "
				+ "where id = '" + emp.getId() + "'";
		
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			conn.commit();
		} else {	// 같은 id가 여러명 또는 존재하지 않음
			conn.rollback();		// DB 서버에서 수행되는 일
		}
		
		conn.setAutoCommit(true);
		close();
		return result;
	}
	
	public Connection getConnection() throws SQLException{
		return pool.getConnection();
	}
	
	public void close() throws SQLException {
		stmt.close();
//		conn.close();
		pool.releaseConnection(conn);
	}
	
	public EmployeeDAO() {
	}
	
	public ConnectionPool getConnectionPool() {
		
//		String className = "oracle.jdbc.driver.OracleDriver";		
//
//		try {		// 웹에서 해결 해야됨 : try-catch 쓸지 throw 쓸지 선택은 개발자가 해결 할 수 있느냐로 결정
//			Class.forName(className);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("오라클 드라이버가를 찾을 수 없습니다.\n "
//					+ "lib 폴더에 ojdbc*.jar 를 확인해주세요.");
//		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		try {
//			conn = DriverManager.getConnection(url, user, password);
			pool = new ConnectionPool(url, user, password, 3, 5, true, 10);
//			conn = pool.getConnection(true, 5);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DBMS 정보 확인 필요!!!\n"
					+ url + "\n" + user + "\n" + password + "\n");
		}
		
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//			while(true) {
//				try {
//					Thread.sleep(300);
//				} catch(InterruptedException e1) {
//					e1.printStackTrace();
//				}
//				try {
//					stmt = conn.createStatement();
//				} catch(SQLException e1) {
//					System.out.println(e1.getMessage());
//				}
//			}
//		}
		
		return pool;
	}
}

