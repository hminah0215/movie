package com.movie.demo.service;

import java.util.List;

import com.movie.demo.vo.TheatherVo;

public interface TheatherService {
	
	// 상영관 정보
	List<TheatherVo> find_theather(int m_no);
	
	List<TheatherVo> allList();
	
	List<TheatherVo> select_date(TheatherVo t);
}
