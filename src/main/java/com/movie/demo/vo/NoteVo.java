package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteVo {
	private int note_no;
	private String from_id;
	private String note_title;
	private String note_content;
	private String note_chk;
	private String user_id;
}
