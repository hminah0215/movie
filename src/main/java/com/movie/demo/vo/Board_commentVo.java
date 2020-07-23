package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board_commentVo {
	private int cm_no;
	private String cm_content;
	private String cm_date;
	private String user_id;
	private int b_no;
}
