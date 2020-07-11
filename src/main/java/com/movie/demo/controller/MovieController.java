package com.movie.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.movie.demo.vo.MovieVo;

@Controller
public class MovieController {
	
	// Document 연결해서 얻어온 html 전체 문서, Element Document의 html 요소, Elements element가 모인 자료형
	// 메소드 get,post둘다 써놨는데 둘다 지우거나 필요한것만 써도 무방함.
	
	@ResponseBody
	@RequestMapping(value = "crawling.do", method = { RequestMethod.GET,RequestMethod.POST }, produces = "text/plain;charset=UTF-8")
	public String crawling() {
		Document doc;
		String str = "";
		int m_no; 					// 영화번호, 시퀀스
		String m_title; 			// 영화 제목
		String m_age; 				// 나이제한
		String m_score; 			// 영화 평점
		String m_advance_rate; 		// 영화 예매율
		String m_genre; 			// 영화 장르
		String m_running_time; 		// 영화 상영시간
		String m_openDate; 			// 영화 개봉일
		String m_director; 			// 영화 감독
		String m_actors; 			// 영화 출연진
		String m_main_poster; 		// 영화 포스터
		String m_now; 				// 상영여부

		try {
			// jsoup으로 네이버 상영영화 정보를 가져온다.
			doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
			
			// 제목, 나이제한, 평점, 예매율, 장르, 러닝타임, 개봉일, 감독, 배우, 이미지 를 크롤링
			Elements title = doc.select("dt.tit > a");
			Elements age = doc.select("dt.tit > span");
			Elements score = doc.select(" .star_t1 > a > .num");
			Elements advance_rate = doc.select(".star_t1.b_star > .num");
			Elements genre = doc.select("dd:nth-child(2) > span.link_txt");
			Elements runtime = doc.select("dd:nth-child(3)");
//			개요 멜로/로맨스, 드라마, 범죄, 가족 | 135분 | 2020.07.09 개봉 감독 증국상 출연 주동우, 이양천새
//			이런시으로 가져와짐
//			Elements openDate = doc.select("");
			Elements director = doc.select("dd:nth-child(4) > span > a");
			Elements actors = doc.select("dd:nth-child(6) > span ");
			Elements mainPoster = doc.select("div:nth-child(1) > div.lst_wrap > ul > li > div > a > img[src]");
			
			//div:nth-child(1) > div.lst_wrap > ul > li:nth-child(2) > div > a > img

			
//			System.out.println(mainPoster +"\n");
			
			List<MovieVo> list = new ArrayList<MovieVo>();

			for (int i = 0; i < 20; i++) {
				m_title = title.get(i).text();
				m_age = age.get(i).text();
				m_score = score.get(i).text();
				m_advance_rate = advance_rate.get(i).text();
				m_genre = genre.get(i).text();
				m_running_time = runtime.get(i).text();
//				System.out.println(m_running_time);
				String[] m = m_running_time.split("\\|");
				//개요 멜로/로맨스, 드라마, 범죄, 가족 | 135분 | 2020.07.09 개봉 감독 증국상 출연 주동우, 이양천새 이거를
				//|로 자름 스플릿으로 자르면 배열로 반환해서 배열에 넣음
				//개요 멜로/로맨스, 드라마, 범죄, 가족
				//135
				//2020.07.09 개봉 감독 증국상 출연 주동우, 이양천새
				// 이런식으로 세덩이로 나눠짐
//				System.out.println(m[1]);
				String[] m2 = m[2].split("개봉");
				//위에서 나눠진 덩어리중에서 3번째(m[2])를 가져와서 개봉으로 자름
//				System.out.println(m2[0]);
//				m_openDate = openDate.get(i).text();
				m_director = director.get(i).text();
				m_actors = actors.get(i).text();
				m_main_poster = mainPoster.get(i).attr("src");
				
				MovieVo test = new MovieVo(0, m_title, m_age, m_score, m_advance_rate, m_genre,
											m[1], m2[0], m_director, m_actors, m_main_poster, "상영중");

				list.add(test);
			}
			Gson gson = new Gson();
			str = gson.toJson(list);

		} catch (Exception e) {
			System.out.println("크롤링 오류: " + e.getMessage());
		}

		return str;
	}
}
