package kr.co.mycom.board.Service;

import java.util.HashMap;
import java.util.List;

import kr.co.mycom.board.model.BoardDAO;
import kr.co.mycom.board.model.BoardDTO;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO;
	
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	
	@Override
	public void insertBoard(BoardDTO dto) {
		
			boardDAO.insertBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList(HashMap map) {
		
		return boardDAO.getBoardList(map);
	}

	@Override
	public BoardDTO getBoard(int num) {
		
		return boardDAO.getBoard(num);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		
		return boardDAO.updateBoard(dto);
	}

	@Override
	public int deleteBoard(BoardDTO dto) {
		
		return boardDAO.deleteBoard(dto);
	}

	@Override
	public void updateHit(int num) {
		boardDAO.updateHit(num);

	}

	@Override
	public int getBoardCount() {
		
		return boardDAO.getBoardCount();
	}

	
	@Override
	public void insertReply(BoardDTO dto) {
		boardDAO.updateSort(dto);
		boardDAO.insertReply(dto);

	}

}
