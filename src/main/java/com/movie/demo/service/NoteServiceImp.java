package com.movie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.dao.NoteDao;
import com.movie.demo.vo.NoteVo;
@Service
public class NoteServiceImp implements NoteService {
	
	@Autowired
	NoteDao nDao;
	
	//쪽지 보내기
	@Override
	public int insert_note(NoteVo n) {
		// TODO Auto-generated method stub
		int re = -1;
		re = nDao.insert_note(n);
		return re;
	}
	
	//쪽지 확인
	@Override
	public int chk_note(NoteVo n) {
		// TODO Auto-generated method stub
		int re = -1;
		re = nDao.chk_note(n);
		return re;
	}
	
	//보낸 쪽지 리스트
	@Override
	public List<NoteVo> send_note_list(NoteVo n) {
		// TODO Auto-generated method stub
		List<NoteVo> list = nDao.send_note_list(n);
		return list;
	}
	
	//받은 쪽지 리스트
	@Override
	public List<NoteVo> reseive_note_list(NoteVo n) {
		// TODO Auto-generated method stub
		List<NoteVo> list = nDao.reseive_note_list(n);
		return list;
	}

	//쪽지 상세보기
	@Override
	public NoteVo detail_note(NoteVo n) {
		// TODO Auto-generated method stub
		NoteVo note = nDao.detail_note(n);
		return note;
	}

}
