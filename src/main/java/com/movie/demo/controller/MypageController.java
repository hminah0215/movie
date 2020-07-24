package com.movie.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.demo.service.MypageService;
import com.movie.demo.vo.MemberVo;

@Controller
public class MypageController {

	@Autowired
	MypageService MypageService;
	
	//마이페이지 메인
	@RequestMapping("/mypage/main")
	public String main() {
		
		return "/mypage/main";
	}
	
	//정보수정 폼
	@RequestMapping("/mypage/update_form")
	public String update_form() {
		
		return "mypage/update";
	}
	
	//작성한 글
	@RequestMapping("/mypage/board")
	public String board(Model model, HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		MemberVo m = (MemberVo)session.getAttribute("member");
		System.out.println("작성글 컨트롤러" + m);
		model.addAttribute("board", MypageService.board(m));
		return "/mypage/board";
	}
	
	//결제내역
	@RequestMapping("/mypage/pay")
	public String pay() {
		
		return "/mypage/pay";
	}
	
	
}
