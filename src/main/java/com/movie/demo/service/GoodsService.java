package com.movie.demo.service;

import java.util.List;

import com.movie.demo.vo.CartVo;
import com.movie.demo.vo.GoodsVo;

public interface GoodsService {
	//상품 등록
	int insert_goods(GoodsVo g);

	//상품 목록
	List<GoodsVo> list_goods(GoodsVo g);

	//상품 수정
	int update_goods(GoodsVo g);

	//상품 삭제
	int delete_goods(GoodsVo g);
	
	//장바구니 담기
	int insert_cart(CartVo c);
	
	//장바구니 삭제
	int delete_cart(CartVo c);
	
	//장바구니 목록
	List<CartVo> list_cart(CartVo c);

}
