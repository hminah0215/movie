package com.movie.demo.dao;

import java.util.List;

import com.movie.demo.vo.MovieVo;

public interface MovieDao {
	
	//db에 저장된 영화 제목비교
	int compare_title(String m_title);
	
	//저장된 영화제목이 없다면 insert
	int insert_movie(MovieVo m);
	
	//저장된 영화제목이 있으면 update
	int update_movie(String m_score, String m_advance_rate, String m_title);
	
	//영화 목록 list
	List<MovieVo> list_movie();
}
