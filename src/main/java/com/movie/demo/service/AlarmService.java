package com.movie.demo.service;

import java.util.List;

import com.movie.demo.vo.AlarmVo;
import com.movie.demo.vo.Board_commentVo;
import com.movie.demo.vo.NoteVo;

public interface AlarmService {
	//알람 등록
	int insert_alarm(AlarmVo a);

	//알람에 사용할 글 작성자 조회
	String search_b_user_id(int b_no);	
	
	//알람에 사용할 쪽지 번호 조회
	int search_note_no();
	
	//알람 확인
	int chk_alarm(AlarmVo a);
	
	//댓글 알람 조회
	List<AlarmVo> search_comment_alarm(AlarmVo a);

	//쪽지 알람 조회
	List<AlarmVo> search_note_alarm(AlarmVo a);
	
	//신규 댓글 수 조회
	Integer cnt_comment_alarm(AlarmVo a);
	
	//신규 쪽지 수 조회
	Integer cnt_note_alarm(AlarmVo a);
}
