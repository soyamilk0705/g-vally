package intranet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import intranet.entity.EmpEntity;

public class EmployeeDAO {
	private Statement stmt;
	private ConnectionPool pool;
	
	public Connection getConnection() throws SQLException{
		return pool.getConnection();
	}
	
    public EmployeeDAO() {  
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
    
    // 로그인
    public EmpEntity getLoginUser(Connection con, String id, String pass) throws SQLException {
    	EmpEntity emp;
    	con = getConnection();
    	
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		String sql = "select * from EmpTBL where id='" + id + "'";
		ResultSet result = stmt.executeQuery(sql);
        
		if(result.next()) {
			emp = new EmpEntity(result.getString("empCode"), result.getString("empLoginId"), result.getString("empLoginPasswd"),result.getString("empName"));
		} else {
			emp = null;
		}
        
    	stmt.close();
		con.close();
		return emp;
    }

 
}
