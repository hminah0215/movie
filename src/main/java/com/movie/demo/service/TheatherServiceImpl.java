package com.movie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.dao.TheatherDao;
import com.movie.demo.vo.TheatherVo;

@Service
public class TheatherServiceImpl implements TheatherService {

	@Autowired
	TheatherDao tdao;
	
	// 상영관 정보
	@Override
	public List<TheatherVo> find_theather(int m_no) {
		List<TheatherVo> list = tdao.find_theather(m_no);
		return list;
	}

	@Override
	public List<TheatherVo> allList() {
		// TODO Auto-generated method stub
		List<TheatherVo> list = tdao.allList();
		return list;
	}

	@Override
	public List<TheatherVo> select_date(TheatherVo t) {
		// TODO Auto-generated method stub
		List<TheatherVo> list = tdao.select_date(t);
		return list;
	}

}
