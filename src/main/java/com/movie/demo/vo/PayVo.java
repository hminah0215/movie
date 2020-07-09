package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayVo {
	private int p_no;
	private String p_type;
	private String p_date;
	private int p_price;
	private int c_no;
}
