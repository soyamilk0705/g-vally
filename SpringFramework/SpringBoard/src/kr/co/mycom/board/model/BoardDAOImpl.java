package kr.co.mycom.board.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class BoardDAOImpl implements BoardDAO {

	private SqlMapClientTemplate sqlMapClientTemplate;		// applicationContext.xml에서 등록해서 사용함
	
	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	
	@Override
	public void insertBoard(BoardDTO dto) {
		sqlMapClientTemplate.insert("insertBoard", dto); // 함수명(insert) - 태그 이름,  id "insertBoard", 파라미터 이름 dto
	}

	@Override
	public List<BoardDTO> getBoardList(HashMap map) {
		return sqlMapClientTemplate.queryForList("getBoardList",map);		// id는 필수
	}

	@Override
	public BoardDTO getBoard(int num) {
		BoardDTO dto = (BoardDTO)sqlMapClientTemplate.queryForObject("getBoard", num);
		System.out.println(dto);
		return dto;
	}

	@Override
	public int updateBoard(BoardDTO dto) {
	
		return sqlMapClientTemplate.update("updateBoard",dto);
	}

	@Override
	public int deleteBoard(BoardDTO dto) {
		
		return sqlMapClientTemplate.delete("deleteBoard",dto);
	}

	@Override
	public void updateHit(int num) {
		sqlMapClientTemplate.update("updateHit",num);

	}

	@Override
	public int getBoardCount() {
	
		return (int)sqlMapClientTemplate.queryForObject("getBoardCount");
	}

	@Override
	public void updateSort(BoardDTO dto) {
		sqlMapClientTemplate.update("updateSort",dto);
	}

	@Override
	public void insertReply(BoardDTO dto) {
		sqlMapClientTemplate.insert("insertReply",dto);

	}

}
