package emp.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import board.model.BoardDTO;
import emp.model.EmpDTO;
import emp.service.EmpService;

@Controller
public class EmpController {
	
	@Resource
	private EmpService empService;
	
	@RequestMapping("/loginForm.khs")
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping("/loginAction.khs")
	public String login(EmpDTO dto, HttpSession session) {
		dto = empService.login(dto);
		
//		String returnValue = "";
		
		if (dto == null) {
			return "loginFail";
		} else {
//			returnValue = "loginSuccess";
			session.setAttribute("login", dto.getName());
			return "redirect:/list.khs";
		}
		
	}
	
	@RequestMapping("/menu.khs")
	public String menu() {
		return "menu";
	}
	
	@RequestMapping("/logout.khs")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		session.invalidate();
		
		return "loginForm";
	}
	
	@RequestMapping("/register.khs")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/registerForm.khs")
	public String registerForm() {
		return "registerForm";
	}

	@RequestMapping("/registerAction.khs")
	public String register(EmpDTO dto) {
		empService.insertEmp(dto);
		
		return "viewRegister";
	}
	

}
