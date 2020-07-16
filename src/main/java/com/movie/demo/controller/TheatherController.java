package com.movie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.demo.service.TheatherService;

@Controller
@RequestMapping("/movie/*")
public class TheatherController {
	
	@Autowired
	TheatherService tService;
	
	// 상영관정보(목록)
	@GetMapping("/theatherList")
	public String theatherList(Model model,int m_no) {
		model.addAttribute("theather",tService.find_theather(m_no));
		System.out.println("컨트롤러 동작");
		return "/movie/theatherList";
	}
	
}
