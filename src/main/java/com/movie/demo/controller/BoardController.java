package com.movie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.demo.service.BoardService;
import com.movie.demo.vo.BoardVo;
import com.movie.demo.vo.Board_commentVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	//자유게시판 목록
	@RequestMapping("/board/list")
	public String list_board(Model model) {
		model.addAttribute("list_board", service.list_board());
		
		return "/board/list";
	}
	
	//공지사항 목록
	
	//faq 목록
	
	//게시물 등록폼
	@RequestMapping("/board/insert_board_form")
	public String insert_board_form() {
		return "/board/insert";
	}
	
	//게시물 등록
	@RequestMapping("/board/insert_board")
	public String insert_board(BoardVo b) {
		service.insert_board(b);
		return "redirect:/board/list";
	}
	
	//게시물 상세보기
	@RequestMapping("/board/detail")
	public String detail_board(BoardVo b, Model model) {
		model.addAttribute("detail", service.detail_board(b));
		//조회수 증가
		service.hit_board(b);
		//댓글 목록
		model.addAttribute("cm_list", service.list_board_comment(b));
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
		return "redirect:/board/list";
	}
	
	
	//댓글 등록
	@RequestMapping("/board/insert_board_comment")
	public String insert_board_comment(Board_commentVo cm) {
		service.insert_board_comment(cm);
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
}
