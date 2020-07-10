package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {
	private int b_no;
	private String b_category;
	private String b_category_sub;
	private String b_title;
	private String b_content;
	private String b_date;
	private String user_id;
	private int b_report_cnt;
	private int b_hit;
	private int cm_cnt;
}
