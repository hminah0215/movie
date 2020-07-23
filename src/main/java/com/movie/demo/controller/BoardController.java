package com.movie.demo.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.demo.service.AlarmService;
import com.movie.demo.service.BoardService;
import com.movie.demo.vo.AlarmVo;
import com.movie.demo.vo.BoardVo;
import com.movie.demo.vo.Board_commentVo;
import com.movie.demo.vo.MemberVo;

import ch.qos.logback.core.subst.Token.Type;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@Autowired
	AlarmService alarmservice;
	
	//게시판 메인
	@RequestMapping("/board/main")
	public String main() {
		return "/board/main";
	}
	
	//자유게시판 목록
	@RequestMapping("/board/free_list")
	public String list_board(Model model) {
		model.addAttribute("list_board", service.list_board());
		
		return "/board/free_list";
	}
	
	//게시물 등록폼
	@RequestMapping("/board/insert_board_form")
	public String insert_board_form() {
		return "/board/free_insert";
	}
	
	//게시물 등록
	@RequestMapping("/board/insert_board")
	public String insert_board(BoardVo b) {
		service.insert_board(b);
		return "redirect:/board/free_list";
	}
	
	//게시물 상세보기
	@RequestMapping("/board/detail")
	public String detail_board(BoardVo b, Model model,HttpServletRequest request) {
		System.out.println("게시물 번호"+b.getB_no());
		model.addAttribute("detail", service.detail_board(b));
		//조회수 증가
		service.hit_board(b);
		//댓글 목록
		model.addAttribute("cm_list", service.list_board_comment(b));
		
//		System.out.println(request.getSession());
	
		if(request.getSession() != null) {
			//System.out.println("aaaaaaaaaaaaa");
			HttpSession session = request.getSession();
			MemberVo m = (MemberVo)session.getAttribute("member");
			//로그인을 했으면
			if(m != null) {
				System.out.println(m);
				AlarmVo avo = new AlarmVo();
				avo.setB_no(b.getB_no());
				avo.setUser_id(m.getUser_id());
				alarmservice.chk_alarm(avo);
			}
			
		}
		
		return "/board/detail";
	}
	
	//게시물 수정폼
	@RequestMapping("/board/update_board_form")
	public String update_board_form(BoardVo b, Model model) {
		model.addAttribute("detail", service.detail_board(b));
		return "/board/update";
	}
	
	//게시물 수정
	@RequestMapping("/board/update_board")
	public String update_board(BoardVo b) {
		service.update_board(b);
		return "redirect:/board/detail?b_no="+b.getB_no();
	}
	
	
	//게시물 삭제
	@RequestMapping("/board/delete_board")
	public String delete_board(BoardVo b) {
		service.delete_board_comment_all(b);
		service.delete_board(b);
		return "redirect:/board/free_list";
	}
	
	
	//댓글 등록
	@RequestMapping("/board/insert_board_comment")
	public String insert_board_comment(Board_commentVo cm) {
		service.insert_board_comment(cm);
		
		//알람 등록하려고 댓글 등록한 글번호,글 작성자
		AlarmVo avo = new AlarmVo();
		avo.setA_type("댓글등록");
		avo.setB_no(cm.getB_no());
		avo.setUser_id(alarmservice.search_b_user_id(cm.getB_no()));
		alarmservice.insert_alarm(avo);
		
		return "redirect:/board/detail?b_no="+cm.getB_no();
	}
	
	//댓글 수정
	@RequestMapping("/board/update_board_comment")
	public String update_board_comment(Board_commentVo cm) {
		service.update_board_comment(cm);
		return "redirect:/board/detail?b_no="+cm.getB_no();
	}
	
	//댓글 삭제
	@RequestMapping("/board/delete_board_comment")
	public String delete_board_comment(Board_commentVo cm) {
		service.delete_board_comment(cm);
		return "redirect:/board/detail?b_no="+cm.getB_no();
	}
	
	//공지사항 목록
	@RequestMapping("/board/notice_list")
	public String notice_list(Model model) {
		model.addAttribute("list_notice", service.list_notice());
		return "/board/notice_list";
	}
	
	//공지사항 등록폼
	@RequestMapping("/board/insert_notice_form")
	public String insert_notice_form() {
		return "/board/notice_insert";
	}
	
	//공지사항 등록
	@RequestMapping("/board/insert_notice")
	public String insert_notice(BoardVo b) {
		service.insert_board(b);
		return "redirect:/board/notice_list";
	}
	
	//fqa 목록
	@RequestMapping("/board/faq_list")
	public String faq_list(Model model) {
		model.addAttribute("list_faq", service.list_faq());
		return "/board/faq_list";
	}
	
	//faq 등록폼
	@RequestMapping("/board/insert_faq_form")
	public String insert_faq_form() {
		return "/board/faq_insert";
	}
	
	//faq 등록
	@RequestMapping("/board/insert_faq")
	public String insert_faq(BoardVo b) {
		service.insert_board(b);
		return "redirect:/board/faq_list";
	}
	
	//게시물 신고
	@RequestMapping("/board/report_board")
	public String report_board(BoardVo b) {
		//로그인 되면 로그인 아이디로 수정 해야됨
		//이미 신고한 사람은 신고 못하게 수정해야됨
		//System.out.println("//로그인 되면 로그인 아이디로 수정 해야됨");
		//b.setUser_id("test01");
		Integer re = service.search_report(b);
		if(re > 0) {
			return "redirect:/board/detail?b_no="+b.getB_no();
		}
		else {
			service.report_board(b);
			System.out.println("신고글번호"+b.getB_no());
			service.report_board_cnt(b);
			return "redirect:/board/detail?b_no="+b.getB_no();
		}
	}
	
	//리뷰 신고
}
