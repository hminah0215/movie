package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {
	private String b_no;
	private String b_category;
	private String b_categoty_sub;
	private String b_write;
	private String b_content;
	private String b_date;
	private String user_id;
	private int b_report_cnt;
}
