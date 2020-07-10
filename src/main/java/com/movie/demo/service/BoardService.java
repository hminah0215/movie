package com.movie.demo.service;

import java.util.List;

import com.movie.demo.vo.BoardVo;
import com.movie.demo.vo.Board_commentVo;

public interface BoardService {
	//자유게시판 목록
	List<BoardVo> list_board();

	//공지사항 목록
	List<BoardVo> list_notice();

	//faq 목록
	List<BoardVo> list_faq();

	//게시물 등록
	int insert_board(BoardVo b);
	
	//게시물 상세보기
	BoardVo detail_board(BoardVo b);
	
	//조회수
	int hit_board(BoardVo b);

	//게시물 수정
	int update_board(BoardVo b);
	
	//게시물 삭제
	int delete_board(BoardVo b);	
	
	//댓글 목록
	List<Board_commentVo> list_board_comment();
	
	//댓글 등록
	int insert_board_comment(Board_commentVo cm);	
}
