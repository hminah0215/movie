package com.movie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.dao.MovieDao;
import com.movie.demo.vo.MovieVo;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao mdao;

	// db에 저장된 영화 제목비교
	@Override
	public int compare_title(String m_title) {
		return mdao.compare_title(m_title);
	}

	// 저장된 영화제목이 없다면 insert
	@Override
	public int insert_movie(MovieVo m) {
		int re = -1;
		re = mdao.insert_movie(m);
		return re;
	}

	// 저장된 영화제목이 있으면 update
	@Override
	public int update_movie(String m_score, String m_advance_rate,String m_title) {
		int re = -1;
		re = mdao.update_movie(m_score, m_advance_rate,m_title);
		return re;
	}

	// 영화 목록 list
	@Override
	public List<MovieVo> list_movie() {
		List<MovieVo> list = mdao.list_movie();
		return list;
	}

}
