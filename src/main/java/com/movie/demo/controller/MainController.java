package com.movie.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.demo.service.AlarmService;
import com.movie.demo.vo.AlarmVo;
import com.movie.demo.vo.MemberVo;

@Controller
public class MainController {

	@Autowired
	AlarmService alarmservice;
	
	// 메인페이지
	@RequestMapping("/main")
	public String main(HttpServletRequest request, Model model) {
		if(request.getSession() != null) {
			HttpSession session = request.getSession();
			MemberVo m = (MemberVo)session.getAttribute("member");
			//로그인을 했으면
			if(m != null) {
				AlarmVo a = new AlarmVo();
				a.setUser_id(m.getUser_id());
				
				//댓글 알람
				model.addAttribute("comment", alarmservice.cnt_comment_alarm(a));
				
				//쪽지 알람
				model.addAttribute("note", alarmservice.cnt_note_alarm(a));
			}
			
		}
		return "/main";
	}
}
