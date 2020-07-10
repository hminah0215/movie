package com.movie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.dao.BoardDao;
import com.movie.demo.vo.BoardVo;
import com.movie.demo.vo.Board_commentVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDao dao;
	
	//자유게시판 목록
	@Override
	public List<BoardVo> list_board() {
		// TODO Auto-generated method stub
		List<BoardVo> list_board = dao.list_board();
		return list_board;
	}

	//공지사항 목록
	@Override
	public List<BoardVo> list_notice() {
		// TODO Auto-generated method stub
		List<BoardVo> list_notice = dao.list_notice();
		return list_notice;
	}

	//faq 목록
	@Override
	public List<BoardVo> list_faq() {
		// TODO Auto-generated method stub
		List<BoardVo> list_faq = dao.list_faq();
		return list_faq;
	}

	//게시물 등록
	@Override
	public int insert_board(BoardVo b) {
		// TODO Auto-generated method stub
		int re = -1;
		re = dao.insert_board(b);
		return re;
	}

	//게시물 상세보기
	@Override
	public BoardVo detail_board(BoardVo b) {
		// TODO Auto-generated method stub
		BoardVo detail = dao.detail_board(b);
		return detail;
	}

	//조회수
	@Override
	public int hit_board(BoardVo b) {
		// TODO Auto-generated method stub
		int re = -1;
		re = dao.hit_board(b);
		return re;
	}

	//게시물 수정
	@Override
	public int update_board(BoardVo b) {
		// TODO Auto-generated method stub
		int re = -1;
		re = dao.update_board(b);
		return re;
	}

	//게시물 삭제
	@Override
	public int delete_board(BoardVo b) {
		// TODO Auto-generated method stub
		int re = -1;
		re = dao.delete_board(b);
		return re;
	}

	//댓글 목록
	@Override
	public List<Board_commentVo> list_board_comment(BoardVo b) {
		// TODO Auto-generated method stub
		List<Board_commentVo> list = dao.list_board_comment(b);
		return list;
	}

	//댓글 등록
	@Override
	public int insert_board_comment(Board_commentVo cm) {
		// TODO Auto-generated method stub
		int re = -1;
		re = dao.insert_board_comment(cm);
		return re;
	}

	//게시물 삭제시 그 글의 댓글 삭제
	@Override
	public int delete_board_comment_all(BoardVo b) {
		// TODO Auto-generated method stub
		int re = -1;
		re = dao.delete_board_comment_all(b);
		return re;
	}

	//댓글 수정
	@Override
	public int update_board_comment(Board_commentVo cm) {
		// TODO Auto-generated method stub
		int re = -1;
		re = dao.update_board_comment(cm);
		return re;
	}

	//댓글 삭제
	@Override
	public int delete_board_comment(Board_commentVo cm) {
		// TODO Auto-generated method stub
		int re = -1;
		re = dao.delete_board_comment(cm);
		return re;
	}

}
