package emp.model;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	//쓰기 , 리스트, 읽기, 수정, 삭제 , 조회수 증가, 글의 수 
	public void insertBoard(BoardDTO dto); //쓰기
	public List<BoardDTO> getBoardList(HashMap map); //리스트
	public BoardDTO getBoard(int num); //읽기
	
	public int updateBoard(BoardDTO dto); //수정
	public int deleteBoard(BoardDTO dto); //삭제
	
	public void updateHit(int num); //조회수 증가
	public int getBoardCount(); //글의수
	public void updateSort(BoardDTO dto); //넘버3보다 크거나 같은 
	public void insertReply(BoardDTO dto); //답변저장.
	
}
