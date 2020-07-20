package com.movie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.demo.service.WishlistService;
import com.movie.demo.vo.WishlistVo;

@Controller
public class WishlistController {

	@Autowired
	WishlistService wishlistService;
	
	//위시리스트 등록
	@RequestMapping("/wishlist/insert_wishlist")
	@ResponseBody
	public void insert_wishlist(WishlistVo w) {
		System.out.println("위시리스트 추가 컨트롤러");
		wishlistService.insert_wishlist(w);
	}
	
	//위시리스트 삭제
	@RequestMapping("/wishlist/delete_wishlist")
	@ResponseBody
	public void delete_wishlist(WishlistVo w) {
		System.out.println("위시리스트 삭제 컨트롤러");
		//위시번호 조회
		int w_no = wishlistService.search_w_no(w);
		WishlistVo w2 = new WishlistVo();
		//아이디,영화번호 셋팅
		w2.setW_no(w_no);
		w2.setUser_id(w.getUser_id());
		wishlistService.delete_wishlist(w2);
	}
	
	//위시리스트 목록
	@RequestMapping("/wishlist/list_wishlist")
	public String list_wishlist(Model model, WishlistVo w) {
		model.addAttribute("wishlist", wishlistService.list_wishlist(w));
		return "/wishlist/list_wishlist";
	}
}
