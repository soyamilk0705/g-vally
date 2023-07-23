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

		// 1. ����̹� �ε� �� ���
		// ������Ʈ Build Path - library�� objdbc6 ��� �ؾ��� (�� �𸣰����� JDBCProject 25�� �ּ� Ȯ��) 
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
		System.out.println("�˻��� ���� �̸��� �Է��ϼ���>");
		String name = in.nextLine();
		emp = selectByName(stmt, name);
		System.out.println(emp);
		
		// insert()
		result = insert(stmt, in);
		System.out.println(result);
		
		// delete()
		System.out.println("������ ������ �̸��� �Է��ϼ���>");
		name = in.nextLine();
		emp = selectByName(stmt, name);
		System.out.println(emp);
		result = delete(stmt, emp.getId());
		System.out.println(result);
		
		// update()
		System.out.println("������ ������ �̸��� �Է��ϼ���>");
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
		
		System.out.println("������ �߰��մϴ�.");
		System.out.println("�������̵� �Է��ϼ���>");
		id = in.nextLine();
		System.out.println("�����̸��� �Է��ϼ���>");
		name = in.nextLine();
		System.out.println("�ʱ��й�ȣ�� �Է��ϼ���>");
		pwd = in.nextLine();
		System.out.println("���� �޴��� ��ȣ�� �Է��ϼ���>");
		phone = in.nextLine();
		System.out.println("���� �̸����� �Է��ϼ���>");
		email = in.nextLine();
		
		String sql = "insert into EmpTBL (seq, id, pwd, name, phone, email, hireDT)\n"
				+ " values (seq_EmpTBL.NEXTVAL, '"+ id +"', '"+ pwd +"', '"+ name +"', '"+ phone +"', '"+ email + "', sysdate)";
		int result  = stmt.executeUpdate(sql);	// insert, delete, update ���� �� ���
		Employee emp;
		
		if (result == 1) {	// ����
			emp = selectByName(stmt, name);
			if (emp.getId().equals(id)) {
				returnResult = "���������� ���������� �ԷµǾ����ϴ�.";
			} else {
				returnResult = "���������� ��ϵ��� �ʾҽ��ϴ�. \n �ٽ� �Է����ּ���.";
			}
		} else {	// ���� : return 0
			returnResult = "���������� ��ϵ��� �ʾҽ��ϴ�. \n �ٽ� �Է����ּ���.";
		}

		return returnResult;
	}
	
	/**
	 * TODO ����1
	 * update ���� & delete ����, ���(insert, select�� ���� ����)
	 * 
	 */
	private static String update(Statement stmt,  Scanner in, String id) throws SQLException {
		Connection conn = stmt.getConnection();		// stmt���� getConnection()�� �߱� ������ close �ϸ� �ȵ�
																			// (������ manager���� connection�� �ϰ� �� connection���� stmt�� ����
																			// �� stmt�� connection�� �޾ƿ� �� �� ���� connection�� ����� �ƴ�)
		conn.setAutoCommit(false);	// update �� unique ������ ���� ���� ���� ���� -> �ٵ� �̹� ������ ������ �̹� �����ʹ� �ٲ� 
													// -> �̷��� ������ �ذ��ϱ� ���� auto commit ��
		
		Employee emp;
		String returnResult;
		String newName, newPwd, newPhone, newEmail;
		
		emp = selectById(stmt, id);
		System.out.println(emp.getName() + "�� ����\n" + emp + "\n");
		System.out.println("[" + emp.getName() + "] : ������ �̸�(���ʿ�� ����)>");
		newName = in.nextLine();
		System.out.println("[" + emp.getPwd() + "] : ������ ��й�ȣ(���ʿ�� ����)>");
		newPwd = in.nextLine();
		System.out.println("[" + emp.getPhone() + "] : ������ �޴��� ��ȣ(���ʿ�� ����)>");
		newPhone = in.nextLine();
		System.out.println("[" + emp.getEmail() + "] : ������ �̸���(���ʿ�� ����)>");
		newEmail = in.nextLine();

		String sql = "update EmpTBL set pwd = '" + (!newPwd.equals("")?newPwd:emp.getPwd()) + "', "
				+ "name = '" + (!newName.equals("")?newName:emp.getName()) + "', "
				+ "phone = '" + (!newPhone.equals("")?newPhone:emp.getPhone()) + "',  "
				+ "email = '" + (!newEmail.equals("")?newEmail:emp.getEmail()) + " "
				+ "where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			emp = selectById(stmt, id);
			returnResult = emp.getName() + "�� ������ ���������� �����Ǿ����ϴ�.\n" + emp + "\n";
			conn.commit();
		} else if(result == 0) {
			returnResult = emp.getName() + "�� ������ ���������� �������� �ʾҽ��ϴ�.\n" + emp + "\n������ ������ �ٽ� Ȯ�����ּ���.";
			conn.rollback();
		} else {	// ���� id�� ������
			returnResult = emp.getId() +  "�� �����Ͱ� 2�� �̻��Դϴ�. ���� �Է��� ������ �������� �ʾҽ��ϴ�."
					+ "\n �����ڿ��� �����ϼ���.";
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
			returnResult = "�̹� ������ �����Դϴ�.";
			return returnResult;
		}
		
		String sql = "delete from EmpTBL where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		if(result == 1) {
			returnResult = "���� ������ �����Ǿ����ϴ�.";
		} else {
			returnResult = "���� ���� ������ �����߽��ϴ�. �ٽ� �Է����ּ���";
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
