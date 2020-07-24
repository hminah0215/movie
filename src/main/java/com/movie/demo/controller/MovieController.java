package com.movie.demo.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.movie.demo.service.MovieService;
import com.movie.demo.service.WishlistService;
import com.movie.demo.vo.MemberVo;
import com.movie.demo.vo.MovieVo;
import com.movie.demo.vo.WishlistVo;

@Controller
@RequestMapping("/movie/*")
public class MovieController {

	@Autowired
	MovieService mService;

	@Autowired
	WishlistService WishlistService;

	// 메소드 get,post둘다 써놨는데 둘다 지우거나 필요한것만 써도 무방함.
	@RequestMapping(value = "list", method = { RequestMethod.GET,RequestMethod.POST }, produces = "text/plain;charset=UTF-8")
	public String crawling(Model model, HttpSession session, HttpServletRequest request) {
		Document doc = null;
		String str = "";
		String m_title; // 영화 제목
		String m_age; // 나이제한
		String m_score; // 영화 평점
		String m_advance_rate; // 영화 예매율
		String m_genre; // 영화 장르
		String m_running_time; // 영화 상영시간
		String m_director; // 영화 감독
		String m_actors; // 영화 출연진
		String m_main_poster; // 영화 포스터

		try {
			// jsoup으로 네이버 상영영화 정보를 가져온다.
			doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();

		} catch (Exception e) {
			System.out.println("크롤링 오류: " + e.getMessage());
		}

		// 제목, 나이제한, 평점, 예매율, 장르, 러닝타임, 개봉일, 감독, 배우, 이미지 를 크롤링
		Elements title = doc.select("dt.tit > a");
		Elements age = doc.select("dt.tit > span");
		Elements score = doc.select(" .star_t1 > a > .num");
		Elements advance_rate = doc.select(".star_t1.b_star > .num");
		Elements genre = doc.select("dd:nth-child(2) > span.link_txt");
		Elements runtime = doc.select("dd:nth-child(3)");
//		개요 멜로/로맨스, 드라마, 범죄, 가족 | 135분 | 2020.07.09 개봉 감독 증국상 출연 주동우, 이양천새
//		이런시으로 가져와짐
//		Elements openDate = doc.select("");
		Elements director = doc.select("dd:nth-child(4) > span > a");
		Elements actors = doc.select("dd:nth-child(6) > span ");
		Elements mainPoster = doc.select("div:nth-child(1) > div.lst_wrap > ul > li > div > a > img[src]");
//		System.out.println(mainPoster +"\n");

		MovieVo mVo = new MovieVo();

		//영수가 추가함 에러나면 이 부분 고치면 됨
		List<Integer> chklist = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			m_title = title.get(i).text();
			m_age = age.get(i).text();
			m_score = score.get(i).text();
			m_advance_rate = advance_rate.get(i).text();
			m_genre = genre.get(i).text();
			m_running_time = runtime.get(i).text();

			String[] m_runtime = m_running_time.split("\\|");
			// 개요 멜로/로맨스, 드라마, 범죄, 가족 | 135분 | 2020.07.09 개봉 감독 증국상 출연 주동우, 이양천새 이거를
			// |로 자름 스플릿으로 자르면 배열로 반환해서 배열에 넣음
			// 개요 멜로/로맨스, 드라마, 범죄, 가족
			// 135
			// 2020.07.09 개봉 감독 증국상 출연 주동우, 이양천새
			// 이런식으로 세덩이로 나눠짐
//			System.out.println(m[1]);
			String[] m_opendate = m_runtime[2].split("개봉");
			// 위에서 나눠진 덩어리중에서 3번째(m[2])를 가져와서 개봉으로 자름
//			System.out.println(m2[0]);
//			m_openDate = openDate.get(i).text();
			m_director = director.get(i).text();
			m_actors = actors.get(i).text();
			m_main_poster = mainPoster.get(i).attr("src");
			
//			System.out.println(m_score);
			
			//영수가 추가함 에러나면 이 부분 고치면 됨
			session = request.getSession();
			MemberVo m = (MemberVo)session.getAttribute("member");
			if(m != null) {
			//if(session.getAttribute("member") != null) {
				//System.out.println("로그인 함");
				int m_no = WishlistService.list_m_no(m_title);
				
				//System.out.println("영화 번호" + m_no);
				//로그인 정보 가져옴
				WishlistVo w = new WishlistVo();
				//영화번호 셋팅
				w.setM_no(m_no);
				//아이디 셋팅
				w.setUser_id(m.getUser_id());
				Integer chk = WishlistService.chk_wishlist(w);
				//System.out.println(chk);
				//model.addAttribute("wishlist", chk);
				if(chk > 0) {
					//System.out.println(m_no + "영화는 위시리스트에 있음");
					chklist.add(1);
				}else {
					//System.out.println(m_no + "영화는 위시리스트에 없음");
					chklist.add(0);
				}
			}
			// 여기까지 
			
			// db에 저장된 영화 제목과 크롤링 한 영화제목 비교
			if (mService.compare_title(m_title) != 0) {
				mService.update_movie(m_score, m_advance_rate+"%" ,m_title);
			} else {
				mVo.setM_title(m_title);
				mVo.setM_age(m_age);
				mVo.setM_score(m_score);
				mVo.setM_advance_rate(m_advance_rate+"%");
				mVo.setM_genre(m_genre);
				mVo.setM_running_time(m_runtime[1]);
				mVo.setM_opendate(m_opendate[0]);
				mVo.setM_director(m_director);
				mVo.setM_actors(m_actors);
				mVo.setM_main_poster(m_main_poster);
//				System.out.println("1");
				mService.insert_movie(mVo);
//				System.out.println("2");
			}
			
			model.addAttribute("listMovie",mService.list_movie());
			model.addAttribute("wishlist", chklist);
			//System.out.println(chklist);
		}
		//System.out.println("컨트롤러 끝");
		return "/movie/list_movie";
	}
}
