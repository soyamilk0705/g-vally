package test.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * JDBC�� Ȱ���Ͽ� Oracle DBMS�� �����ϰ�
 * EmpTBL�� update(insert/delete/update)�� select�� �׽�Ʈ�Ѵ�.
 * 
 * @author user04
 *
 */
public class TestEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String className = "oracle.jdbc.driver.OracleDriver";
		
//		1. ����̹� �ε� �� ���
		// ������Ʈ ������ ��ư Ŭ�� -> Build Path -> Configure Build Path -> Libraries 
		// -> Add External JARs Ŭ�� -> C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib ã�ư��� objdbc6 ���� -> Apply	
		Class.forName(className);	// DriverManager�� ����� �ڵ�
		
//		2. ���� ������
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	// jdbc:oracle:thin: -> ��������(��ӵ� ����, ex. http, smtp ���) @localhost -> ������, 1521 -> ��Ʈ��ȣ, xe -> ���� id(������ �� �� �ִ��� �˷���)
		String user = "hr";
		String password = "hr";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
//		3. ��ɹ� �����ϱ�
		Statement stmt = conn.createStatement();
		
//		4. ��� �����ϱ�
//		Employee[] emps = new Employee[10];
//		int i =0;
		
		ArrayList<Employee> listEmp = new ArrayList<Employee>();
		Employee emp;
		String result;
//		listEmp.add("hello"); String type �̿��� ������
		
		// 1. ����� �Է�
		Scanner in = new Scanner(System.in);
		System.out.println("�����̸��� �Է��ϼ���>");
		String name = in.nextLine();
//		
//		// 2. name���� ���� ������ ã�ƿ��� �Լ� : select()
//		emp = selectByName(stmt, name);
//		System.out.println(emp);
		
		// ���� �߰�(����, ��� ���� �Ի�) : insert()
//		result = insert(stmt, in);
//		System.out.println(result);
		
		// TODO
		// ����1. ���������� ���� �Լ� : delete()
//		emp = selectByName(stmt, name);
//		System.out.println(emp);
//		result = delete1(stmt, emp.getId());
//		System.out.println(result);
		
		// ����2. ���������� ���� �Լ� : update()
		emp = selectByName(stmt, name);		// �����ϱ� ���ؼ� �ѹ� �� ���
		System.out.println(emp);
		result = update(stmt, in, emp.getId());
		System.out.println(result);
		
		// ��ü ���� �˻�
		listEmp = selectAll(stmt, listEmp);
		System.out.println(listEmp);
		
//		6. ���� ���� : close()
		stmt.close();
		conn.close();
		in.close();
		
		// session = ���� ���� ������ ����
		//	session�̶� ������ connection���� �������
				
		// www.naver.com
		// naver : ������(ip �ּҸ� �״�� ����ϱ� ����� �������� ������ ����鿡�� ���� ���� ����)

		// L4 ����ġ : �̱� �������� ��Ƽ ȣ��Ʈ�� �Ҵ����ִ� ��ġ
		// ��Ʈ��ũ ī�� 
		// ��Ʈ��ȣ
		
	}

	private static String insert(Statement stmt, Scanner in) throws SQLException {
		// TODO Auto-generated method stub
		String returnResult;
		String name, id, pwd, phone, email;
		
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
	
	/**
	 * ������ ���������� ������ üũ�ϴ� ���
	 * @param stmt
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	private static String delete1(Statement stmt, String id) throws SQLException {
		Employee emp;
		String returnResult;
		
		emp = selectById(stmt, id);
		if (emp == null){
			returnResult = "ID : " + id + "�� ���������� �̹� �����Ǿ����ϴ�.\n";
			return returnResult;
		}
		
		String sql = "delete from EmpTBL where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			returnResult = "���������� ���������� �����Ǿ����ϴ�.";
		} else {
			returnResult = "���������� �������� �ʾҽ��ϴ�. \nid�� �ٽ� �Է����ּ���.";
		}
		
		return returnResult;
	}
	
	
	/**
	 * ���� ������ ������ �� ���������� �����Ǿ������� Ȯ���Ѵ�.
	 * (���� �� üŷ �ϱ� ������ ���� �ڵ� �ƴ�)
	 * @param stmt
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	private static String delete2(Statement stmt, String id) throws SQLException {
		Employee emp;
		String returnResult;
		
		String sql = "delete from EmpTBL where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		emp = selectById(stmt, id);
		if (emp == null){
			returnResult = "ID : " + id + "�� ��������" + result + "���� �����Ǿ����ϴ�.";
		}  else {
			returnResult = "���������� �������� �ʾҽ��ϴ�. \nId : " + id + "�� �ٽ� �Է����ּ���.";
		}
		
		return returnResult;
	}
	
	private static String update(Statement stmt, Scanner in , String id) throws SQLException {
		String newId, pwd, name, phone, email, returnResult;
		Employee emp;
		
		System.out.println("������ �������̵� �Է��ϼ���>");
		newId = in.nextLine();
		System.out.println("������ �����̸��� �Է��ϼ���>");
		name = in.nextLine();
		System.out.println("������ �ʱ��й�ȣ�� �Է��ϼ���>");
		pwd = in.nextLine();
		System.out.println("������ ���� �޴��� ��ȣ�� �Է��ϼ���>");
		phone = in.nextLine();
		System.out.println("������ ���� �̸����� �Է��ϼ���>");
		email = in.nextLine();
		
		String sql = "update EmpTBL\n"
				+ " set id = '" + newId + "' , pwd = '" + pwd + "', name = '" + name + "', phone = '" + phone + "', email = '" + email + "'\n"
				+ " where id = '" + id + "'";
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			emp = selectByName(stmt, name);
			if (emp.getId().equals(newId)) {
				returnResult = "���� ������ �����Ǿ����ϴ�.";
			} else {
				returnResult = "���� ���� ������ �����߽��ϴ�.";
			}
		} else {
			returnResult = "���� ���� ������ �����߽��ϴ�.";
		}
		
		return returnResult;
	}

	private static ArrayList<Employee> selectAll(Statement stmt, ArrayList<Employee> listEmp) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from EmpTBL";
		ResultSet result = stmt.executeQuery(sql);
		
//		5. ������̺��� ������ ����
//		if (result.next()) {	// select ���� �� ������ ���� ���� �����ϱ�
		while(result.next()) {	
//			String colStr = result.getString(1);		// sql�� 1������ ����
			String id = result.getString("id");
			String pwd = result.getString("pwd");
			String name = result.getString("name");
			String phone = result.getString("phone");
			String email = result.getString("email");
			String hireDT = result.getString("hireDT");		// Date
			
//			System.out.println(name);
			
			// ���ڵ� �� ���� �ϳ��� ��ü�� ������.
//			Employee emp = new Employee();
//			emp.setId(id);
//			emp.setPwd(pwd);
//			emp.setName(name);
//			emp.setPhone(phone);
//			emp.setEmail(email);
//			emp.setHireDT(hireDT);
			
			Employee emp = new Employee(id, pwd, name, phone, email, hireDT);
//			emps[i++] = emp;	// ++i : ���� ����, i++ : i�� ������ ��� ���� �� i�� ����
			listEmp.add(emp);
//			System.out.println(emp);			
		}
//		} else {
//		System.out.println("no data");	// no data ������ commit �ߴ��� Ȯ��
//	}
	
		result.close();
		
		return listEmp;
	}
	
	

}
