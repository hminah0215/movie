package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MovieVo {
	//제목, 평점, 예매율, 장르, 러닝타임, 개봉일, 감독, 배우, 이미지 
	private int m_no;				// 영화 번호
	private String m_title;			// 영화 제목
	private String m_age;			// 나이 제한
	private String m_score; 		// 영화 평점
	private String m_advance_rate; 	// 영화 예매율
	private String m_genre; 		// 영화 장르
	private String m_running_time; 	// 영화 상영시간
	private String m_openDate; 		// 영화 개봉일
	private String m_director; 		// 영화 감독
	private String m_actors; 		// 영화 출연진
	private String m_main_poster;	// 영화 포스터
	private String m_now;			// 상영여부
}
