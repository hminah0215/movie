package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmVo {
	private int a_no;
	private String a_type;
	private String a_check;
	private String user_id;
	private int b_no;
	private int note_no;
	
	private Integer cnt;
}
