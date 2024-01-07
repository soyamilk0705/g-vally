package emp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;


public class EmpDAOImpl implements EmpDAO{

private SqlMapClientTemplate sqlMapClientTemplate;		// applicationContext.xml�뿉�꽌 �벑濡앺빐�꽌 �궗�슜�븿
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	
	@Override
	public void insertEmp(EmpDTO dto) {
		sqlMapClientTemplate.insert("insertEmp", dto);
	}

	@Override
	public List<EmpDTO> getEmpList(HashMap map) {
		return sqlMapClientTemplate.queryForList("getEmpList",map);		// id�뒗 �븘�닔
	}

	@Override
	public EmpDTO getEmp(int num) {
		EmpDTO dto = (EmpDTO)sqlMapClientTemplate.queryForObject("getEmp", num);
		System.out.println(dto);
		return dto;
	}

	@Override
	public int updateEmp(EmpDTO dto) {
	
		return sqlMapClientTemplate.update("updateEmp",dto);
	}

	@Override
	public int deleteEmp(EmpDTO dto) {
		
		return sqlMapClientTemplate.delete("deleteEmp",dto);
	}

	@Override
	public void updateHit(int num) {
		sqlMapClientTemplate.update("updateHit",num);

	}

	@Override
	public int getEmpCount() {
		return (int) sqlMapClientTemplate.queryForObject("getEmpCount");
	}

	@Override
	public void updateSort(EmpDTO dto) {
		sqlMapClientTemplate.update("updateSort",dto);
	}

	@Override
	public void insertReply(EmpDTO dto) {
		sqlMapClientTemplate.insert("insertReply",dto);

	}
	
	@Override
	public EmpDTO getEmp(String id) {
		EmpDTO dto = (EmpDTO) sqlMapClientTemplate.queryForObject("getEmpById", id);
		System.out.println(dto);
		return dto;
	}

	@Override
	public int getEmpCountById(String id) {
		return (int)sqlMapClientTemplate.queryForObject("getEmpCountById", id);
	}

}
