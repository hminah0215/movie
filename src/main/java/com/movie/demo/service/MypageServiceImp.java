package com.movie.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.demo.dao.MypageDao;
import com.movie.demo.vo.BoardVo;
import com.movie.demo.vo.MemberVo;

@Service
public class MypageServiceImp implements MypageService {
	@Autowired
	MypageDao mypagedao;
	
	//작성한 글
	@Override
	public List<BoardVo> board(MemberVo m) {
		// TODO Auto-generated method stub
		List<BoardVo> list = mypagedao.board(m);
		return list;
	}
}
