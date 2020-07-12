package com.movie.demo.service;

import java.util.List;

import com.movie.demo.vo.BoardVo;
import com.movie.demo.vo.Board_commentVo;
import com.movie.demo.vo.ReviewVo;

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
	
	//게시물 삭제시 그 글의 댓글 삭제
	int delete_board_comment_all(BoardVo b);
	
	//댓글 목록
	List<Board_commentVo> list_board_comment(BoardVo b);
	
	//댓글 등록
	int insert_board_comment(Board_commentVo cm);	
	
	//댓글 수정
	int update_board_comment(Board_commentVo cm);
	
	//댓글 삭제
	int delete_board_comment(Board_commentVo cm);
	
	//게시물 신고
	int report_board(BoardVo b);

	//리뷰 신고
	int report_review(ReviewVo r);
	
	//게시물 신고하면 게시물 테이블에 신고수 업데이트
	int report_board_cnt(BoardVo b);	
	
	//신고한 사람 확인
	Integer search_report(BoardVo b);	
}
