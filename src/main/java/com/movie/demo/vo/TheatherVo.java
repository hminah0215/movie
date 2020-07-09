package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TheatherVo {
	private int branch_no;
	private String branch_name;
	private String branch_addr;
	private int screen_no;
	private String seat_no;
	private String screening_date;
	private String screening_start;
	private int m_no;
}
