package intranet.biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectionPool;
import intranet.dao.EmployeeDAO;
import intranet.entity.EmployeeDTO;

public class EmployeeService {
	private ConnectionPool pool;
	private EmployeeDAO dao;
	

	public EmployeeDTO login(EmployeeDTO emp) throws SQLException {
		EmployeeDTO empFromDB = dao.selectById(emp.getId());
		System.out.println("login() :: " + empFromDB);
		if((empFromDB != null) && (emp.getPwd().trim().equals(empFromDB.getPwd())))
			return empFromDB;
		else
			return null;
	}
	/**
	 * 과제 1 : update 복습 & delete 적용, 고민(insert(), select...()도 적용 여부)
	 * 
	 * @param stmt
	 * @param id
	 * @param in
	 * @return
	 * @throws SQLException
	 */
	public String update(EmployeeDTO emp) throws SQLException {
		int result = dao.update(emp);
		String returnResult;
		//		5. 결과테이블에서 데이터 추출
		if(result == 1) {
//			emp = selectById(emp.getId()); //불합리함.
			returnResult = emp.getName() + "의 정보가 정상적으로 수정되었습니다.\n<br/>" + emp +"\n<br/>";
		}else if(result == 0) {
			returnResult = emp.getName() + "의 정보가 정상적으로 수정되지 않았습니다.\n<br/>" + emp 
													  +"\n<br/>수정할 정보를 다시 확인해주세요.";
		}else {//같은 id가 여러명
			returnResult = emp.getId() + "의 데이터가 2개 이상입니다. 따라서 입력한 정보는 수정되지 않았습니다.\n" 
												+ "<br/>관리자에게 문의하세요.\n<br/>" + emp + "\n";
		}
		return returnResult;
	}

	public String delete(EmployeeDTO emp) throws SQLException {
		int result = dao.delete(emp);
		String returnResult;
		//		5. 결과테이블에서 데이터 추출
		if(result == 1) {
//			EmployeeDTO resultEmp = selectById(emp.getId()); //불합리함.
			returnResult = emp.getName() + "의 정보가 정상적으로 삭제되었습니다.\n<br/>" + emp +"\n<br/>";
		}else if(result == 0) {
			returnResult = emp.getName() + "의 정보가 정상적으로 삭제되지 않았습니다.\n<br/>" + emp 
													  +"\n<br/>삭제할 정보를 다시 확인해주세요.";
		}else {//같은 id가 여러명
			returnResult = "ID(" + emp.getId() + ")의 데이터가 2개 이상입니다. 따라서 입력한 정보는 삭제되지 않았습니다.\n" 
												+ "<br/>관리자에게 문의하세요.\n<br/>" + emp + "\n";
		}
		return returnResult;
	}

	public String insert(EmployeeDTO emp) throws SQLException {
		int result = dao.insert(emp);
		String returnResult;
		String id = emp.getId();
		//		5. 결과테이블에서 데이터 추출
		if(result == 1) {
//			emp = selectByName(emp.getName());
			if (emp.getId().equals(id)) {
				returnResult = "직원정보가 정상적으로 입력되었습니다.<br/>"+emp;
			}else
				returnResult = "직원정보가 등록되지 않았습니다. <br/> 다시 입력해주세요.";
		}else
			returnResult = "직원정보가 등록되지 않았습니다. <br/> 다시 입력해주세요.";
		return returnResult;
	}
	/**
	 * 직원 정보를 삭제한 뒤 정상적으로 삭제되었는지를 확인한다.
	 * 1번 과제에서 수정할 함수...
	 * @param stmt
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public  String delete(String id) throws SQLException {
		// TODO Auto-generated method stub
		EmployeeDTO emp;
		String returnResult;
		int result = dao.delete(id);
		emp = selectById(id);
		if(result == 1) {
			if (emp == null) {
				returnResult = "ID : " +id + "의 직원정보 "+result+"개가 삭제되었습니다.\n";
			}else {
				returnResult = emp.getId() + "의 데이터가 2개 이상입니다. 따라서 삭제하려는 정보는 원상복구됩니다.\n" + emp 
					  +"<br/>관리자에게 문의하세요.";
			}
		}else {
			returnResult = emp.getId() + "의 데이터가 2개 이상입니다. 따라서 삭제하려는 정보는 원상복구됩니다.\n" + emp 
			  +"<br/>관리자에게 문의하세요.";
		}
		return returnResult;
	}
	public  EmployeeDTO selectById(String id) throws SQLException {
		EmployeeDTO emp = dao.selectById(id);
		return emp;
	}
	
	public  EmployeeDTO selectByName(String name) throws SQLException {
		EmployeeDTO emp = dao.selectByName(name);
		return emp;
	}
	
	public  ArrayList<EmployeeDTO> selectAll() throws SQLException {
		ArrayList<EmployeeDTO> listEmp = dao.selectAll();
		return listEmp;
	}
	
	public EmployeeService() {
		this.dao = new EmployeeDAO();
		this.pool = dao.getConnectionPool();
	}
}
