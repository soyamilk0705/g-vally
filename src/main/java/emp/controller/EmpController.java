package emp.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import emp.model.EmpDTO;
import emp.service.EmpService;

@Controller
public class EmpController {
	
	@Resource
	private EmpService empService;
	
	@RequestMapping("/login2")
	public String login2() {
		return "login";
	}
	
	@RequestMapping("/login.khs")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/menu.khs")
	public String menu() {
		return "menu";
	}
	
	@RequestMapping("/loginAction.khs")
	public String login(EmpDTO dto) {
		dto = empService.login(dto);
		return (dto == null) ? "loginFail" : "loginSuccess";
	}
	
	@RequestMapping("/register.khs")
	public String register() {
		return "register";
	}
	
//	@RequestMapping("/registerAction.khs")
//	public String register(EmpDTO dto) {
//		empService.insertEmp(dto);
//		dto = empService.
//		return null;
//	}
	

//	@RequestMapping("/writeform.htm")		// url濡� �뱾�뼱�삱 �닔 �뾾寃� view �븞�뿉 �꽔�뼱�넧湲� �븣臾몄뿉 �젒洹� 媛��뒫�븯寃� �븷�떦 �빐以섏빞�븿
//	public String writeform(){
//		return "writeform";
//	}//ModelAndView瑜� 由ы꽩�븯�뒗寃껉낵 媛숈쓬
//	
//	@RequestMapping("/write.htm")
//	public String write(EmpDTO dto){
//		empService.insertBoard(dto);
//		return "redirect:/list.htm";
//	}
//	
//	@RequestMapping("/list.htm")
//	public String list(HttpServletRequest request){
//		
//		int pg=1;
//		String strPg = request.getParameter("pg"); 
//		if(strPg!=null){
//			pg = Integer.parseInt(strPg);			
//		}
//		int rowSize = 10;
//		int start = (pg*rowSize)-(rowSize -1);
//		int end = pg*rowSize;
//		
//		int total = empService.getBoardCount(); //珥� 寃뚯떆臾쇱닔
//		System.out.println("�떆�옉 : "+start +" �걹:"+end);
//		System.out.println("湲��쓽 �닔 : "+total);
//		
//		int allPage = (int) Math.ceil(total/(double)rowSize); //�럹�씠吏��닔
//		//int totalPage = total/rowSize + (total%rowSize==0?0:1);
//		System.out.println("�럹�씠吏��닔 : "+ allPage);
//		
//		int block = 10; //�븳�럹�씠吏��뿉 蹂댁뿬以�  踰붿쐞 << [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] >>
//		int fromPage = ((pg-1)/block*block)+1;  //蹂댁뿬以� �럹�씠吏��쓽 �떆�옉
//		//((1-1)/10*10)
//		int toPage = ((pg-1)/block*block)+block; //蹂댁뿬以� �럹�씠吏��쓽 �걹
//		if(toPage> allPage){ // �삁) 20>17
//			toPage = allPage;
//		}
//		
//		
//		HashMap map = new HashMap();
//		
//		map.put("start", start);
//		map.put("end", end);
//		
//		List<EmpDTO> list = empService.getBoardList(map);
//		request.setAttribute("list", list);
//		request.setAttribute("pg",pg);
//		request.setAttribute("allPage",allPage);
//		request.setAttribute("block",block);
//		request.setAttribute("fromPage",fromPage);
//		request.setAttribute("toPage",toPage);	
//		
//		return "list"; //list.jsp
//	}
//	
//	@RequestMapping("/read.htm")
//	public String read(int num,int pg, Model model){ //@RequestParam(
//		
//		//int num = Integer.parseInt(request.getParameter("num"));
//		empService.updateHit(num); //議고쉶�닔 利앷�
//		EmpDTO dto = empService.getBoard(num); //湲� �씫湲�
//		System.out.println(dto);
//		model.addAttribute("b", dto);  //紐⑤뜽�븻 酉곗쨷�뿉�꽌 紐⑤뜽~
//		model.addAttribute("pg", pg); 
//		return "read"; //read.jsp
//		
//	}
//	@RequestMapping("/updateform.htm")
//	public String upadteform(int num, int pg, Model model){
//		EmpDTO dto = empService.getBoard(num);
//		model.addAttribute("b", dto);	
//		model.addAttribute("pg", pg);
//		return "updateform"; //updateform.jsp
//	}
//	
//	@RequestMapping("/update.htm")
//	public String upadte(EmpDTO dto, int pg){
//		System.out.println("upadte=>"+dto);
//		int result = empService.updateBoard(dto); //�떎�뙣 : 0 , �꽦怨� : 1
//		System.out.println("Update result=>"+result);
//		String res = "redirect:/list.htm?pg="+pg; //由щ떎�씠�젆�듃�뒗 URL瑜� �옱吏��젙. 二쇱냼媛� 諛붾��
//		if(result == 0){
//			res = "fail" ; //fail.jsp
//		}
//		return res;
//	}
//	
//	@RequestMapping("/deleteform.htm")
//	public String deleteform(){
//		return "deleteform"; //eleteform.jsp
//	}
//	
//	@RequestMapping("/delete.htm")
//	public String delete(EmpDTO dto, int pg){
//		int result = empService.deleteBoard(dto); //�떎�뙣 : 0 , �꽦怨� : 1
//		String res = "redirect:/list.htm?pg="+pg;
//		if(result == 0){
//			res = "fail" ; //fail.jsp
//		}
//		
//		return res;
//	}
//	
//	@RequestMapping("/replyform.htm")
//	public String replyform(int num,Model model){ 
//		
//		EmpDTO dto = empService.getBoard(num);
//		model.addAttribute("b",dto);
//		
//		return "replyform"; //replyform.jsp
//	}
	
//	@RequestMapping("/reply.htm")
//	public String reply(EmpDTO dto, int pg){
//		System.out.println("reply=>"+dto);
//		dto.setSort(dto.getSort()+1);
//		dto.setTab(dto.getTab()+1);
//		
//		empService.insertReply(dto);
//		return "redirect:/list.htm?pg="+pg;
//	}
}
