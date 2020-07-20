package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistVo{
	private int w_no;
	private String w_Date;
	private String user_id;
	private int m_no;
	
	private String m_title;			// 영화 제목
	private String m_age;			// 나이제한
	private String m_score; 		// 영화 평점
	private String m_advance_rate; 	// 영화 예매율
	private String m_genre; 		// 영화 장르
	private String m_running_time; 	// 영화 상영시간
	private String m_opendate; 		// 영화 개봉일
	private String m_director; 		// 영화 감독
	private String m_actors; 		// 영화 출연진
	private String m_main_poster;	// 영화 포스터
	private String m_now; 			// 상영여부
}
