package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MovieVo {
	//제목, 평점, 예매율, 장르, 러닝타임, 개봉일, 감독, 배우, 이미지 
	
	private String title;			// 영화 제목
	private String score; 			// 영화 평점
	private String advance_rate; 	// 영화 예매율
	private String genre; 			// 영화 장르
	private String running_time; 	// 영화 상영시간
	private String openDate; 		// 영화 개봉일
	private String director; 		// 영화 감독
	private String actors; 			// 영화 출연진
	private String main_poster;		// 영화 포스터
}
