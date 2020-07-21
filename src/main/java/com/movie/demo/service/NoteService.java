package com.movie.demo.service;

import java.util.List;

import com.movie.demo.vo.NoteVo;

public interface NoteService {
	//쪽지 보내기
	int insert_note(NoteVo n);

	//쪽지 확인
	int chk_note(NoteVo n);

	//보낸 쪽지 리스트
	List<NoteVo> send_note_list(NoteVo n);

	//받은 쪽지 리스트
	List<NoteVo> reseive_note_list(NoteVo n);

	//쪽지 상세보기
	NoteVo detail_note(NoteVo n);	
}
