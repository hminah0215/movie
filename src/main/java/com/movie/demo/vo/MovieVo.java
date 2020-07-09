package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MovieVo {
	private int m_no;
	private String m_title;
	private String m_runtime;
	private String m_ageLimit;
	private String m_genre;
	private String m_opendate;
	private String m_director;
	private String m_cast;
	private String m_summary;
	private String m_poster;
	private String expert_rating;
	private String visitor_rating;
}
