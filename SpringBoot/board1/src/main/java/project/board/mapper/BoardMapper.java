package project.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.board.dto.BoardDto;

@Mapper		// Mapper라고 선언함
public interface BoardMapper {
	// 여기서 지정한 메서드의 이름은 쿼리의 이름과 동일해야 함 (selectBoardList)
	List<BoardDto> selectBoardList() throws Exception;
	int select() throws Exception;

	void insertBoard(BoardDto board); 
	
	BoardDto selectByIdx(int boardIdx);
	
	int deleteByIdx(int boardIdx);
}