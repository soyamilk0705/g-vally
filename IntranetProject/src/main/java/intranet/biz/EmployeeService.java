package intranet.biz;

import java.sql.Connection;
import java.sql.SQLException;

import intranet.dao.ConnectionPool;
import intranet.dao.EmployeeDAO;
import intranet.entity.EmpEntity;

public class EmployeeService {
	private EmployeeDAO dao;
	private ConnectionPool pool;
	private Connection con;

    public EmployeeService() throws SQLException {
    	this.dao = new EmployeeDAO();
    	this.pool = dao.getConnectionPool();
    }
    
    // �α���
    public EmpEntity getLoginUser(String id, String pass) throws SQLException {
    	// ������ �ۼ� - Database ���� �� Dao�� �Լ� ȣ��
    	EmpEntity emp = dao.getLoginUser(con, id, pass);
        
        if ((emp != null) && (emp.getEmpLoginPasswd().trim().equals(pass))) {
        	return emp;
        } else {
        	return null;
        }
       
    }
}
