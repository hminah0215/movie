package com.movie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.dao.WishlistDao;
import com.movie.demo.vo.MovieVo;
import com.movie.demo.vo.WishlistVo;

@Service
public class WishlistServiceImp implements WishlistService {

	@Autowired
	WishlistDao wDao;
	
	//위시리스트 등록
	@Override
	public int insert_wishlist(WishlistVo w) {
		// TODO Auto-generated method stub
		int re = -1;
		re = wDao.insert_wishlist(w);
		return re;
	}

	//위시리스트 삭제
	@Override
	public int delete_wishlist(WishlistVo w) {
		// TODO Auto-generated method stub
		int re = -1;
		re = wDao.delete_wishlist(w);
		return re;
	}

	//위시리스트 목록
	@Override
	public List<WishlistVo> list_wishlist(WishlistVo w) {
		// TODO Auto-generated method stub
		List<WishlistVo> list = wDao.list_wishlist(w);
		return list;
	}

	//위시리스트에 추가한 영화인지 확인
	@Override
	public Integer chk_wishlist(WishlistVo w) {
		// TODO Auto-generated method stub
		Integer re = -1;
		re = wDao.chk_wishlist(w);
		return re;
	}

	//위시리스트에 추가한 영화인지 확인을 위한 영화번호 조회
	@Override
	public Integer list_m_no(String title) {
		// TODO Auto-generated method stub
		int re  = wDao.list_m_no(title);
		return re;
	}

	//위시번호 조회
	@Override
	public int search_w_no(WishlistVo w) {
		// TODO Auto-generated method stub
		int re = -1;
		re = wDao.search_w_no(w);
		return re;
	}

}
