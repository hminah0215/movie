package com.movie.demo.service;

import java.util.List;

import com.movie.demo.vo.BoardVo;
import com.movie.demo.vo.MemberVo;

public interface MypageService {
	//작성한 글
	List<BoardVo> board(MemberVo m);
}
