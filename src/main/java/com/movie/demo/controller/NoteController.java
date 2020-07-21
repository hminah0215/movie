package com.movie.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.demo.service.NoteService;
import com.movie.demo.vo.NoteVo;

@Controller
public class NoteController {
	
	@Autowired
	NoteService noteService;
	
	//쪽지 보내기폼
	@RequestMapping("/note/insert_note_form")
	public String insert_note_form(Model model, String from_id, String to_id) {
		//보내는 사람 아이디
		model.addAttribute("from_id", from_id);
		//받는 사람 아이디
		model.addAttribute("to_id", to_id);
		
		return "/note/insert_note";
	}
	
	//쪽지 보내기
	@RequestMapping("/note/insert_note")
	@ResponseBody
	public void insert_note(NoteVo n) {
		noteService.insert_note(n);
	}
	
	//쪽지 확인
	
	//쪽지함
	@RequestMapping("/note/list_note")
	public String list_note() {
		return "/note/list_note";
	}
	
	//보낸 쪽지 리스트
	@RequestMapping("/note/send_note_list")
	public String send_note_list(Model model,NoteVo n) {
		model.addAttribute("send_note_list", noteService.send_note_list(n));
		
		return "/note/send_note_list";
	}
	
	//받은 쪽지 리스트
	@RequestMapping("/note/reseive_note_list")
	public String reseive_note_list(Model model,NoteVo n) {
		model.addAttribute("reseive_note_list", noteService.reseive_note_list(n));
		
		return "/note/reseive_note_list";
	}
	
	//쪽지 상세보기
	@RequestMapping("/note/detail_note")
	public String detail_note(Model model,NoteVo n) {
		noteService.chk_note(n);
		model.addAttribute("detail", noteService.detail_note(n));
		return "/note/detail_note";
	}
}
