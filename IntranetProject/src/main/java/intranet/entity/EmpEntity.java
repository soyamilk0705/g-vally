package intranet.entity;


public class EmpEntity {
	
	private String empCode; 
	private String empLoginId; 
	private String empLoginPasswd; 
	private String empName;

	
	public EmpEntity(){
		
	}
	public EmpEntity(String empCode,String empLoginId,String empLoginPasswd,String empName){
		this.empCode = empCode;
		this.empLoginId = empLoginId;
		this.empLoginPasswd = empLoginPasswd;
		this.empName = empName;	
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpLoginId() {
		return empLoginId;
	}
	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}
	public String getEmpLoginPasswd() {
		return empLoginPasswd;
	}
	public void setEmpLoginPasswd(String empLoginPasswd) {
		this.empLoginPasswd = empLoginPasswd;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	
}