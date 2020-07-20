package com.movie.demo.dao;

import com.movie.demo.vo.MemberVo;

public interface MemberDao {
	
	//회원등록
	int register(MemberVo mv);
	
	//아이디비교
	int checkId(String user_id);
	
	//로그인
	MemberVo login(String user_id, String pwd);
}
