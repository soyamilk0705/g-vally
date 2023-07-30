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

	public EmployeeDTO selectByName(String name) throws SQLException {	// jsp에서 static 아닌거 선호(사실 상관 없음)
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
				returnResult = "ID : " + id + "의 직원정보 " + result + "개가 삭제되었습니다.\n";
			} else {
				returnResult = emp.getId() + "의 데이터가 2개 이상입니다. 따라서 삭제하려는 정보는 원상복구됩니다.\n"
						+ "<br /> 관리자에게 문의하세요.";
			}
		} else {		// 여러명을 지웠을 경우
			returnResult = emp.getId() + "의 데이터가 2개 이상입니다. 따라서 삭제하려는 정보는 원상복구됩니다.\n"
					+ "<br /> 관리자에게 문의하세요.";
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
		
		if (result == 1) {	// 성공
			emp = selectByName(emp.getName());	// emp(현재) : 사용자 입력 데이터
																				// emp(new) : DB에서 가져온 데이터
			if (emp.getId().equals(id)) {						
				returnResult = "직원정보가 정상적으로 입력되었습니다.<br />" + emp;
			} else {
				returnResult = "직원정보가 등록되지 않았습니다. <br />다시 입력해주세요.";
			}
		} else {	// 실패 : return 0
			returnResult = "직원정보가 등록되지 않았습니다.<br /> 다시 입력해주세요.";
		}

		return returnResult;
	}
	
	
	public String update(EmployeeDTO emp) throws SQLException {
		int result = dao.update(emp);
		
		String returnResult;
		
		if (result == 1) {
			emp = selectById(emp.getId());		// 불합리함: service에서 selectById를 할지 dao에서 selectById를 쓸지 정하고 난 후 지울거임(내 마음데로 판단 불가)
			returnResult = emp.getName() + "의 정보가 정상적으로 수정되었습니다.<br />" + emp + "<br />";

		} else if(result == 0) {
			returnResult = emp.getName() + "의 정보가 정상적으로 수정되지 않았습니다.<br />" + emp + "<br />수정할 정보를 다시 확인해주세요.";

		} else {	// 같은 id가 여러명
			returnResult = emp.getId() +  "의 데이터가 2개 이상입니다. 따라서 입력한 정보가 수정되지 않았습니다."
					+ "<br /> 관리자에게 문의하세요.";
		}
		
		return returnResult;
	}
	
	public EmployeeService() throws SQLException {
		this.dao = new EmployeeDAO();
		this.pool = dao.getConnectionPool();
//		dao.close();
	}
}

