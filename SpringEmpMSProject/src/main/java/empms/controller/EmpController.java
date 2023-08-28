package empms.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import empms.model.EmpDTO;
import empms.service.EmpService;

@Controller
public class EmpController {
	
	@Resource
	private EmpService empService;
	
	@RequestMapping("/menu.khs")
	public String menu() {
		return "menu";
	}
	
	@RequestMapping("/loginForm.khs")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/top.khs")
	public String top() {
		return "top";
	}
	
	@RequestMapping("/loginAction.khs")
	public String loginAction(EmpDTO dto, HttpSession session) {
		dto = empService.login(dto);
		String returnResult = "";
		
		if (dto == null) {
			returnResult = "loginFail";
		} else {
			returnResult = "loginSuccess";
			session.setAttribute("login", dto.getName());
		}
		
		return returnResult;
		
	}
	
	@RequestMapping("/main.khs")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/empMenu.khs")
	public String empMenu() {
		return "empMenu";
	}
	
	@RequestMapping("/logout.khs")
	public String logout(HttpSession session) {
		String name = (String) session.getAttribute("login");
		session.removeAttribute(name);
		session.invalidate();
		
		return "logout";
	}


//	
//	@RequestMapping("/menu.khs")
//	public String menu() {
//		return "menu";
//	}
//	
//	@RequestMapping("/logout.khs")
//	public String logout() {
//		return "logout";
//	}
//	
//	@RequestMapping("/register.khs")
//	public String register() {
//		return "register";
//	}
//	
//	@RequestMapping("/registerForm.khs")
//	public String registerForm() {
//		return "registerForm";
//	}
//
//	@RequestMapping("/registerAction.khs")
//	public String register(EmpDTO dto) {
//		empService.insertEmp(dto);
//		
//		return "viewRegister";
//	}
	

}
