package com.movie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.demo.service.MemberService;
import com.movie.demo.vo.MemberVo;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	MemberService memService;
	
	
	// 회원등록
	@GetMapping(value = "/regForm")
	public void registerForm() {
		System.out.println("회원가입 폼");
	}
	
	@PostMapping(value = "/register")
	public String register(Model model, MemberVo mv) {

		System.out.println("회원가입 컨트롤러");
		
		int result = memService.checkId(mv.getUser_id());
		if(result == 1) {
			return "/member/register";
		}else if(result == 0) {
			memService.register(mv);
		}
		
		return "redirect:/";
	}
	
	// 아이디비교
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	@ResponseBody
	public int chkeckId(String user_id) {
		int re = memService.checkId(user_id);
		return re;
	}
}
