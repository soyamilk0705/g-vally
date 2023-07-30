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
	public EmployeeDTO selectByName(String name) throws SQLException {	// jsp���� static �ƴѰ� ��ȣ(��� ��� ����)
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
		int result  = stmt.executeUpdate(sql);	// insert, delete, update ���� �� ���
		close();
		return result;
	}
	
	public int update(EmployeeDTO emp) throws SQLException {
		conn = getConnection();
		stmt = conn.createStatement();
//		Connection conn = stmt.getConnection();		// stmt���� getConnection()�� �߱� ������ close �ϸ� �ȵ�
																			// (������ manager���� connection�� �ϰ� �� connection���� stmt�� ����
																			// �� stmt�� connection�� �޾ƿ� �� �� ���� connection�� ����� �ƴ�)
		conn.setAutoCommit(false);	// update �� unique ������ ���� ���� ���� ���� -> �ٵ� �̹� ������ ������ �̹� �����ʹ� �ٲ� 
													// -> �̷��� ������ �ذ��ϱ� ���� auto commit ��
		
		String sql = "update EmpTBL set pwd = '" + emp.getPwd() + "', "
				+ "name = '" + emp.getName() + "', "
				+ "phone = '" + emp.getPhone() + "', "
				+ "email = '" + emp.getEmail() + "' "
				+ "where id = '" + emp.getId() + "'";
		
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			conn.commit();
		} else {	// ���� id�� ������ �Ǵ� �������� ����
			conn.rollback();		// DB �������� ����Ǵ� ��
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
//		try {		// ������ �ذ� �ؾߵ� : try-catch ���� throw ���� ������ �����ڰ� �ذ� �� �� �ִ��ķ� ����
//			Class.forName(className);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("����Ŭ ����̹����� ã�� �� �����ϴ�.\n "
//					+ "lib ������ ojdbc*.jar �� Ȯ�����ּ���.");
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
			System.out.println("DBMS ���� Ȯ�� �ʿ�!!!\n"
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

