package test.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {
	
	private ConnectionPool pool;
	private EmployeeDAO dao;

	public EmployeeDTO selectByName(String name) throws SQLException {	// jsp���� static �ƴѰ� ��ȣ(��� ��� ����)
		EmployeeDTO emp = dao.selectByName(name);
		return emp;
	}
	
	public EmployeeDTO selectById(String id) throws SQLException {
		EmployeeDTO emp = dao.selectById(id);
		return emp;
	}
	
	public String delete(String id) throws SQLException {
		EmployeeDTO emp;
		String returnResult;
		
		int result = dao.delete(id);
		emp = selectById(id);
		
		if(result == 1) {
			if (emp == null) {
				returnResult = "ID : " + id + "�� �������� " + result + "���� �����Ǿ����ϴ�.\n";
			} else {
				returnResult = emp.getId() + "�� �����Ͱ� 2�� �̻��Դϴ�. ���� �����Ϸ��� ������ ���󺹱��˴ϴ�.\n"
						+ "<br /> �����ڿ��� �����ϼ���.";
			}
		} else {		// �������� ������ ���
			returnResult = emp.getId() + "�� �����Ͱ� 2�� �̻��Դϴ�. ���� �����Ϸ��� ������ ���󺹱��˴ϴ�.\n"
					+ "<br /> �����ڿ��� �����ϼ���.";
		}
		
		return returnResult;
	}
	
	public ArrayList<EmployeeDTO> selectAll() throws SQLException {
		ArrayList<EmployeeDTO> listEmp = dao.selectAll();
		return listEmp;
	}
	
	public String insert(EmployeeDTO emp) throws SQLException {
		int result = dao.insert(emp);
		String returnResult;		
		String id =emp.getId();
		
		if (result == 1) {	// ����
			emp = selectByName(emp.getName());	// emp(����) : ����� �Է� ������
																				// emp(new) : DB���� ������ ������
			if (emp.getId().equals(id)) {						
				returnResult = "���������� ���������� �ԷµǾ����ϴ�.<br />" + emp;
			} else {
				returnResult = "���������� ��ϵ��� �ʾҽ��ϴ�. <br />�ٽ� �Է����ּ���.";
			}
		} else {	// ���� : return 0
			returnResult = "���������� ��ϵ��� �ʾҽ��ϴ�.<br /> �ٽ� �Է����ּ���.";
		}

		return returnResult;
	}
	
	
	public String update(EmployeeDTO emp) throws SQLException {
		int result = dao.update(emp);
		
		String returnResult;
		
		if (result == 1) {
			emp = selectById(emp.getId());		// ���ո���: service���� selectById�� ���� dao���� selectById�� ���� ���ϰ� �� �� �������(�� �������� �Ǵ� �Ұ�)
			returnResult = emp.getName() + "�� ������ ���������� �����Ǿ����ϴ�.<br />" + emp + "<br />";

		} else if(result == 0) {
			returnResult = emp.getName() + "�� ������ ���������� �������� �ʾҽ��ϴ�.<br />" + emp + "<br />������ ������ �ٽ� Ȯ�����ּ���.";

		} else {	// ���� id�� ������
			returnResult = emp.getId() +  "�� �����Ͱ� 2�� �̻��Դϴ�. ���� �Է��� ������ �������� �ʾҽ��ϴ�."
					+ "<br /> �����ڿ��� �����ϼ���.";
		}
		
		return returnResult;
	}
	
	public EmployeeService() throws SQLException {
		this.dao = new EmployeeDAO();
		this.pool = dao.getConnectionPool();
//		dao.close();
	}
}

