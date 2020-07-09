package com.movie.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo {
	private int g_no;
	private String g_type;
	private String g_name;
	private int g_price;
	private int g_qty;
}
