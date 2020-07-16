package com.movie.demo.dao;

import java.util.List;

import com.movie.demo.vo.TheatherVo;

public interface TheatherDao {
	// 상영관 정보
	List<TheatherVo> find_theather(int m_no);
	
	List<TheatherVo> allList();
	
	List<TheatherVo> select_date(TheatherVo t);
	
	
}
