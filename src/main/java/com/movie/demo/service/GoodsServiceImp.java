package com.movie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.dao.GoodsDao;
import com.movie.demo.vo.GoodsVo;
@Service
public class GoodsServiceImp implements GoodsService {
	
	@Autowired
	GoodsDao gdao;
	
	//상품 등록
	@Override
	public int insert_goods(GoodsVo g) {
		// TODO Auto-generated method stub
		int re = -1;
		re = gdao.insert_goods(g);
		return re;
	}
	
	//상품 목록
	@Override
	public List<GoodsVo> list_goods() {
		// TODO Auto-generated method stub
		List<GoodsVo> list = gdao.list_goods();
		return list;
	}
	
	//상품 수정
	@Override
	public int update_goods(GoodsVo g) {
		// TODO Auto-generated method stub
		int re = -1;
		re = gdao.update_goods(g);
		return re;
	}
	
	//상품 삭제
	@Override
	public int delete_goods(GoodsVo g) {
		// TODO Auto-generated method stub
		int re = -1;
		re = gdao.delete_goods(g);
		return re;
	}

}
