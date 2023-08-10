package emp.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import emp.model.BoardDTO;
import emp.model.EmpDTO;
import emp.service.EmpService;

@Controller
public class EmpController {
	
	@Resource
	private EmpService empService;
	
	@RequestMapping("/index.khs")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/loginForm.khs")
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping("/loginAction.khs")
	public String login(EmpDTO dto, HttpSession session) {
		dto = empService.login(dto);
		
		String returnValue = "";
		
		if (dto == null) {
			returnValue = "loginFail";
		} else {
			returnValue = "loginSuccess";
			session.setAttribute("login", dto.getName());
		}
		
		return returnValue;
		
	}
	
	@RequestMapping("/menu.khs")
	public String menu() {
		return "menu";
	}
	
	@RequestMapping("/logout.khs")
	public String logout() {
		return "logout";
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
