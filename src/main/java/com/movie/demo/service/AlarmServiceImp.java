package com.movie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.dao.AlarmDao;
import com.movie.demo.vo.AlarmVo;
@Service
public class AlarmServiceImp implements AlarmService {

	@Autowired
	AlarmDao aDao;
	
	//알람 등록
	@Override
	public int insert_alarm(AlarmVo a) {
		// TODO Auto-generated method stub
		int re = -1;
		re = aDao.insert_alarm(a);
		return re;
	}

	//알람에 사용할 쪽지 번호 조회
	@Override
	public int search_note_no() {
		// TODO Auto-generated method stub
		int re = -1;
		re = aDao.search_note_no();
		return re;
	}

	//알람 확인
	@Override
	public int chk_alarm(AlarmVo a) {
		// TODO Auto-generated method stub
		int re = -1;
		re = aDao.chk_alarm(a);
		return re;
	}

	//알람에 사용할 글 작성자 조회
	@Override
	public String search_b_user_id(int b_no) {
		// TODO Auto-generated method stub
		String str = "";
		str = aDao.search_b_user_id(b_no);
		return str;
	}
	
	//댓글 알람 조회
	@Override
	public List<AlarmVo> search_comment_alarm(AlarmVo a) {
		// TODO Auto-generated method stub
		List<AlarmVo> list = aDao.search_comment_alarm(a); 
		return list;
	}
	
	//쪽지 알람 조회
	@Override
	public List<AlarmVo> search_note_alarm(AlarmVo a) {
		// TODO Auto-generated method stub
		List<AlarmVo> list = aDao.search_note_alarm(a);
		return list;
	}

	//신규 댓글 수 조회
	@Override
	public Integer cnt_comment_alarm(AlarmVo a) {
		// TODO Auto-generated method stub
		Integer re = -1;
		re = aDao.cnt_comment_alarm(a);
		return re;
	}

	//신규 쪽지 수 조회
	@Override
	public Integer cnt_note_alarm(AlarmVo a) {
		// TODO Auto-generated method stub
		Integer re = -1;
		re = aDao.cnt_note_alarm(a);
		return re;
	}
	






}
