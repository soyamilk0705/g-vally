package intranet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.ConnectionPool;
import intranet.entity.EmployeeDTO;
import intranet.entity.UserDTO;

public class UserDAO {
	private Statement stmt;
	private ConnectionPool pool;
	private Connection conn;
	
	public Connection getConnection() throws SQLException{
		return pool.getConnection();
	}
	
    public UserDAO() {  
    }
 
public ConnectionPool getConnectionPool() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		try {
			pool = new ConnectionPool(url, user, password, 3, 5, true, 10);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DBMS 정보 확인 필요!!!\n"
					+ url + "\n" + user + "\n" + password + "\n");
		}
		
		return pool;
	}

	
    
	public int insert(UserDTO emp) throws SQLException {
		conn = getConnection();
		stmt = conn.createStatement();
		conn.setAutoCommit(false);
		
		String sql = "INSERT INTO UserTBL (USER_ID, NAME, PASSWORD, ADDRESS, PHONE, PASSWORD_QUESTION, PASSWORD_ANSWER, MARRIAGE, HOBBY, ETC) "
				+ "VALUES ('" + emp.getUserId() + "', '" 
				+ emp.getName() + "', '" 
				+ emp.getPassword() + "', '"
				+ emp.getAddress() + "', '"
				+ emp.getPhone() + "', '"
				+ emp.getPasswordQuestion() + "', '"
				+ emp.getPasswordAnswer() + "', '"
				+ emp.getMarriage() + "', '"
				+ emp.getHobby() + "', '"
				+ emp.getEtc() + "')";
		
		int result = stmt.executeUpdate(sql);
		
		if (result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		
		conn.setAutoCommit(true);
		close();
		return result;
	}

	public UserDTO getLoginUser(String id, String pass) throws SQLException {
		UserDTO emp;
    	conn = getConnection();
    	
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		String sql = "SELECT * FROM UserTBL WHERE USER_ID='" + id + "'";
		ResultSet result = stmt.executeQuery(sql);
        
		if(result.next()) {
			emp = new UserDTO(
					result.getString("USER_ID"), 
					result.getString("NAME"), 
					result.getString("PASSWORD"),
					result.getString("ADDRESS"),
					result.getString("PHONE"),
					result.getString("PASSWORD_QUESTION"),
					result.getString("PASSWORD_ANSWER"),
					result.getString("MARRIAGE"),
					result.getString("HOBBY"),
					result.getString("ETC"));
			 
		} else {
			emp = null;
		}
        
		close();
		return emp;
    }
    
    public void close() throws SQLException {
    	stmt.close();
    	pool.releaseConnection(conn);
    }

}
