package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewVo {
	private int r_no;
	private int r_star;
	private String r_content;
	private int r_like;
	private String user_id;
	private int m_no;
	private int r_report_cnt;
	private int p_no;
}
