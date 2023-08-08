package emp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import emp.model.EmpDAO;
import emp.model.EmpDTO;

public class EmpServiceImpl implements EmpService {

	private EmpDAO empDAO;
	
	
	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	
	@Override
	public void insertEmp(EmpDTO dto) {
		empDAO.insertEmp(dto);
	}

	@Override
	public List<EmpDTO> getEmpList(HashMap map) {
		return empDAO.getEmpList(map);
	}

	@Override
	public EmpDTO getEmp(int num) {
		return empDAO.getEmp(num);
	}

	@Override
	public int updateEmp(EmpDTO dto) {
		return empDAO.updateEmp(dto);
	}

	@Override
	public int deleteEmp(EmpDTO dto) {
		return empDAO.deleteEmp(dto);
	}

	@Override
	public void updateHit(int num) {
		empDAO.updateHit(num);

	}

	@Override
	public int getEmpCount() {
		return empDAO.getEmpCount();
	}

	
	@Override
	public void insertReply(EmpDTO dto) {
		empDAO.updateSort(dto);
		empDAO.insertReply(dto);

	}


	@Override
	public EmpDTO login(EmpDTO dto) {
		System.out.println("login(" + dto.getId() + ") :: count = " + empDAO.getEmpCountById(dto.getId()));
//		EmpDTO result = empDAO.getEmp(dto.getId().trim(), dto.getPwd().trim());	// 원래 login구현
		EmpDTO result = empDAO.getEmp(dto.getId());
		
//		// 방법1
//		if(dto.getPwd().trim().equals(result.getPwd())) {
//			return result;
//		} else {
//			return null;
//		}
		
		// 방법2
		EmpDTO returnValue = (dto != null && result != null && (dto.getPwd().trim().equals(result.getPwd()))) ?  result : null;
		
		return returnValue;
	}
}
