package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartVo {
	private int c_no;
	private String c_name;
	private int c_qty;
	private int g_no;
	private int r_no;
}
