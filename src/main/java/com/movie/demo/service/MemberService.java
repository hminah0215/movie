package com.movie.demo.service;

import com.movie.demo.vo.MemberVo;

public interface MemberService {

	// 회원등록
	int register(MemberVo mv);

	// 아이디비교
	int checkId(String user_id);

}
