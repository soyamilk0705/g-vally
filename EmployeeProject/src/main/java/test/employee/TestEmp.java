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

		// 1. ����̹� �ε� �� ���
		Class.forName(className);

		// 2. ���� ������
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		Connection conn = DriverManager.getConnection(url, user, password);

		// 3. ��ɹ� �����ϱ�
		Statement stmt = conn.createStatement();

		// 4. ��ɹ� �����ϱ�
		ArrayList<Employee> listEmp = new ArrayList<Employee>();
		Employee emp;
		String result;

		// select()
		Scanner in = new Scanner(System.in);
		System.out.println("���� �̸��� �Է��ϼ���>");
		String name = in.nextLine();
		
		emp = select(stmt, name);
		System.out.println(emp);
		
		// update()
		System.out.println("��ȭ��ȣ�� ������ ������ �̸��� �Է��ϼ���>");
		name = in.nextLine();
		
		emp = select(stmt, name);
		result = updatePhone(stmt, name, in);
		System.out.println(result);
		
		// delete()
		System.out.println("������ ������ �̸��� �Է��ϼ���>");
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
			message = "������ �����Դϴ�.";
			return message;
		}
		
		System.out.println("���� ��ȭ��ȣ�� �Է��ϼ���>");
		String phone = in.nextLine();
		
		String sql = "update EmpTBL set phone = '" + phone + "' where name = '" + name + "'";
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			message = "��ȭ��ȣ�� �����Ǿ����ϴ�.";
		} else {
			message = "��ȭ��ȣ ������ �����߽��ϴ�.";
		}
		
		return message;
	}
	
	private static String delete(Statement stmt, String name) throws SQLException {
		Employee emp;
		String message;
		
		emp = select(stmt, name);
		if (emp == null) {
			message = "�̹� ������ �����Դϴ�.";
			return message;
		}
		
		String sql = "delete from EmpTBL where name = '" + name + "'";
		int result = stmt.executeUpdate(sql);
		
		if(result == 1) {
			message = "���� ������ �����Ǿ����ϴ�.";
		} else {
			message = "���� ���� ������ �����߽��ϴ�. �ٽ� �Է����ּ���";
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
