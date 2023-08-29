package project.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.board.dto.BoardDto;
import project.board.mapper.BoardMapper;

@Service //서비스임을 선언
public class BoardService{

	@Autowired //Mapper와 연결
	private BoardMapper boardMapper;


	public List<BoardDto> selectBoardList() throws Exception {
		System.out.println("BoardService::"+boardMapper);
		List<BoardDto> resultList = boardMapper.selectBoardList();
		return resultList;
	}

	public int select() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardService::"+boardMapper);
		return boardMapper.select();
	}

	public void insertBoard(BoardDto board) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.insertBoard(board);
	}
	
	public BoardDto selectByIdx(int boardIdx) {
		System.out.println("BoardService::selectByIdx");
		return boardMapper.selectByIdx(boardIdx);
	}
	
	public int deleteByIdx(int boardIdx) {
		return boardMapper.deleteByIdx(boardIdx);
	}
}