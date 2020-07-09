package com.movie.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.movie.demo.vo.MovieVo;

@Controller
public class MovieController {

	@ResponseBody
	@RequestMapping(value = "crawling.do", method = { RequestMethod.GET,RequestMethod.POST }, produces = "text/plain;charset=UTF-8")
	public String crawling() {
		Document doc;
		String str = "";
//		String title = ""; // 영화 제목
//		String score = ""; // 영화 평점
//		String advance_rate = ""; // 영화 예매율
//		String genre = ""; // 영화 장르
//		String running_time = ""; // 영화 상영시간
//		String openDate = ""; // 영화 개봉일
//		String director = ""; // 영화 감독
//		String actors = ""; // 영화 출연진
//		int finalCnt = 0; // 예매순 1~20위 까지 가져온다

		try {
			// jsoup으로 네이버 상영영화 정보를 가져온다.
			doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
			
			Elements title = doc.select("dt.tit > a");
			Elements score = doc.select(".star_t1 > .num");
//			Elements advance_rate = doc.select(".lst_dsc > .info_exp > dd >.star_t1 > .num");
			Elements advance_rate = doc.select(".star_t1 > .num");
			
			List<MovieVo> list = new ArrayList<MovieVo>();
			
			for(int i= 0; i < 20; i++) {
				String tit = title.get(i).text();
				String scores = score.get(i).text();
				String rate = advance_rate.get(i).text();
				
//				System.out.println(tit);
				
				//MovieVo test = new MovieVo(tit, scores, rate ,"","","","","","");
				MovieVo test = new MovieVo();
				test.setM_title(tit);
				test.setM_score(scores);
				test.setM_advance_rate(rate);
				
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
