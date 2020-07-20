package com.movie.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// 메인페이지
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}
}
