package com.movie.demo.controller;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.demo.service.GoodsService;
import com.movie.demo.vo.CartVo;
import com.movie.demo.vo.GoodsVo;

@Controller
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
	
	//상품 크롤링
//	@RequestMapping("/goods/crwaling")
//	@ResponseBody
//	public void crwaling() {
//		System.out.println("크롤링 컨트롤러");
//		Document doc;
//		String g_type; 		//상품 타입 (콤보,팝콘,음료,스낵 등)
//		String g_name; 		//상품 이름
//		int g_price; 		//상품 가격
//		int g_qty = 100;	//상품 수령 (기본으로 100개 입력)
//		String g_pic_name;	//상품 사진
//		
//		try {
//			doc = Jsoup.connect("http://www.cgv.co.kr/culture-event/popcorn-store/store-category.aspx?CategoryIdx=4").get();
//			g_type = "콤보";
//			//Elements c_g_name = doc.select(".com_list_text_title");
//			Elements c_g_name = doc.select("span.com_list_text_wrap");
//			Elements c_g_price = doc.select(".store_deatail_source_price");
//			Elements c_g_pic_name = doc.select(".com_list_img_wrap > img");
//			
//			System.out.println(doc);
//			
//			GoodsVo g = new GoodsVo();
//			
//			for(int i = 0; i < c_g_name.size(); i++) {
//				g.setG_type(g_type);
//				g.setG_name(c_g_name.get(i).text());
//				g.setG_price(Integer.parseInt((c_g_price.get(i).text())));
//				g.setG_pic_name(c_g_pic_name.get(i).text());
//				
//				System.out.println("상품 정보 수집");
//				goodsService.insert_goods(g);
//				System.out.println("상품 등록");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//	}
	
	//상품등록 폼
	@RequestMapping("/goods/insert_goods_form")
	public String insert_goods_form() {
		return "/goods/insert_goods";
	}
	
	//상품등록
	@RequestMapping("/goods/insert_goods")
	public String insert_goods(GoodsVo g) {
		goodsService.insert_goods(g);
		//계속 등록하려고 상품등록 폼으로 보냄
		return "redirect:/goods/insert_goods_form";
	}
	
	//상품목록
	@RequestMapping("/goods/list_goods")
	public String list_goods(Model model, GoodsVo g) {
		//jsp에서 보낸 g_type이 없으면 자동으로 전체목록 조회
		//jsp에서 보낸 g_type이 있으면  g_type으로 조회
		model.addAttribute("list_goods", goodsService.list_goods(g));
		return "/goods/list_goods";
	}
	
	//장바구니 담기
	@RequestMapping("/goods/insert_cart")
	@ResponseBody
	public String insert_cart(CartVo c) {
		//c.setRs_no(0);
		//goodsService.insert_cart(c);
		c.setUser_id("test01");
		int re = -1;
		re = goodsService.insert_cart(c);
		if(re > 0) {
			return "장바구니에 담았습니다";
		}else {
			return "장바구니에 담지 못했습니다";
		}
	}
	
	//장바구니 삭제
	@RequestMapping("/goods/delete_cart")
	public String delete_cart(CartVo c) {
		goodsService.delete_cart(c);
		
		return "/goods/list_cart";
	}
	
	//장바구니 목록
	@RequestMapping("/goods/list_cart")
	public String list_cart(Model model, CartVo c) {
		c.setUser_id("test01");
		model.addAttribute("list_cart", goodsService.list_cart(c));
		
		return "/goods/list_cart";
	}
	
}
