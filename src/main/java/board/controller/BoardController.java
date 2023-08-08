package board.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardDTO;
import board.service.BoardService;

//Controller를 상속또는 implements를 하고 POJO방식으로 작성

@Controller
public class BoardController {

	@Resource
	private BoardService boardService;
	
	@RequestMapping("/writeform.khs")		// url로 들어올 수 없게 view 안에 넣어놨기 때문에 접근 가능하게 할당 해줘야함
	public String writeform(){
		return "writeform";
	}//ModelAndView를 리턴하는것과 같음
	
	@RequestMapping("/write.khs")
	public String write(BoardDTO dto){
		boardService.insertBoard(dto);
		return "redirect:/list.khs";
	}
	
	@RequestMapping("/list.khs")
	public String list(HttpServletRequest request){
		
		int pg=1;
		String strPg = request.getParameter("pg"); 
		if(strPg!=null){
			pg = Integer.parseInt(strPg);			
		}
		int rowSize = 10;
		int start = (pg*rowSize)-(rowSize -1);
		int end = pg*rowSize;
		
		int total = boardService.getBoardCount(); //총 게시물수
		System.out.println("시작 : "+start +" 끝:"+end);
		System.out.println("글의 수 : "+total);
		
		int allPage = (int) Math.ceil(total/(double)rowSize); //페이지수
		//int totalPage = total/rowSize + (total%rowSize==0?0:1);
		System.out.println("페이지수 : "+ allPage);
		
		int block = 10; //한페이지에 보여줄  범위 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>
		int fromPage = ((pg-1)/block*block)+1;  //보여줄 페이지의 시작
		//((1-1)/10*10)
		int toPage = ((pg-1)/block*block)+block; //보여줄 페이지의 끝
		if(toPage> allPage){ // 예) 20>17
			toPage = allPage;
		}
		
		
		HashMap map = new HashMap();
		
		map.put("start", start);
		map.put("end", end);
		
		List<BoardDTO> list = boardService.getBoardList(map);
		request.setAttribute("list", list);
		request.setAttribute("pg",pg);
		request.setAttribute("allPage",allPage);
		request.setAttribute("block",block);
		request.setAttribute("fromPage",fromPage);
		request.setAttribute("toPage",toPage);	
		
		return "list"; //list.jsp
	}
	
	@RequestMapping("/read.khs")
	public String read(int num,int pg, Model model){ //@RequestParam(
		
		//int num = Integer.parseInt(request.getParameter("num"));
		boardService.updateHit(num); //조회수 증가
		BoardDTO dto = boardService.getBoard(num); //글 읽기
		System.out.println(dto);
		model.addAttribute("b", dto);  //모델앤 뷰중에서 모델~
		model.addAttribute("pg", pg); 
		return "read"; //read.jsp
		
	}
	@RequestMapping("/updateform.khs")
	public String upadteform(int num, int pg, Model model){
		BoardDTO dto = boardService.getBoard(num);
		model.addAttribute("b", dto);	
		model.addAttribute("pg", pg);
		return "updateform"; //updateform.jsp
	}
	
	@RequestMapping("/update.khs")
	public String upadte(BoardDTO dto, int pg){
		System.out.println("upadte=>"+dto);
		int result = boardService.updateBoard(dto); //실패 : 0 , 성공 : 1
		System.out.println("Update result=>"+result);
		String res = "redirect:/list.khs?pg="+pg; //리다이렉트는 URL를 재지정. 주소가 바뀜
		if(result == 0){
			res = "fail" ; //fail.jsp
		}
		return res;
	}
	
	@RequestMapping("/deleteform.khs")
	public String deleteform(){
		return "deleteform"; //eleteform.jsp
	}
	
	@RequestMapping("/delete.khs")
	public String delete(BoardDTO dto, int pg){
		int result = boardService.deleteBoard(dto); //실패 : 0 , 성공 : 1
		String res = "redirect:/list.khs?pg="+pg;
		if(result == 0){
			res = "fail" ; //fail.jsp
		}
		
		return res;
	}
	
	@RequestMapping("/replyform.khs")
	public String replyform(int num,Model model){ 
		
		BoardDTO dto = boardService.getBoard(num);
		model.addAttribute("b",dto);
		
		return "replyform"; //replyform.jsp
	}
	
	@RequestMapping("/reply.khs")
	public String reply(BoardDTO dto, int pg){
		System.out.println("reply=>"+dto);
		dto.setSort(dto.getSort()+1);
		dto.setTab(dto.getTab()+1);
		
		boardService.insertReply(dto);
		return "redirect:/list.khs?pg="+pg;
	}
}
