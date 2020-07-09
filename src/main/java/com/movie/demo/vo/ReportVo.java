package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportVo {
	private int report_no;
	private int b_no;
	private String user_id;
	private int r_no;
}
