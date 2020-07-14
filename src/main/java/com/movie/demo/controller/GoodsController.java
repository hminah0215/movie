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
	public String list_goods(Model model) {
		model.addAttribute("list_goods", goodsService.list_goods());
		return "/goods/list_goods";
	}
}
