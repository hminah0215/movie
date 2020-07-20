package com.movie.demo.service;

import java.util.List;

import com.movie.demo.vo.WishlistVo;

public interface WishlistService {
	//위시리스트 등록
	int insert_wishlist(WishlistVo w);

	//위시리스트 삭제
	int delete_wishlist(WishlistVo w);

	//위시리스트 목록
	List<WishlistVo> list_wishlist(WishlistVo w);
	
	//위시리스트에 추가한 영화인지 확인
	Integer chk_wishlist(WishlistVo w);
	
	//위시리스트에 추가한 영화인지 확인을 위한 영화번호 조회
	Integer list_m_no(String title);
	
	//위시번호 조회
	int search_w_no(WishlistVo w);
}
