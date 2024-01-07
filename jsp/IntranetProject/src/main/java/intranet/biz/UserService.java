package intranet.biz;

import java.sql.SQLException;

import common.ConnectionPool;
import intranet.dao.UserDAO;
import intranet.entity.UserDTO;

public class UserService {
	private UserDAO dao;
	private ConnectionPool pool;

    public UserService() throws SQLException {
    	this.dao = new UserDAO();
    	this.pool = dao.getConnectionPool();
    }
    
	public String register(UserDTO emp) throws SQLException {
		int result = dao.insert(emp);
		String returnResult;
		String id = emp.getUserId();
		//		5. 결과테이블에서 데이터 추출
		if(result == 1) {
//			user = selectByName(user.getName());
			if (emp.getUserId().equals(id)) {
				returnResult = "직원정보가 정상적으로 입력되었습니다.<br/>"+emp;
			}else
				returnResult = "직원정보가 등록되지 않았습니다. <br/> 다시 입력해주세요.";
		}else
			returnResult = "직원정보가 등록되지 않았습니다. <br/> 다시 입력해주세요.";
		return returnResult;
	}
	
	public UserDTO getLoginUser(String id, String pass) throws SQLException{
		UserDTO emp = dao.getLoginUser(id, pass);
        
        if ((emp != null) && (emp.getPassword().trim().equals(pass))) {
        	return emp;
        } else {
        	return null;
        }
       
    }
}
