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
	public Employee selectByName(String name) throws SQLException {	// jsp���� static �ƴѰ� ��ȣ(��� ��� ����)
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
	
	public Employee selectById(String id) throws SQLException {
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
	
	public int delete(String id) throws SQLException {
		Employee emp;
		String returnResult;
		
		String sql = "delete from EmpTBL where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
//		emp = selectById(id);
		
		if (result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		
		return result;
	}
	
	public ArrayList<Employee> selectAll() throws SQLException {
		String sql = "select * from EmpTBL";
		ResultSet result = stmt.executeQuery(sql);
		ArrayList<Employee> listEmp = new ArrayList<Employee>();
		
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
	
	public int insert(Employee emp) throws SQLException {
		String returnResult;		
		String id =emp.getId();
		String sql = "insert into EmpTBL (seq, id, pwd, name, phone, email, hireDT)\n"
				+ " values (seq_EmpTBL.NEXTVAL, '"+ emp.getId() +"', '"+ emp.getPwd() +"', '"+ emp.getName() +"', '"+ emp.getPhone() +"', '"+ emp.getEmail() + "', sysdate)";
		int result  = stmt.executeUpdate(sql);	// insert, delete, update ���� �� ���

		return result;
	}
	
	public int update(Employee emp) throws SQLException {
		Connection conn = stmt.getConnection();		// stmt���� getConnection()�� �߱� ������ close �ϸ� �ȵ�
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
		return result;
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
			conn = pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DBMS ���� Ȯ�� �ʿ�!!!\n"
					+ url + "\n" + user + "\n" + password + "\n");
		}
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			
			while(true) {
				try {
					Thread.sleep(300);
				} catch(InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					stmt = conn.createStatement();
				} catch(SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		}
		
		return pool;
	}
}

