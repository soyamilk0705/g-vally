package emp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import emp.model.EmpDTO;


public interface EmpService {
	public void insertEmp(EmpDTO dto); //쓰기
	public List<EmpDTO> getEmpList(HashMap map); //리스트
	public EmpDTO getEmp(int num); //읽기
	
	public int updateEmp(EmpDTO dto); //수정
	public int deleteEmp(EmpDTO dto); //삭제
	
	public void updateHit(int num); //조회수 증가
	public int getEmpCount(); //글의수
	public void insertReply(EmpDTO dto); //답변저장.
	
	public EmpDTO login(EmpDTO dto);
	
	
}
