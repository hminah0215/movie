package com.movie.demo.dao;

import java.util.List;

import com.movie.demo.vo.BoardVo;
import com.movie.demo.vo.MemberVo;

public interface MypageDao {
	//작성한 글
	List<BoardVo> board(MemberVo m);
}
