package com.movie.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.dao.MemberDao;
import com.movie.demo.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;

	// 회원등록
	@Override
	public int register(MemberVo mv) {

		return memberDao.register(mv);
	}

	// 아이디비교
	@Override
	public int checkId(String user_id) {
		int re = memberDao.checkId(user_id);
		return re;
	}
	
	// 로그인
	@Override
	public MemberVo login(String user_id, String pwd) {
		
		return memberDao.login(user_id,pwd);
	}

}
