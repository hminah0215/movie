package com.movie.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.movie.demo.service.TheatherService;
import com.movie.demo.vo.TheatherVo;

@Controller
@RequestMapping("/movie/*")
public class TheatherController {
	
	@Autowired
	TheatherService tService;
	
	// 상영관정보(목록)
	@GetMapping("/theatherList")
	public String theatherList(Model model,int m_no) {
		model.addAttribute("theather",tService.find_theather(m_no));
		model.addAttribute("allList", tService.allList());
		System.out.println("컨트롤러 동작");
		return "/movie/theatherList";
	}
	
	@GetMapping("/selecttheather")
	@ResponseBody
	public List<TheatherVo> selecttheather(Model model,TheatherVo t) {
		System.out.println("영화번호"+t.getM_no());
		List<TheatherVo> list = tService.find_theather(t.getM_no());
		return list;
	}
	
	@GetMapping("/selectdate")
	@ResponseBody
	public List<TheatherVo> selectdate(Model model,TheatherVo t) {
		System.out.println("영화번호"+t.getM_no());
		List<TheatherVo> list = tService.select_date(t);
		return list;
	}
}
